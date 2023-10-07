package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FixStringTest {
    @Test
    @DisplayName("Базовый тест1")
    void basicTest1() {
        String arr = "123456";

        String answer = FixString.fixString(arr);

        assertThat(answer)
            .isEqualTo("214365");
    }
    @Test
    @DisplayName("Базовый тест2")
    void basicTest2() {
        String arr = "hTsii  s aimex dpus rtni.g";

        String answer = FixString.fixString(arr);

        assertThat(answer)
            .isEqualTo("This is a mixed up string.");
    }

    @Test
    @DisplayName("Базовый тест3")
    void basicTest3() {
        String arr = "badce";

        String answer = FixString.fixString(arr);

        assertThat(answer)
            .isEqualTo("abcde");
    }

    @Test
    @DisplayName("Пустая строка")
    void emptyString() {
        String arr = "";

        String answer = FixString.fixString(arr);

        assertThat(answer)
            .isEqualTo("");
    }


    @Test
    @DisplayName("Один символ")
    void oneSymbol() {
        String arr = "a";

        String answer = FixString.fixString(arr);

        assertThat(answer)
            .isEqualTo("a");
    }
}
