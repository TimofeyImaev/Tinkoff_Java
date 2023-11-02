package edu.hw4;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task14Test {
    static Arguments[] isAnimalsListHadDogWithHeightMoreOrEqualsK() {
        Arguments[] animalListsWithMostCommonSex = new Arguments[5];
        for (int i = 0; i < 5; ++i) {
            animalListsWithMostCommonSex[i] =
                Arguments.of(
                    AnimalLists.animalLists()[i].get()[0],
                    AnimalLists.isAnimalsListHadDogWithHeightMoreOrEqualsK()[i].get()[0],
                    AnimalLists.isAnimalsListHadDogWithHeightMoreOrEqualsK()[i].get()[1]
                );
        }

        return animalListsWithMostCommonSex;
    }

    @ParameterizedTest
    @MethodSource("isAnimalsListHadDogWithHeightMoreOrEqualsK")
    void givenAnimalsListWhenSearchingDogWithHeightMoreKThenReturnDogAnimal(
        List<Animal> animalList,
        Integer k,
        Boolean expectedAnswer
    ) {
        Boolean actualAnswer = AnimalTools.isAnimalsListHadDogWithHeightMoreOrEqualsK(animalList, k);

        assertThat(actualAnswer).isEqualTo(expectedAnswer);
    }
}
