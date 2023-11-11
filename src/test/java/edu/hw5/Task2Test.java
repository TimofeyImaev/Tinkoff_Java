package edu.hw5;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {
    static Arguments[] fridaysThirteenthOfYheYear() {
        return new Arguments[] {
            Arguments.of(
                1925,
                new ArrayList<>(
                    List.of(
                        "1925-02-13",
                        "1925-03-13",
                        "1925-11-13"
                    )
                )
            ),
            Arguments.of(
                2024,
                new ArrayList<>(
                    List.of(
                        "2024-09-13",
                        "2024-12-13"
                    )
                )
            ),
            Arguments.of(
                2035,
                new ArrayList<>(
                    List.of(
                        "2035-04-13",
                        "2035-07-13"
                    )
                )
            ),
            Arguments.of(
                2011,
                new ArrayList<>(
                    List.of(
                        "2011-05-13"
                    )
                )
            ),
            Arguments.of(
                1677,
                new ArrayList<>(
                    List.of(
                        "1677-08-13"
                    )
                )
            ),
        };
    }

    @ParameterizedTest
    @MethodSource("fridaysThirteenthOfYheYear")
    void givenYearWhenSearchingFridaysThirteenthThenReturnedFridaysThirteenthDates(
        int year,
        ArrayList<String> expectedAnswer
    ) {
        ArrayList<String> actualAnswer = Task2.allFridaysThirteenthOfYheYear(year);

        assertThat(actualAnswer).isEqualTo(expectedAnswer);
    }

    static Arguments[] closestFridayThirteenth() {
        return new Arguments[] {
            Arguments.of(
                LocalDate.of(2011, 5, 10),
                LocalDate.of(2011, 5, 13)
            ),
            Arguments.of(
                LocalDate.of(1925, 2, 13),
                LocalDate.of(1925, 3, 13)
            ),
            Arguments.of(
                LocalDate.of(1677, 1, 1),
                LocalDate.of(1677, 8, 13)
            ),
            Arguments.of(
                LocalDate.of(2011, 5, 10),
                LocalDate.of(2011, 5, 13)
            ),
            Arguments.of(
                LocalDate.of(2035, 4, 22),
                LocalDate.of(2035, 7, 13)
            ),
        };
    }

    @ParameterizedTest
    @MethodSource("closestFridayThirteenth")
    void givenDateWhenSearchingClosestFridaysThirteenthThenReturnedFridayThirteenthDate(
        LocalDate date,
        LocalDate expectedAnswer
    ) {
        LocalDate actualAnswer = Task2.closestFridayThirteenth(date);

        assertThat(actualAnswer).isEqualTo(expectedAnswer);
    }
}
