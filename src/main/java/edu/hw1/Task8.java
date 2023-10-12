package edu.hw1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task8 {
    private final static Logger LOGGER = LogManager.getLogger();
    private final static int BOARD_SIDE_SIZE = 8;
    private final static int MINUS_TWO = -2;

    private Task8() {

    }

    public static boolean knightBoardCapture(int[][] arr) {
        Pair<Integer, Integer>[] knightMoves = new Pair[] {
            new Pair<>(2, 1),
            new Pair<>(1, 2),
            new Pair<>(2, -1),
            new Pair<>(-1, 2),
            new Pair<>(-1, MINUS_TWO),
            new Pair<>(MINUS_TWO, -1),
            new Pair<>(MINUS_TWO, 1),
            new Pair<>(1, MINUS_TWO),
        };

        for (int i = 0; i < BOARD_SIDE_SIZE; ++i) {
            for (int j = 0; j < BOARD_SIDE_SIZE; ++j) {
                for (var each : knightMoves) {
                    int x = each.first + i;
                    int y = each.second + j;

                    if (x >= 0 && y >= 0 && x < BOARD_SIDE_SIZE && y < BOARD_SIDE_SIZE
                        && arr[x][y] == 1 && arr[i][j] == 1) {
                        LOGGER.trace("Knight {}, {} hits {}, {}", i, j, x, y);
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
