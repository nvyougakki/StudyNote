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
	/*for i := 0; i < n; i ++ {
		self.stack.pop()
	}*/
	self.SetTop(-n-1)
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

//将栈顶值弹出插入指定位置
func (self *luaState) Insert(idx int) {
	self.Rotate(idx, 1)
}
//删除指定位置的值,上面的值下移
func (self *luaState) Remove(idx int) {
	self.Rotate(idx, -1)
	self.Pop(1)
}
/**
slot: [1, 2, 3, 5, 6, 7]
					 top

 */
func (self *luaState) Rotate(idx, n int) {
	t := self.stack.top - 1
	p := self.stack.absIndex(idx) - 1

	var m int
	if n >= 0 {
		m = t - n
	} else {
		m = p - n - 1
	}
	self.stack.reverse(p, m)
	self.stack.reverse(m+1, t)
	self.stack.reverse(p, t)
}


func (self *luaState) SetTop(idx int) {
	newTop := self.stack.absIndex(idx)
	if newTop < 0 {
		panic("stack underflow")
	}
	n := self.stack.top - newTop
	if n > 0 {
		for i := 0; i < n; i++ {
			self.stack.pop()
		}
 	} else if n < 0 {
 		for i := 0; i > n; i-- {
 			self.stack.push(nil)
		}
	}
}




