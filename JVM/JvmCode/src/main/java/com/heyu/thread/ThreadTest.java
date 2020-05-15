package com.heyu.thread;

import java.util.Hashtable;
import java.util.Optional;

/**
 * @ClassName ThreadTest
 * @Description TODO
 * @Author 女友Gakki
 * @Date 2019/11/25 22:05
 */
public class ThreadTest {



    public static void main(String[] args) {
        Thread t = new Thread(()->{
            Optional.of("helloworld").ifPresent(System.out::println);

            try {
                Thread.sleep(100_1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1");
        System.out.println(t.getId());
        System.out.println(t.getName());
        System.out.println(t.getPriority());
        System.out.println(t.getState());
        t.start();
        System.out.println(t.getState());
    }

}
