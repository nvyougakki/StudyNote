package com.heyu.netty.demo007_nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class Demo02 {

    public static void main(String[] args) throws IOException {
        RandomAccessFile file = new RandomAccessFile("NioTest1.txt", "rw");
        FileChannel channel = file.getChannel();
        MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_WRITE, 0, 5);
        map.put(0, (byte)'z');
        map.put(4, (byte)'x');
        channel.close();
        file.close();
    }

}
