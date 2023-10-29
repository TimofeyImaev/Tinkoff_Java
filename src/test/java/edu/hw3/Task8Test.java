package edu.hw3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Vector;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task8Test {
    static Arguments[] collections() {
        return new Arguments[] {
            Arguments.of(new ArrayList<Object>(), new Object[] {'a', 'b', 'c', 'j', 'b'}),
            Arguments.of(new LinkedList<Object>(), new Object[] {525, 25, "asda", 'j', 'b'}),
            Arguments.of(new ArrayList<Object>(), new Object[] {"asf", "fsff", "g", "asg", "asggas"}),
            Arguments.of(new Vector<Object>(), new Object[] {125, 5, 25, 526, 626, 62}),
        };
    }

    @ParameterizedTest
    @MethodSource("collections")
    void givenCollectionWithElementsWhenIteratingOverCollectionThenReturnedCollectionElements(
        Collection<Object> collection,
        Object[] objects
    ) {
        for (var each : objects) {
            collection.add(each);
        }

        ArrayList expectedList = new ArrayList(Arrays.asList(objects));
        Collections.reverse(expectedList);

        ArrayList actualList = new ArrayList();
        Task8.BackwardIterator iterator = new Task8.BackwardIterator(collection);

        while (iterator.hasNext()) {
            actualList.add(iterator.next());
        }

        assertThat(actualList).isEqualTo(expectedList);
    }
}
