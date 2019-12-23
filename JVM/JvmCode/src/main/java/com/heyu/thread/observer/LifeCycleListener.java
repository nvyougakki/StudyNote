package com.heyu.thread.observer;

public interface LifeCycleListener {

    void onEvent(ObserverRunnable.RunnableEvent e);
}
