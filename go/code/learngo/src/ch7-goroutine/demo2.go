package main

import (
	"fmt"
	"runtime"
)

func main() {
	/*go func(s string) {
		for i := 0; i < 2; i++ {
			fmt.Println(s, i)
		}
	}("world")

	for i := 0; i < 2; i++ {
		runtime.Gosched()
		fmt.Println("hello", i)
	}*/
	go func() {
		defer fmt.Println("A.defer")
		func() {
			defer fmt.Println("B.defer")
			// 结束协程
			runtime.Goexit()
			defer fmt.Println("C.defer")
			fmt.Println("B")
		}()
		fmt.Println("A")
	}()

	for {

	}
}