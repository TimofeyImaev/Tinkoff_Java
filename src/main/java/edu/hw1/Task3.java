package edu.hw1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task3 {
    private final static Logger LOGGER = LogManager.getLogger();

    private Task3() {

    }

    public static boolean isNestable(int[] arr1, int[] arr2) {
        if (arr1.length == 0 || arr2.length == 0) {
            return false;
        }

        int minArr1 = arr1[0];
        int minArr2 = arr2[0];
        int maxArr1 = arr1[0];
        int maxArr2 = arr2[0];

        for (var each : arr1) {
            minArr1 = Math.min(each, minArr1);
            maxArr1 = Math.max(each, maxArr1);
        }

        for (var each : arr2) {
            minArr2 = Math.min(each, minArr2);
            maxArr2 = Math.max(each, maxArr2);
        }

        return minArr1 > minArr2 && maxArr1 < maxArr2;
    }
}
