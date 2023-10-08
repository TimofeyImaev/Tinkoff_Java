package edu.hw1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class IsNestable {
    private final static Logger LOGGER = LogManager.getLogger();

    private IsNestable() {

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
            minArr1 = each < minArr1 ? each : minArr1;
            maxArr1 = each > maxArr1 ? each : maxArr1;
        }

        for (var each : arr2) {
            minArr2 = each < minArr2 ? each : minArr2;
            maxArr2 = each > maxArr2 ? each : maxArr2;
        }

        return minArr1 > minArr2 && maxArr1 < maxArr2;
    }
}
