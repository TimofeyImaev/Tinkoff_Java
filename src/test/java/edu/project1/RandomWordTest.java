package edu.project1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RandomWordTest {
    @Test
    @DisplayName("length zero")
    void lengthZeroTest() {
        boolean isFailed = false;

        for (int i = 0; i < 100; ++i) {
            if (GetRandomWord.getRandomWord().equals("")) {
                isFailed = true;
                break;
            }
        }

        assertThat(isFailed).
            isEqualTo(false);
    }

    @Test
    @DisplayName("testThat dont returned length 1")
    void lengthOneTest() {
        boolean isFailed = false;

        for (int i = 0; i < 100; ++i) {
            if (GetRandomWord.getRandomWord().length() == 1) {
                isFailed = true;
                break;
            }
        }

        assertThat(isFailed).
            isEqualTo(false);
    }

    @Test
    @DisplayName("testThat randomWord returned small latin letters")
    void smallLatinLettersTest() {
        boolean isFailed = false;

        for (int i = 0; i < 100; ++i) {
            for (var each: GetRandomWord.getRandomWord().toCharArray()) {
                if (each < 'a' || each > 'z') {
                    isFailed = true;
                }
            }
        }

        assertThat(isFailed).
            isEqualTo(false);
    }
}
