package main

import "fmt"

type tree struct {
	Value       int
	left, right *tree
}
func main() {
	values := []int{67, 34,23,77,99, 134, 54}
	sort(values)

	fmt.Print(values)
}

func sort(values []int) {
	var root *tree
	for _, v := range values {
		root = Add(root, v)
	}
	appendValues(values[:0], root)
}


func appendValues(values []int , t *tree) []int {
	if t != nil {
		values = appendValues(values, t.left)
		values = append(values, t.Value)
		values = appendValues(values, t.right)
	}
	return values
}

func Add(t *tree, value int) *tree {
	if t == nil {
		t = new(tree)
		t.Value = value
		return t;
	}

	if t.Value < value {
		t.right = Add(t.right, value)
	} else {
		t.left = Add(t.left, value)
	}
	return t;
}
