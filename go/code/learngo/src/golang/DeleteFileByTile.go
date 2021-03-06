package main

import (
	"flag"
	"os"

	//"flag"
	"fmt"
	"io/ioutil"
	"time"
)

func main() {
	dir := flag.String("dir", "", "目录")
	minute := flag.Int64("minute", 5, "时间间隔")
	flag.Parse()

	if len(*dir) == 0 {
		panic("dir is empty")
		return
	}
	fileInfos, err := ioutil.ReadDir(*dir)

	if(err != nil) {
		panic("open " + *dir + " fail")
		fmt.Println(err)
	}
	for {
		go func() {
			now := time.Now().Add(-time.Duration(time.Minute.Nanoseconds() * *minute))
			//now = now.Add(ti)
			fmt.Println(now)
			for _, file := range fileInfos{

				if now.After(file.ModTime()) && !file.IsDir() {
					//fmt.Println(file.Name())
					fmt.Printf("remove file: %s\r\n", file.Name())
					os.Remove(*dir + "/" +file.Name())
				}
			}
		}()

		time.Sleep(time.Duration(time.Minute.Nanoseconds() * *minute))
	}


}
