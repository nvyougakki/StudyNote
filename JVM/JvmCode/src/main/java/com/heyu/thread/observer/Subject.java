package com.heyu.thread.observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {

    private final List<Observer> observers = new ArrayList<>();

    private int state;

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void update(int state) {
        if(this.state == state)
            return;
        this.state = state;
        notifAll();

    }

    public int getState() {
        return state;
    }

    public void notifAll(){
        observers.forEach(Observer::update);
    }
}
