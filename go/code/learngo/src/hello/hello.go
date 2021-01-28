package main

import "fmt"

func f() *int {
	x := 1
	return &x
}

func incr(p *int) int {
	*p++
	return *p
}
func incr1(x int) int {
	x++
	return x
}
func main() {
	//fmt.Printf("hello, %d\n", 23)
	//fmt.Fprint(os.Stderr, "hello ", 23 , "\n")
	//fmt.Println("Hello", 23)
	//fmt.Println(fmt.Sprint("Hello ", 23))
	x := 1
	incr1(x)
	fmt.Println(incr1(x))
	fmt.Println(incr1(x))
	fmt.Println(incr1(x))

}
