package main

import "fmt"

func main () {
	fmt.Println(twoSum([]int{2, 7, 11, 15}, 9))
}

func twoSum(nums []int, target int) []int {
	m := make(map[int] int)
	for i := 0; i < len(nums); i++ {
		var num = nums[i]
	//for i, num := range nums {
		another := target - num
		if _, ok := m[another]; ok {
			return []int{m[another], i}
		}
		m[num] = i
	}
	return nil
}