package edu.hw6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Task2 {
    static void cloneFile(Path path) throws IOException {
        if (Files.exists(path)) {
            String fileNameWithTag = String.valueOf(path.getFileName());
            String fileName;
            String fileType = "";

            if (fileNameWithTag.contains(".")) {
                fileName = fileNameWithTag.split("\\.")[0];
                fileType = "." + fileNameWithTag.split("\\.")[1];
            } else {
                fileName = fileNameWithTag;
            }

            if (Files.exists(Path.of(path.getParent().toString() + "\\" + fileName + " — копия" + fileType))) {
                int copyIndex = 2;

                while (Files.exists(Path.of(
                    path.getParent().toString() + "\\" + fileName + " — копия (" + copyIndex + ")" + fileType))) {
                    copyIndex++;
                }

                Files.copy(path, Path.of(
                    path.getParent().toString() + "\\" + fileName + " — копия (" + copyIndex + ")" + fileType));
            } else {
                Files.copy(path, Path.of(path.getParent().toString() + "\\" + fileName + " — копия" + fileType));
            }
        }
    }
}
