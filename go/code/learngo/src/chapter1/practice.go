package main

import (
	"bufio"
	"fmt"
	"os"
)

func main() {
	//test1()
	//dup1()
	dup2()
}

func test1() {
	var s, sep string
	for i := 0; i < len(os.Args); i++ {
		s += sep + os.Args[i]
		sep = " "
	}
	fmt.Println(s)
}

func dup1() {
	counts := make(map[string] int)
	input := bufio.NewScanner(os.Stdin)
	for input.Scan() {
		text := input.Text()
		if text == "exit" {
			break;
		}
		counts[input.Text()]++
	}
	for key, value := range counts {
		if value > 1{
			fmt.Printf("%d\t%s\n", value, key)
		}
	}
}

func dup2() {
	counts := make(map[string] int)
	files := os.Args[1:]
	fmt.Println(len(files))
	if len(files) == 0 {
		countLines(os.Stdin, counts)
	} else {
		for _, arg := range files {
			f, err := os.Open(arg)
			if err != nil {
				fmt.Fprintf(os.Stderr, "dup2: &v\n", err)
				continue;
			}
			countLines(f, counts)
			f.Close()
		}
	}

	for line, n := range counts {
		fmt.Printf("%d\t%s\n", n, line)
	}
}

func countLines(f *os.File, counts map[string]int) {
	input := bufio.NewScanner(f)
	for input.Scan() {
		counts[input.Text()]++
	}
}
