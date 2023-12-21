package edu.hw8.task2;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class FixedThreadPool implements ThreadPool {
    private final Thread[] threads;
    final BlockingQueue<Runnable> threadTasksQueue;

    FixedThreadPool(int countOfThreads) {
        this.threads = new Thread[countOfThreads];
        this.threadTasksQueue = new LinkedBlockingQueue<>();

        for (int i = 0; i < countOfThreads; ++i) {
            threads[i] = new Thread(
                () -> {
                    while (true) {
                        Runnable taskForThread = null;
                        try {
                            taskForThread = threadTasksQueue.take();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                        if (taskForThread != null) {
                            taskForThread.run();
                        }
                    }
                }
            );
        }
    }

    public static FixedThreadPool create(int countOfThreads) {
        return new FixedThreadPool(countOfThreads);
    }

    @Override
    public void start() {
        for (var thread : threads) {
            thread.start();
        }
    }

    @Override
    public void execute(Runnable runnable) {
        try {
            threadTasksQueue.put(runnable);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void close() {
        for (var thread : threads) {
            thread.interrupt();
        }
    }
}
