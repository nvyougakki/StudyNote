package com.heyu.netty.demo008_zerocopy;

import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class IOClient {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 9999);
        FileInputStream fileInputStream = new FileInputStream("D:\\Program Files\\java\\gradle-6.4.1-all.zip");

        byte[] writeByte = new byte[4096];
        int len = 0;
        int count = 0;
        long start = System.currentTimeMillis();
        while (-1 != (len = fileInputStream.read(writeByte))) {
            socket.getOutputStream().write(writeByte, 0 ,len);
            count += len;
        }
        System.out.println("写入：" + count + ",用时:" + (System.currentTimeMillis() - start));
    }

}
