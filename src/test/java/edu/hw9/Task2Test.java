package edu.hw9;

import edu.hw9.task2.DirectoriesSortedByNumberOfFiles;
import edu.hw9.task2.FilesSortedByExtension;
import edu.hw9.task2.FilesSortedBySize;
import java.nio.file.Path;
import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task2Test {
    static Path currentFilePath = Path.of(Paths.getRepositoryPath());
    static Path someDirectory =
        currentFilePath.resolve("src/test/java/edu/hw9/someDirectory");

    static Arguments[] directoryPathsSortedByNumberOfFiles() {
        return new Arguments[] {
            Arguments.of(
                someDirectory,
                List.<Path>of(
                    someDirectory.resolve("BigDirectory"),
                    someDirectory.resolve("randomDirectory/directory/ThreeFiles"),
                    someDirectory.resolve("randomDirectory/directory"),
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
                    someDirectory.resolve("randomDirectory/directory/ThreeFiles"),
                    someDirectory.resolve("randomDirectory/directory")
                )
            ),
            Arguments.of(
                someDirectory.resolve("smallDirectory"),
                List.<Path>of(
                )
            ),
        };
    }

    static Arguments[] directoryPathsSortedSize() {
        return new Arguments[] {
            Arguments.of(
                someDirectory,
                List.<Path>of(
                    someDirectory.resolve("BigDirectory/some.png"),
                    someDirectory.resolve("BigDirectory/someFIleTwo"),
                    someDirectory.resolve("randomDirectory/directory/file.png"),
                    someDirectory.resolve("randomDirectory/directory/twoFiles/file1"),
                    someDirectory.resolve("thisispng.png")
                )
            ),
            Arguments.of(
                someDirectory.resolve("BigDirectory"),
                List.<Path>of(
                    someDirectory.resolve("BigDirectory/some.png"),
                    someDirectory.resolve("BigDirectory/someFIleTwo")
                )
            ),
            Arguments.of(
                someDirectory.resolve("randomDirectory"),
                List.<Path>of(
                    someDirectory.resolve("randomDirectory/directory/file.png"),
                    someDirectory.resolve("randomDirectory/directory/twoFiles/file1")
                )
            ),
            Arguments.of(
                someDirectory.resolve("smallDirectory"),
                List.<Path>of(
                )
            ),
        };
    }

    static Arguments[] directoryPathsSortedExtension() {
        return new Arguments[] {
            Arguments.of(
                someDirectory,
                List.<Path>of(
                    someDirectory.resolve("BigDirectory/some.png"),
                    someDirectory.resolve("randomDirectory/directory/file.png"),
                    someDirectory.resolve("thisispng.png")
                )
            ),
            Arguments.of(
                someDirectory.resolve("BigDirectory"),
                List.<Path>of(
                    someDirectory.resolve("BigDirectory/some.png")
                )
            ),
            Arguments.of(
                someDirectory.resolve("randomDirectory"),
                List.<Path>of(
                    someDirectory.resolve("randomDirectory/directory/file.png")
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
    @MethodSource("directoryPathsSortedExtension")
    void givenDirectoryWhenSearchingFilesByExtensionThenReturnPath(
        Path rootOfTree,
        List<Path> expectedAnswer
    ) {
        FilesSortedByExtension filesSortedBySize =
            new FilesSortedByExtension(rootOfTree, "png");

        filesSortedBySize.fork();
        List<Path> actualAnswer = filesSortedBySize.join();

        assertEquals(expectedAnswer, actualAnswer);
    }

    @ParameterizedTest
    @MethodSource("directoryPathsSortedSize")
    void givenDirectoryWhenSearchingFilesBySizeThenReturnPath(
        Path rootOfTree,
        List<Path> expectedAnswer
    ) {
        FilesSortedBySize filesSortedBySize =
            new FilesSortedBySize(rootOfTree, 10);

        filesSortedBySize.fork();
        List<Path> actualAnswer = filesSortedBySize.join();

        assertEquals(expectedAnswer, actualAnswer);
    }

    @ParameterizedTest
    @MethodSource("directoryPathsSortedByNumberOfFiles")
    void givenDirectoryWhenSearchingDirectoriesWithAtLeastThreeFilesThenReturnPath(
        Path rootOfTree,
        List<Path> expectedAnswer
    ) {
        DirectoriesSortedByNumberOfFiles directoriesWithAtLeastThreeFiles =
            new DirectoriesSortedByNumberOfFiles(rootOfTree, 3);

        directoriesWithAtLeastThreeFiles.fork();
        List<Path> actualAnswer = directoriesWithAtLeastThreeFiles.join();

        assertEquals(expectedAnswer, actualAnswer);
    }
}
