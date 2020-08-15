package main

import "fmt"

func main() {
	fmt.Printf("%T\n", add)
}

func add(x, y int) int {
	return x + y
}
