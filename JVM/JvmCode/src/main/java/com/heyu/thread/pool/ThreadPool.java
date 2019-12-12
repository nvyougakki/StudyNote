package com.heyu.thread.pool;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class ThreadPool {

    private final int size;

    private static final int DEFAULT_SIZE = 10;

    private static final ThreadGroup GROUP = new ThreadGroup("POOL_GROUP");

    private static volatile int THREAD_NAME_NUMBER = 1;

    private static final String THREAD_NAME_PREFIX = "MY_POLL_THREAD-";

    private static final LinkedList<Runnable> TASK_QUENE = new LinkedList<>();

    private static final ArrayList<Thread> THREAD_QUENE = new ArrayList<>();

    public ThreadPool(){
        this(DEFAULT_SIZE);
    }

    public ThreadPool(int size) {
        this.size = size;
        init();
    }

    public void init() {
        for (int i = 0; i < size; i++) {
            createTask();
        }
    }

    public void submit(Runnable runnable){
        synchronized (TASK_QUENE) {
            TASK_QUENE.addLast(runnable);
            TASK_QUENE.notifyAll();
        }
    }

    public void createTask() {
        WorkTask workTask = new WorkTask(GROUP, THREAD_NAME_PREFIX + (THREAD_NAME_NUMBER++));
        workTask.start();
        THREAD_QUENE.add(workTask);
    }

    private enum TaskState {
        FREE, RUNNING, BLOCK, DEAD
    }


    private class WorkTask extends Thread {

        private volatile TaskState state = TaskState.FREE;

        public TaskState getTaskState() {
            return state;
        }

        public WorkTask(ThreadGroup group, String name) {
            super(group, name);
        }

        @Override
        public void run() {
            OUTTER:
            while (state == TaskState.FREE) {
                Runnable runnable;
                synchronized (TASK_QUENE) {
                    while (TASK_QUENE.isEmpty()) {
                        try {
                            state = TaskState.BLOCK;
                            TASK_QUENE.wait();
                        } catch (InterruptedException e) {
                            break OUTTER;
                        }
                    }

                    runnable = TASK_QUENE.removeFirst();
                }
                if(runnable != null) {
                    state = TaskState.RUNNING;
                    runnable.run();
                    state = TaskState.FREE;
                }
            }
        }


        public void close() {
            state = TaskState.DEAD;
        }

    }

    public static void main(String[] args) {
        ThreadPool threadPool = new ThreadPool();
        IntStream.rangeClosed(0, 40).forEach(i -> {
            threadPool.submit(() -> {
                System.out.println("the running " + i + " working on " +  Thread.currentThread().getName());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        });
    }
}
