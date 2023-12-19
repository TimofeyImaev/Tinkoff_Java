package edu.hw5;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task4Test {
    static Arguments[] passwords() {
        return new Arguments[] {
            Arguments.of("password", false),
            Arguments.of("df23", false),
            Arguments.of("qwerty12345", false),
            Arguments.of("jhgeugyg3", false),
            Arguments.of("fjuhru874ijhbjd", false),
            Arguments.of("g", false),
            Arguments.of("jh787h!kihu3!", true),
            Arguments.of("dsdkljhi38hd@jihudh", true),
            Arguments.of("##", true),
            Arguments.of("asgasg2$$", true),
            Arguments.of("aj82jhu%df44g6", true),
            Arguments.of("gnu7&&", true),
            Arguments.of("*|*|*", true),
        };
    }

    @ParameterizedTest
    @MethodSource("passwords")
    void givenPasswordWhenSearchingSpecialSymbolsThenReturnedBoolean(
        String password,
        boolean expectedAnswer
    ) {
        boolean actualAnswer = Task4.checkPasswordSpecialsSymbols(password);

        assertThat(actualAnswer).isEqualTo(expectedAnswer);
    }
}
