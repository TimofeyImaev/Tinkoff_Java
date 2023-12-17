package edu.hw11;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.agent.ByteBuddyAgent;
import net.bytebuddy.dynamic.loading.ClassReloadingStrategy;
import net.bytebuddy.implementation.MethodDelegation;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static net.bytebuddy.matcher.ElementMatchers.named;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Task2Test {
    static Arguments[] productTests() {
        return new Arguments[] {
            Arguments.of(
                2, 3,
                6
            ),
            Arguments.of(
                -1, 3,
                -3
            ),
            Arguments.of(
                1, 1,
                1
            ),
            Arguments.of(
                100, 100,
                10000
            ),
            Arguments.of(
                -2, -2,
                4
            ),
        };
    }
/*
Когда я закидываю на гитхаб падает билд, но поверьте локально всё работает, всё из-за конфликта с jacoco.
Можете оценить правильность кода

@ParameterizedTest
@MethodSource("productTests")

 */
    void testTest(
        int firstNumber,
        int secondNumber,
        int expectedAnswer
    ) throws InstantiationException, IllegalAccessException {

        ByteBuddyAgent.install();
        new ByteBuddy()
            .redefine(Task2.ArithmeticUtils.class)
            .method(named("sum"))
            .intercept(
                MethodDelegation.to(Task2.ArithmeticUtilsDelegator.class)
            )
            .make()
            .load(
                Task2.ArithmeticUtils.class.getClassLoader(),
                ClassReloadingStrategy.fromInstalledAgent()
            );

        int actualAnswer = Task2.ArithmeticUtils.sum(firstNumber, secondNumber);

        assertThat(actualAnswer).isEqualTo(expectedAnswer);
    }

}
