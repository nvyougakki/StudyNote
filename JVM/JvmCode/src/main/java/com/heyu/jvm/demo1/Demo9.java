package com.heyu.jvm.demo1;

/**
 * @ClassName Demo9
 * @Description TODO
 * @Author Ů��Gakki
 * @Date 2019/9/17 23:00
 */
public class Demo9 {

    public static void main(String[] args) {
        ClassLoaderTest3 myClassLoader1 = new ClassLoaderTest3("loder1");
        ClassLoaderTest3 myClassLoader2 = new ClassLoaderTest3(myClassLoader1, "loder2");
    }
}
