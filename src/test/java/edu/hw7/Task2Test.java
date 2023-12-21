package edu.hw7;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {
    static Arguments[] factorial() {
        return new Arguments[] {
            Arguments.of(
                1,
                1L
            ),
            Arguments.of(
                2,
                2L
            ),
            Arguments.of(
                6,
                720L
            ),
            Arguments.of(
                10,
                3628800L
            ),
            Arguments.of(
                20,
                2432902008176640000L
            )
        };
    }

    @ParameterizedTest
    @MethodSource("factorial")
    void givenNumberWhenCountingFactorialOfThisNumberThenReturnFactorial(int number, Long expectedAnswer) {
        Long actualAnswer = Task2.factorial(number);

        assertThat(actualAnswer).isEqualTo(expectedAnswer);
    }
}
