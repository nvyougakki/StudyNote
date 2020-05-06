package com.heyu.netty.demo3;

import com.heyu.netty.demo002.MyClientInit;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MyChatClient {

    public static void main(String[] args) throws InterruptedException, IOException {
        EventLoopGroup client = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(client).channel(NioSocketChannel.class).
                    handler(new MyChatClientInit());
            Channel channel = bootstrap.connect("localhost", 9999).sync().channel();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            for(;;) {
                channel.writeAndFlush(br.readLine() + "\r\n");
            }
        } finally {
            client.shutdownGracefully();
        }
    }

}
