package edu.hw3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task5 {
    private static final Logger LOGGER = LogManager.getLogger();

    private Task5() {

    }

    public static Object[] parseContacts(String[] names, String order) {
        if (names == null) {
            return new Object[] {};
        }

        ArrayList<String> namesList = new ArrayList<String>(Arrays.asList(names));
        int reverseOrder;
        LOGGER.trace("Sorting {} in {} order", names, order);

        if (order.equals("DESC")) {
            reverseOrder = -1;
        } else {
            reverseOrder = 1;
        }

        Collections.sort(namesList, (p1, p2) -> {
            String[] p1Split = p1.split(" ");
            String[] p2Split = p2.split(" ");

            if (p1Split.length == 2 && p2Split.length == 2) {
                return reverseOrder * p1Split[p1Split.length - 1].compareTo(p2Split[p2Split.length - 1]);
            } else {
                return reverseOrder * p1Split[0].compareTo(p2Split[0]);
            }
        });

        LOGGER.trace("Sorted array: {}", namesList);

        return namesList.toArray();
    }
}
