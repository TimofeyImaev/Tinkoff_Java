package edu.hw9;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Collectors;

public class Task2 {
    private static final int MAX_COUNT_OF_FILES = 3;

    static class DirectoriesWithAtLeastThreeFiles extends RecursiveTask<List<Path>> {
        private final Path currentDirectory;

        DirectoriesWithAtLeastThreeFiles(Path currentDirectory) {
            this.currentDirectory = currentDirectory;
        }

        @Override
        protected List<Path> compute() {
            List<Path> directoriesWithAtLeastThreeFiles = new ArrayList<>();

            if (!Files.isDirectory(currentDirectory)) {
                return directoriesWithAtLeastThreeFiles;
            }

            List<Path> files;
            try {
                files = Files.list(currentDirectory).collect(Collectors.toList());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            if (files != null) {
                DirectoriesWithAtLeastThreeFiles[] tasks = new DirectoriesWithAtLeastThreeFiles[files.size()];

                for (int i = 0; i < files.size(); ++i) {
                    tasks[i] = new DirectoriesWithAtLeastThreeFiles(files.get(i));
                    tasks[i].fork();
                }

                for (int i = 0; i < files.size(); ++i) {
                    directoriesWithAtLeastThreeFiles.addAll(tasks[i].join());
                }

                if (files.size() >= MAX_COUNT_OF_FILES) {
                    directoriesWithAtLeastThreeFiles.add(currentDirectory);
                }
            }

            return directoriesWithAtLeastThreeFiles;
        }
    }
}
