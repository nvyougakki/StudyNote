package com.heyu.thread;

import org.omg.CosNaming.BindingIterator;

import java.util.stream.Stream;

public class ThreadSafepush {

    public Holder holder;

    public void initlize(){
        holder = new Holder(24);
    }

    public static void main(String[] args) {
        Holder holder = new Holder(1);
        new Thread(() -> {
            while (true) {
                holder.test();
            }
        }, "t1").start();

        new Thread(() -> {
            int i = 0;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while (true) {
                holder.setI(i++);
            }
        }, "t2").start();
    }

}

class Holder {
    private int i = 0;

    Holder(int i){
        this.i = i;
    }

    public void setI(int i ) {
        this.i = i;
    }

    public void test(){
        if(i != i) {
            throw new AssertionError("不安全的引用");
        }
    }
}
