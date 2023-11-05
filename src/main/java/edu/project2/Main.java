package edu.project2;

import java.io.IOException;

public class Main {
    private final static int ELEVEN = 11;
    private final static int TWENTY_ONE = 21;
    private final static int NINETEEN = 19;

    private Main() {

    }

    public static void main(String[] args) throws InterruptedException, IOException {
        Labyrinth labyrinth = new Labyrinth(ELEVEN);

        labyrinth.buildLabyrinthUsingRecursiveBacktracker();

        //labyrinth.writeLabyrinth();

        //TimeUnit.MILLISECONDS.sleep(10000);
        labyrinth.findPathWithDfs(1, 1, TWENTY_ONE, NINETEEN, true);

        //TimeUnit.MILLISECONDS.sleep(10000);
        labyrinth.findPathWithBfs(1, 1, TWENTY_ONE, NINETEEN, true);

    }
}
