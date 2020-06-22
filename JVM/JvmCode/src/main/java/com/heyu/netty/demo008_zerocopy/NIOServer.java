package com.heyu.netty.demo008_zerocopy;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class NIOServer {

    public static void main(String[] args) throws IOException {
        InetSocketAddress address = new InetSocketAddress(9999);
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        ServerSocket serverSocket = serverSocketChannel.socket();
        serverSocket.setReuseAddress(true);
        serverSocket.bind(address);


        ByteBuffer byteBuffer = ByteBuffer.allocate(4096);


        while (true) {
            SocketChannel socketChannel = serverSocketChannel.accept();
            socketChannel.configureBlocking(true);
            //System.out.println(len);
            int len = 0;
            while (true) {
                try{
                    len = socketChannel.read(byteBuffer);
                    System.out.println(len);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                byteBuffer.rewind();
                if(len < byteBuffer.capacity()) break;

            }


        }
    }

}
