package com.heyu.netty.demo006_protobuf;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;


public class TestClient {
    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup client = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(client).channel(NioSocketChannel.class).
                    handler(new TestClientInitializer());
            ChannelFuture localhost = bootstrap.connect("localhost", 9999).sync();
            localhost.channel().closeFuture().sync();
        } finally {
            client.shutdownGracefully();
        }
    }
}
