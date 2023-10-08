package edu.hw1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CyclicShift {
    private final static Logger LOGGER = LogManager.getLogger();

    private CyclicShift() {

    }

    public static byte[] getBytes(int number) {
        int num = number;
        int size = 0;
        do {
            num /= 2;
            size += 1;
        } while(num > 0);

        num = number;
        byte[] arr = new byte[size];

        for (int i = 0; i < size; ++i) {
            arr[size - 1 - i] = (byte) (num % 2);
            num /= 2;
        }

        return arr;
    }

    public static int rotateRight(int number, int shift) {
        byte[] arr = getBytes(number);
        byte[] ans = new byte[arr.length];

        for (int i = 0; i < arr.length; ++i) {
            ans[(i + shift) % arr.length] = arr[i];
        }
        LOGGER.trace("Shifting {}", number);

        int num = 0;
        for (var each : ans) {
            num *= 2;
            num += each;
        }
        return num;
    }

    public static int rotateLeft(int number, int shift) {
        byte[] arr = getBytes(number);
        byte[] ans = new byte[arr.length];

        for (int i = 0; i < arr.length; ++i) {
            ans[((i - shift)%arr.length + arr.length) % arr.length] = arr[i];
        }
        LOGGER.trace("Shifting {}", number);

        int num = 0;
        for (var each : ans) {
            num *= 2;
            num += each;
        }
        return num;
    }
}
