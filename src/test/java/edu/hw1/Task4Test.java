package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task4Test {
    @Test
    @DisplayName("Строка 123456")
    void basicTest1() {
        String arr = "123456";

        String answer = Task4.fixString(arr);

        assertThat(answer)
            .isEqualTo("214365");
    }

    @Test
    @DisplayName("Строка This is a mixed up")
    void basicTest2() {
        String arr = "hTsii  s aimex dpus rtni.g";

        String answer = Task4.fixString(arr);

        assertThat(answer)
            .isEqualTo("This is a mixed up string.");
    }

    @Test
    @DisplayName("Строка abcde")
    void basicTest3() {
        String arr = "badce";

        String answer = Task4.fixString(arr);

        assertThat(answer)
            .isEqualTo("abcde");
    }

    @Test
    @DisplayName("Пустая строка")
    void emptyString() {
        String arr = "";

        String answer = Task4.fixString(arr);

        assertThat(answer)
            .isEqualTo("");
    }

    @Test
    @DisplayName("Один символ")
    void oneSymbol() {
        String arr = "a";

        String answer = Task4.fixString(arr);

        assertThat(answer)
            .isEqualTo("a");
    }
}
