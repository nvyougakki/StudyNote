package main

import (
	"ch6/geometry"
	"fmt"
)

type Rocket struct {
	Name string
}

func (r Rocket) Run() {
	fmt.Println(r.Name + " start run")
}



func main () {
	/*r := Rocket{"rocket1"}

	time.AfterFunc(10 * time.Second, r.Run)*/
	/*r := Rocket{"rocket1"}
	time.AfterFunc(3 * time.Second, func() {
		r.Run()
	})
	time.Sleep(4 * time.Second)*/

	/*p := geometry.Point{1, 2}
	q := geometry.Point{4, 5}
	distance := geometry.Point.Distance
	fmt.Println(distance(p, q))

	scale := (*geometry.Point).ScaleBy

	scale(&p, 2)

	fmt.Println(p)
	fmt.Printf("%T\n", scale)*/


	path := geometry.Path{{1, 3}, {2 ,4}}
	path.TranslateBy(geometry.Point{1, 1}, true)
	fmt.Println(path)

}
