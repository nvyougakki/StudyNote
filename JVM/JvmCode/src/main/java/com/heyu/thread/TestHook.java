package com.heyu.thread;

/**
 * @ClassName TestHook
 * @Description TODO
 * @Author 女友Gakki
 * @Date 2019/12/10 21:35
 */
public class TestHook {

    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {

        }));

        
    }

}