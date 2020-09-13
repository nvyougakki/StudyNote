package main

import (
	"ch6/geometry"
	"fmt"
	"image/color"
)

type ColoredPoint struct {
	geometry.Point
	Color color.RGBA
}

func main () {
	var cp ColoredPoint
	cp.X = 1
	fmt.Println(cp.Point.X)

	cp.Y = 2
	fmt.Println(cp.Point.Y)

	red := color.RGBA{255, 0, 0, 255}
	blue := color.RGBA{0, 0, 0, 255}
	p := ColoredPoint{geometry.Point{1, 2}, red}
	q := ColoredPoint{geometry.Point{2, 5}, blue}
	fmt.Println(p.Distance(q.Point))
	p.ScaleBy(2)
	q.ScaleBy(2)

	fmt.Println(p.Distance(q.Point))


}