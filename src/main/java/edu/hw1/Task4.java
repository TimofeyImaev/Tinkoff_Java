package edu.hw1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task4 {
    private final static Logger LOGGER = LogManager.getLogger();

    private Task4() {

    }

    public static String fixString(String arg) {
        char[] arr = arg.toCharArray();

        LOGGER.trace("Swapping symbols in {}", arg);

        for (int i = 1; i < arr.length; i += 2) {
            char temp = arr[i];
            arr[i] = arr[i - 1];
            arr[i - 1] = temp;
        }

        return new String(arr);
    }
}
