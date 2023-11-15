package edu.hw4;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task3Test {
    static Arguments[] amountOfAnimalsInSpecies() {
        Arguments[] animalListsWithAmountOfAnimalsInEverySpecies = new Arguments[5];
        for (int i = 0; i < 5; ++i) {
            animalListsWithAmountOfAnimalsInEverySpecies[i] =
                Arguments.of(
                    AnimalLists.animalLists()[i].get()[0],
                    AnimalLists.amountOfAnimalsInEverySpecies()[i].get()[0]
                );
        }

        return animalListsWithAmountOfAnimalsInEverySpecies;
    }

    @ParameterizedTest
    @MethodSource("amountOfAnimalsInSpecies")
    void givenAnimalsListWhenCountingAnimalsInEverySpeciesThenReturnAmountsOfAnimals(
        List<Animal> animalList,
        Map<Animal.Type, Long> expectedAnswer
    ) {
        Map<Animal.Type, Long> actualAnswer = AnimalTools.amountOfAnimalsInSpecies(animalList);


        assertThat(actualAnswer).isEqualTo(expectedAnswer);
    }
}
