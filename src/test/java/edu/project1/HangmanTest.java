package edu.project1;

import edu.project1.sessionStatuses.ActingStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class HangmanTest {
    @Test
    @DisplayName("Stop test")
    void stopTest() {
        String command = "stop";
        ActingStatus gameStatus = new ActingStatus();

        assertThat(Hangman.turn(command, gameStatus))
            .isEqualTo("stop");
    }

    @Test
    @DisplayName("Surrender test")
    void surrenderTest() {
        String command = "surrender";
        ActingStatus gameStatus = new ActingStatus();

        assertThat(Hangman.turn(command, gameStatus))
            .isEqualTo("surrender (Write anything to continue)\n");
    }

    @Nested
    class WrongInputTests {
        @Test
        @DisplayName("testThat abacab is wrong")
        void wrongInputTest1() {
            String res = Hangman.turn("abacab", new ActingStatus());

            assertThat(res).isEqualTo("Wrong input!\n");
        }

        @Test
        @DisplayName("testThat gf5 is wrong")
        void wrongInputTest2() {
            String res = Hangman.turn("gf5", new ActingStatus());

            assertThat(res).isEqualTo("Wrong input!\n");
        }

        @Test
        @DisplayName("testThat - is wrong")
        void wrongInputTest3() {
            String res = Hangman.turn("-", new ActingStatus());

            assertThat(res).isEqualTo("Wrong input!\n");
        }
    }

    static Arguments[] allGuessed() {
        return new Arguments[] {
            Arguments.of(new ActingStatus("abacaba", "abacaba")),
            Arguments.of(new ActingStatus("apple", "apple")),
            Arguments.of(new ActingStatus("blueberry", "blueberry")),
            Arguments.of(new ActingStatus("pineapple", "pineapple")),
        };
    }

    @ParameterizedTest(name = "{argumentsWithNames} Returned win")
    @MethodSource("allGuessed")
    void allGuessedTest(ActingStatus gameStatus) {
        assertThat(Hangman.turn("a", gameStatus))
            .isEqualTo("You won!\n");
    }

    static Arguments[] gameStatuses() {
        return new Arguments[] {
            Arguments.of(new ActingStatus("abacaba", "_______")),
            Arguments.of(new ActingStatus("apple", "_____")),
            Arguments.of(new ActingStatus("blueberry", "_________")),
            Arguments.of(new ActingStatus("pineapple", "_________")),
        };
    }

    @ParameterizedTest(name = "{argumentsWithNames} Returned lost")
    @MethodSource("gameStatuses")
    void mistakesLimitTest(ActingStatus gameStatus) {
        Hangman.turn("z", gameStatus);
        Hangman.turn("z", gameStatus);
        Hangman.turn("z", gameStatus);
        Hangman.turn("z", gameStatus);

        assertThat(Hangman.turn("z", gameStatus))
            .isEqualTo("You lost! (Write anything to continue)\n");
    }
}
