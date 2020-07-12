package main

type Point struct {
	X int
	Y int
}

type Cycle struct {
	Point
	X string
	Radius int
}

type Wheel struct {
	Cycle
	Spokes int
}

func main() {
	var wheel Wheel
	wheel.Y = 1
	wheel.Cycle.Point.X = 1
}


