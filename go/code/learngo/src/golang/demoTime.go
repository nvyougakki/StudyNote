package main

import (
	"flag"
	"fmt"
	"time"
)

func main() {
	now := time.Now()

	fmt.Println(now.Format("2006-01-02 15:04:05"))

	name := flag.String("name", "heyu", "姓名")
	age := flag.Int("age", 19, "年龄")
	flag.Parse()
	fmt.Println(*name, *age)
}
