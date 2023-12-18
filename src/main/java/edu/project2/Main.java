package edu.project2;

import java.io.IOException;

public class Main {
    private final static int ELEVEN = 11;
    private final static int TWENTY_ONE = 21;
    private final static int NINETEEN = 19;

    private Main() {

    }

    public static void main(String[] args) throws InterruptedException, IOException {
        Labyrinth labyrinth = new Labyrinth(
            BuildLabyrinthRecursively.buildLabyrinthUsingRecursiveBacktracker(ELEVEN)
        );
        //labyrinth.writeLabyrinth();

        //TimeUnit.MILLISECONDS.sleep(10000);
        DepthFirstSearch depthFirstSearch = new DepthFirstSearch(
            labyrinth.labyrinth,
            labyrinth.frame,
            labyrinth.labels
        );
        depthFirstSearch.findPathWithDfs(1, 1, TWENTY_ONE, NINETEEN, true);

        BreadthFirstSearch breathFirstSearch = new BreadthFirstSearch(
            labyrinth.labyrinth,
            labyrinth.frame,
            labyrinth.labels
        );
        //TimeUnit.MILLISECONDS.sleep(10000);
        breathFirstSearch.findPathWithBfs(1, 1, TWENTY_ONE, NINETEEN, true);

    }
}
