package main

import (
	"ch2/heyutil"
	tv "ch2/tempconv"
	"fmt"
	"time"
)

var a = b
var b = a

func main() {
	heyutil.Hello()
	fmt.Println(tv.CToF(tv.BollingC))
	var x uint64 = 255
	start := time.Now().UnixNano()
	fmt.Println(start)

	fmt.Println(heyutil.PopCount(x))
	fmt.Println(heyutil.PopCountCycle(x))
	fmt.Println(heyutil.PopCountOneBit(x))
	fmt.Println(time.Now().UnixNano())

	fmt.Println(a)

}
