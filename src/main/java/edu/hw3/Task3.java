package edu.hw3;

import java.util.TreeMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task3 {
    private static final Logger LOGGER = LogManager.getLogger();

    private Task3() {

    }

    public static TreeMap<Object, Integer> freqDict(Object[] objectList) {
        TreeMap<Object, Integer> alphabeticFrequencyDict = new TreeMap<>();

        for (var each : objectList) {
            if (alphabeticFrequencyDict.containsKey(each)) {
                alphabeticFrequencyDict.put(each, alphabeticFrequencyDict.get(each) + 1);
            } else {
                alphabeticFrequencyDict.put(each, 1);
            }
        }

        return alphabeticFrequencyDict;
    }
}
