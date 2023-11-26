package edu.hw7;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {
    static Arguments[] countsOfThreads() {
        return new Arguments[] {
            Arguments.of(1, 10000),
            Arguments.of(2, 20000),
            Arguments.of(3, 30000),
            Arguments.of(4, 40000),
            Arguments.of(5, 50000),
            Arguments.of(6, 60000),
        };
    }

    @ParameterizedTest
    @MethodSource("countsOfThreads")
    void givenCountOfThreadsWhenThreadsIncrementingNumberThenReturnedNumber(int countOfThreads, int expectedAnswer)
        throws InterruptedException {
        int actualAnswer = Task1.multipleThreadsIncreaseTheNumber(countOfThreads);

        assertThat(actualAnswer).isEqualTo(expectedAnswer);
    }

}
