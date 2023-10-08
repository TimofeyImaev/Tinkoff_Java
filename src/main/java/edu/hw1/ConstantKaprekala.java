package edu.hw1;

import java.util.Arrays;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static java.lang.Math.abs;

public class ConstantKaprekala {
    private final static Logger LOGGER = LogManager.getLogger();

    private ConstantKaprekala() {

    }

    public static int constantKaprekala(int number) {
        final int constantK = 6174;

        LOGGER.trace("Processing {}", number);
        if (number == constantK) {
            return 0;
        }

        final int TEN = 10;
        char[] arr = String.valueOf(number).toCharArray();

        Arrays.sort(arr);
        int num1 = 0;
        int num2 = 0;
        for (int i = 0; i < arr.length; ++i) {
            num1 *= TEN;
            num2 *= TEN;

            num1 += arr[i];
            num2 += arr[arr.length - 1 - i];
        }
        if (num1 == num2) {
            return -1;
        }

        return constantKaprekala(abs(num1 - num2)) + 1;
    }
}
