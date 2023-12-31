package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task1Test {
    @Test
    @DisplayName("Двузначные секунды и минуты")
    void basicTest1() {
        String arr = "12:51";

        int answer = Task1.minutesToSeconds(arr);

        assertThat(answer)
            .isEqualTo(12 * 60 + 51);
    }

    @Test
    @DisplayName("Однозначные минуты и двузначные секунды")
    void basicTest2() {
        String arr = "2:31";

        int answer = Task1.minutesToSeconds(arr);

        assertThat(answer)
            .isEqualTo(2 * 60 + 31);
    }

    @Test
    @DisplayName("Трёхзначные минуты и двузначные секунды")
    void basicTest3() {
        String arr = "215:00";

        int answer = Task1.minutesToSeconds(arr);

        assertThat(answer)
            .isEqualTo(215 * 60 + 0);
    }

    @Test
    @DisplayName("Не указаны минуты")
    void withoutMinutes() {
        String arr = ":21";

        int answer = Task1.minutesToSeconds(arr);

        assertThat(answer)
            .isEqualTo(-1);
    }

    @Test
    @DisplayName("Не указаны секунды")
    void withoutSeconds() {
        String arr = "512:";

        int answer = Task1.minutesToSeconds(arr);

        assertThat(answer)
            .isEqualTo(-1);
    }

    @Test
    @DisplayName("Количество секунд больше 60")
    void invalidSeconds() {
        String arr = "51:63";

        int answer = Task1.minutesToSeconds(arr);

        assertThat(answer)
            .isEqualTo(-1);
    }

    @Test
    @DisplayName("Есть плохой символ")
    void invalidSymbol() {
        String arr = "51:4t3";

        int answer = Task1.minutesToSeconds(arr);

        assertThat(answer)
            .isEqualTo(-1);
    }

    @Test
    @DisplayName("Два двоеточия")
    void doubleColons() {
        String arr = "51:4:3";

        int answer = Task1.minutesToSeconds(arr);

        assertThat(answer)
            .isEqualTo(-1);
    }
}
