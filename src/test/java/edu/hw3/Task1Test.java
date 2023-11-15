package edu.hw3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {
    private static final Logger LOGGER = LogManager.getLogger();

    @Nested
    class MirrorLetterTest {
        static Arguments[] latinLetters() {
            return new Arguments[] {
                Arguments.of('a', 'z'),
                Arguments.of('b', 'y'),
                Arguments.of('c', 'x'),
                Arguments.of('d', 'w'),
                Arguments.of('v', 'e'),
                Arguments.of('u', 'f'),
                Arguments.of('t', 'g'),
                Arguments.of('s', 'h'),
                Arguments.of('r', 'i'),
                Arguments.of('q', 'j'),
                Arguments.of('p', 'k'),
                Arguments.of('o', 'l'),
                Arguments.of('n', 'm'),

                Arguments.of('A', 'Z'),
                Arguments.of('B', 'Y'),
                Arguments.of('C', 'X'),
                Arguments.of('D', 'W'),
                Arguments.of('E', 'V'),
                Arguments.of('F', 'U'),
                Arguments.of('G', 'T'),
                Arguments.of('H', 'S'),
                Arguments.of('I', 'R'),
                Arguments.of('J', 'Q'),
                Arguments.of('K', 'P'),
                Arguments.of('L', 'O'),
                Arguments.of('M', 'N'),
            };
        }

        @ParameterizedTest
        @MethodSource("latinLetters")
        void givenLatinLetterWhenMirrorLetterThenReturnMirroredLetter(char toMirrorLetter, char expectedAnswer) {
            char actualAnswer = Task1.getMirrorLetter(toMirrorLetter);

            assertThat(actualAnswer).isEqualTo(expectedAnswer);
        }

        static Arguments[] notLatinLetters() {
            return new Arguments[] {
                Arguments.of('1', '1'),
                Arguments.of('7', '7'),
                Arguments.of('}', '}'),
                Arguments.of('-', '-'),
                Arguments.of('=', '='),
                Arguments.of('$', '$'),
                Arguments.of('`', '`'),
                Arguments.of('\\', '\\'),
            };
        }

        @ParameterizedTest
        @MethodSource("notLatinLetters")
        void givenNotLatinLetterWhenDoNothingThenReturnInputLetter(char toMirrorLetter, char expectedAnswer) {
            char actualAnswer = Task1.getMirrorLetter(toMirrorLetter);

            assertThat(actualAnswer).isEqualTo(expectedAnswer);
        }
    }

    @Nested
    class AtbashCiherTest {
        static Arguments[] latinLettersStrings() {
            return new Arguments[] {
                Arguments.of("abcdefghijklmnopqrstuvwxyz", "zyxwvutsrqponmlkjihgfedcba"),
                Arguments.of("ajjgv", "zqqte"),
                Arguments.of("gjv", "tqe"),
                Arguments.of("b", "y"),
            };
        }

        @ParameterizedTest
        @MethodSource("latinLettersStrings")
        void givenLatinLettersStringWhenMirrorLettersThenReturnMirroredString(
            String toMirrorString,
            String expectedAnswer
        ) {
            String actualAnswer = Task1.atbashCiher(toMirrorString);

            assertThat(actualAnswer).isEqualTo(expectedAnswer);
        }

        static Arguments[] latinLettersString() {
            return new Arguments[] {
                Arguments.of("abcdefghijklmnopqrstuvwxyz", "zyxwvutsrqponmlkjihgfedcba"),
                Arguments.of("ABCDEFGHIJKLM", "ZYXWVUTSRQPON"),
                Arguments.of("aJjgv", "zQqte"),
                Arguments.of("gjv", "tqe"),
                Arguments.of("b", "y"),
                Arguments.of("A", "Z"),
            };
        }

        static Arguments[] strings() {
            return new Arguments[] {
                Arguments.of("n75GV2@88^%", "m75TE2@88^%"),
                Arguments.of("|3F28(*", "|3U28(*"),
                Arguments.of("~", "~"),
            };
        }

        @ParameterizedTest
        @MethodSource("strings")
        void givenStringWhenMirrorLettersThenReturnMirroredString(String toMirrorString, String expectedAnswer) {
            String actualAnswer = Task1.atbashCiher(toMirrorString);

            assertThat(actualAnswer).isEqualTo(expectedAnswer);
        }

        @Test
        @DisplayName("testThat empty string Returned empty string")
        void givenEmptyStringWhenDoNothingThenReturnEmptyString() {
            String expectedAnswer = "";
            String toMirrorString = "";

            String actualAnswer = Task1.atbashCiher(toMirrorString);

            assertThat(actualAnswer).isEqualTo(expectedAnswer);
        }
    }
}
