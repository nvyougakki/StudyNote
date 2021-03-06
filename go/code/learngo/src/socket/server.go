package main

import (
	"bufio"
	"fmt"
	"net"
)

func main() {
	listener, err := net.Listen("tcp", "127.0.0.1:20000")
	if err != nil {
		fmt.Println("listen failed ,err:", err)
		return
	}
	for {
		accept, err := listener.Accept()
		if err != nil {
			fmt.Println("accept failed ,err:", err)
			continue
		}
		go process(accept)
	}

}

func process(conn net.Conn) {


	defer conn.Close()

	for {
		reader := bufio.NewReader(conn)
		var buf [3]byte
		n, err := reader.Read(buf[:])
		if err != nil {
			fmt.Println("read failed, err:", err)
			break
		}
		receiveStr := string(buf[:n])
		fmt.Println("receive from client: ", receiveStr)
		conn.Write([]byte(receiveStr))
	}

}