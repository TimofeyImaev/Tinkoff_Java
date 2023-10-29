package edu.hw3;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task4Test {
    @Nested
    class ConvertToRomanTest {
        static Arguments[] arabicNumbers() {
            return new Arguments[] {
                Arguments.of(1251, "MCCLI"),
                Arguments.of(152, "CLII"),
                Arguments.of(1, "I"),
                Arguments.of(5, "V"),
                Arguments.of(5, "V"),
                Arguments.of(45, "XLV"),
                Arguments.of(15, "XV"),
                Arguments.of(9, "IX"),
                Arguments.of(1000, "M"),
                Arguments.of(865, "DCCCLXV"),
                Arguments.of(985, "CMLXXXV"),
            };
        }

        @ParameterizedTest
        @MethodSource("arabicNumbers")
        void givenArabicNumberWhenConvertingIntoRomanSystemThenReturnedRomanNumber(
            int arabicNumber,
            String expectedRomanNumber
        ) {
            String actualRomanNumber = Task4.convertToRoman(arabicNumber);

            assertThat(actualRomanNumber).isEqualTo(expectedRomanNumber);
        }
    }
}
