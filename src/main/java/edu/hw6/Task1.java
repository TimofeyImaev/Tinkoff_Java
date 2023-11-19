package edu.hw6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Task1 {
    private final static Logger LOGGER = LogManager.getLogger();

    static class DiskMap implements Map<String, String> {
        private static final Path DICT =
            Path.of("C:\\Users\\ullle\\IdeaProjects\\java-course-2023\\src\\main\\java\\edu\\hw6\\dictionary");
        private static int size = 0;

        @Override
        public int size() {
            return size;
        }

        @Override
        public boolean isEmpty() {
            return size == 0;
        }

        @Override
        public boolean containsKey(Object key) {
            if (key == null || key.getClass() != String.class) {
                return false;
            }

            Path filePath = DICT.resolve((String) key);
            return Files.exists(filePath);
        }

        @Override
        public boolean containsValue(Object value) {
            if (value == null || value.getClass() != String.class) {
                return false;
            }

            String valueInFile = "[" + value + "]";

            try {
                Object finalValue = valueInFile;
                return Files.list(DICT)
                    .anyMatch(path -> {
                        try {
                            LOGGER.trace(
                                "Checking that {} value equals to {}",
                                String.valueOf(Files.readAllLines(path)),
                                finalValue
                            );
                            return String.valueOf(Files.readAllLines(path)).equals(finalValue);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public String get(Object key) {
            if (this.containsKey(key)) {
                Path filePath = DICT.resolve((String) key);
                if (Files.exists(filePath)) {
                    try {
                        String toSub = String.valueOf(Files.readAllLines(filePath));

                        LOGGER.trace("Value {}, subString of value {}", toSub, toSub.substring(1, toSub.length() - 1));

                        return toSub.substring(1, toSub.length() - 1);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            return null;
        }

        @Nullable
        @Override
        public String put(String key, String value) {
            Path filePath = DICT.resolve(key);
            if (Files.exists(filePath)) {
                try {
                    String previousValue = String.valueOf(Files.readAllLines(filePath));

                    Files.write(filePath, value.getBytes());

                    return previousValue;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else {
                size++;

                try {
                    Files.write(filePath, value.getBytes());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            return null;
        }

        @Override
        public String remove(Object key) {
            if (this.containsKey(key)) {
                Path filePath = DICT.resolve((String) key);
                if (Files.exists(filePath)) {
                    try {
                        String previousValue = String.valueOf(Files.readAllLines(filePath));

                        Files.delete(filePath);
                        size--;

                        return previousValue;
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            return null;
        }

        @Override
        public void putAll(@NotNull Map<? extends String, ? extends String> m) {
            for (var each : m.entrySet()) {
                put(each.getKey(), each.getValue());
            }
        }

        @Override
        public void clear() {
            try {
                Files.list(DICT)
                    .forEach(path -> {
                        try {
                            Files.delete(path);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });

                size = 0;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        @NotNull
        @Override
        public Set<String> keySet() {
            try {
                return Files.list(DICT)
                    .map(path -> path.getFileName().toString())
                    .collect(Collectors.toSet());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        @NotNull
        @Override
        public Collection<String> values() {
            try {
                return Files.list(DICT)
                    .map(path -> {
                        try {
                            String toSub = String.valueOf(Files.readAllLines(path));
                            return toSub.substring(1, toSub.length() - 1);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }).collect(Collectors.toList());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        @NotNull
        @Override
        public Set<Entry<String, String>> entrySet() {
            try {
                return Files.list(DICT)
                    .map(path -> {
                        try {
                            String toSub = String.valueOf(Files.readAllLines(path));
                            return Map.entry(path.getFileName().toString(), toSub.substring(1, toSub.length() - 1));
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }).collect(Collectors.toSet());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
