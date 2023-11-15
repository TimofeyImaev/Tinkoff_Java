package edu.hw4;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {
    private static final Logger LOGGER = LogManager.getLogger();

    public static Arguments[] animalLists() {
        Arguments[] animalListsWithSortedAndUnsortedHeight = new Arguments[5];
        for (int i = 0; i < 5; ++i) {
            animalListsWithSortedAndUnsortedHeight[i] =
                Arguments.of(
                    (List<Animal>) AnimalLists.animalLists()[i].get()[0],
                    (List<Animal>) AnimalLists.animalListsWeightSorted()[i].get()[0],
                    (Integer) AnimalLists.animalListsWeightSorted()[i].get()[1]
                );
        }
        return animalListsWithSortedAndUnsortedHeight;
    }

    @ParameterizedTest
    @MethodSource("animalLists")
    void givenAnimalListWhenSortingByHeightThenReturnedSortedList(
        List<Animal> animalList,
        List<Animal> expectedAnswer,
        Integer k
    ) {
        List<Animal> actualAnswer = AnimalTools.weightSort(animalList, k);

        assertThat(actualAnswer).isEqualTo(expectedAnswer);
    }
}
