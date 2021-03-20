package main

import (
	"io"
	"log"
	"os"
)

func main() {
	file, err := os.Open("./base64.txt")
	if err != nil {
		log.Printf("open file error; %s", err)
		return
	}
	defer file.Close()
	var buf [128]byte
	var content []byte
	for {
		n, err := file.Read(buf[:])
		if err == io.EOF {
			break
		}
		if err  != nil {
			log.Printf("read file error;%s", err)
			return
		}
		content = append(content, buf[:n]...)
	}
	log.Println(string(content))

}
