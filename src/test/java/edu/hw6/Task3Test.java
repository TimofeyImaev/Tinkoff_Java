package edu.hw6;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static java.nio.file.Files.newDirectoryStream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class Task3Test {
    static Arguments[] directoryPathsWithRegexAns() {
        return new Arguments[] {
            Arguments.of(
                Path.of(
                    Paths.getPathToRepository() + "/src/test/java/edu/hw6/TestDirectories/b1234"),
                List.of("Tinkoff Bank Biggest Secret.txt")
            ),
            Arguments.of(
                Path.of(
                    Paths.getPathToRepository() + "/src/test/java/edu/hw6/TestDirectories/firstDirectory"),
                List.of(
                    "Tinkoff Bank Biggest Secret — копия (2).txt",
                    "Tinkoff Bank Biggest Secret — копия.txt",
                    "Tinkoff Bank Biggest Secret — копия (1).txt",
                    "Tinkoff Bank Biggest Secret.txt"
                )
            ),
            Arguments.of(
                Path.of(
                    Paths.getPathToRepository() + "/src/test/java/edu/hw6/TestDirectories/Folder"),
                List.of()
            ),
            Arguments.of(
                Path.of(
                    Paths.getPathToRepository() + "/src/test/java/edu/hw6/TestDirectories/secondDirectory"),
                List.of("tocopyfile.txt")
            ),
            Arguments.of(
                Path.of(
                    Paths.getPathToRepository() + "/src/test/java/edu/hw6/TestDirectories/thirdDirectory"),
                List.of()
            ),
        };
    }

    static Arguments[] directoryPathsWithSizeAnswer() {
        return new Arguments[] {
            Arguments.of(
                Path.of(
                    Paths.getPathToRepository() + "/src/test/java/edu/hw6/TestDirectories/b1234"),
                List.of("Tinkoff Bank Biggest Secret.txt")
            ),
            Arguments.of(
                Path.of(
                    Paths.getPathToRepository() + "/src/test/java/edu/hw6/TestDirectories/firstDirectory"),
                List.of(
                    "Tinkoff Bank Biggest Secret — копия (2).txt",
                    "Tinkoff Bank Biggest Secret — копия.txt",
                    "Tinkoff Bank Biggest Secret.txt",
                    "Tinkoff Bank Biggest Secret — копия (1).txt"
                )
            ),
            Arguments.of(
                Path.of(
                    Paths.getPathToRepository() + "/src/test/java/edu/hw6/TestDirectories/Folder"),
                List.of("file123", "somefile")
            ),
            Arguments.of(
                Path.of(
                    Paths.getPathToRepository() + "/src/test/java/edu/hw6/TestDirectories/secondDirectory"),
                List.of("tocopyfile.txt", "tocopyfile - копия")
            ),
            Arguments.of(
                Path.of(
                    Paths.getPathToRepository() + "/src/test/java/edu/hw6/TestDirectories/thirdDirectory"),
                List.of()
            ),
        };
    }

    static Arguments[] directoryPathsWithMagicNumberAnswer() {
        return new Arguments[] {
            Arguments.of(
                Path.of(
                    Paths.getPathToRepository() + "/src/test/java/edu/hw6/TestDirectories/b1234"),
                List.of("thisfile.png")
            ),
            Arguments.of(
                Path.of(
                    Paths.getPathToRepository() + "/src/test/java/edu/hw6/TestDirectories/firstDirectory"),
                List.of()
            ),
            Arguments.of(
                Path.of(
                    Paths.getPathToRepository() + "/src/test/java/edu/hw6/TestDirectories/Folder"),
                List.of()
            ),
            Arguments.of(
                Path.of(
                    Paths.getPathToRepository() + "/src/test/java/edu/hw6/TestDirectories/secondDirectory"),
                List.of()
            ),
            Arguments.of(
                Path.of(
                    Paths.getPathToRepository() + "/src/test/java/edu/hw6/TestDirectories/thirdDirectory"),
                List.of()
            ),
        };
    }

    static Arguments[] directoryPathsWithAttributesAnswer() {
        return new Arguments[] {
            Arguments.of(
                Path.of(
                    Paths.getPathToRepository() + "/src/test/java/edu/hw6/TestDirectories/b1234"),
                List.of("thisfile.png", "Tinkoff Bank Biggest Secret.txt")
            ),
            Arguments.of(
                Path.of(
                    Paths.getPathToRepository() + "/src/test/java/edu/hw6/TestDirectories/firstDirectory"),
                List.of(
                    "nottext",
                    "Tinkoff Bank Biggest Secret — копия (2).txt",
                    "Tinkoff Bank Biggest Secret — копия.txt",
                    "Tinkoff Bank Biggest Secret.txt",
                    "Tinkoff Bank Biggest Secret — копия (1).txt"
                )
            ),
            Arguments.of(
                Path.of(
                    Paths.getPathToRepository() + "/src/test/java/edu/hw6/TestDirectories/Folder"),
                List.of("file123", "somefile")
            ),
            Arguments.of(
                Path.of(
                    Paths.getPathToRepository() + "/src/test/java/edu/hw6/TestDirectories/secondDirectory"),
                List.of("tocopyfile - копия", "tocopyfile.txt")
            ),
            Arguments.of(
                Path.of(
                    Paths.getPathToRepository() + "/src/test/java/edu/hw6/TestDirectories/thirdDirectory"),
                List.of("asdfile", "asdfile — копия", "asdfile — копия (1)")
            ),
        };
    }

    @ParameterizedTest
    @MethodSource("directoryPathsWithRegexAns")
    void givenDirectoryPathWhenFilteringFilesByExtensionThenReturnStreamOfPaths(
        Path file,
        List<String> expectedAnswer
    ) throws IOException {
        Task3.FileExtensionsFilter fileExtensionsFilter = new Task3.FileExtensionsFilter("txt");

        DirectoryStream<Path> actualAnswer = newDirectoryStream(file, fileExtensionsFilter);

        AtomicInteger actualAnswerSize = new AtomicInteger();

        actualAnswer.forEach(
            path -> {
                if (!expectedAnswer.contains(path.getFileName().toString())) {
                    fail(path.getFileName().toString());
                }
                actualAnswerSize.getAndIncrement();
            }
        );

        assertEquals(actualAnswerSize.get(), expectedAnswer.size());
    }

    @ParameterizedTest
    @MethodSource("directoryPathsWithMagicNumberAnswer")
    void givenDirectoryPathWhenFilteringFilesByMagicNumbersThenReturnStreamOfPaths(
        Path file,
        List<String> expectedAnswer
    ) throws IOException {
        Task3.MagicNumbersFilter magicNumbersFilter = new Task3.MagicNumbersFilter(0x89);

        DirectoryStream<Path> actualAnswer = newDirectoryStream(file, magicNumbersFilter);

        AtomicInteger actualAnswerSize = new AtomicInteger();

        actualAnswer.forEach(
            path -> {
                if (!expectedAnswer.contains(path.getFileName().toString())) {
                    fail(path.getFileName().toString());
                }
                actualAnswerSize.getAndIncrement();
            }
        );

        assertEquals(actualAnswerSize.get(), expectedAnswer.size());
    }

    @ParameterizedTest
    @MethodSource("directoryPathsWithRegexAns")
    void givenDirectoryPathWhenFilteringFilesByRegexThenReturnStreamOfPaths(
        Path file,
        List<String> expectedAnswer
    ) throws IOException {
        Task3.RegexFilter regexFilter = new Task3.RegexFilter(".*/.txt$");

        DirectoryStream<Path> actualAnswer = newDirectoryStream(file, regexFilter);

        AtomicInteger actualAnswerSize = new AtomicInteger();

        actualAnswer.forEach(
            path -> {
                if (!expectedAnswer.contains(path.getFileName().toString())) {
                    fail(path.getFileName().toString());
                }
                actualAnswerSize.getAndIncrement();
            }
        );

        assertEquals(actualAnswerSize.get(), expectedAnswer.size());
    }

    @ParameterizedTest
    @MethodSource("directoryPathsWithSizeAnswer")
    void givenDirectoryPathWhenFilteringFilesBySizeThenReturnStreamOfPaths(
        Path file,
        List<String> expectedAnswer
    ) throws IOException {
        Task3.SizeFilter sizeFilter = new Task3.SizeFilter();

        sizeFilter.setMaxSize(1000);
        sizeFilter.setMinSize(10);
        DirectoryStream<Path> actualAnswer = newDirectoryStream(file, sizeFilter);

        AtomicInteger actualAnswerSize = new AtomicInteger();

        actualAnswer.forEach(
            path -> {
                if (!expectedAnswer.contains(path.getFileName().toString())) {
                    fail(path.getFileName().toString());
                }
                actualAnswerSize.getAndIncrement();
            }
        );

        assertEquals(expectedAnswer.size(), actualAnswerSize.get());
    }

    @ParameterizedTest
    @MethodSource("directoryPathsWithAttributesAnswer")
    void givenDirectoryPathWhenFilteringFilesByAttributeReturnStreamOfPaths(
        Path file,
        List<String> expectedAnswer
    ) throws IOException {
        Task3.AttributeFilter attributeFilter = new Task3.AttributeFilter("readable");

        DirectoryStream<Path> actualAnswer = newDirectoryStream(file, attributeFilter);

        AtomicInteger actualAnswerSize = new AtomicInteger();

        actualAnswer.forEach(
            path -> {
                if (!expectedAnswer.contains(path.getFileName().toString())) {
                    fail(path.getFileName().toString());
                }
                actualAnswerSize.getAndIncrement();
            }
        );

        assertEquals(expectedAnswer.size(), actualAnswerSize.get());
    }
}
