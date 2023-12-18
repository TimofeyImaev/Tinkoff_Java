package edu.project2;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Labyrinth {

    String[][] labyrinth;
    JFrame frame;
    JLabel[] labels;

    private Labyrinth() {

    }

    @Deprecated
    public Labyrinth(int sideOfLabyrinth) {
        int newSideOfLabyrinth = sideOfLabyrinth * 2 + 1;
        this.labyrinth = new String[newSideOfLabyrinth][newSideOfLabyrinth];
    }

    public Labyrinth(String[][] preparedLabyrinth) {
        this.labyrinth = preparedLabyrinth;
    }
}
