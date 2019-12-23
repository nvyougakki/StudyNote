package com.heyu.thread.observer;

public abstract class Observer {


    protected Subject subject;

    public Observer(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    public void update() {

    }

}
