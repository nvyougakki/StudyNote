package com.heyu.thread.observer;

public abstract class ObserverRunnable implements Runnable {

    private LifeCycleListener listener;

    public ObserverRunnable(LifeCycleListener listener) {
        this.listener = listener;
    }

    public void notifyChange(RunnableEvent e){
        listener.onEvent(e);
    }

    public enum RunnableState {
        RUNNING, ERROR, DONE
    }

    public static class RunnableEvent {
        private final RunnableState state;
        private final Thread thread;
        private final Throwable e;

        public RunnableEvent(RunnableState state, Thread thread, Throwable e) {
            this.state = state;
            this.thread = thread;
            this.e = e;
        }

        public RunnableState getState() {
            return state;
        }

        public Thread getThread() {
            return thread;
        }

        public Throwable getE() {
            return e;
        }
    }
}
