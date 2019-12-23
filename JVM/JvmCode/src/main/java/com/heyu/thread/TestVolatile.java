package com.heyu.thread;


public class TestVolatile {

    private volatile static TestVolatile instance;

    public static TestVolatile getInstance(){
        synchronized (TestVolatile.class) {
            if(instance == null) {
                instance = new TestVolatile();
            }
        }
        return instance;
    }
    private static volatile int initValue = 0;
    private final static int MAX_VALUE = 5;

    public static void main(String[] args) {

        new Thread(() -> {
//            try {
                int localValue = initValue;
                while(localValue < MAX_VALUE) {
                    if(localValue != initValue) {
                        System.out.printf("initValue update to %d\n", initValue);
                        localValue = initValue;
                    }
                }
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }

        }, "READ").start();
        new Thread(() -> {
            int localValue = initValue;
            try {
                while(localValue < MAX_VALUE) {
                    initValue = ++localValue;
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "WRITE").start();
    }





}
