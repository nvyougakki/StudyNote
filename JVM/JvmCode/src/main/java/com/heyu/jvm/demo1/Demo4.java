package com.heyu.jvm.demo1;

/**
 * @ClassName demo2
 * @Description TODO
 * @Author Ů��Gakki
 * @Date 2019/9/14 11:19
 */
/* *
 * ֻ���и���ĳ�ʼ��
 * ��Ϊ
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
