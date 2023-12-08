package edu.hw9;

import java.io.File;
import java.util.concurrent.RecursiveTask;

public class Task2 {
    static class AmountOfDirectoryFiles extends RecursiveTask<Integer> {
        private final File currentDirectory;

        AmountOfDirectoryFiles(File currentDirectory) {
            this.currentDirectory = currentDirectory;
        }

        @Override
        protected Integer compute() {
            if (!currentDirectory.isDirectory()) {
                return 0;
            }

            int amountOfFilesInCurrentDirectory = 0;
            File[] listFiles = currentDirectory.listFiles();
            AmountOfDirectoryFiles[] filesFromCurrentDirectory = new AmountOfDirectoryFiles[listFiles.length];

            for (int i = 0; i < listFiles.length; ++i) {
                filesFromCurrentDirectory[i] = new AmountOfDirectoryFiles(listFiles[i]);
                filesFromCurrentDirectory[i].fork();
            }

            for (int i = 0; i < listFiles.length; ++i) {
                amountOfFilesInCurrentDirectory += filesFromCurrentDirectory[i].join() + 1;
            }

            return amountOfFilesInCurrentDirectory;
        }
    }
}
