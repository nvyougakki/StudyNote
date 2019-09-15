package com.heyu.demo1;

/**
 * @ClassName ClassLoadTest
 * @Description TODO
 * @Author Å®ÓÑGakki
 * @Date 2019/9/14 15:38
 */
public class ClassLoadTest {

    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> clazz = Class.forName("java.lang.String");
        System.out.println(clazz.getClassLoader());

        Class<?> aClass = A.class;
        System.out.println(aClass.getClassLoader());

        int[] aArr = new int[5];
        System.out.println(aArr.getClass().getClassLoader());
    }

}

class A {

}
