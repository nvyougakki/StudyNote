package com.heyu.jvm.demo1;

/**
 * @ClassName Person
 * @Description TODO
 * @Author Ů��Gakki
 * @Date 2019/9/15 20:51
 */
public class Person {

    public Person(){
        System.out.println("person loaded by: " + getClass().getClassLoader());

        new Dog();
    }
}
