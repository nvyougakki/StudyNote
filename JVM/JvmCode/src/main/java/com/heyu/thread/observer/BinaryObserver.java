package com.heyu.thread.observer;

public class BinaryObserver extends Observer {

    public BinaryObserver(Subject subject) {
        super(subject);
    }

    @Override
    public void update() {
        System.out.println("update state :" + Integer.toBinaryString(subject.getState()));
    }
}
