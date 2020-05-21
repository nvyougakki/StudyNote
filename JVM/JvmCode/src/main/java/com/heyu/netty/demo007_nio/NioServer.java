package com.heyu.netty.demo007_nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class NioServer {

    private static Map<String, SocketChannel> clientMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        Selector selector = Selector.open();

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);

        ServerSocket socket = serverSocketChannel.socket();
        socket.bind(new InetSocketAddress(9999));

        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true) {
            int select = selector.select();

            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            System.out.println("selectKeys: " + selectionKeys.size());

            for (SelectionKey selectionKey : selectionKeys) {
                final SocketChannel client;
                try {
                    if (selectionKey.isAcceptable()) {
                        ServerSocketChannel channel = (ServerSocketChannel) selectionKey.channel();
                        client = channel.accept();
                        client.configureBlocking(false);

                        client.register(selector, SelectionKey.OP_READ);

                        clientMap.put("【" + UUID.randomUUID().toString() + "】", client);

                    } else if (selectionKey.isReadable()) {
                        client = (SocketChannel) selectionKey.channel();
                        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

                        int count = client.read(byteBuffer);

                        if (count > 0) {
                            byteBuffer.flip();
                            Charset charset = Charset.forName("utf-8");
                            String message = String.valueOf(charset.decode(byteBuffer).array());

                            System.out.println("client：" + message);

                            String sendKey = null;
                            for (Map.Entry<String, SocketChannel> entry : clientMap.entrySet()) {
                                if (client == entry.getValue()) {
                                    sendKey = entry.getKey();
                                    break;
                                }
                            }
                            for (Map.Entry<String, SocketChannel> entry : clientMap.entrySet()) {
                                SocketChannel value = entry.getValue();
                                ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
                                String writeMsg = sendKey + "：" + message;
                                writeBuffer.put(writeMsg.getBytes());
                                writeBuffer.flip();
                                value.write(writeBuffer);
                            }
                        }
                    }
                } catch (Exception e) {

                }

            }

            selectionKeys.clear();


        }



    }

}
