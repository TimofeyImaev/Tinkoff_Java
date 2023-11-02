package edu.hw4;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task15Test {
    static Arguments[] findTotalWeightOfEveryTypeFromKToLAge() {
        Arguments[] animalListsWithMostCommonSex = new Arguments[5];
        for (int i = 0; i < 5; ++i) {
            animalListsWithMostCommonSex[i] =
                Arguments.of(
                    AnimalLists.animalLists()[i].get()[0],
                    AnimalLists.findTotalWeightOfEveryTypeFromKToLAge()[i].get()[0],
                    AnimalLists.findTotalWeightOfEveryTypeFromKToLAge()[i].get()[1],
                    AnimalLists.findTotalWeightOfEveryTypeFromKToLAge()[i].get()[2]
                );
        }

        return animalListsWithMostCommonSex;
    }

    @ParameterizedTest
    @MethodSource("findTotalWeightOfEveryTypeFromKToLAge")
    void givenAnimalsListWhenCountingTotalWeightOfEveryTypeFromKToLAgeThenReturnMapAnimalTypeAndInteger(
        List<Animal> animalList,
        Integer k,
        Integer l,
        Map<Animal.Type, Integer> expectedAnswer
    ) {
        Map<Animal.Type, Integer> actualAnswer = AnimalTools.findTotalWeightOfEveryTypeFromKToLAge(animalList, k, l);

        assertThat(actualAnswer).isEqualTo(expectedAnswer);
    }
}
