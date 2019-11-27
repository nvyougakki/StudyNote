package com.heyu.thread;

/**
 * @ClassName TestJoin
 * @Description TODO
 * @Author 女友Gakki
 * @Date 2019/11/25 22:16
 */
public class TestJoin {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            System.out.println("t1 start");
            try {
                Thread.sleep(100_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t1 end");
        });
        Thread t2 = new Thread(()->{
            System.out.println("t2 start");
            try {
                Thread.sleep(100_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t2 end");
        });
        t2.join();
    }

}
