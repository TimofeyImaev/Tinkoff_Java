package edu.hw5;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task5Test {
    static Arguments[] licensePlates() {
        return new Arguments[] {
            Arguments.of("123АВЕ777", false),
            Arguments.of("А123К77", false),
            Arguments.of("Т123гЕ7477", false),
            Arguments.of("Т:123АР69477", false),
            Arguments.of("*:3Ок3637", false),
            Arguments.of("Т;23РЕ777", false),
            Arguments.of("А123ВЕ777", true),
            Arguments.of("О777ОО177", true),
            Arguments.of("С008ОК632", true),
            Arguments.of("М004КА904", true),
            Arguments.of("С006ОР328", true),
            Arguments.of("М004КА934", true),
            Arguments.of("Т004КА246", true),
        };
    }

    @ParameterizedTest
    @MethodSource("licensePlates")
    void givenLicensePlateWhenValidatingPlateThenReturnedBoolean(
        String licensePlate,
        boolean expectedAnswer
    ) {
        boolean actualAnswer = Task5.licensePlateValidation(licensePlate);

        assertThat(actualAnswer).isEqualTo(expectedAnswer);
    }
}
