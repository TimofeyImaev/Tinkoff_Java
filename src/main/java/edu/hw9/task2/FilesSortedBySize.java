package edu.hw9.task2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Collectors;

public class FilesSortedBySize extends RecursiveTask<List<Path>> {
    private final Path currentPath;
    private final long size;

    public FilesSortedBySize(Path currentDirectory, long size) {
        this.currentPath = currentDirectory;
        this.size = size;
    }

    @Override
    protected List<Path> compute() {
        List<Path> filesSortedBySize = new ArrayList<>();

        List<Path> files = new ArrayList<>();

        try {
            if (!Files.isDirectory(currentPath)) {
                if (Files.size(currentPath) < size) {
                    filesSortedBySize.add(currentPath);
                }
            } else {
                files = Files.list(currentPath).collect(Collectors.toList());
            }
        } catch (IOException e) {
        }

        if (Files.isDirectory(currentPath)) {
            FilesSortedBySize[] tasks = new FilesSortedBySize[files.size()];

            for (int i = 0; i < files.size(); ++i) {
                tasks[i] = new FilesSortedBySize(files.get(i), size);
                tasks[i].fork();
            }

            for (int i = 0; i < files.size(); ++i) {
                filesSortedBySize.addAll(tasks[i].join());
            }
        }

        return filesSortedBySize;
    }
}
