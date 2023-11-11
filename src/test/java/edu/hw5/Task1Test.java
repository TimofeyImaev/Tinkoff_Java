package edu.hw5;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {
    static Arguments[] sessionsStartAndEndTimes() {
        return new Arguments[] {
            Arguments.of(
                new String[] {
                    "2022-03-12, 20:20 - 2022-03-12, 23:50",
                    "2022-04-01, 21:30 - 2022-04-02, 01:20"
                },
                Duration.of(220, ChronoUnit.MINUTES)
            ),
            Arguments.of(
                new String[] {
                    "2022-03-12, 20:20 - 2022-03-12, 23:50",
                    "2022-04-01, 21:30 - 2022-04-02, 01:21"
                },
                Duration.of(220, ChronoUnit.MINUTES)
                    .plus(30, ChronoUnit.SECONDS)
            ),
            Arguments.of(
                new String[] {
                    "2017-03-12, 20:20 - 2017-03-12, 23:50",
                    "2044-05-05, 21:30 - 2044-05-05, 21:36",
                    "2024-01-02, 16:11 - 2024-01-02, 18:19",
                    "2027-10-01, 20:30 - 2027-10-02, 01:21",
                    "2021-12-11, 14:12 - 2021-12-11, 17:56"
                },
                Duration.of(171, ChronoUnit.MINUTES)
                    .plus(48, ChronoUnit.SECONDS)
            ),
            Arguments.of(
                new String[] {
                    "2017-08-16, 14:52 - 2017-08-16, 15:50"
                },
                Duration.of(58, ChronoUnit.MINUTES)
                    .plus(0, ChronoUnit.SECONDS)
            ),
            Arguments.of(
                new String[] {
                },
                Duration.of(0, ChronoUnit.MINUTES)
                    .plus(0, ChronoUnit.SECONDS)
            ),
        };
    }

    @ParameterizedTest
    @MethodSource("sessionsStartAndEndTimes")
    void givenSessionsTimePeriodsWhenCountAverageTimeOfSessionsThenReturnedAverageTime(
        String[] sessionsStartAndEnd,
        Duration expectedAnswer
    ) {
        Duration actualAnswer = Task1.averageSessionDuration(sessionsStartAndEnd);

        assertThat(actualAnswer).isEqualTo(expectedAnswer);
    }
}
