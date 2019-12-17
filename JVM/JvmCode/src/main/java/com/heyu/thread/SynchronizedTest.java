package com.heyu.thread;

import java.util.Collections;

/**
 * @ClassName SynchronizedTest
 * @Description TODO
 * @Author 女友Gakki
 * @Date 2019/11/26 21:51
 */
public class SynchronizedTest {

    public synchronized void test(){

    }

    public static void main(String[] args) {
        SynchronizedRunnable target = new SynchronizedRunnable();
        /*Thread t1 = new Thread(target,"1号窗口");
        Thread t2 = new Thread(target,"2号窗口");
        Thread t3 = new Thread(target,"3号窗口");

        t1.start();
        t2.start();
        t3.start();*/

        //证明属性方法锁是this锁
//        Thread t1 = new Thread(target, "test this lock");
//        t1.start();
//        target.testSynchornizedThis();

        //证明属性方法锁是.class锁
        Thread t1 = new Thread(target, "test static lock");
        t1.start();
        target.testSynchornizedStatic();
    }

}
