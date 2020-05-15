package com.heyu.netty.demo006_protobuf;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class TestClientHandler extends SimpleChannelInboundHandler<TestProto.Student> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TestProto.Student msg) throws Exception {
        System.out.println("**********client***********");
        System.out.println(msg.toString());
        System.out.println("**********client***********");
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("sendmsg");
        TestProto.Student heyu = TestProto.Student.newBuilder().
                setName("heyu").setId("124342").setAge(18).build();
        ctx.channel().writeAndFlush(heyu);
    }
}
