package edu.hw4;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task8Test {
    static Arguments[] heaviestAnimalLowerK() {
        Arguments[] animalListsWithMostCommonSex = new Arguments[5];
        for (int i = 0; i < 5; ++i) {
            animalListsWithMostCommonSex[i] =
                Arguments.of(
                    AnimalLists.animalLists()[i].get()[0],
                    AnimalLists.heaviestAnimalLowerK()[i].get()[0],
                    AnimalLists.heaviestAnimalLowerK()[i].get()[1]
                );
        }

        return animalListsWithMostCommonSex;
    }

    @ParameterizedTest
    @MethodSource("heaviestAnimalLowerK")
    void givenAnimalsListWhenSearchingHeaviestAnimalLowerKThenReturnHeaviestAnimalLowerK(
        List<Animal> animalList,
        Integer k,
        Optional<Animal> expectedAnswer
    ) {
        Optional<Animal> actualAnswer = AnimalTools.heaviestAnimalLowerK(animalList, k);

        assertThat(actualAnswer).isEqualTo(expectedAnswer);
    }
}
