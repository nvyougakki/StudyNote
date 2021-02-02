package binchunk

type binnaryChunk struct {
	header
	siteUpvalues byte
	mainFunc     *Prototype
}

const (
	LUA_SIGNATURE    = "\x1bLua"
	LUAC_VERSION     = 0x53
	LUAC_FORMAT      = 0
	LUAC_DATA        = "\x19\x93\r\n\x1a\n"
	CINT_DATA        = 4
	CSZIET_SIZE      = 8
	INSTRUCTION_SIZE = 4
	LUA_INTEGER_SIZE = 8
	LUA_NUMBER_SIZE  = 8
	LUAC_INT         = 0x5678
	LUAC_NUM         = 370.5
)

type header struct {
	signature [4]byte //魔数1B4C7561（ESC、L、u、a）
	version   byte    //版本号，5.1.4，5*16+4
	format    byte    //格式号默认00
	luacData  [6]byte //发布年份：0X1993。后四个（0x0D0A1A0A）(回车、换行、替换、换行)
	//接下来5个字节(0x0408040808)分别表示对应数据类型在chunk中占用的字节数
	cintSize        byte
	cszietSize      byte
	instructionSize byte
	luaIntegerSize  byte
	luaNumberSize   byte

	luacInt int64   //8个字节，0x5678 判断机器大小端
	luacNum float64 //8个字节，存放浮点数370.5，检测浮点数存储格式
}

type Prototype struct {
	Source string //源文件名，0x11 (文件长度16字节) @hello_world.luc，@开头表示从.lua文件编译而来

	//起止行号，main函数都为0，其他函数都大于0
	LineDefined     uint32
	LastLineDefined uint32

	NumParams    byte          //固定参数个数
	IsVararg     byte          //函数是否是Vararg函数，即是否有变长参数
	MaxStackSize byte          //寄存器数量
	Code         []uint32      //指令表，每条指令占4个字节
	Constants    []interface{} //常亮表，以一个字节tag开头，标识类型
	Upvalues     []Upvalue     //Upvalue表
	Protos        []*Prototype  //子函数原型表
	LineInfo     []uint32      //行号表
	LocVars      []LocVar      //局部变量表
	UpvalueNames []string      //Upvalue名列表
}

type Upvalue struct {
	Instack byte
	Idx     byte
}

type LocVar struct {
	VarName string
	StartPc uint32
	EndPc   uint32
}

const (
	TAG_NIL       = 0x00
	TAG_BOOLEAN   = 0x01
	TAG_NUMBER    = 0x03
	TAG_INTEGER   = 0x13
	TAG_SHORT_STR = 0x04
	TAG_LONG_STR  = 0x14
)

func Undump(data []byte) *Prototype {
	reader := &reader{data}
	reader.checkHeader()        //校验头部
	reader.readByte()           //跳过upvalue数量
	return reader.readProto("") //读取函数原型
}
