package main

import "fmt"

func lengthOfLongestSubstring(s string) int {
	var begin, max int

	exist := make(map[byte] int)

	for i := 0; i < len(s); i++ {
		sbyte := s[i]
		//if exist in map
		//update begin
		if index, ok := exist[sbyte]; ok && index >= begin {
			begin = index + 1
		} else {  // not exist
			if i - begin + 1  > max {
				max = i - begin + 1
			}

		}

		exist[sbyte] = i
	}
	return max
}

func main() {
	i := lengthOfLongestSubstring("pwwkew")
	fmt.Println(i)
}