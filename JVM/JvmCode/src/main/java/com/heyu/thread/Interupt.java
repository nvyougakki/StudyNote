package com.heyu.thread;

/**
 * @ClassName Interupt
 * @Description TODO
 * @Author 女友Gakki
 * @Date 2019/11/26 21:28
 */
public class Interupt {

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while (true){
                try {
                    Thread.sleep(1_000);
                } catch (InterruptedException e) {
                    System.out.println("中断线程");

                    e.printStackTrace();
                    break;
                }
            }
        });
        t1.start();
        try {
            Thread.sleep(5_000);
            t1.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
