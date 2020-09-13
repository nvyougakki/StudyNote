package geometry

import (
	"image/color"
	"math"
)

type Point struct {X, Y float64}

func Distance(p, q Point) float64 {
	return math.Hypot(q.X - p.X, q.Y - p.Y)
}

func (p Point) Distance(q Point) float64 {
	return math.Hypot(q.X - p.X, q.Y - p.Y)
}

func test() {
	p := Point{12, 12}
	p.Distance(Point{13, 13})
}

type Path []Point

func (p Path) Distance() float64 {
	result := 0.0
	for i, item := range p {
		if i > 0 {
			result += item.Distance(p[i-1])
		}

	}
	return result
}

func (p *Point) ScaleBy(float float64) {
	p.X *= float
	p.Y *= float
}

func (p Point) add(q Point) Point{
	return Point{p.X + q.X, p.Y + q.Y}
}

func (p Point) sub(q Point) Point{
	return Point{p.X - q.X, p.Y - q.Y}
}

func (path Path) TranslateBy(p Point, add bool)  {
	var op func(p Point, q Point) Point
	if add {
		op = Point.add
	} else {
		op = Point.sub
	}
	for i := range path {
		path[i] = op(path[i], p)
	}
}

type ColoredPoint struct {
	*Point
	color.RGBA
}
