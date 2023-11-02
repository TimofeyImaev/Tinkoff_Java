package edu.hw4;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task18Test {
    static Arguments[] heaviestFishInListsOfAnimals() {
        Arguments[] animalListsWithMostCommonSex = new Arguments[5];
        for (int i = 0; i < 5; ++i) {
            animalListsWithMostCommonSex[i] =
                Arguments.of(
                    AnimalLists.listsOfAnimalLists()[i].get()[0],
                    AnimalLists.heaviestFishInListsOfAnimals()[i].get()[0]
                );
        }

        return animalListsWithMostCommonSex;
    }

    @ParameterizedTest
    @MethodSource("heaviestFishInListsOfAnimals")
    void givenAnimalsListWhenSearchingHeaviestFishInListsOfAnimalsThenReturnAnimal(
        List<List<Animal>> animalList,
        Animal expectedAnswer
    ) {
        Animal actualAnswer = AnimalTools.heaviestFishInListsOfAnimals(animalList);

        assertThat(actualAnswer).isEqualTo(expectedAnswer);
    }
}
