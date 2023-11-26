package edu.hw7;

import java.util.stream.Stream;

public class Task2 {
    private Task2() {

    }

    static Long factorial(int n) {
        return Stream.iterate(1L, number -> number + 1L)
            .limit(n)
            .parallel()
            .reduce((a, b) -> a * b)
            .get();
    }
}
