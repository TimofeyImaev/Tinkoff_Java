package edu.project1;

import edu.project1.sessionStatuses.ActingStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ActingStatusTest {
    @Nested
    class IncorrectInput {
        @Test
        @DisplayName("testThat basd incorrect input")
        void incorrectInput1() {
            ActingStatus gameStatus = (new ActingStatus());
            String incorrectInput = "basd";

            Throwable error = Assertions.assertThrows(ActingStatus.WrongMoveException.class, () -> {
                gameStatus.changeStatus(incorrectInput);
            });

            assertThat("PASS").
                isEqualTo(error.getMessage());
        }

        @Test
        @DisplayName("testThat 2 incorrect input")
        void incorrectInput2() {
            ActingStatus gameStatus = (new ActingStatus());
            String incorrectInput = "2";

            Throwable error = Assertions.assertThrows(ActingStatus.WrongMoveException.class, () -> {
                gameStatus.changeStatus(incorrectInput);
            });

            assertThat("PASS").
                isEqualTo(error.getMessage());
        }

        @Test
        @DisplayName("testThat h1fd2 incorrect input")
        void incorrectInput3() {
            ActingStatus gameStatus = (new ActingStatus());
            String incorrectInput = "h1fd2";

            Throwable error = Assertions.assertThrows(ActingStatus.WrongMoveException.class, () -> {
                gameStatus.changeStatus(incorrectInput);
            });

            assertThat("PASS").
                isEqualTo(error.getMessage());
        }
    }

    @Nested
    class MistakeTest {
        @Test
        @DisplayName("testThat bim with a returned mistake")
        void mistakeTest1() {
            String hiddenWord = "bim";
            String state = "___";
            String command = "a";
            String lastMessage = String.format(
                "Missed, mistake %d out of 5.\n\n" +
                    "The word: %s\n", 1, state);

            ActingStatus game = new ActingStatus(hiddenWord, state);
            game.changeStatus(command);

            assertThat(game.getLastMessage())
                .isEqualTo(lastMessage);
        }

        @Test
        @DisplayName("testThat yasstm with h returned mistake")
        void mistakeTest2() {
            String hiddenWord = "yasstm";
            String state = "_____";
            String command = "h";
            String lastMessage = String.format(
                "Missed, mistake %d out of 5.\n\n" +
                    "The word: %s\n", 1, state);

            ActingStatus game = new ActingStatus(hiddenWord, state);
            game.changeStatus(command);

            assertThat(game.getLastMessage())
                .isEqualTo(lastMessage);
        }

        @Test
        @DisplayName("testThat mojhg with h returned mistake")
        void mistakeTest3() {
            String hiddenWord = "mojhg";
            String state = "_____";
            String command = "i";
            String lastMessage = String.format(
                "Missed, mistake %d out of 5.\n\n" +
                    "The word: %s\n", 1, state);

            ActingStatus game = new ActingStatus(hiddenWord, state);
            game.changeStatus(command);

            assertThat(game.getLastMessage())
                .isEqualTo(lastMessage);
        }
    }

    @Nested
    class HitTest {
        @Test
        @DisplayName("testThat abacaba with a returned hit")
        void hitTest1() {
            String hiddenWord = "abacaba";
            String state = "a_a_a_a";
            String command = "a";
            String lastMessage = String.format(
                "Hit!\n\n" +
                    "The word: %s\n", state);

            ActingStatus game = new ActingStatus(hiddenWord, "_______");
            game.changeStatus(command);

            assertThat(game.getLastMessage())
                .isEqualTo(lastMessage);
        }

        @Test
        @DisplayName("testThat blueberry with e returned hit")
        void hitTest2() {
            String hiddenWord = "blueberry";
            String state = "___e_e___";
            String command = "e";
            String lastMessage = String.format(
                "Hit!\n\n" +
                    "The word: %s\n", state);

            ActingStatus game = new ActingStatus(hiddenWord, "_________");
            game.changeStatus(command);

            assertThat(game.getLastMessage())
                .isEqualTo(lastMessage);
        }

        @Test
        @DisplayName("testThat asmr with s returned hit")
        void hitTest3() {
            String hiddenWord = "asmr";
            String state = "_s__";
            String command = "s";
            String lastMessage = String.format(
                "Hit!\n\n" +
                    "The word: %s\n", state);

            ActingStatus game = new ActingStatus(hiddenWord, "____");
            game.changeStatus(command);

            assertThat(game.getLastMessage())
                .isEqualTo(lastMessage);
        }
    }
}
