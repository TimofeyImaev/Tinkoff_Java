package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task6Test {
    @Test
    @DisplayName("Число 6621 выводит 5 операций")
    void basicTest1() {
        int number = 6621;

        int answer = Task6.constantKaprekala(number);

        assertThat(answer)
            .isEqualTo(5);
    }

    @Test
    @DisplayName("Число 6554 выводит 4 операции")
    void basicTest2() {
        int number = 6554;

        int answer = Task6.constantKaprekala(number);

        assertThat(answer)
            .isEqualTo(4);
    }

    @Test
    @DisplayName("Число 1234 выводит 3 операции")
    void basicTest3() {
        int number = 1234;

        int answer = Task6.constantKaprekala(number);

        assertThat(answer)
            .isEqualTo(3);
    }

    @Test
    @DisplayName("Число 3524 выводит 3 операции")
    void basicTest4() {
        int number = 3524;

        int answer = Task6.constantKaprekala(number);

        assertThat(answer)
            .isEqualTo(3);
    }

    @Test
    @DisplayName("Все цифры одинаковые1")
    void sameNumbers1() {
        int number = 2222;

        int answer = Task6.constantKaprekala(number);

        assertThat(answer)
            .isEqualTo(-1);
    }

    @Test
    @DisplayName("Все цифры одинаковые2")
    void sameNumbers2() {
        int number = 5555;

        int answer = Task6.constantKaprekala(number);

        assertThat(answer)
            .isEqualTo(-1);
    }
}
