package edu.hw4;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task17Test {
    static Arguments[] isSpidersBitesMoreOftenThenDogs() {
        Arguments[] animalListsWithMostCommonSex = new Arguments[5];
        for (int i = 0; i < 5; ++i) {
            animalListsWithMostCommonSex[i] =
                Arguments.of(
                    AnimalLists.animalLists()[i].get()[0],
                    AnimalLists.isSpidersBitesMoreOftenThenDogs()[i].get()[0]
                );
        }

        return animalListsWithMostCommonSex;
    }

    @ParameterizedTest
    @MethodSource("isSpidersBitesMoreOftenThenDogs")
    void givenAnimalsListWhenCheckingSpidersBitesMoreOftenThenDogsThenReturnBoolean(
        List<Animal> animalList,
        Boolean expectedAnswer
    ) {
        Boolean actualAnswer = AnimalTools.isSpidersBitesMoreOftenThenDogs(animalList);

        assertThat(actualAnswer).isEqualTo(expectedAnswer);
    }
}
