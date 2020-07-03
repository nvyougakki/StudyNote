package main

import (
	"bufio"
	"fmt"
	"io/ioutil"
	"os"
	"strings"
)

func main() {
	//test1()
	//dup1()
	//dup2()
	pdup3()
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

func dup3(){
	counts := make(map[string] int)
	for _, fileName := range os.Args {
		data, err := ioutil.ReadFile(fileName)
		if err != nil {
			fmt.Fprintf(os.Stderr, "dup3:%v\n", err)
		}

		for _, line := range strings.Split(string(data), "\n") {
			counts[line]++
		}

	}

	for line, n := range counts {
		fmt.Printf("%d\t%s\n", n, line)
	}
}
func pdup3(){
	counts := make(map[string] int)
	for _, fileName := range os.Args {
		data, err := ioutil.ReadFile(fileName)
		if err != nil {
			fmt.Fprintf(os.Stderr, "dup3:%v\n", err)
		}

		for _, line := range strings.Split(string(data), "\n") {
			counts[line]++
			if counts[line] > 1 {
				fmt.Println(fileName)
				break
			}
		}

	}
}
