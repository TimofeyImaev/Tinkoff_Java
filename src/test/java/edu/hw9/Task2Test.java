package edu.hw9;

import java.net.URL;
import java.nio.file.Path;
import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task2Test {
    static Path currentFilePath = Path.of(System.getProperty("user.dir"));
    static Path someDirectory =
        currentFilePath.resolve("src\\test\\java\\edu\\hw9\\someDirectory");

    static Arguments[] directoryPaths() {
        return new Arguments[] {
            Arguments.of(
                someDirectory,
                List.<Path>of(
                    someDirectory.resolve("BigDirectory"),
                    someDirectory.resolve("randomDirectory\\directory\\ThreeFiles"),
                    someDirectory.resolve("randomDirectory\\directory"),
                    someDirectory
                )
            ),
            Arguments.of(
                someDirectory.resolve("BigDirectory"),
                List.<Path>of(
                    someDirectory.resolve("BigDirectory")
                )
            ),
            Arguments.of(
                someDirectory.resolve("randomDirectory"),
                List.<Path>of(
                    someDirectory.resolve("randomDirectory\\directory\\ThreeFiles"),
                    someDirectory.resolve("randomDirectory\\directory")
                )
            ),
            Arguments.of(
                someDirectory.resolve("smallDirectory"),
                List.<Path>of(
                )
            ),
        };
    }

    @ParameterizedTest
    @MethodSource("directoryPaths")
    void givenDirectoryWhenSearchingDirectoriesWithAtLeastThreeFilesThenReturnPath(
        Path rootOfTree,
        List<Path> expectedAnswer
    ) {
        Task2.DirectoriesWithAtLeastThreeFiles directoriesWithAtLeastThreeFiles =
            new Task2.DirectoriesWithAtLeastThreeFiles(rootOfTree);

        directoriesWithAtLeastThreeFiles.fork();
        List<Path> actualAnswer = directoriesWithAtLeastThreeFiles.join();

        assertEquals(expectedAnswer, actualAnswer);
    }
}
