package com.heyu.netty.demo008_zerocopy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;

public class NIOClient {

    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("localhost", 9999));
        socketChannel.configureBlocking(true);
        FileChannel fileChannel = new FileInputStream("D:\\Program Files\\java\\gradle-6.4.1-all.zip").getChannel();

        long start = System.currentTimeMillis();
        long size = fileChannel.size();
        long position = 0;
        long len = 0;
        while (true) {
            System.out.println(position);
            len = fileChannel.transferTo(position, size, socketChannel);
            System.out.println(len);
            if(len <= 0) {
                break;
            }
            position += len;
           // System.out.println(len + "," + count);
        }


        System.out.println("传输：" + position + ";用时：" + (System.currentTimeMillis() - start));
       /* while(true){

        }*/
        fileChannel.close();

    }
}


