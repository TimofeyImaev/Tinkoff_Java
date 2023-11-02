package edu.hw4;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task12Test {
    static Arguments[] amountOfAnimalsWhichWeightMoreHeight() {
        Arguments[] animalListsWithMostCommonSex = new Arguments[5];
        for (int i = 0; i < 5; ++i) {
            animalListsWithMostCommonSex[i] =
                Arguments.of(
                    AnimalLists.animalLists()[i].get()[0],
                    AnimalLists.amountOfAnimalsWhichWeightMoreHeight()[i].get()[0]
                );
        }

        return animalListsWithMostCommonSex;
    }

    @ParameterizedTest
    @MethodSource("amountOfAnimalsWhichWeightMoreHeight")
    void givenAnimalsListWhenCountingAnimalsWhichWeightMoreHeightThenReturnAmountOfAnimals(
        List<Animal> animalList,
        Integer expectedAnswer
    ) {
        Integer actualAnswer = AnimalTools.amountOfAnimalsWhichWeightMoreHeight(animalList);

        assertThat(actualAnswer).isEqualTo(expectedAnswer);
    }
}
