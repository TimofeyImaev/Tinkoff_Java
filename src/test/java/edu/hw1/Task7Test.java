package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task7Test {
    @Test
    @DisplayName("Сдвиг 8 на 1 бит вправо")
    void basicTest1() {
        int number = 8;
        int shift = 1;

        int answer = Task7.rotateRight(number, shift);

        assertThat(answer)
            .isEqualTo(4);
    }

    @Test
    @DisplayName("Сдвиг 16 на 1 бит влево")
    void basicTest2() {
        int number = 16;
        int shift = 1;

        int answer = Task7.rotateLeft(number, shift);

        assertThat(answer)
            .isEqualTo(1);
    }

    @Test
    @DisplayName("Сдвиг 17 на 2 бита влево")
    void basicTest3() {
        int number = 17;
        int shift = 2;

        int answer = Task7.rotateLeft(number, shift);

        assertThat(answer)
            .isEqualTo(6);
    }

    @Test
    @DisplayName("Нулевой сдвиг влево")
    void zeroShiftLeft() {
        int number = 17;
        int shift = 0;

        int answer = Task7.rotateLeft(number, shift);

        assertThat(answer)
            .isEqualTo(17);
    }

    @Test
    @DisplayName("Нулевой сдвиг вправо")
    void zeroShiftRight() {
        int number = 17;
        int shift = 0;

        int answer = Task7.rotateRight(number, shift);

        assertThat(answer)
            .isEqualTo(17);
    }

    @Test
    @DisplayName("Ноль")
    void zeroTest() {
        int number = 0;
        int shift = 13;

        int answer = Task7.rotateLeft(number, shift);

        assertThat(answer)
            .isEqualTo(0);
    }
}
