package edu.hw1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class IsPalindromeDescendant {
    private final static Logger LOGGER = LogManager.getLogger();

    private IsPalindromeDescendant() {

    }

    public static int[] getSymbols(int number) {
        int num = number;
        int size = 0;
        do {
            num /= 10;
            size++;
        } while (num > 0);

        int[] arr = new int[size];

        num = number;
        for (int i = 0; i < size; ++i) {
            arr[size - 1 - i] = num % 10;
            num /= 10;
        }

        return arr;
    }

    public static boolean isPalyndrom(int[] arr) {
        for (int i =0 ; i < arr.length; ++i) {
            if (arr[i] != arr[arr.length - i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindromeDescendant(int number) {
        int num = number;

        while (true){
            LOGGER.trace("Checking {}, ", num);

            int[] arr = getSymbols(num);

            if (isPalyndrom(arr) && (arr.length != 1 || number == arr[0])) {
                return true;
            }
            if (arr.length % 2 == 1) {
                break;
            }

            num = 0;
            for(int i = 1; i < arr.length; i += 2) {
                num *= 10;
                if (arr[i] + arr[i - 1] >= 10) {
                    num *= 10;
                }
                num += arr[i] + arr[i - 1];
            }
        }

        return false;
    }

}
