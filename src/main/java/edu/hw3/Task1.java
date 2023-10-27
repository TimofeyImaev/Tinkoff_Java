package edu.hw3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task1 {
    private static final Logger LOGGER = LogManager.getLogger();

    public Task1() {

    }

    public static char getMirrorLetter(char c) {
        if (c >= 'a' && c <= 'z') {
            return (char) ('z' - (c - 'a'));
        } else if (c >= 'A' && c <= 'Z') {
            return (char) ('Z' - (c - 'A'));
        }

        return c;
    }

    public static String atbashCiher(String encryptedString) {
        LOGGER.trace("String {} mirror", encryptedString);
        char[] arr = encryptedString.toCharArray();

        for (int i = 0; i < arr.length; ++i) {
            arr[i] = getMirrorLetter(arr[i]);
        }

        return new String(arr);
    }
}
