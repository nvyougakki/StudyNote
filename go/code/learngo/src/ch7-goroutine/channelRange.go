package main

import "fmt"

func main () {
	ch := make(chan int)
	go func(ch chan int) {
		for i := 0; i < 100; i++ {
			ch <- i
		}
		close(ch)
	}(ch)

	for i := range ch {
		fmt.Println(i)
	}
}
