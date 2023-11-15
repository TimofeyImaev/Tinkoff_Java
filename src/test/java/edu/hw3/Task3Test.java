package edu.hw3;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import static java.util.Map.entry;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test {
    @Nested
    class FreqDictTest {
        static Arguments[] objectLists() {
            return new Arguments[] {
                Arguments.of(
                    new Object[] {"a", "bb", "a", "bb"},
                    Map.ofEntries(
                        entry("a", 2),
                        entry("bb", 2)
                    )
                ),
                Arguments.of(
                    new Object[] {"this", "and", "that", "and"},
                    Map.ofEntries(
                        entry("this", 1),
                        entry("and", 2),
                        entry("that", 1)
                    )
                ),
                Arguments.of(
                    new Object[] {"код", "код", "код", "bug"},
                    Map.ofEntries(
                        entry("код", 3),
                        entry("bug", 1)
                    )
                ),
                Arguments.of(
                    new Object[] {1, 1, 2, 2},
                    Map.ofEntries(
                        entry(1, 2),
                        entry(2, 2)
                    )
                ),
                Arguments.of(
                    new Object[] {'a', 'c', 'd', 'c'},
                    Map.ofEntries(
                        entry('a', 1),
                        entry('c', 2),
                        entry('d', 1)
                    )
                ),
            };
        }

        @ParameterizedTest
        @MethodSource("objectLists")
        void givenObjectListWhenCountingObjectsFrequencyThenReturnedFreqDict(
            Object[] objectList,
            Map<Object, Integer> expectedAnswer
        ) {
            HashMap<Object, Integer> actualAnswer = Task3.freqDict(objectList);

            assertThat(actualAnswer).isEqualTo(expectedAnswer);
        }
    }
}
