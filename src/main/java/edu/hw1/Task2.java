package edu.hw1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task2 {
    private final static Logger LOGGER = LogManager.getLogger();
    private final static int TEN = 10;

    private Task2() {

    }

    public static int countDigits(int number) {
        int cnt = 0;

        LOGGER.trace("Counting length of {}", number);

        int now = number;
        do {
            now /= TEN;
            cnt++;
        } while (now > 0);

        return cnt;
    }
}
