package edu.hw3;

import java.util.ArrayList;
import java.util.Collections;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task4 {
    private static final Logger LOGGER = LogManager.getLogger();
    private final static char[] ROMAN_DIGITS = new char[] {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
    private final static int GREATEST_ROMAN_NUMBER = 3999;
    private final static int TEN = 10;
    private final static int NINE = 9;
    private final static int EIGHT = 8;
    private final static int FIVE = 5;
    private final static int FOUR = 4;
    private final static int THREE = 3;

    private Task4() {

    }

    public static String convertToRoman(int arabicNumber) {
        if (arabicNumber > GREATEST_ROMAN_NUMBER || arabicNumber <= 0) {
            return "";
        }

        ArrayList<Character> romanNumber = new ArrayList<Character>();

        int num = arabicNumber;
        int numberOfDigit = 0;

        while (num > 0) {
            if (num % TEN == NINE) {
                romanNumber.add(ROMAN_DIGITS[numberOfDigit + 2]);
                romanNumber.add(ROMAN_DIGITS[numberOfDigit]);
            } else if (num % TEN <= EIGHT && num % TEN >= FIVE) {
                for (int i = 0; i < num % TEN - FIVE; ++i) {
                    romanNumber.add(ROMAN_DIGITS[numberOfDigit]);
                }
                romanNumber.add(ROMAN_DIGITS[numberOfDigit + 1]);
            } else if (num % TEN == FOUR) {
                romanNumber.add(ROMAN_DIGITS[numberOfDigit + 1]);
                romanNumber.add(ROMAN_DIGITS[numberOfDigit]);
            } else if (num % TEN <= THREE && num % TEN >= 1) {
                for (int i = 0; i < num % TEN; ++i) {
                    romanNumber.add(ROMAN_DIGITS[numberOfDigit]);
                }
            }

            num /= TEN;
            numberOfDigit += 2;
        }
        Collections.reverse(romanNumber);

        char[] arr = new char[romanNumber.size()];

        for (int i = 0; i < arr.length; ++i) {
            arr[i] = romanNumber.get(i);
        }

        LOGGER.trace("Converting {}, to {}", arabicNumber, romanNumber);

        return new String(arr);
    }
}
