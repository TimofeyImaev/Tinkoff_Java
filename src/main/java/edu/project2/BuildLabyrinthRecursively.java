package edu.project2;

import java.util.Collections;
import static edu.project2.Constants.NEIGHBOURS_OF_CEIL;
import static edu.project2.Constants.cyanCeil;
import static edu.project2.Constants.orangeCeil;

public class BuildLabyrinthRecursively {
    static String[][] labyrinth;

    private BuildLabyrinthRecursively() {

    }

    private static void dfsPathBreaker(
        Integer x, Integer y,
        boolean[][] used
    ) {
        used[x][y] = true;
        labyrinth[x][y] = orangeCeil;
        //writeLabyrinth();

        Collections.shuffle(NEIGHBOURS_OF_CEIL);
        for (var shift : NEIGHBOURS_OF_CEIL) {
            Integer neighbourX = x + shift.first * 2;
            Integer neighbourY = y + shift.second * 2;

            if (neighbourX.compareTo(0) > 0 && neighbourY.compareTo(0) > 0
                && neighbourX.compareTo(labyrinth.length - 1) < 0
                && neighbourY.compareTo(labyrinth.length - 1) < 0
                && !used[neighbourX][neighbourY]) {
                labyrinth[x + shift.first][y + shift.second] = orangeCeil;
                dfsPathBreaker(neighbourX, neighbourY, used);
            }
        }
    }

    static String[][] buildLabyrinthUsingRecursiveBacktracker(int sideOfLabyrinth) {
        int newSideOfLabyrinth = sideOfLabyrinth * 2 + 1;
        labyrinth = new String[newSideOfLabyrinth][newSideOfLabyrinth];

        for (int i = 0; i < newSideOfLabyrinth; ++i) {
            for (int j = 0; j < newSideOfLabyrinth; ++j) {
                labyrinth[i][j] = cyanCeil;
            }
        }

        boolean[][] used = new boolean[labyrinth.length][labyrinth.length];

        dfsPathBreaker(1, 1, used);

        return labyrinth;
    }
}
