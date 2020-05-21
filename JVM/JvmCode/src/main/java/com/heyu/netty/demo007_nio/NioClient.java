package com.heyu.netty.demo007_nio;

import io.netty.util.CharsetUtil;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NioClient {

    public static void main(String[] args) throws IOException {
        Selector selector = Selector.open();
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        socketChannel.register(selector, SelectionKey.OP_CONNECT);
        socketChannel.connect(new InetSocketAddress("localhost", 9999));

        while (true) {
            int select = selector.select();
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            selectionKeys.forEach(selectionKey -> {
                try{
                    if(selectionKey.isConnectable()) {
                        System.out.println("已建立连接");
                        SocketChannel client = (SocketChannel) selectionKey.channel();
                        if(client.isConnectionPending()) {
                            client.finishConnect();
                            ByteBuffer writeBuf = ByteBuffer.allocate(1024);
                            writeBuf.put((LocalDateTime.now() + " 连接成功").getBytes());
                            writeBuf.flip();
                            client.write(writeBuf);

                            ExecutorService executorService = Executors.newSingleThreadExecutor(Executors.defaultThreadFactory());
                            executorService.submit(() -> {
                                while (true) {
                                    writeBuf.clear();
                                    InputStreamReader inputStreamReader = new InputStreamReader(System.in);
                                    BufferedReader bf = new BufferedReader(inputStreamReader);

                                    String msg = bf.readLine();
                                    writeBuf.put(msg.getBytes());
                                    writeBuf.flip();
                                    client.write(writeBuf);
                                }
                            });
                            /*ByteBuffer readBuf = ByteBuffer.allocate(1024);
                            executorService.submit(() -> {

                                while (true) {
                                    try {
                                        if(-1 == client.read(readBuf)) {
                                            break;
                                        }
                                        Charset charset = Charset.forName("utf-8");

                                        readBuf.flip();
                                        System.out.println(String.valueOf(charset.decode(readBuf).array()));
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                    *//*writeBuf.clear();
                                    InputStreamReader inputStreamReader = new InputStreamReader(System.in);
                                    BufferedReader bf = new BufferedReader(inputStreamReader);

                                    String msg = bf.readLine();
                                    writeBuf.put(msg.getBytes());
                                    writeBuf.flip();
                                    client.write(writeBuf);*//*
                                }
                            });*/
                        }
                        client.register(selector, SelectionKey.OP_READ);
                    } else if(selectionKey.isReadable()) {
                        SocketChannel client = (SocketChannel) selectionKey.channel();
                        ByteBuffer readBuf = ByteBuffer.allocate(1024);
                        int count = client.read(readBuf);

                        if(count > 0) {
                            readBuf.flip();
                            String msg = new String(readBuf.array(), 0, count);
                            System.out.println(msg);
                        }
                    }
                } catch (Exception e) {

                }

            });

            selectionKeys.clear();
        }

    }

}
