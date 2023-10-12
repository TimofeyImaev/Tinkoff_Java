package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task5Test {
    @Test
    @DisplayName("Число 11211230 выводит true")
    void basicTest1() {
        int number = 11211230;

        boolean answer = Task5.isPalindromeDescendant(number);

        assertThat(answer)
            .isEqualTo(true);
    }

    @Test
    @DisplayName("Число 13001120 выводит true")
    void basicTest2() {
        int number = 13001120;

        boolean answer = Task5.isPalindromeDescendant(number);

        assertThat(answer)
            .isEqualTo(true);
    }

    @Test
    @DisplayName("Число 23336014 выводит true")
    void basicTest3() {
        int number = 23336014;

        boolean answer = Task5.isPalindromeDescendant(number);

        assertThat(answer)
            .isEqualTo(true);
    }

    @Test
    @DisplayName("Двузначное число")
    void basicTest4() {
        int number = 11;

        boolean answer = Task5.isPalindromeDescendant(number);

        assertThat(answer)
            .isEqualTo(true);
    }

    @Test
    @DisplayName("Нечётная длина")
    void oddLength() {
        int number = 122;

        boolean answer = Task5.isPalindromeDescendant(number);

        assertThat(answer)
            .isEqualTo(false);
    }

    @Test
    @DisplayName("Единица из десятки")
    void oneFromTen() {
        int number = 10;

        boolean answer = Task5.isPalindromeDescendant(number);

        assertThat(answer)
            .isEqualTo(false);
    }

    @Test
    @DisplayName("Единица")
    void oneTest() {
        int number = 1;

        boolean answer = Task5.isPalindromeDescendant(number);

        assertThat(answer)
            .isEqualTo(true);
    }
}
