package binchunk

import (
	"encoding/binary"
	"math"
)

type reader struct {
	data []byte
}

func (self *reader) readByte() byte {
	b := self.data[0]
	self.data = self.data[1:]
	return b
}

func (self *reader) readUint32() uint32 {
	b := binary.LittleEndian.Uint32(self.data)
	self.data = self.data[4:]
	return b
}

func (self *reader) readUint64() uint64 {
	b := binary.LittleEndian.Uint64(self.data)
	self.data = self.data[8:]
	return b
}

func (self *reader) readLuaInteger() int64 {
	return int64(self.readUint64())
}

func (self *reader) readLuaNumber() float64 {
	return math.Float64frombits(self.readUint64())
}

func (self *reader) readString() string{
	size := uint(self.readByte())  //短字符串
	if size == 0 {
		return ""
	}
	if size == 0xFF { //长字符串
		size = uint(self.readUint64())
	}
	bytes := self.readBytes(size - 1)
	return string(bytes)
}

func (self *reader) readBytes(n uint) []byte {
	bytes := self.data[0:n]
	self.data = self.data[n:]
	return bytes
}

func (self *reader) checkHeader() {

}
