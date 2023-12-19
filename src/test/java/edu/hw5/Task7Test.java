package edu.hw5;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task7Test {
    static Arguments[] binaryStringsIsThirdCharacterZero() {
        return new Arguments[] {
            Arguments.of("000", true),
            Arguments.of("1101001010", true),
            Arguments.of("110110101", true),
            Arguments.of("1001", true),
            Arguments.of("010", true),
            Arguments.of("001", false),
            Arguments.of("00", false),
            Arguments.of("0", false),
            Arguments.of("1", false),
            Arguments.of("0010010", false),
            Arguments.of("ab0cd123", false),
        };
    }

    static Arguments[] binaryStringsIsStartEndSymbolsAreEquals() {
        return new Arguments[] {
            Arguments.of("000", true),
            Arguments.of("1101001010", false),
            Arguments.of("110110101", true),
            Arguments.of("1001", true),
            Arguments.of("010", true),
            Arguments.of("001", false),
            Arguments.of("00", true),
            Arguments.of("0", true),
            Arguments.of("1", true),
            Arguments.of("0010010", true),
        };
    }

    static Arguments[] binaryStringsLengthFromOneToThree() {
        return new Arguments[] {
            Arguments.of("000", true),
            Arguments.of("1101001010", false),
            Arguments.of("110110101", false),
            Arguments.of("1001", false),
            Arguments.of("010", true),
            Arguments.of("001", true),
            Arguments.of("00", true),
            Arguments.of("0", true),
            Arguments.of("1", true),
            Arguments.of("0010010", false),
        };
    }

    @ParameterizedTest
    @MethodSource("binaryStringsIsThirdCharacterZero")
    void givenBinaryStringWhenCheckingThirdCharacterIsZeroThenReturnedBoolean(
        String binaryString,
        boolean expectedAnswer
    ) {
        boolean actualAnswer = Task7.isThirdCharacterZero(binaryString);

        assertThat(actualAnswer).isEqualTo(expectedAnswer);
    }

    @ParameterizedTest
    @MethodSource("binaryStringsIsStartEndSymbolsAreEquals")
    void givenBinaryStringWhenCheckingStartEndSymbolsAreEqualsThenReturnedBoolean(
        String binaryString,
        boolean expectedAnswer
    ) {
        boolean actualAnswer = Task7.startEndSymbolsAreEqual(binaryString);

        assertThat(actualAnswer).isEqualTo(expectedAnswer);
    }

    @ParameterizedTest
    @MethodSource("binaryStringsLengthFromOneToThree")
    void givenBinaryStringWhenCheckingLengthFromOneToThreeThenReturnedBoolean(
        String binaryString,
        boolean expectedAnswer
    ) {
        boolean actualAnswer = Task7.lengthFromOneToThree(binaryString);

        assertThat(actualAnswer).isEqualTo(expectedAnswer);
    }
}
