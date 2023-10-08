package edu.hw1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class KnightBoardCapture {
    private final static Logger LOGGER = LogManager.getLogger();

    private KnightBoardCapture() {

    }

    public static boolean knightBoardCapture(int[][] arr) {
        final int boardSideSize = 8;
        final int minusTwo = -2;
        Pair<Integer, Integer>[] coords = new Pair[] {
            new Pair<>(2, 1),
            new Pair<>(1, 2),
            new Pair<>(2, -1),
            new Pair<>(-1, 2),
            new Pair<>(-1, minusTwo),
            new Pair<>(minusTwo, -1),
            new Pair<>(minusTwo, 1),
            new Pair<>(1, minusTwo),
        };

        for (int i = 0; i < boardSideSize; ++i) {
            for (int j = 0; j < boardSideSize; ++j) {
                for (var each : coords) {
                    int x = each.first + i;
                    int y = each.second + j;

                    if (x >= 0 && y >= 0 && x < boardSideSize && y < boardSideSize
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
