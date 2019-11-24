package com.heyu.jdk8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * @ClassName Test3
 * @Description TODO
 * @Author 女友Gakki
 * @Date 2019/11/4 21:07
 */
public class Test3 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("1a","2b","3v");
        list.stream().map(str -> str.toUpperCase());
        Function<Integer, Integer> function1 = val -> val *2;
        Function<String, Integer> before = val -> Integer.parseInt(val);

        test("100",function1, before);
    }


    public static void test(String str, Function<Integer, Integer> function, Function<String, Integer> before){
        int j = function.compose(before).apply(str);
        System.out.println(j);
    }
}
