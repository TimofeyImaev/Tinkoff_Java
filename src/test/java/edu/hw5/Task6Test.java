package edu.hw5;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task6Test {
    static Arguments[] licensePlates() {
        return new Arguments[] {
            Arguments.of("abc", "achfdbaabgabcaabg", true),
            Arguments.of("hbfsy", "bhgysgrhbfsygfgs", true),
            Arguments.of("sdgg", "sdggtyuhbyybdfs", true),
            Arguments.of("huuuf", "hjyhygguhduhuf", true),
            Arguments.of("jifgd", "djuigkifngjdo", true),
            Arguments.of("abc", "nmm", false),
            Arguments.of("bbbb", "u", false),
            Arguments.of("sdf", "sfshs", false),
            Arguments.of("fhire", "sjywc", false),
            Arguments.of("dgder", "negdshjtyewrmm", false),
        };
    }

    @ParameterizedTest
    @MethodSource("licensePlates")
    void givenTwoStringsWhenCheckingIsFirstSubsequenceOfSecondThenReturnedBoolean(
        String s,
        String t,
        boolean expectedAnswer
    ) {
        boolean actualAnswer = Task6.isSubsequence(s, t);

        assertThat(actualAnswer).isEqualTo(expectedAnswer);
    }
}
