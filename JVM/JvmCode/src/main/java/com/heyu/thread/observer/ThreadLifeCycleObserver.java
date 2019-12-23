package com.heyu.thread.observer;

import java.util.List;

public class ThreadLifeCycleObserver implements LifeCycleListener {

    private final Object lock = new Object();

    public void concurrentQuery(List<String> ids){
        ids.forEach(id -> {
            new Thread(new ObserverRunnable(this) {
                @Override
                public void run() {
                    try{
                        notifyChange(new RunnableEvent(RunnableState.RUNNING, Thread.currentThread(), null));
                        //dosth
                        Thread.sleep(3_000);
                        notifyChange(new RunnableEvent(RunnableState.DONE, Thread.currentThread(), null));
                    } catch (Exception e) {
                        notifyChange(new RunnableEvent(RunnableState.ERROR, Thread.currentThread(), e));
                    }
                }
            }, id).start();
        });
    }

    @Override
    public void onEvent(ObserverRunnable.RunnableEvent e) {
        if(e.getE() != null) {
            System.out.println("出错");
        }
    }
}
