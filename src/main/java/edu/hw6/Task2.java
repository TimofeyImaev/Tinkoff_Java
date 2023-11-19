package edu.hw6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Task2 {
    static private final String DOT = "\\.";

    private Task2() {

    }

    static void cloneFile(Path path) throws IOException {
        if (Files.exists(path)) {
            String fileNameWithTag = String.valueOf(path.getFileName());
            String fileName;
            String fileType = "";

            if (fileNameWithTag.contains(".")) {
                fileName = fileNameWithTag.split(DOT)[0];
                fileType = "." + fileNameWithTag.split(DOT)[1];
            } else {
                fileName = fileNameWithTag;
            }
            Path pathToCopy = Path.of(path.getParent().toString() + "\\" + fileName + " — копия" + fileType);

            if (Files.exists(pathToCopy)) {
                int copyIndex = 1;
                Path pathToNthCopy;
                do {
                    pathToNthCopy = Path.of(
                        path.getParent().toString() + "\\" + fileName + " — копия (" + copyIndex + ")" + fileType);
                    copyIndex++;
                }
                while (Files.exists(pathToNthCopy));

                Files.copy(path, pathToNthCopy);
            } else {
                Files.copy(path, pathToCopy);
            }
        }
    }
}
