package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CyclicShiftTest {
    @Test
    @DisplayName("Базовый тест1")
    void basicTest1() {
        int number = 8;
        int shift = 1;

        int answer = CyclicShift.rotateRight(number, shift);

        assertThat(answer)
            .isEqualTo(4);
    }
    @Test
    @DisplayName("Базовый тест2")
    void basicTest2() {
        int number = 16;
        int shift = 1;

        int answer = CyclicShift.rotateLeft(number, shift);

        assertThat(answer)
            .isEqualTo(1);
    }

    @Test
    @DisplayName("Базовый тест3")
    void basicTest3() {
        int number = 17;
        int shift = 2;

        int answer = CyclicShift.rotateLeft(number, shift);

        assertThat(answer)
            .isEqualTo(6);
    }

    @Test
    @DisplayName("Нулевой сдвиг влево")
    void zeroShiftLeft() {
        int number = 17;
        int shift = 0;

        int answer = CyclicShift.rotateLeft(number, shift);

        assertThat(answer)
            .isEqualTo(17);
    }

    @Test
    @DisplayName("Нулевой сдвиг вправо")
    void zeroShiftRight() {
        int number = 17;
        int shift = 0;

        int answer = CyclicShift.rotateRight(number, shift);

        assertThat(answer)
            .isEqualTo(17);
    }

    @Test
    @DisplayName("Ноль")
    void zeroTest() {
        int number = 0;
        int shift = 13;

        int answer = CyclicShift.rotateLeft(number, shift);

        assertThat(answer)
            .isEqualTo(0);
    }
}
