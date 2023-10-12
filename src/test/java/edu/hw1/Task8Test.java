package edu.hw1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task8Test {
    @Test
    @DisplayName("Никто никого не бъёт")
    void basicTest1() {
        int[][] arr = new int[][] {
            {0, 0, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 1, 0, 1, 0},
            {0, 1, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 1, 0, 0, 0}
        };

        boolean answer = Task8.knightBoardCapture(arr);

        assertThat(answer)
            .isEqualTo(true);
    }

    @Test
    @DisplayName("Кони 2 4 и 4 3 бъют друг друга")
    void basicTest2() {
        int[][] arr = new int[][] {
            {1, 0, 1, 0, 1, 0, 1, 0},
            {0, 1, 0, 1, 0, 1, 0, 1},
            {0, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 1, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 0, 1, 0, 1, 0, 1}
        };

        boolean answer = Task8.knightBoardCapture(arr);

        assertThat(answer)
            .isEqualTo(false);
    }

    @Test
    @DisplayName("Кони 2 6 и 3 4 бъют друг друга")
    void basicTest3() {
        int[][] arr = new int[][] {
            {0, 0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 0},
            {1, 0, 0, 0, 0, 0, 0, 0}
        };

        boolean answer = Task8.knightBoardCapture(arr);

        assertThat(answer)
            .isEqualTo(false);
    }

    @Test
    @DisplayName("Все нули")
    void allZeros() {
        int[][] arr = new int[][] {
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0}
        };

        boolean answer = Task8.knightBoardCapture(arr);

        assertThat(answer)
            .isEqualTo(true);
    }

    @Test
    @DisplayName("Все единицы")
    void allOnes() {
        int[][] arr = new int[][] {
            {1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1},
            {1, 1, 1, 1, 1, 1, 1, 1}
        };

        boolean answer = Task8.knightBoardCapture(arr);

        assertThat(answer)
            .isEqualTo(false);
    }

    @Test
    @DisplayName("Все на нечётных позициях")
    void kngihtsOnOddPosititons() {
        int[][] arr = new int[][] {
            {0, 1, 0, 1, 0, 1, 0, 1},
            {1, 0, 1, 0, 1, 0, 1, 0},
            {0, 1, 0, 1, 0, 1, 0, 1},
            {1, 0, 1, 0, 1, 0, 1, 0},
            {0, 1, 0, 1, 0, 1, 0, 1},
            {1, 0, 1, 0, 1, 0, 1, 0},
            {0, 1, 0, 1, 0, 1, 0, 1},
            {1, 0, 1, 0, 1, 0, 1, 0}
        };

        boolean answer = Task8.knightBoardCapture(arr);

        assertThat(answer)
            .isEqualTo(true);
    }
}
