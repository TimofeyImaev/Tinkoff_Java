package edu.hw4;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task5Test {
    static Arguments[] amountOfAnimalsInSpecies() {
        Arguments[] animalListsWithMostCommonSex = new Arguments[5];
        for (int i = 0; i < 5; ++i) {
            animalListsWithMostCommonSex[i] =
                Arguments.of(
                    AnimalLists.animalLists()[i].get()[0],
                    AnimalLists.mostCommonSex()[i].get()[0]
                );
        }

        return animalListsWithMostCommonSex;
    }

    @ParameterizedTest
    @MethodSource("amountOfAnimalsInSpecies")
    void givenAnimalsListWhenCountingAnimalsInEverySpeciesThenReturnAmountsOfAnimals(
        List<Animal> animalList,
        Animal.Sex expectedAnswer
    ) {
        Animal.Sex actualAnswer = AnimalTools.mostCommonSex(animalList);


        assertThat(actualAnswer).isEqualTo(expectedAnswer);
    }
}
