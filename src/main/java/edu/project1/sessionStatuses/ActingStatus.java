package edu.project1.sessionStatuses;

import edu.project1.GetRandomWord;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ActingStatus implements Session {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final String WORD_GUESSED = "The word: %s\n\nGuess a letter:\n";

    private Integer mistakesCnt;
    private String hiddenWord;
    private char[] state;
    private String lastMessage;

    public ActingStatus() {
        this.mistakesCnt = 0;
        this.hiddenWord = GetRandomWord.getRandomWord();
        this.state = new char[this.hiddenWord.length()];

        for (int i = 0; i < this.hiddenWord.length(); i++) {
            this.state[i] = '_';
        }
        this.lastMessage = String.format(WORD_GUESSED, new String(state));
    }

    public ActingStatus(String hiddenWord, String state) {
        this.mistakesCnt = 0;
        this.hiddenWord = hiddenWord;
        this.state = state.toCharArray();
        this.lastMessage = String.format(WORD_GUESSED, new String(this.state));
    }

    public int getMistakesCnt() {
        return mistakesCnt;
    }

    public boolean isLettersGuessed() {
        for (var each : state) {
            if (each == '_') {
                return false;
            }
        }

        return true;
    }

    @Override
    public ActingStatus changeStatus(String move) throws WrongMoveException {
        //LOGGER.trace("Changing status with {} message", move);

        if (move.length() != 1 || move.charAt(0) < 'a' || move.charAt(0) > 'z') {
            throw new WrongMoveException();
        }

        boolean isHit = false;

        for (int i = 0; i < state.length; ++i) {
            if (state[i] == '_' && hiddenWord.charAt(i) == move.charAt(0)) {
                isHit = true;
                state[i] = move.charAt(0);
            }
        }

        if (!isHit) {
            mistakesCnt++;

            lastMessage = String.format(
                "Missed, mistake %d out of 5.\n\n"
                    + "The word: %s\n", mistakesCnt, new String(state));
        } else {
            lastMessage = String.format(
                "Hit!\n\nThe word: %s\n", new String(state));
        }

        return this;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    public String toString() {
        return hiddenWord;
    }

    public static class WrongMoveException extends RuntimeException {

        public String getMessage() {
            return "PASS";
        }
    }
}
