package main

import "fmt"

type ListNode struct {
	Val int
	Next *ListNode
}
func main() {
	l1 := ListNode{5, &ListNode{5, nil}}
	l2 := ListNode{5, nil}
	head := addTwoNumbers(&l1, &l2)
	for {
		if head == nil {
			break;
		}
		fmt.Println(head.Val)
		head = head.Next
	}
}
var nilNode = ListNode{0, nil}
func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
	result := ListNode{0, nil}

	p, q := l1, l2
	var curr *ListNode
	curr = &result
	flag := 0
	for (p != nil || q != nil) {
		var x, y int
		if p == nil {
		 	x = 0
		} else {
			x = p.Val
			p = p.Next
		}

		if q == nil {
		 	y = 0
		} else {
			y = q.Val
			q = q.Next
		}
		sum := x + y + flag
		flag = sum/10
		curr.Next = &ListNode{sum%10, nil}
		curr = curr.Next
	}
	if flag > 0 {
		curr.Next = &ListNode{1, nil}
	}
	return result.Next
	//return addTwoNum(l1, l2, 0)
}

func addTwoNum(l1 *ListNode, l2 *ListNode, i int)  *ListNode {
	//if(l1 == nil || l2 == nil) {
	//	return 0, nil
	//}
	//result := ListNode{}
	//i, next := addTowNum(l1.Next, l2.Next)
	//num := l1.Val + l2.Val + i
	//result.Val = num%10
	//result.Next = next
	//return num/10, &
	if l1 == nil && l2 == nil {
		if i > 0 {
			return &ListNode{i, nil}
		}
		return nil
	}
	if l1 == nil {
		l1 = &nilNode
	}
	if l2 == nil {
		l2 = &nilNode
	}
	sum := l1.Val + l2.Val + i
	result := ListNode{}
	result.Val = sum%10

 	result.Next = addTwoNum(l1.Next, l2.Next, sum/10)
	return &result

}
