package edu.hw3;

import java.util.TreeMap;

public class Task3 {

    private Task3() {

    }

    public static TreeMap<Object, Integer> freqDict(Object[] objectList) {
        TreeMap<Object, Integer> alphabeticFrequencyDict = new TreeMap<>();

        for (var each : objectList) {
            alphabeticFrequencyDict.put(
                each,
                alphabeticFrequencyDict.getOrDefault(each, 0) + 1
            );
        }

        return alphabeticFrequencyDict;
    }
}
