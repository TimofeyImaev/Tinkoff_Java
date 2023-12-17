package edu.hw10;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {
    @Test
    void givenFibFunctionWhenUseFunctionTwoTimesThenCheckCache() {
        Task2.FibCalculator fibCalculator = new Task2.Fib();
        Task2.FibCalculator proxy = Task2.CacheProxy.create(fibCalculator, Task2.FibCalculator.class);

        long expectedAnswer = proxy.fib(5);

        assertThat(proxy.fib(5)).isEqualTo(expectedAnswer);
    }

    @Test
    void givenSquareFunctionWhenUseFunctionTwoTimesThenCheckCache() {
        Task2.SquareOfNumber square = new Task2.Square();
        Task2.SquareOfNumber proxy = Task2.CacheProxy.create(square, Task2.SquareOfNumber.class);

        long expectedAnswer = proxy.square(5);

        assertThat(proxy.square(5)).isEqualTo(expectedAnswer);
    }

    @Test
    void givenConcatenateFunctionWhenUseFunctionTwoTimesThenCheckCache() {
        Task2.StringConcatenation fibCalculator = new Task2.Concatenate();
        Task2.StringConcatenation proxy = Task2.CacheProxy.create(fibCalculator, Task2.StringConcatenation.class);

        String expectedAnswer = proxy.concatenate("aba", "cab");

        assertThat(proxy.concatenate("aba", "cab")).isEqualTo(expectedAnswer);
    }
}
