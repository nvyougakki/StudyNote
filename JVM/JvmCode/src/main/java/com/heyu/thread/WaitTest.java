package com.heyu.thread;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.LongAdder;

public class WaitTest {

    private static final Object LOCK = new Object();


    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            while(true) {
                synchronized (LOCK) {
                    try {
                        long currTime = System.currentTimeMillis();
                        System.out.println("before wait date: " + currTime);
                        LOCK.wait(10000);
                        System.out.println("after wait date：" + currTime);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t1.start();
        Thread.sleep(2000L);
        synchronized (LOCK){
            LOCK.notify();
        }
        Random random = new Random();
        random.nextInt(5);



    }

}
