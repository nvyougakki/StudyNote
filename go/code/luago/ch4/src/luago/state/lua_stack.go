package state

type luaStack struct {
	slots []luaValue
	top   int
}

func newLuaStack(size int) *luaStack {
	return &luaStack{
		slots: make([]luaValue, size),
		top:   0,
	}
}

func (self *luaStack) check(n int) {
	free := len(self.slots) - self.top
	for i := free; i < n;  i++ {
		self.slots = append(self.slots, nil)
	}
}

func (self *luaStack) push(val luaValue) {
	if self.top == len(self.slots) {
		panic("stack overflow")
	}
	self.slots[self.top] = val
	self.top++
}

func (self *luaStack) pop() luaValue{
	if self.top < 1 {
		panic("stack overflow")
	}
	self.top--
	res := self.slots[self.top]
	self.slots[self.top] = nil
	return res
}



func (self *luaStack) absIndex(idx int) int {
	if idx >= 0 { return idx }
	return idx + self.top + 1
}

//判断索引是否有效
func (self *luaStack) isValid(idx int) bool {
	absIdx := self.absIndex(idx)
	return absIdx > 0 && absIdx <= self.top
}

func (self *luaStack) get(idx int) luaValue {
	if !self.isValid(idx) {
		return nil
	}
	absIdx := self.absIndex(idx)
	return self.slots[absIdx]
}

func (self *luaStack) set(idx int, val luaValue) {
	if !self.isValid(idx) {
		panic("invalid index")
	}
	self.slots[idx] = val
}
