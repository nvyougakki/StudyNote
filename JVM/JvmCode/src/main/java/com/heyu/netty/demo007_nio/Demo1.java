package com.heyu.netty.demo007_nio;

import java.nio.IntBuffer;

public class Demo1 {

    public static void main(String[] args) {
        IntBuffer intBuffer = IntBuffer.allocate(10);

        for(int i = 0; i < intBuffer.array().length; i++) {
            intBuffer.put(i);
        }
        intBuffer.flip();
        intBuffer.put(1000);
        while (intBuffer.remaining() > 0) {
            System.out.println(intBuffer.get());
        }
    }

}
