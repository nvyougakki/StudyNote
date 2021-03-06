package main

import (
	"fmt"
	"time"
)
//var wg sync.WaitGroup

func main() {
	/*for i:=0; i<10; i++ {
		wg.Add(i)
		go hello(i)
	}
	time.Sleep(time.Second)
	wg.Wait()*/
	go func() {
		i := 0
		for {
			i++
			fmt.Println("goruntine ", i)
			time.Sleep(time.Second)
		}
	}()
	i:=1
	for {
		i++
		fmt.Println("main runtine:", i)
		time.Sleep(time.Second)
		if i== 2 {
			break
		}
	}
}

func hello(i int) {
	//defer wg.Done()
	fmt.Println("hello func", i)
}
