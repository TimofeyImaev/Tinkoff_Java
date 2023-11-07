package edu.hw3;

import java.util.HashMap;

public class Task3 {

    private Task3() {

    }

    public static HashMap<Object, Integer> freqDict(Object[] objectList) {
        HashMap<Object, Integer> alphabeticFrequencyDict = new HashMap<>();

        for (var each : objectList) {
            alphabeticFrequencyDict.put(
                each,
                alphabeticFrequencyDict.getOrDefault(each, 1)
            );
        }

        return alphabeticFrequencyDict;
    }
}
