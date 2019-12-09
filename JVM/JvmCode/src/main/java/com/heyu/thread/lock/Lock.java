package com.heyu.thread.lock;

import java.util.concurrent.TimeoutException;

public interface Lock {

    void lock() throws InterruptedException;

    void lock(long times) throws InterruptedException, TimeoutException;

    void unlock() throws InterruptedException;

}
