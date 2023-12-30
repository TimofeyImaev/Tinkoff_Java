package edu.hw10.task2;

public class Fib implements FibCalculator {
    @Override
    public long fib(int number) {
        if (number <= 1) {
            return 0;
        }
        return fib(number - 1) + fib(number - 2);
    }
}
