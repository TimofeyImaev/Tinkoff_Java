package edu.hw8;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Task2 {
    public static int calculateFibonacci(int n) {
        if (n <= 1) {
            return 1;
        }

        return calculateFibonacci(n - 1) + calculateFibonacci(n - 2);
    }

    public static int[] fastFibonacciCalculator(int n) {
        int[] fibonacciNumbers = new int[n];
        FixedThreadPool fixedThreadPool = FixedThreadPool.create(4);

        for (int i = 1; i <= n; ++i) {
            int finalI = i;
            fixedThreadPool.execute(() -> {
                fibonacciNumbers[finalI - 1] = calculateFibonacci(finalI);
            });
        }

        fixedThreadPool.start();

        while (!fixedThreadPool.threadTasksQueue.isEmpty()) {
        }
        fixedThreadPool.close();

        return fibonacciNumbers;
    }

    public interface ThreadPool extends AutoCloseable {
        void start();

        void execute(Runnable runnable);
    }

    static class FixedThreadPool implements ThreadPool {
        private final Thread[] threads;
        private final BlockingQueue<Runnable> threadTasksQueue;

        public FixedThreadPool(int countOfThreads) {
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
}
