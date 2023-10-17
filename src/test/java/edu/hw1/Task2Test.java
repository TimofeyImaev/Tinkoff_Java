package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {

    @Test
    @DisplayName("Четырёхзначное число")
    void basicTest1() {
        int number = 4666;

        int answer = Task2.countDigits(number);

        assertThat(answer)
            .isEqualTo(4);
    }

    @Test
    @DisplayName("Трёхзначное число")
    void basicTest2() {
        int number = 544;

        int answer = Task2.countDigits(number);

        assertThat(answer)
            .isEqualTo(3);
    }

    @Test
    @DisplayName("Двузначное число")
    void basicTest3() {
        int number = 12;

        int answer = Task2.countDigits(number);

        assertThat(answer)
            .isEqualTo(2);
    }

    @Test
    @DisplayName("Ноль")
    void zeroTest() {
        int number = 0;

        int answer = Task2.countDigits(number);

        assertThat(answer)
            .isEqualTo(1);
    }

    @Test
    @DisplayName("Единица")
    void oneTest() {
        int number = 1;

        int answer = Task2.countDigits(number);

        assertThat(answer)
            .isEqualTo(1);
    }
}
