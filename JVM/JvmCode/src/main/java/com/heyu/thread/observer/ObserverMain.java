package com.heyu.thread.observer;

public class ObserverMain {

    public static void main(String[] args) {
        Subject subject = new Subject();
        new BinaryObserver(subject);
        subject.update(3);
        subject.update(3);
        subject.update(5);
    }

}
