package edu.hw3;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test {
    @Nested
    class FreqDictTest {
        static Arguments[] objectLists() {
            return new Arguments[] {
                Arguments.of(
                    new Object[] {"a", "bb", "a", "bb"},
                    "{a=2, bb=2}"
                ),
                Arguments.of(
                    new Object[] {"this", "and", "that", "and"},
                    "{and=2, that=1, this=1}"
                ),
                Arguments.of(
                    new Object[] {"код", "код", "код", "bug"},
                    "{bug=1, код=3}"
                ),
                Arguments.of(
                    new Object[] {1, 1, 2, 2},
                    "{1=2, 2=2}"
                ),
                Arguments.of(
                    new Object[] {'a', 'c', 'd', 'c'},
                    "{a=1, c=2, d=1}"
                ),
            };
        }

        @ParameterizedTest
        @MethodSource("objectLists")
        void givenObjectListWhenCountingObjectsFrequencyThenReturnedFreqDict(
            Object[] objectList,
            String expectedAnswer
        ) {
            String actualAnswer = Task3.freqDict(objectList).toString();

            assertThat(actualAnswer).isEqualTo(expectedAnswer);
        }
    }
}
