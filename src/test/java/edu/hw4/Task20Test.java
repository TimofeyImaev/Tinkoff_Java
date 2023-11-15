package edu.hw4;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task20Test {
    static Arguments[] animalsWithValidationError() {
        Arguments[] animalsWithValidationError = new Arguments[5];
        for (int i = 0; i < 5; ++i) {
            animalsWithValidationError[i] =
                Arguments.of(
                    AnimalLists.animalLists()[i].get()[0],
                    AnimalLists.readableListOfAnimalsWithValidationError()[i].get()[0]
                );
        }

        return animalsWithValidationError;
    }

    @ParameterizedTest
    @MethodSource("animalsWithValidationError")
    void givenAnimalsListWhenMakingReadableListOfAnimalsWithValidationErrorThenReturnAnimalsWithValidationError(
        List<Animal> animalList,
        Map<String, String> expectedAnswer
    ) {
        Map<String, String> actualAnswer = AnimalTools.readableListOfAnimalsWithValidationError(animalList);

        assertThat(actualAnswer).isEqualTo(expectedAnswer);
    }
}
