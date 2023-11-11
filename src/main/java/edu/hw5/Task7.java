package edu.hw5;

import java.util.regex.Pattern;

public class Task7 {
    private Task7() {

    }

    public static boolean isThirdCharacterZero(String string) {
        return Pattern.matches("^..0.*$", string);
    }

    public static boolean startEndSymbolsAreEqual(String string) {
        return Pattern.matches("^([01]).*\\1|[01]$", string);
    }

    public static boolean lengthFromOneToThree(String string) {
        return Pattern.matches("^[01]{1,3}$", string);
    }
}
