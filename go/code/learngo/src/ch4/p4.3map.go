package main

import (
	"bufio"
	"fmt"
	"os"
)

func main() {
	//ages := make(map[string]int)

	ages := map[string]int{
		"bob": 21,
	}

	bobage, ok := ages["bob"]
	fmt.Println(bobage, ok)

	arr := []string{"test1", "arr"}

	fmt.Printf("att text: %q\n", arr)

	dedup()

}

func dedup() {
	seen := make(map[string]bool)
	input := bufio.NewScanner(os.Stdin)
	for input.Scan() {
		line := input.Text()
		if !seen[line] {
			seen[line] = true
			fmt.Println(line)
		}
	}

	if err := input.Err(); err != nil {
		fmt.Fprintf(os.Stderr, "dedup:%v\n", err)
		os.Exit(1)
	}

}
