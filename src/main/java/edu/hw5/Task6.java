package edu.hw5;

import java.util.regex.Pattern;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task6 {
    private static final Logger LOGGER = LogManager.getLogger();

    private Task6() {

    }

    public static boolean isSubsequence(String s, String t) {
        String pattern = ".*" + s.replaceAll(".", "$0.*");

        LOGGER.trace("{} is subsequence pattern: {}", s, pattern);

        return Pattern.matches(pattern, t);
    }
}
