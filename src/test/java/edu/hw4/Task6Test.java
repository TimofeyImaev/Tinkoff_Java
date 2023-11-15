package edu.hw4;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task6Test {
    static Arguments[] amountOfAnimalsInSpecies() {
        Arguments[] animalListsWithHeaviestAnimal = new Arguments[5];
        for (int i = 0; i < 5; ++i) {
            animalListsWithHeaviestAnimal[i] =
                Arguments.of(
                    AnimalLists.animalLists()[i].get()[0],
                    AnimalLists.heaviestAnimal()[i].get()[0]
                );
        }

        return animalListsWithHeaviestAnimal;
    }

    @ParameterizedTest
    @MethodSource("amountOfAnimalsInSpecies")
    void givenAnimalsListWhenCountingAnimalsInEverySpeciesThenReturnAmountsOfAnimals(
        List<Animal> animalList,
        Map<Animal.Type, Animal> expectedAnswer
    ) {
        Map<Animal.Type, Animal> actualAnswer = AnimalTools.heaviestAnimalOfEveryType(animalList);


        assertThat(actualAnswer).isEqualTo(expectedAnswer);
    }
}
