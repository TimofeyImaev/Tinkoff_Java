package edu.hw9;

import edu.hw1.Pair;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static java.lang.Math.abs;
import static java.lang.Thread.sleep;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

public class Task1Test {
    private final Double EPSILON = 1e-7;

    static Arguments[] numericalData() {
        return new Arguments[] {
            Arguments.of(
                List.of(
                    new Pair<>("centimeters", new Double[] {0.1, 0.05, 1.4, 5.1, 0.3}),
                    new Pair<>("millimeters", new Double[] {12.0, 4.0, 1.02, 23.0, 2.11})
                ),
                Map.<String, Double>ofEntries(
                    Map.entry("centimetersAverage", 1.39),
                    Map.entry("centimetersMinimum", 0.05),
                    Map.entry("centimetersSum", 6.95),
                    Map.entry("centimetersMaximum", 5.1),

                    Map.entry("millimetersAverage", 8.426),
                    Map.entry("millimetersMinimum", 1.02),
                    Map.entry("millimetersSum", 42.13),
                    Map.entry("millimetersMaximum", 23.0)
                )
            ),
            Arguments.of(
                List.of(
                    new Pair<>("degrees", new Double[] {12.73, 24.0}),
                    new Pair<>("degrees", new Double[] {8.8, -5.0, 4.15}),
                    new Pair<>("precipitation", new Double[] {23.58, 19.24}),
                    new Pair<>("precipitation", new Double[] {1.21, 19.86}),
                    new Pair<>("humidity", new Double[] {14.28, 7.38, 1.51}),
                    new Pair<>("humidity", new Double[] {6.33, 2.66, 24.28})
                ),
                Map.<String, Double>ofEntries(
                    Map.entry("degreesAverage", 8.936),
                    Map.entry("degreesMinimum", -5.0),
                    Map.entry("degreesSum", 44.68),
                    Map.entry("degreesMaximum", 24.0),

                    Map.entry("precipitationAverage", 15.9725),
                    Map.entry("precipitationMinimum", 1.21),
                    Map.entry("precipitationSum", 63.89),
                    Map.entry("precipitationMaximum", 23.58),


                    Map.entry("humidityAverage", 9.4066666666666),
                    Map.entry("humidityMinimum", 1.51),
                    Map.entry("humiditySum", 56.44),
                    Map.entry("humidityMaximum", 24.28)
                )
            ),
            Arguments.of(
                List.of(
                    new Pair<>("countOfErrors", new Double[] {16.0, 9.0, 15.0, 10.0})
                ),
                Map.<String, Double>ofEntries(
                    Map.entry("countOfErrorsAverage", 12.5),
                    Map.entry("countOfErrorsMinimum", 9.0),
                    Map.entry("countOfErrorsSum", 50.0),
                    Map.entry("countOfErrorsMaximum", 16.0)
                )
            ),
            Arguments.of(
                List.of(
                ),
                Map.<String, Double>ofEntries(
                )
            ),
        };
    }

    @ParameterizedTest
    @MethodSource("numericalData")
    void givenArrayOfDoublesWhenCalculatingSumAverageMaxMinThenReturnedMap(
        List<Pair<String, Double[]>> metricNameAndData,
        Map<String, Double> expectedAnswer
    ) throws InterruptedException {
        Task1.StatsCollector statsCollector = new Task1.StatsCollector();
        CountDownLatch countDownLatch = new CountDownLatch(metricNameAndData.size());

        for (var each : metricNameAndData) {
            Runnable runnable = () -> {
                statsCollector.push(each.first, each.second);
                countDownLatch.countDown();
            };

            Thread thread = new Thread(runnable);
            thread.start();
        }

        countDownLatch.await();

        Map<String, Double> actualAnswer = statsCollector.stats();

        for (var each : actualAnswer.keySet()) {
            if (!expectedAnswer.containsKey(each)
                || abs(expectedAnswer.get(each) - actualAnswer.get(each)) > EPSILON) {
                fail(each
                    + "\nexpected answer: " + expectedAnswer.get(each)
                    + "\nactual answer: " + actualAnswer.get(each));
            }
        }

        assertThat(actualAnswer.size()).isEqualTo(expectedAnswer.size());
    }
}
