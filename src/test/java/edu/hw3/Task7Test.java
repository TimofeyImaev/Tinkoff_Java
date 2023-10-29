package edu.hw3;

import java.util.TreeMap;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task7Test {
    @Test
    void givenComparatorWhenAddingNullkeyThenDontThrowError() {
        TreeMap<String, String> tree = new TreeMap<String, String>(new Task7.NullKeyComparator<>());

        tree.put(null, "test");

        assertThat(tree.containsKey(null)).isTrue();
    }
}
