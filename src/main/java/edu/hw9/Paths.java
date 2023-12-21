package edu.hw9;

import java.io.File;

public class Paths {
    private Paths() {

    }

    public static String getRepositoryPath() {
        return new File("").getAbsolutePath();
    }
}
