package main

import (
	"bytes"
	"fmt"
	"strconv"
	"strings"
)

func main() {
	fmt.Println(strconv.Itoa(1235544))
	fmt.Println(strconv.ParseInt("123", 2, 128))
	//fmt.Println(comma("1234.1234"))
}

func comma(s string) string {
	var buf bytes.Buffer
	sArr := strings.Split(s, ".")
	if  len(sArr) > 0 {
		for i:=0; i<len(sArr); i++ {
			tmpS:=sArr[i]
			if(tmpS[0] == '-') {
				buf.WriteByte('-')
				tmpS = tmpS[1:]
			}
			for j:=0; j < len(tmpS); j++ {
				var index = (len(tmpS) - j)
				if index%3 == 0 && index != 0 && j != 0 {
					buf.WriteByte(',')
				}
				buf.WriteByte(tmpS[j])
			}
			if i == 0 {
				buf.WriteByte('.')
			}
		}

	}


	return buf.String()
}
