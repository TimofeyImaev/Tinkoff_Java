package edu.hw7;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static java.lang.Math.abs;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task4Test {
    private static final long TEN_MILLIONS = 10000000L;
    private static final long HUNDRED_MILLIONS = 100000000L;
    private static final long LONG_BILLION = 1000000000L;
    private static final int INT_BILLION = 1000000000;

    static Arguments[] countOfIterationsAndDifference() {
        return new Arguments[] {
            Arguments.of(
                (int) 1e7,
                    0.01
            ),
            Arguments.of(
                (int) 1e8,
                0.001
            ),
            Arguments.of(
                (int) 1e9,
                0.0001
            ),
        };
    }

    @ParameterizedTest
    @MethodSource("countOfIterationsAndDifference")
    void givenOneThreadWhenCalculatingPiWithMonteCarloThenCompareToMathPi(
        int countOfIterations,
        double difference
    ) {
        double actualAnswer = Task4.methodMonteCarloPiCalculation(countOfIterations);
        double expectedAnswer = Math.PI;

        assertTrue(abs(actualAnswer - expectedAnswer) < difference);
    }

    @ParameterizedTest
    @MethodSource("countOfIterationsAndDifference")
    void givenTwoThreadsWhenCalculatingPiWithMonteCarloThenCompareToMathPi(
        int countOfIterations,
        double difference
    ) {
        double actualAnswer = Task4.multiThreadMethodMonteCarloPiCalculation(countOfIterations, 2);
        double expectedAnswer = Math.PI;

        assertTrue(abs(actualAnswer - expectedAnswer) < difference);
    }

    @ParameterizedTest
    @MethodSource("countOfIterationsAndDifference")
    void givenFiveThreadsWhenCalculatingPiWithMonteCarloThenCompareToMathPi(
        int countOfIterations,
        double difference
    ) {
        double actualAnswer = Task4.multiThreadMethodMonteCarloPiCalculation(countOfIterations, 5);
        double expectedAnswer = Math.PI;

        assertTrue(abs(actualAnswer - expectedAnswer) < difference);
    }

    @ParameterizedTest
    @MethodSource("countOfIterationsAndDifference")
    void givenTenThreadsWhenCalculatingPiWithMonteCarloThenCompareToMathPi(
        int countOfIterations,
        double difference
    ) {
        double actualAnswer = Task4.multiThreadMethodMonteCarloPiCalculation(countOfIterations, 10);
        double expectedAnswer = Math.PI;

        assertTrue(abs(actualAnswer - expectedAnswer) < difference);
    }
}
