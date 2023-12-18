package edu.project2;

import edu.hw1.Pair;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class PathTest {
    @Test
    void givenRandomLabyrinthWhenSearchingPathBetweenTwoPointWithDFSThenReturnPath()
        throws IOException, InterruptedException {
        Random random = new Random();

        for (int j = 0; j < 100; ++j) {
            int sideLength = random.nextInt(2, 30);
            Labyrinth labyrinth = new Labyrinth(
                BuildLabyrinthRecursively
                    .buildLabyrinthUsingRecursiveBacktracker(sideLength)
            );

            DepthFirstSearch depthFirstSearch = new DepthFirstSearch(
                labyrinth.labyrinth, labyrinth.frame, labyrinth.labels
            );
            List<Pair<Integer, Integer>> path = depthFirstSearch.findPathWithDfs(
                random.nextInt(1, sideLength) * 2 + 1,
                random.nextInt(1, sideLength) * 2 + 1,
                random.nextInt(1, sideLength) * 2 + 1,
                random.nextInt(1, sideLength) * 2 + 1,
                false
            );

            for (int i = 1; i < path.size(); ++i) {
                if (!labyrinth.labyrinth[path.get(i - 1).first][path.get(i - 1).second].equals(
                    labyrinth.labyrinth[path.get(i).first][path.get(i).second]
                )) {
                    fail();
                }
            }
        }

        assertTrue(true);
    }

    @Test
    void givenRandomLabyrinthWhenSearchingPathBetweenTwoPointWithBFSThenReturnPath()
        throws IOException, InterruptedException {
        Random random = new Random();

        for (int j = 0; j < 100; ++j) {
            int sideLength = random.nextInt(2, 30);
            Labyrinth labyrinth = new Labyrinth(
                BuildLabyrinthRecursively
                    .buildLabyrinthUsingRecursiveBacktracker(sideLength)
            );

            BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch(
                labyrinth.labyrinth, labyrinth.frame, labyrinth.labels
            );
            List<Pair<Integer, Integer>> path = breadthFirstSearch.findPathWithBfs(
                random.nextInt(1, sideLength) * 2 + 1,
                random.nextInt(1, sideLength) * 2 + 1,
                random.nextInt(1, sideLength) * 2 + 1,
                random.nextInt(1, sideLength) * 2 + 1,
                false
            );

            for (int i = 1; i < path.size(); ++i) {
                if (!labyrinth.labyrinth[path.get(i - 1).first][path.get(i - 1).second].equals(
                    labyrinth.labyrinth[path.get(i).first][path.get(i).second]
                )) {
                    fail();
                }
            }
        }

        assertTrue(true);
    }
}
