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
                    new Object[] {
                        new Task5.Contact("Thomas", "Aquinas"),
                        new Task5.Contact("Rene", "Descartes"),
                        new Task5.Contact("David", "Hume"),
                        new Task5.Contact("John", "Locke")
                    }
                ),
                Arguments.of(new String[] {"Paul Erdos", "Leonhard Euler", "Carl Gauss"}, "DESC",
                    new Object[] {
                        new Task5.Contact("Carl", "Gauss"),
                        new Task5.Contact("Leonhard", "Euler"),
                        new Task5.Contact("Paul", "Erdos")
                    }
                ),
                Arguments.of(new String[] {}, "DESC",
                    new Object[] {}
                ),
                Arguments.of(new String[] {"Alexandr", "Maksim", "Lera"}, "ASC",
                    new Object[] {
                        new Task5.Contact("Alexandr"),
                        new Task5.Contact("Lera"),
                        new Task5.Contact("Maksim"),
                    }
                ),
                Arguments.of(new String[] {"Alexandr", "Maksim", "Lera"}, "DESC",
                    new Object[] {
                        new Task5.Contact("Maksim"),
                        new Task5.Contact("Lera"),
                        new Task5.Contact("Alexandr")
                    }
                ),
                Arguments.of(new String[] {"Vladimir Cherepanov", "Maksim Khasanov", "Nastya Berezova"}, "ASC",
                    new Object[] {
                        new Task5.Contact("Nastya", "Berezova"),
                        new Task5.Contact("Vladimir", "Cherepanov"),
                        new Task5.Contact("Maksim", "Khasanov")
                    }
                ),
                Arguments.of(new String[] {"Vladimir Cherepanov", "Maksim Khasanov", "Nastya Berezova"}, "DESC",
                    new Object[] {
                        new Task5.Contact("Maksim", "Khasanov"),
                        new Task5.Contact("Vladimir", "Cherepanov"),
                        new Task5.Contact("Nastya", "Berezova")
                    }
                ),
                Arguments.of(new String[] {"Artem Dmitriev", "Aleksey Mardiev", "Vika"}, "DESC",
                    new Object[] {
                        new Task5.Contact("Vika"),
                        new Task5.Contact("Aleksey", "Mardiev"),
                        new Task5.Contact("Artem", "Dmitriev")
                    }
                ),
                Arguments.of(new String[] {"Artem Dmitriev", "Aleksey Mardiev", "Vika"}, "ASC",
                    new Object[] {
                        new Task5.Contact("Artem", "Dmitriev"),
                        new Task5.Contact("Aleksey", "Mardiev"),
                        new Task5.Contact("Vika")
                    }
                ),
                Arguments.of(new String[] {}, "DESC",
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
