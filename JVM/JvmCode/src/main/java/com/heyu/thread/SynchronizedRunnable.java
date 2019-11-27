package com.heyu.thread;

/**
 * @ClassName SynchronizedRunnable
 * @Description TODO
 * @Author 女友Gakki
 * @Date 2019/11/26 22:15
 */
public class SynchronizedRunnable implements Runnable {

    public static int index = 0;

    public static final Object LOCK = new Object();

    public void testSynchornizedThis(){
        System.out.println("test synchronized this");
        synchronized (this){
            System.out.println("22222");
        }
    }

    public void testSynchornizedStatic(){
        System.out.println("test synchronized static");
        /*try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        synchronized (SynchronizedRunnable.class){
            System.out.println(++index);
        }
    }

    @Override
    public void run() {
        while (true) {
            if(getNumber()) break;
        }
    }

    public static synchronized boolean getNumber(){
        if(index > 100) return true;
        try {
            Thread.sleep(1);
            System.out.println(Thread.currentThread().getName() + ": " + ++index);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }
}
