package main

import "fmt"

func main() {
	x := 0666
	fmt.Printf("%d %[1]o %#[1]o\n", x)

	y := int64(0xabcdef)
	fmt.Printf("%d %[1]x %#[1]x",y)
}
