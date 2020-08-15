package main

import (
	"ch6/geometry"
	"fmt"
)

func main() {
	perim := geometry.Path{{1, 1}, {5, 1}, {5, 4}, {1, 1}}
	fmt.Println(perim.Distance())
	p := geometry.Point{1, 2}
	q := &p
	q.ScaleBy(12.0)
	fmt.Println(*q)

	/*var i int = 10
	fmt.Println(i)
	fmt.Println(&i)
	var j *int = &i
	var k *(*int) = &j
	fmt.Println(**k)*/
}
