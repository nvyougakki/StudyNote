package main

import "fmt"
type Currency int
const (
	USD Currency = iota
	EUR
	GBP
	RMB
)
func main() {
	symbol := [...]string{USD: "$", EUR: "€", GBP: "￡", RMB: "￥"}
	fmt.Println(symbol[RMB])


	_slice := symbol[1:1]
	fmt.Println(len(_slice), cap(_slice))

	a := []string{"s", "a", "a", "s", "d", "z", "a", "z", "v", "w", "w", "a", "a"}
	//fmt.Println(&a)
	replace(&a)
	fmt.Println(a)
}

func reverse(arr *[]int) {
	a := *arr
	length := len(a)
	for i:=0; i < length/2; i++ {
		a[i], a[length - 1 - i] = a[length - i - i], a[i]
	}
}

func replace(a *[]string){
	arr := *a
	count := len(arr)
	for i:=1; i < len(arr); i++ {
		if arr[i] == arr[i - 1] {
			arr = append(arr[:i], arr[i+1:]...)
			count--
		}
	}
	*a = arr[:count]
}
