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

    public static void main(String[] args) {
        TestVolatile.getInstance();
    }

}
