package com.heyu.demo1;

import java.util.Random;

/**
 * @ClassName demo1
 * @Description TODO
 * @Author 女友Gakki
 * @Date 2019/9/13 18:58
 */
/* *
 * 子接口或子类初始化时，父接口不初始化
 * 只有当调用父接口的类常量时候才初始化
 **/
public class demo1 {

    public static void main(String[] args) {
        System.out.println(Children.i);
    }

}

interface MyParent{
    Thread t = new Thread(){
        {
            System.out.println("parent init");
        }
    };
    int par = 1;
}
interface Children extends MyParent{
    int i = new Random().nextInt(5);
    Thread t = new Thread(){
        {
            System.out.println("child init");
        }
    };
}
