package edu.hw5;

import java.time.LocalDate;
import java.util.Optional;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test {
    static Arguments[] parseDatesToString() {
        return new Arguments[] {
            Arguments.of(
                "2020-10-10",
                Optional.of(LocalDate.of(2020, 10, 10))
            ),
            Arguments.of(
                "2020-12-2",
                Optional.of(LocalDate.of(2020, 12, 2))
            ),
            Arguments.of(
                "2-f3-35",
                Optional.empty()
            ),
            Arguments.of(
                "1/3/1976",
                Optional.of(LocalDate.of(1976, 3, 1))
            ),
            Arguments.of(
                "2/33/3f5",
                Optional.empty()
            ),
            Arguments.of(
                "1/3/20",
                Optional.of(LocalDate.of(20, 3, 1))
            ),
            Arguments.of(
                "tomorrow",
                Optional.of(LocalDate.now().plusDays(1))
            ),
            Arguments.of(
                "today",
                Optional.of(LocalDate.now())
            ),
            Arguments.of(
                "toda7y",
                Optional.empty()
            ),
            Arguments.of(
                "yesterday",
                Optional.of(LocalDate.now().minusDays(1))
            ),
            Arguments.of(
                "1 day ago",
                Optional.of(LocalDate.now().minusDays(1))
            ),
            Arguments.of(
                "1 dgay ago",
                Optional.empty()
            ),
            Arguments.of(
                "2234 days ago",
                Optional.of(LocalDate.now().minusDays(2234))
            )
        };
    }

    @ParameterizedTest
    @MethodSource("parseDatesToString")
    void givenStringWhenParsingToDateThenReturnedLocalDate(
        String toParse,
        Optional<LocalDate> expectedAnswer
    ) {
        Optional<LocalDate> actualAnswer = Task3.parseDate(toParse);

        assertThat(actualAnswer).isEqualTo(expectedAnswer);
    }
}
