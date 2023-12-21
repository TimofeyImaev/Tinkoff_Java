package edu.hw9.task2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Collectors;

public class FilesSortedByExtension extends RecursiveTask<List<Path>> {
    private final Path currentPath;
    private final String extension;

    public FilesSortedByExtension(Path currentDirectory, String extension) {
        this.currentPath = currentDirectory;
        this.extension = extension;
    }

    @Override
    protected List<Path> compute() {
        List<Path> filesSortedByExtension = new ArrayList<>();

        List<Path> files = new ArrayList<>();

        try {
            String[] strings = currentPath.getFileName().toString().split("\\.", 2);

            if (!Files.isDirectory(currentPath)) {
                if (strings.length > 1
                    && strings[strings.length - 1].equals(extension)) {
                    filesSortedByExtension.add(currentPath);
                }
            } else {
                files = Files.list(currentPath).collect(Collectors.toList());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if (Files.isDirectory(currentPath)) {
            FilesSortedByExtension[] tasks = new FilesSortedByExtension[files.size()];

            for (int i = 0; i < files.size(); ++i) {
                tasks[i] = new FilesSortedByExtension(files.get(i), extension);
                tasks[i].fork();
            }

            for (int i = 0; i < files.size(); ++i) {
                filesSortedByExtension.addAll(tasks[i].join());
            }
        }

        return filesSortedByExtension;
    }
}

