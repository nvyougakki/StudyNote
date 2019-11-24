package com.heyu.jvm.demo1;

/**
 * @ClassName demo2
 * @Description TODO
 * @Author Ů��Gakki
 * @Date 2019/9/14 11:19
 */

public class Demo2 {

    public static void main(String[] args) {
        System.out.println(Test.i);
    }

}

class Test{
    public static int i = 1;

    static {
        System.out.println("init static area");
    }
}
