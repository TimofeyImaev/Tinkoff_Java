package edu.hw5;

import java.util.regex.Pattern;

public class Task4 {
    private static final Pattern PATTERN = Pattern.compile("[~!@#$%^&*|]");

    private Task4() {

    }

    static boolean checkPasswordSpecialsSymbols(String password) {
        return PATTERN.matcher(password).find();
    }
}
