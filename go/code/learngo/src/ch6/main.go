package main

import (
	"ch6/geometry"
	"fmt"
	"image/color"
)


func main() {
	/*perim := geometry.Path{{1, 1}, {5, 1}, {5, 4}, {1, 1}}
	fmt.Println(perim.Distance())
	p := geometry.Point{1, 2}
	q := &p
	q.ScaleBy(12.0)
	fmt.Println(*q)*/

	red := color.RGBA{255, 0, 0, 255}
	blue := color.RGBA{0, 0, 255, 255}
	var p = geometry.ColoredPoint{&geometry.Point{1, 1}, red}
	var q = geometry.ColoredPoint{&geometry.Point{5, 4}, blue}
	fmt.Println(p.Distance(*q.Point))
	p.ScaleBy(2)
	q.ScaleBy(2)
	fmt.Println(p.Distance(*q.Point))


}
