package com.heyu.demo1;

/**
 * @ClassName Dog
 * @Description TODO
 * @Author Å®ÓÑGakki
 * @Date 2019/9/15 20:50
 */
public class Dog {

    public Dog(){
        System.out.println("dog loaded by :" + getClass().getClassLoader());
    }

}
