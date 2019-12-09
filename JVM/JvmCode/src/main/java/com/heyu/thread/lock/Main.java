package com.heyu.thread.lock;

import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        BooleanLock lock = new BooleanLock();
        Stream.of("t1", "t2", "t3", "t4").forEach(name -> new Thread(() -> {
            try {
                lock.lock();
                Main.work();
                System.out.println("wait thread size : " + lock.getLockThreadSize());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                try {
                    lock.unlock();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }, name).start());

        Thread.sleep(2_000);
        lock.unlock();
    }

    public static void work() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " start work");
        Thread.sleep(4_000);
    }

}
