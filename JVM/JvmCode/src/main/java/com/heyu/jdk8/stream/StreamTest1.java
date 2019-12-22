package com.heyu.jdk8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
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

//        String[] arr = stream.toArray(i -> new String[i]);
//        String[] arr1 = stream.toArray(String[]::new);

        System.out.println(Stream.of("h1", "h2", "h3").getClass());
//        String[] strings = stream.toArray(length -> new String[length]);
//        Arrays.asList(strings).forEach(System.out::println);
        List<String> list = stream.collect(() -> new ArrayList<String>(), (r, t) -> r.add(t), (r, t) -> r.addAll(t));
//        List<String> list = stream.collect(Collectors.toList());
//        List<String> list = strea
//        stream.collect()
    }

}
