package main

import (
	"fmt"
	. "luago/api"
	"luago/binchunk"
	"luago/vm"
)
import _ "luago/binchunk"
import "luago/state"

func main() {
	ls := state.New()

	ls.PushBoolean(true)
	printStack(ls)
	ls.PushInteger(10)
	printStack(ls)
	ls.PushNil()
	printStack(ls)
	ls.PushString("hello")
	printStack(ls)
	ls.PushValue(-4)
	printStack(ls)
	ls.Replace(3)
	printStack(ls)
	ls.SetTop(6)
	printStack(ls)
	ls.Remove(-3)
	printStack(ls)
	ls.SetTop(-5)
	printStack(ls)
}

func printStack(ls LuaState) {
	top := ls.GetTop()
	for i := 1; i <= top; i++ {
		t := ls.Type(i)
		switch t {
		case LUA_TBOOLEAN:
			fmt.Printf("[%t]", ls.ToBoolean(i))
		case LUA_TNUMBER:
			fmt.Printf("[%g]", ls.ToNumber(i))
		case LUA_TSTRING:
			fmt.Printf("[%q]", ls.ToString(i))
		default: // other values
			fmt.Printf("[%s]", ls.TypeName(t))
		}
	}
	fmt.Println()
}

func list(f *binchunk.Prototype) {
	printHeader(f)
	printCode(f)
	printDetail(f)
	for _, p := range f.Protos {
		list(p)
	}
}

func printHeader(f *binchunk.Prototype) {
	funcType := "main"
	if f.LineDefined > 0 { funcType = "function" }
	varargFlag := ""
	if f.IsVararg > 0 { varargFlag = "+" }

	fmt.Printf("\n%s <%s:%d,%d>(%d instructions)\n", funcType, f.Source, f.LineDefined,
		f.LastLineDefined, len(f.Code))
	fmt.Printf("%d%s params, %d slots, %d upvalues, ",
		f.NumParams, varargFlag, f.MaxStackSize, len(f.Upvalues))
	fmt.Printf("%d locals, %d constants, %d functions\n",
		len(f.LocVars), len(f.Constants), len(f.Protos))
}

//打印指令的序号、行号和十六进制表示
func printCode(f *binchunk.Prototype) {
	for pc, c := range f.Code {
		line := "-"
		if len(f.LineInfo) > 0 {
			line = fmt.Sprintf("%d", f.LineInfo[pc])
		}
		i := vm.Instruction(c)

		fmt.Printf("\t%d\t[%s]\t%s \t", pc + 1, line, i.Opname())
		printOperands(i)
		fmt.Println()
	}
}

func printOperands(i vm.Instruction) {
	switch i.Opmode() {
	case vm.IABC:
		a, b, c := i.ABC()
		fmt.Printf("%d", a)
		if i.Bmode() != vm.OpArgN {
			if b > 0xFF {
				fmt.Printf(" %d", -1-b&0xFF)
			} else {
				fmt.Printf(" %d", b)
			}
		}
		if i.Cmode() != vm.OpArgN {
			if b > 0xFF {
				fmt.Printf(" %d", -1-c&0xFF)
			} else {
				fmt.Printf(" %d", c)
			}
		}
	case vm.IABx:
		a, bx := i.ABx()
		fmt.Printf("%d", a)
		if i.Bmode() == vm.OpArgK {
			fmt.Printf(" %d", -1-bx)
		} else if i.Bmode() == vm.OpArgU {
			fmt.Printf(" %d", bx)
		}
	case vm.IAsBx:
		a, sbx := i.AsBx()
		fmt.Printf("%d %d", a, sbx)
	case vm.IAx:
		ax := i.Ax()
		fmt.Printf("%d", -1-ax)
	}
}

//打印常量表、局部变量表和Upvalue表
func printDetail(f *binchunk.Prototype) {

	//打印常量
	fmt.Printf("constants (%d):\n", len(f.Constants))

	for i, k := range f.Constants {
		fmt.Printf("\t%d\t%s\n", i + 1, k)
	}

	//打印局部变量表
	fmt.Printf("locals (%d):\n", len(f.LocVars))

	for i, locVar := range f.LocVars {
		fmt.Printf("\t%d\t%s\t%d\t%d\n",
			i, locVar.VarName, locVar.StartPc, locVar.EndPc)
	}

	//打印Upvalues
	fmt.Printf("upvalues (%d):\n", len(f.Upvalues))

	for i, upval := range f.Upvalues {
		fmt.Printf("\t%d\t%s\t%d\t%d\n",
			i, upvalName(f, i), upval.Instack, upval.Idx)
	}

}

func upvalName(f *binchunk.Prototype, i int) string{
	if len(f.UpvalueNames) > 0 {
		return f.UpvalueNames[i]
	}
	return "-"
}

func constantToString(k interface{}) string {
	switch k.(type) {
	case nil:
		return "nil";
	case bool:
		return fmt.Sprintf("%t", k)
	case float64:
		return fmt.Sprintf("%g", k)
	case int64:
		return fmt.Sprintf("%d", k)
	case string:
		return fmt.Sprintf("%q", k)
	default:
		return "?"
	}

}
