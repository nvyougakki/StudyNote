package com.heyu.demo1;

/**
 * @ClassName demo2
 * @Description TODO
 * @Author 女友Gakki
 * @Date 2019/9/14 11:19
 */
/* *
 * 只进行父类的初始化
 * 因为
 **/
public class Demo4 {

    public static void main(String[] args) {
        System.out.println(MyChild4.i);
    }

}

class MyParent4{
    public static int i = 10;

    static {
        System.out.println("init parent static area");
    }
}

class MyChild4 extends MyParent4{

    static {
        System.out.println("init child static area");
    }
}
