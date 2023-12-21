package edu.hw9.task2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Collectors;

public class DirectoriesSortedByNumberOfFiles extends RecursiveTask<List<Path>> {
    private final Path currentDirectory;
    private final int countOfFiles;

    public DirectoriesSortedByNumberOfFiles(Path currentDirectory, int countOfFiles) {
        this.currentDirectory = currentDirectory;
        this.countOfFiles = countOfFiles;
    }

    @Override
    protected List<Path> compute() {
        List<Path> directoriesSortedByNumberOfFiles = new ArrayList<>();

        if (!Files.isDirectory(currentDirectory)) {
            return directoriesSortedByNumberOfFiles;
        }

        List<Path> files;
        try {
            files = Files.list(currentDirectory).collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (files != null) {
            DirectoriesSortedByNumberOfFiles[] tasks = new DirectoriesSortedByNumberOfFiles[files.size()];

            for (int i = 0; i < files.size(); ++i) {
                tasks[i] = new DirectoriesSortedByNumberOfFiles(files.get(i), countOfFiles);
                tasks[i].fork();
            }

            for (int i = 0; i < files.size(); ++i) {
                directoriesSortedByNumberOfFiles.addAll(tasks[i].join());
            }

            if (files.size() >= countOfFiles) {
                directoriesSortedByNumberOfFiles.add(currentDirectory);
            }
        }

        return directoriesSortedByNumberOfFiles;
    }
}
