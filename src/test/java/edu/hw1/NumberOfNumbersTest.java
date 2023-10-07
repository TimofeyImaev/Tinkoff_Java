package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class NumberOfNumbersTest {

    @Test
    @DisplayName("Базовый тест1")
    void basicTest1() {
        int number = 4666;

        int answer = CountDigits.countDigits(number);

        assertThat(answer)
            .isEqualTo(4);
    }
    @Test
    @DisplayName("Базовый тест2")
    void basicTest2() {
        int number = 544;

        int answer = CountDigits.countDigits(number);

        assertThat(answer)
            .isEqualTo(3);
    }

    @Test
    @DisplayName("Базовый тест3")
    void basicTest3() {
        int number = 12;

        int answer = CountDigits.countDigits(number);

        assertThat(answer)
            .isEqualTo(2);
    }

    @Test
    @DisplayName("Ноль")
    void zeroTest() {
        int number = 0;

        int answer = CountDigits.countDigits(number);

        assertThat(answer)
            .isEqualTo(1);
    }

    @Test
    @DisplayName("Единица")
    void oneTest() {
        int number = 1;

        int answer = CountDigits.countDigits(number);

        assertThat(answer)
            .isEqualTo(1);
    }
}
