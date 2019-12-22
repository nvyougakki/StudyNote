package com.heyu.thread.singleton;

/**
 * @ClassName Singleton1
 * @Description TODO
 * @Author 女友Gakki
 * @Date 2019/12/18 21:16
 */
public class Singleton1 {

    private Singleton1() {

    }

    //第一中单例：饿汉式
    private static final Singleton1 singleton1 = new Singleton1();

    public Singleton1 getInstance(){
        return singleton1;
    }

    //第二种   在多线程下不安全
    private static Singleton1 singleton2;

    public Singleton1 getInstance2(){
        if(null == singleton2) {
            singleton2 = new Singleton1();
        }
        return singleton2;
    }

    //第三种 double check

    private static volatile Singleton1 singleton3;

    public Singleton1 getInstance3(){
            if(null == singleton3) {
                synchronized (singleton3){
                    if(singleton3 == null)
                        singleton3 = new Singleton1();
                }

            }
        return singleton3;
    }

    private static Singleton1 singleton4;


    //第五种

    private static class InstanceHolder {
        private final static Singleton1 instance = new Singleton1();
    }

    public Singleton1 getInstance5(){
        return InstanceHolder.instance;
    }

    //枚举
    private enum Singleton {
        INSTANCE;
        private final Singleton1 instance;

        Singleton() {
            instance = new Singleton1();
        }

        public Singleton1 getInstance() {
           return instance;
        }
    }

    public static Singleton1 getInstance6() {
        return Singleton.INSTANCE.getInstance();
    }

}
