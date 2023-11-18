package edu.hw6;

import edu.hw1.Pair;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static java.util.Map.entry;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class Task1Test {
    static Arguments[] listOfEntrys() {
        return new Arguments[] {
            Arguments.of(
                List.<Pair<String, String>>of(
                    new Pair("key1", "value1"),
                    new Pair("key2", "gd3d")
                )),
            Arguments.of(
                List.of(
                    new Pair("asf", "d3sasd")
                )),
            Arguments.of(
                List.of(
                )),
            Arguments.of(
                List.of(
                    new Pair("key1", "value1"),
                    new Pair("key3", "dasad"),
                    new Pair("key2", "asfas"),
                    new Pair("g4g2g", "asfasf"),
                    new Pair("key6", "hfh")
                )),
            Arguments.of(
                List.of(
                    new Pair("key1", "shww"),
                    new Pair("key2", "dsg2"),
                    new Pair("key21", "sdf2")
                )
            )
        };
    }

    static Arguments[] keySets() {
        return new Arguments[] {
            Arguments.of(
                Set.<String>of(
                    "key1",
                    "key2"
                )),
            Arguments.of(
                Set.of(
                    "asf", "d3sasd"
                )),
            Arguments.of(
                Set.of(
                )),
            Arguments.of(
                Set.of(
                    "key1",
                    "key3",
                    "key2",
                    "g4g2g",
                    "key6"
                )),
            Arguments.of(
                Set.of(
                    "key1",
                    "key2",
                    "key21"
                )
            )
        };
    }

    static Arguments[] maps() {
        return new Arguments[] {
            Arguments.of(
                Map.ofEntries(
                    entry("key1", "value1"),
                    entry("key2", "gd3d")
                )),
            Arguments.of(
                Map.ofEntries(
                    entry("asf", "d3sasd")
                )),
            Arguments.of(
                Map.ofEntries(
                )),
            Arguments.of(
                Map.ofEntries(
                    entry("key1", "value1"),
                    entry("key3", "dasad"),
                    entry("key2", "asfas"),
                    entry("g4g2g", "asfasf"),
                    entry("key6", "hfh")
                )),
            Arguments.of(
                Map.ofEntries(
                    entry("key1", "shww"),
                    entry("key2", "dsg2"),
                    entry("key21", "sdf2")
                )
            )
        };
    }

    static Arguments[] entrys() {
        return new Arguments[] {
            Arguments.of(
                new Pair("key1", "value1")
            ),
            Arguments.of(
                new Pair("asf", "d3sasd")
            ),
            Arguments.of(
                new Pair("asf", "d3sasd")
            ),
            Arguments.of(
                new Pair("key1", "value1")
            ),
            Arguments.of(
                new Pair("key1", "shww")
            )
        };
    }

    @ParameterizedTest
    @MethodSource("listOfEntrys")
    void givenDiskMapWhenPuttingElementsOnMapThenFilesCreated(
        List<Pair<String, String>> entrysList
    ) {
        Task1.DiskMap diskMap = new Task1.DiskMap();

        for (var each : entrysList) {
            diskMap.put(each.first, each.second);
        }

        for (var each : entrysList) {
            if (!Files.exists(Path.of(
                "C:\\Users\\ullle\\IdeaProjects\\java-course-2023\\src\\main\\java\\edu\\hw6\\dictionary\\" +
                    each.first))) {
                fail();
            }
        }

        diskMap.clear();

        assertTrue(true);
    }

    @ParameterizedTest
    @MethodSource("entrys")
    void givenDiskMapWhenPutElementThenCheckContainsKey(
        Pair<String, String> entry
    ) {
        Task1.DiskMap diskMap = new Task1.DiskMap();

        diskMap.put(entry.first, entry.second);

        if (!diskMap.containsKey(entry.first)) {
            fail(entry.first);
        }
        diskMap.clear();

        assertTrue(true);
    }

    @ParameterizedTest
    @MethodSource("entrys")
    void givenDiskMapWhenPutElementThenCheckContainsValue(
        Pair<String, String> entry
    ) {
        Task1.DiskMap diskMap = new Task1.DiskMap();

        diskMap.put(entry.first, entry.second);

        if (!diskMap.containsValue(entry.second)) {
            fail(entry.second);
        }
        diskMap.clear();

        assertTrue(true);
    }

    @ParameterizedTest
    @MethodSource("entrys")
    void givenDiskMapWhenPutElementThenCheckGetByKey(
        Pair<String, String> entry
    ) {
        Task1.DiskMap diskMap = new Task1.DiskMap();

        diskMap.put(entry.first, entry.second);

        if (!diskMap.get(entry.first).equals(entry.second)) {
            fail();
        }
        diskMap.clear();

        assertTrue(true);
    }

    @ParameterizedTest
    @MethodSource("listOfEntrys")
    void givenDiskMapWhenPutElementThenCheckSizeOfDiskMap(
        List<Pair<String, String>> entrysList
    ) {
        Task1.DiskMap diskMap = new Task1.DiskMap();

        for (var each : entrysList) {
            diskMap.put(each.first, each.second);
        }

        int sizeOfDiskMap = diskMap.size();

        diskMap.clear();

        assertThat(sizeOfDiskMap).isEqualTo(entrysList.size());
    }

    @ParameterizedTest
    @MethodSource("entrys")
    void givenDiskMapWhenPutElementThenRemoveElement(
        Pair<String, String> entry
    ) {
        Task1.DiskMap diskMap = new Task1.DiskMap();

        diskMap.put(entry.first, entry.second);
        diskMap.remove(entry.first);

        if (diskMap.containsKey(entry.first)) {
            fail();
        }
        diskMap.clear();

        assertTrue(true);
    }

    @ParameterizedTest
    @MethodSource("maps")
    void givenDiskMapWhenPutAllElementsOnMapThenFilesCreated(
        Map<String, String> map
    ) {
        Task1.DiskMap diskMap = new Task1.DiskMap();

        diskMap.putAll(map);

        for (var each : map.entrySet()) {
            if (!Files.exists(Path.of(
                "C:\\Users\\ullle\\IdeaProjects\\java-course-2023\\src\\main\\java\\edu\\hw6\\dictionary\\" +
                    each.getKey()))) {
                fail();
            }
        }

        diskMap.clear();

        assertTrue(true);
    }

    @ParameterizedTest
    @MethodSource("keySets")
    void givenDiskMapWhenPutAllElementsOnMapThenCheckingKeySet(
        Set<String> set
    ) {
        Task1.DiskMap diskMap = new Task1.DiskMap();

        set.forEach(key -> diskMap.put(key, "123"));

        if (!diskMap.keySet().equals(set)) {
            fail();
        }

        diskMap.clear();

        assertTrue(true);
    }

    @ParameterizedTest
    @MethodSource("listOfEntrys")
    void givenDiskMapWhenPuttingElementsOnMapThenReturnedValues(
        List<Pair<String, String>> entrysList
    ) {
        Task1.DiskMap diskMap = new Task1.DiskMap();

        for (var each : entrysList) {
            diskMap.put(each.first, each.second);
        }

        Collection<String> collection = diskMap.values();

        for (var each : entrysList) {
            if (!collection.contains(each.second)) {
                fail();
            }
        }

        diskMap.clear();

        assertTrue(true);
    }

    @ParameterizedTest
    @MethodSource("listOfEntrys")
    void givenDiskMapWhenPuttingElementsOnMapThenReturnedEntrySet(
        List<Pair<String, String>> entrysList
    ) {
        Task1.DiskMap diskMap = new Task1.DiskMap();

        for (var each : entrysList) {
            diskMap.put(each.first, each.second);
        }

        Set<Map.Entry<String, String>> collection = diskMap.entrySet();

        for (var each : entrysList) {
            if (!collection.contains(Map.entry(each.first, each.second))) {
                fail();
            }
        }

        diskMap.clear();

        assertTrue(true);
    }
}
