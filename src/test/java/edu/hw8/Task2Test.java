package edu.hw8;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static edu.hw8.task2.CalculateFibonacci.fastFibonacciCalculator;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {
    static Arguments[] fibonacciNumbers() {
        return new Arguments[] {
            Arguments.of(
                1,
                new int[] {1}
            ),
            Arguments.of(
                2,
                new int[] {1, 2}
            ),
            Arguments.of(
                3,
                new int[] {1, 2, 3}
            ),
            Arguments.of(
                4,
                new int[] {1, 2, 3, 5}
            ),
            Arguments.of(
                5,
                new int[] {1, 2, 3, 5, 8}
            ),
            Arguments.of(
                6,
                new int[] {1, 2, 3, 5, 8, 13}
            ),
            Arguments.of(
                7,
                new int[] {1, 2, 3, 5, 8, 13, 21}
            ),
            Arguments.of(
                8,
                new int[] {1, 2, 3, 5, 8, 13, 21, 34}
            ),
        };
    }

    @ParameterizedTest
    @MethodSource("fibonacciNumbers")
    void givenNumberWhenCalculatingFirstNumberFibonacciNumbersThenReturnIntArray(
        int n,
        int[] expectedAnswer
    ) {
        int[] actualAnswer = fastFibonacciCalculator(n);

        assertThat(actualAnswer).isEqualTo(expectedAnswer);
    }
}
