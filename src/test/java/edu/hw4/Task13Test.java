package edu.hw4;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task13Test {
    static Arguments[] animalListsWithNamesLongerThanTwoWords() {
        Arguments[] animalListsWithMostCommonSex = new Arguments[5];
        for (int i = 0; i < 5; ++i) {
            animalListsWithMostCommonSex[i] =
                Arguments.of(
                    AnimalLists.animalWithLongNamesLists()[i].get()[0],
                    AnimalLists.animalListsWithNamesLongerThanTwoWords()[i].get()[0]
                );
        }

        return animalListsWithMostCommonSex;
    }

    @ParameterizedTest
    @MethodSource("animalListsWithNamesLongerThanTwoWords")
    void givenAnimalsListWhenCountingAnimalsWithNamesLongerThanTwoWordsThenReturnAmountOfAnimals(
        List<Animal> animalList,
        List<Animal> expectedAnswer
    ) {
        List<Animal> actualAnswer = AnimalTools.animalListsWithNamesLongerThanTwoWords(animalList);

        assertThat(actualAnswer).isEqualTo(expectedAnswer);
    }
}
