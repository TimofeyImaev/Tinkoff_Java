package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class specialPalindromeTest {
    @Test
    @DisplayName("Базовый тест1")
    void basicTest1() {
        int number = 11211230;

        boolean answer = IsPalindromeDescendant.isPalindromeDescendant(number);

        assertThat(answer)
            .isEqualTo(true);
    }
    @Test
    @DisplayName("Базовый тест2")
    void basicTest2() {
        int number = 13001120;

        boolean answer = IsPalindromeDescendant.isPalindromeDescendant(number);

        assertThat(answer)
            .isEqualTo(true);
    }

    @Test
    @DisplayName("Базовый тест3")
    void basicTest3() {
        int number = 23336014;

        boolean answer = IsPalindromeDescendant.isPalindromeDescendant(number);

        assertThat(answer)
            .isEqualTo(true);
    }

    @Test
    @DisplayName("Базовый тест4")
    void basicTest4() {
        int number = 11;

        boolean answer = IsPalindromeDescendant.isPalindromeDescendant(number);

        assertThat(answer)
            .isEqualTo(true);
    }

    @Test
    @DisplayName("Нечётная длина")
    void oddLength() {
        int number = 122;

        boolean answer = IsPalindromeDescendant.isPalindromeDescendant(number);

        assertThat(answer)
            .isEqualTo(false);
    }

    @Test
    @DisplayName("Единица из десятки")
    void oneFromTen() {
        int number = 10;

        boolean answer = IsPalindromeDescendant.isPalindromeDescendant(number);

        assertThat(answer)
            .isEqualTo(false);
    }

    @Test
    @DisplayName("Единица")
    void oneTest() {
        int number = 1;

        boolean answer = IsPalindromeDescendant.isPalindromeDescendant(number);

        assertThat(answer)
            .isEqualTo(true);
    }
}
