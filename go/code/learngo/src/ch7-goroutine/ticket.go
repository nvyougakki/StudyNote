package main

import (
	"fmt"
	"time"
)

func main() {
	ticket := time.NewTicker(3 * time.Second)
	i := 0
	/*for {
		<- ticket.C
		i++
		fmt.Println(i)
	}*/
	go func(ticker *time.Ticker) {
		for {
			i++
			fmt.Println(<- ticket.C)
			if i == 5 {
				ticket.Stop()
			}
		}
	}(ticket)
	for {

	}

}
