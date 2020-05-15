package com.heyu.netty.demo006_protobuf;

import com.google.protobuf.InvalidProtocolBufferException;

public class Main {

    public static void main(String[] args) throws InvalidProtocolBufferException {
        TestProto.Student heyu = TestProto.Student.newBuilder().
                setAge(13).setId("123455").setName("heyu").build();
        byte[] bytes = heyu.toByteArray();

        TestProto.Student student = TestProto.Student.parseFrom(bytes);
        System.out.println(student.toString());
    }
}
