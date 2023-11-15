package edu.hw4;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task4Test {
    static Arguments[] amountOfAnimalsInSpecies() {
        Arguments[] animalListsWithAnimalWithLongestName = new Arguments[5];
        for (int i = 0; i < 5; ++i) {
            animalListsWithAnimalWithLongestName[i] =
                Arguments.of(
                    AnimalLists.animalLists()[i].get()[0],
                    AnimalLists.animalsWithLongestName()[i].get()[0]
                );
        }

        return animalListsWithAnimalWithLongestName;
    }

    @ParameterizedTest
    @MethodSource("amountOfAnimalsInSpecies")
    void givenAnimalsListWhenCountingAnimalsInEverySpeciesThenReturnAmountsOfAnimals(
        List<Animal> animalList,
        Animal expectedAnswer
    ) {
        Animal actualAnswer = AnimalTools.animalWithLongestName(animalList);

        assertThat(actualAnswer).isEqualTo(expectedAnswer);
    }
}
