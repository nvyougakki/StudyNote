### http协议

**http请求**：

- 请求方法  请求资源路径  协议版本
- 请求头
- 请求实体

```http
GET  /index.html HTTP/1.1
Connection: keep-alive
Pragma: no-cache
Cache-Control: no-cache
Upgrade-Insecure-Requests: 1
User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/76.0.3809.132 Safari/537.36
Sec-Fetch-Mode: navigate
Sec-Fetch-User: ?1
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3
```

**http响应**：

- 协议  状态码  描述
- 响应头
- 响应实体

```http
HTTP/1.1 200 OK
Date: Thu, 12 Sep 2019 07:38:37 GMT
Content-Type: text/html; charset=utf-8
Transfer-Encoding: chunked
Server: GitHub.com
Status: 200 OK
Vary: X-PJAX

```



### Socket类

客户端套接字；socket 套接字用于在网络通信，不同计算机程序可以通过他交流。

新建一个套接字需要直到IP和端口号，新建一个java套接字的方法

```java
public Socket(String host, int port);

new Socket("127.0.0.1", 8080); //访问本机8080端口的程序
```

创建成功后即可通过socket接收和发送字节流；通过socket.getInputStream返回的字节流读取信息，通过socket.getOutputStream返回的流写入信息

#### ServerSocket类

表示服务端套接字；服务端套接字用于等待客户端发起请求，并进行相应的相应

可通过如下构造函数创建

```java
public ServerSocket(int port, int backlog, InetAddress bindAddr) throws IOException {}

serverSocket =  new ServerSocket(8080, 1, InetAddress.getByName("127.0.0.1"));
```

serverSocket的accept会阻塞线程，当有客户端发情请求时，才会执行accept()方法并向下执行，该方法返回一个Socket实例，该socket实例可通过getInputStream获取客户端传送的字节流，getOutputStream返回字节流给客户端

具体的源代码见代码目录ex01，ex01是一个简单的http协议解析：通过getInputStream获取客户端发送的HTTP请求、解析请求头、获取资源文件，将资源文件写入socket获取的OutputStream返回到浏览器客户端（官网下载的代码会访问不到，原因是未在返回index.html之前没有写入HTTP相应信息）

使用/SHOTDOWN进行关闭



