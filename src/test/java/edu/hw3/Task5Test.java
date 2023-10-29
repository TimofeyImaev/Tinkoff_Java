package edu.hw3;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task5Test {
    @Nested
    class ParseContactsTest {
        static Arguments[] namesArray() {
            return new Arguments[] {
                Arguments.of(new String[] {"John Locke", "Thomas Aquinas", "David Hume", "Rene Descartes"}, "ASC",
                    new Object[] {"Thomas Aquinas", "Rene Descartes", "David Hume", "John Locke"}
                ),
                Arguments.of(new String[] {"Paul Erdos", "Leonhard Euler", "Carl Gauss"}, "DESC",
                    new Object[] {"Carl Gauss", "Leonhard Euler", "Paul Erdos"}
                ),
                Arguments.of(new String[] {}, "DESC",
                    new Object[] {}
                ),
                Arguments.of(new String[] {"Alexandr", "Maksim", "Lera"}, "ASC",
                    new Object[] {"Alexandr", "Lera", "Maksim"}
                ),
                Arguments.of(new String[] {"Alexandr", "Maksim", "Lera"}, "DESC",
                    new Object[] {"Maksim", "Lera", "Alexandr"}
                ),
                Arguments.of(new String[] {"Vladimir Cherepanov", "Maksim Khasanov", "Nastya Berezova"}, "ASC",
                    new Object[] {"Nastya Berezova", "Vladimir Cherepanov", "Maksim Khasanov"}
                ),
                Arguments.of(new String[] {"Vladimir Cherepanov", "Maksim Khasanov", "Nastya Berezova"}, "DESC",
                    new Object[] {"Maksim Khasanov", "Vladimir Cherepanov", "Nastya Berezova"}
                ),
                Arguments.of(new String[] {"Artem Dmitriev", "Aleksey Mardiev", "Vika"}, "DESC",
                    new Object[] {"Vika", "Aleksey Mardiev", "Artem Dmitriev"}
                ),
                Arguments.of(new String[] {"Artem Dmitriev", "Aleksey Mardiev", "Vika"}, "ASC",
                    new Object[] {"Artem Dmitriev", "Aleksey Mardiev", "Vika"}
                ),
                Arguments.of(null, "DESC",
                    new Object[] {}
                ),
            };
        }

        @ParameterizedTest
        @MethodSource("namesArray")
        void givenNamesArrayWhenSortingArrayThenReturnedSortedArray(
            String[] namesArray,
            String order,
            Object[] expectedAnswer
        ) {
            Object[] actualAnswer = Task5.parseContacts(namesArray, order);

            assertThat(actualAnswer).isEqualTo(expectedAnswer);
        }
    }
}
