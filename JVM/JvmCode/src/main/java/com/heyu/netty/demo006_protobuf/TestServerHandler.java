package com.heyu.netty.demo006_protobuf;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class TestServerHandler extends SimpleChannelInboundHandler<TestProto.Student> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TestProto.Student msg) throws Exception {
        System.out.println("**********server***********");
        System.out.println(msg.toString());
        System.out.println("**********server***********");
    }
}
