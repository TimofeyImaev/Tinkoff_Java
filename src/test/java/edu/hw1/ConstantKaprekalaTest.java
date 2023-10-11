package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ConstantKaprekalaTest {
    @Test
    @DisplayName("Базовый тест1")
    void basicTest1() {
        int number = 6621;

        int answer = ConstantKaprekala.constantKaprekala(number);

        assertThat(answer)
            .isEqualTo(5);
    }
    @Test
    @DisplayName("Базовый тест2")
    void basicTest2() {
        int number = 6554;

        int answer = ConstantKaprekala.constantKaprekala(number);

        assertThat(answer)
            .isEqualTo(4);
    }

    @Test
    @DisplayName("Базовый тест3")
    void basicTest3() {
        int number = 1234;

        int answer = ConstantKaprekala.constantKaprekala(number);

        assertThat(answer)
            .isEqualTo(3);
    }

    @Test
    @DisplayName("Базовый тест4")
    void basicTest4() {
        int number = 3524;

        int answer = ConstantKaprekala.constantKaprekala(number);

        assertThat(answer)
            .isEqualTo(3);
    }

    @Test
    @DisplayName("Все цифры одинаковые1")
    void sameNumbers1() {
        int number = 2222;

        int answer = ConstantKaprekala.constantKaprekala(number);

        assertThat(answer)
            .isEqualTo(-1);
    }

    @Test
    @DisplayName("Все цифры одинаковые2")
    void sameNumbers2() {
        int number = 5555;

        int answer = ConstantKaprekala.constantKaprekala(number);

        assertThat(answer)
            .isEqualTo(-1);
    }
}
