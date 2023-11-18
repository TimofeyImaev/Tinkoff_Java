package edu.hw6;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {
        Path dict = Path.of("C:\\Users\\ullle\\IdeaProjects\\java-course-2023\\src\\main\\java\\edu\\hw6\\dictionary");

        if (!Files.exists(dict.resolve("Key1.txt")))
            Files.createFile(dict.resolve("Key1.txt"));
        else
            Files.delete(dict.resolve("Key1.txt"));
    }
}
