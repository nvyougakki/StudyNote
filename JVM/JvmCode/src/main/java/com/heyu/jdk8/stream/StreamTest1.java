package com.heyu.jdk8.stream;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @ClassName StreamTest1
 * @Description TODO
 * @Author 女友Gakki
 * @Date 2019/11/20 22:02
 */
public class StreamTest1 {

    public static void main(String[] args) {
        Stream<String> stream = Stream.of("h1", "h2", "h3");
        System.out.println(Stream.of("h1", "h2", "h3").getClass());
//        String[] strings = stream.toArray(length -> new String[length]);
//        Arrays.asList(strings).forEach(System.out::println);

//        stream.collect()
    }

}
