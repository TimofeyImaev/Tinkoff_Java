package edu.hw6;

import java.io.File;

public class Paths {
    private Paths() {

    }

    public static String getPathToRepository() {

        return new File("").getAbsolutePath();
    }
}
