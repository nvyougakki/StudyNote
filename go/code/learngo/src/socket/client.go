package main

import (
	"bufio"
	"fmt"
	"io"
	"net"
	"strings"
)

// 客户端
func main() {
	conn, err := net.Dial("tcp", "www.baidu.com:80")
	if err != nil {
		fmt.Println("err :", err)
		return
	}
	defer conn.Close() // 关闭连接
	//inputReader := bufio.NewReader(os.Stdin)
	//for {
	//	input, _ := inputReader.ReadString('\n') // 读取用户输入
	//	fmt.Println(input)
	//	inputInfo := strings.Trim(input, "\r\n")
	//	if strings.ToUpper(inputInfo) == "Q" { // 如果输入q就退出
	//		return
	//	}
	//	_, err = conn.Write([]byte(inputInfo)) // 发送数据
	//	if err != nil {
	//		return
	//	}
	//	buf := [512]byte{}
	//	n, err := conn.Read(buf[:])
	//	if err != nil {
	//		fmt.Println("recv failed, err:", err)
	//		return
	//	}
	//	fmt.Println(string(buf[:n]))
	//}

	buf := [512]byte{}
	//var resp []byte
	reader := bufio.NewReader(conn)
	for {

		//_, err = conn.Write([]byte("GET / HTTP/1.1\r\nHost:www.baidu.com\r\n\r\n")) // 发送数据
		input, _ := reader.ReadString('\n')
		inputInfo := strings.Trim(input, "\r\n")
		fmt.Println(inputInfo)
		_, err = conn.Write([]byte(inputInfo)) // 发送数据
		for {
			n, err := reader.Read(buf[:])
			fmt.Println(n)
			if err == io.EOF {
				//conn.Close()
				break;
			}
			if n == 0 {
				//conn.Close()
				break;
			}
			if err != nil {
				fmt.Println("recv failed, err:", err)
				return
			}
			fmt.Print(string(buf[:n]))
		}


		//resp = append(resp, buf[:n]...)

	}


}