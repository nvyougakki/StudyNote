package state

func (self *luaState) GetTop() int {
	return self.stack.top
}

func (self *luaState) AbsIndex(idx int) int {
	return self.stack.absIndex(idx)
}

func (self *luaState) CheckStack(n int) bool {
	self.stack.check(n)
	return true
}
func (self *luaState) Pop(n int) {
	for i := 0; i < n; i ++ {
		self.stack.pop()
	}
}
func (self *luaState) Copy(fromIdx, toIdx int) {
	val := self.stack.get(fromIdx)
	self.stack.set(toIdx, val)
}
func (self *luaState) PushValue(idx int) {
	self.stack.push(self.stack.get(idx))
}
func (self *luaState) Replace(idx int) {
	self.stack.set(idx, self.stack.pop())
}
func (self *luaState) Insert(idx int) {
	self.Rotate(idx, 1)
}
func (self *luaState) Remove(idx int) {
	self.Rotate(idx, -1)
	self.Pop(1)
}
func (self *luaState) Rotate(idx, n int) {
	t := self.stack.top - 1
	p := self.stack.absIndex(idx) - 1
}
SetTop(idx int)
/* access functions (stack -> Go) */
TypeName(tp LuaType) string
Type(idx int) LuaType
IsNone(idx int) bool
IsNil(idx int) bool
IsNoneOrNil(idx int) bool
IsBoolean(idx int) bool
IsInteger(idx int) bool
IsNumber(idx int) bool
IsString(idx int) bool
IsTable(idx int) bool
IsThread(idx int) bool
IsFunction(idx int) bool
ToBoolean(idx int) bool
ToInteger(idx int) int64
ToIntegerX(idx int) (int64, bool)
ToNumber(idx int) float64
ToNumberX(idx int) (float64, bool)
ToString(idx int) string
ToStringX(idx int) (string, bool)
/* push functions (Go -> stack) */
PushNil()
PushBoolean(b bool)
PushInteger(n int64)
PushNumber(n float64)
PushString(s string)


