package edu.hw4;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task7Test {
    static Arguments[] kthOldestAnimal() {
        Arguments[] animalListsWithMostCommonSex = new Arguments[5];
        for (int i = 0; i < 5; ++i) {
            animalListsWithMostCommonSex[i] =
                Arguments.of(
                    AnimalLists.animalLists()[i].get()[0],
                    AnimalLists.kthOldestAnimal()[i].get()[0],
                    AnimalLists.kthOldestAnimal()[i].get()[1]
                );
        }

        return animalListsWithMostCommonSex;
    }

    @ParameterizedTest
    @MethodSource("kthOldestAnimal")
    void givenAnimalsListWhenKthOldestAnimalThenReturnKthOldestAnimal(
        List<Animal> animalList,
        Integer k,
        Animal expectedAnswer
    ) {
        Animal actualAnswer = AnimalTools.kthOldestAnimal(animalList, k);


        assertThat(actualAnswer).isEqualTo(expectedAnswer);
    }
}
