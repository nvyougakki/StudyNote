package main

func main() {
	//fun := squares()
	//fmt.Println(fun())
	//fmt.Println(fun())
	//fmt.Println(fun())
	//fmt.Println(fun())


}

func squares() func() int {
	var x int
	return func() int {
		x++
		return x * x
	}
}
