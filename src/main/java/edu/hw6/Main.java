package edu.hw6;

import java.io.IOException;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {
        Path dict = Path.of("C:\\Users\\ullle\\IdeaProjects\\java-course-2023\\src\\main\\java\\edu\\hw6\\dictionary");

        String name = String.valueOf(dict.resolve("text.txt").getFileName());

        if (name.contains(".")) {
            System.out.println(name.split("\\.")[0] + " " + name.split("\\.")[1]);
        } else {
            System.out.println(name);
        }
    }
}
