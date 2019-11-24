package com.heyu.jvm.demo1;

/**
 * @ClassName Dog
 * @Description TODO
 * @Author Ů��Gakki
 * @Date 2019/9/15 20:50
 */
public class Dog {

    public Dog(){
        System.out.println("dog loaded by :" + getClass().getClassLoader());
    }

}
