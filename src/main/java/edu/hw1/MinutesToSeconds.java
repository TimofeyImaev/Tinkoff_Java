package edu.hw1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class MinutesToSeconds {
    private final static Logger LOGGER = LogManager.getLogger();

    private MinutesToSeconds() {

    }

    public static int minutesToSeconds(String args) {
        int cntColon = 0;
        final int secInMin = 60;
        final int bigInteger = 100;

        LOGGER.trace("Converting time {} to seconds", args);

        for (int i = 0; i < args.length(); ++i) {
            if (args.charAt(i) == ':') {
                cntColon++;
            } else if (args.charAt(i) < '0' || args.charAt(i) > '9') {
                cntColon = bigInteger;
            }
        }

        if (cntColon == 1) {
            String[] arr = args.split(":", 2);

            if (arr[0].length() != 0 && arr[1].length() != 0) {
                Integer minutes = Integer.valueOf(arr[0]);
                Integer seconds = Integer.valueOf(arr[1]);

                if (seconds.intValue() <= secInMin) {
                    return minutes * secInMin + seconds;
                }
            }
        }

        return -1;
    }
}
