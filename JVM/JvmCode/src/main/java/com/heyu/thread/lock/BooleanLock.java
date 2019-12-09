package com.heyu.thread.lock;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeoutException;
import java.util.stream.Stream;

public class BooleanLock implements Lock {

    private boolean lockValue;

    private Thread currLockThread;

    private List<Thread> waitThreads = new ArrayList<>();

    BooleanLock(){
        this.lockValue = false;
    }

    @Override
    public synchronized void lock() throws InterruptedException {
        while (lockValue) {
            if(!waitThreads.contains(Thread.currentThread()))
                waitThreads.add(Thread.currentThread());
            System.out.println(Thread.currentThread().getName() + " wait");
            this.wait();
            System.out.println(Thread.currentThread().getName() + "  awake");
        }
        lockValue = true;
        System.out.println(Thread.currentThread().getName() + " get lock");
        waitThreads.remove(Thread.currentThread());
        currLockThread = Thread.currentThread();

    }

    @Override
    public synchronized void lock(long times) throws InterruptedException, TimeoutException {

    }

    @Override
    public synchronized void unlock() throws InterruptedException {
        if(Thread.currentThread() == currLockThread) {
            System.out.println(Thread.currentThread().getName() + " unlock");
            this.lockValue = false;
            this.notifyAll();
        }

    }

    public List<Thread> getLockThread() {
        return Collections.unmodifiableList(waitThreads);
    }

    public int getLockThreadSize(){
        return waitThreads.size();
    }


}
