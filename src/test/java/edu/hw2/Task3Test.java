package edu.hw2;

import edu.hw1.Pair;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.ValueSource;
import java.util.concurrent.ConcurrentNavigableMap;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test {
    private static final Logger LOGGER = LogManager.getLogger();

    @Test
    @DisplayName("testThat FaultyConnectionManager rarely fails")
    void faultyConnectionManagerTest() {
        int failedCnt = 0;

        for (int i = 0; i < 100; ++i) {
            try {
                Task3.PopularCommandExecutor.updatePackages(new Task3.FaultyConnectionManager());
            } catch (Task3.ConnectionException e) {
                failedCnt++;
            }
        }

        LOGGER.trace("{}", failedCnt);

        assertThat(failedCnt < 5).
            isEqualTo(true);
    }

    @Test
    @DisplayName("testThat DefaultConnectionManager rarely fails")
    void defaultConnectionManagerTest() {
        int failedCnt = 0;

        for (int i = 0; i < 100; ++i) {
            try {
                Task3.PopularCommandExecutor.updatePackages(new Task3.DefaultConnectionManager());
            } catch (Task3.ConnectionException e) {
                failedCnt++;
            }
        }

        LOGGER.trace("{}", failedCnt);

        assertThat(failedCnt < 2).
            isEqualTo(true);
    }
}
