package edu.hw4;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task19Test {
    static Arguments[] animalsWithValidationError() {
        Arguments[] animalsWithValidationError = new Arguments[5];
        for (int i = 0; i < 5; ++i) {
            animalsWithValidationError[i] =
                Arguments.of(
                    AnimalLists.animalLists()[i].get()[0],
                    AnimalLists.animalsWithValidationError()[i].get()[0]
                );
        }

        return animalsWithValidationError;
    }

    @ParameterizedTest
    @MethodSource("animalsWithValidationError")
    void givenAnimalsListWhenSearchingAnimalsWithValidationErrorThenReturnAnimalsWithValidationError(
        List<Animal> animalList,
        Map<String, Set<ValidationError>> expectedAnswer
    ) {
        Map<String, Set<ValidationError>> actualAnswer = AnimalTools.animalsWithValidationError(animalList);

        assertThat(actualAnswer.keySet()).isEqualTo(expectedAnswer.keySet());

        for(var each: actualAnswer.entrySet()) {
            assertThat(expectedAnswer.get(each.getKey()).size()).isEqualTo(each.getValue().size());
        }
    }
}
