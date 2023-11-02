package edu.hw4;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task16Test {
    static Arguments[] animalsListSortedByTypeSexName() {
        Arguments[] animalListsWithMostCommonSex = new Arguments[5];
        for (int i = 0; i < 5; ++i) {
            animalListsWithMostCommonSex[i] =
                Arguments.of(
                    AnimalLists.animalLists()[i].get()[0],
                    AnimalLists.animalsListSortedByTypeSexName()[i].get()[0]
                );
        }

        return animalListsWithMostCommonSex;
    }

    @ParameterizedTest
    @MethodSource("animalsListSortedByTypeSexName")
    void givenAnimalsListWhenCountingTotalWeightOfEveryTypeFromKToLAgeThenReturnMapAnimalTypeAndInteger(
        List<Animal> animalList,
        List<Animal> expectedAnswer
    ) {
        List<Animal> actualAnswer = AnimalTools.animalsListSortedByTypeSexName(animalList);

        assertThat(actualAnswer).isEqualTo(expectedAnswer);
    }
}
