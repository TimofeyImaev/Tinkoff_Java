package edu.hw6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class Task2Test {
    static Arguments[] filePaths() {
        return new Arguments[] {
            Arguments.of(
                Path.of(
                    Paths.getPathToRepository() + "\\src\\test\\java\\edu\\hw6\\TestDirectories\\b1234\\Tinkoff Bank Biggest Secret.txt"),
                Path.of(
                    Paths.getPathToRepository() + "\\src\\test\\java\\edu\\hw6\\TestDirectories\\b1234\\Tinkoff Bank Biggest Secret — копия.txt")
            ),
            Arguments.of(
                Path.of(
                    Paths.getPathToRepository() + "\\src\\test\\java\\edu\\hw6\\TestDirectories\\firstDirectory\\Tinkoff Bank Biggest Secret.txt"),
                Path.of(
                    Paths.getPathToRepository() + "\\src\\test\\java\\edu\\hw6\\TestDirectories\\firstDirectory\\Tinkoff Bank Biggest Secret — копия (3).txt")
            ),
            Arguments.of(
                Path.of(
                    Paths.getPathToRepository() + "\\src\\test\\java\\edu\\hw6\\TestDirectories\\Folder\\somefile"),
                Path.of(
                    Paths.getPathToRepository() + "\\src\\test\\java\\edu\\hw6\\TestDirectories\\Folder\\somefile — копия")
            ),
            Arguments.of(
                Path.of(
                    Paths.getPathToRepository() + "\\src\\test\\java\\edu\\hw6\\TestDirectories\\secondDirectory\\tocopyfile.txt"),
                Path.of(
                    Paths.getPathToRepository() + "\\src\\test\\java\\edu\\hw6\\TestDirectories\\secondDirectory\\tocopyfile — копия.txt")
            ),
            Arguments.of(
                Path.of(
                    Paths.getPathToRepository() + "\\src\\test\\java\\edu\\hw6\\TestDirectories\\thirdDirectory\\asdfile"),
                Path.of(
                    Paths.getPathToRepository() + "\\src\\test\\java\\edu\\hw6\\TestDirectories\\thirdDirectory\\asdfile — копия (2)")
            ),
        };
    }

    @ParameterizedTest
    @MethodSource("filePaths")
    void givenFilePathWhenCreatingCopyOfFile(
        Path toCopyFilePath,
        Path expectedAnswer
    ) throws IOException {
        Task2.cloneFile(toCopyFilePath);

        boolean isFileExist = Files.exists(expectedAnswer);
        boolean isFilesCopied = false;

        if (isFileExist) {
            if (Files.readAllLines(expectedAnswer).equals(Files.readAllLines(toCopyFilePath))) {
                isFilesCopied = true;
            }

            Files.delete(expectedAnswer);
        }

        assertTrue(isFilesCopied);
    }
}
