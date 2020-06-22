package com.heyu.netty.demo007_nio;

public class Demo {

    private static Boolean[] flag = {true, false, true};
    static class Thread1 extends Thread {
        @Override
        public void run() {
            System.out.println("Thread1开始执行");
            if (flag[2]) {
                flag[2] = false;
            }

            System.out.println("Thread1执行完毕");
        }
    }
    static class Thread2 extends Thread {
        @Override
        public void run() {
            System.out.println("Thread2开始执行");

            while (flag[2]) {
                //System.out.println(flag[2]);
                //flag[1] = true;
            }
            System.out.println("Thread2执行完毕");
        }
    }
    public static void main(String[] args) throws InterruptedException {
        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();
        thread2.start();
        Thread.sleep(2000);
        thread1.start();
    }

}
