package edu.project2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.swing.*;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
        Labyrinth labyrinth = new Labyrinth(11);

        labyrinth.buildLabyrinthUsingRecursiveBacktracker();

        //labyrinth.writeLabyrinth();

        //TimeUnit.MILLISECONDS.sleep(10000);
        labyrinth.findPathWithDfs(1, 1, 21, 19, true);

        //TimeUnit.MILLISECONDS.sleep(10000);
        labyrinth.findPathWithBfs(1, 1, 21, 19, true);

    }
}
