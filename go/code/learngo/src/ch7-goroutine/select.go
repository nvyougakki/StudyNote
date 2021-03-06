package main

import (
	"fmt"
	"time"
)

func chanAdd(ch chan string, waitTime time.Duration) {
	time.Sleep(waitTime)
	ch <- "wait time : " + waitTime.String()
}

func main() {
	/*ch1 := make(chan string)
	ch2 := make(chan string)

	go chanAdd(ch1, 2 * time.Second)

	go chanAdd(ch2, 5 * time.Second)

	for {
		select {
		case t1 := <-ch1:
			fmt.Printf("t1: %s\n",t1)
		case t2 := <-ch2:
			fmt.Printf("t2: %s\n",t2)
		}
	}*/

	ch2 := make(chan string)

	go func(ch chan string) {
		for  {
			select {
			case ch <- "hello":
				fmt.Println("write hello")
			default:
				fmt.Println("channel full")
			}
			time.Sleep(time.Millisecond * 500)
		}
	}(ch2)

	for s := range ch2 {
		fmt.Println("res: " + s)
		time.Sleep(time.Second)
	}


}
