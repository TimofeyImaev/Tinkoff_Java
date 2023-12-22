package edu.hw10;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {
    @Test
    void givenFibFunctionWhenUseFunctionTwoTimesThenCheckCache() {
        Task2.FibCalculator fibCalculator = new Task2.Fib();
        Task2.FibCalculator proxy = Task2.CacheProxy.create(fibCalculator, Task2.FibCalculator.class);

        long expectedAnswerFive = proxy.fib(5);
        long expectedAnswerSeven = proxy.fib(7);
        long expectedAnswerTwo = proxy.fib(2);
        long expectedAnswerOne = proxy.fib(1);

        assertThat(
            proxy.fib(5) == expectedAnswerFive
            && proxy.fib(1) == expectedAnswerOne
            && proxy.fib(7) == expectedAnswerSeven
            && proxy.fib(2) == expectedAnswerTwo
        );
    }

    @Test
    void givenSquareFunctionWhenUseFunctionTwoTimesThenCheckCache() {
        Task2.SquareOfNumber square = new Task2.Square();
        Task2.SquareOfNumber proxy = Task2.CacheProxy.create(square, Task2.SquareOfNumber.class);

        long expectedAnswerFive = proxy.square(5);
        long expectedAnswerTen = proxy.square(10);
        long expectedAnswerTwelve = proxy.square(12);
        long expectedAnswerOne = proxy.square(1);

        assertThat(
            proxy.square(5) == expectedAnswerFive
                && proxy.square(1) == expectedAnswerOne
                && proxy.square(10) == expectedAnswerTen
                && proxy.square(12) == expectedAnswerTwelve
        );
    }

    @Test
    void givenConcatenateFunctionWhenUseFunctionTwoTimesThenCheckCache() {
        Task2.StringConcatenation fibCalculator = new Task2.Concatenate();
        Task2.StringConcatenation proxy = Task2.CacheProxy.create(fibCalculator, Task2.StringConcatenation.class);

        String expectedAnswerLengthSix = proxy.concatenate("aba", "cab");
        String expectedAnswerLengthSeven = proxy.concatenate("htye", "dgs");
        String expectedAnswerLengthOne = proxy.concatenate("", "c");
        String expectedAnswerLengthTwo = proxy.concatenate("a", "b");
        String expectedAnswerLengthFive = proxy.concatenate("abag", "b");

        assertThat(
            proxy.concatenate("aba", "cab") == expectedAnswerLengthSix
            && proxy.concatenate("a", "b") == expectedAnswerLengthTwo
            && proxy.concatenate("htye", "dgs") == expectedAnswerLengthSeven
            && proxy.concatenate("", "c") == expectedAnswerLengthOne
            && proxy.concatenate("abag", "b") == expectedAnswerLengthFive);
    }
}
