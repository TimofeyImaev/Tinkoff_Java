package edu.hw8.task2;

public class CalculateFibonacci {
    private CalculateFibonacci() {

    }

    public static int calculateFibonacci(int n) {
        if (n <= 1) {
            return 1;
        }

        return calculateFibonacci(n - 1) + calculateFibonacci(n - 2);
    }

    public static int[] fastFibonacciCalculator(int n) {
        final int COUNT_OF_THREADS_FOUR = 4;

        int[] fibonacciNumbers = new int[n];
        FixedThreadPool fixedThreadPool = FixedThreadPool.create(COUNT_OF_THREADS_FOUR);

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
}
