package com.heyu.demo1;

/**
 * @ClassName demo2
 * @Description TODO
 * @Author 女友Gakki
 * @Date 2019/9/14 11:19
 */
//Test3不初始化
//因为此时i是编译期常量，编译后Test.i的值直接进入Demo3的常量池
//查看Demo3反编译指令码
//iconst_1
public class Demo3 {

    public static void main(String[] args) {
        System.out.println(Test3.b);
    }

}

class Test3{
    public static final byte b = 0;
    public static final short s = 130;
    public static final int i = 8519680;
    public static final long l = 268435456l;



    static {
        System.out.println("init static area");
    }
}
