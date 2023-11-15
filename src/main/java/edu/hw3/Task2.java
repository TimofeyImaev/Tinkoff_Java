package edu.hw3;

import java.util.ArrayList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task2 {
    private static final Logger LOGGER = LogManager.getLogger();

    private Task2() {

    }

    public static ArrayList<String> clusterize(String brackets) {
        LOGGER.trace("Clustering {}", brackets);

        int numberParenthesesToClose = 0;
        boolean unbalanced = false;

        ArrayList<String> clusters = new ArrayList<String>();
        ArrayList<Character> cluster = new ArrayList<Character>();

        for (var each : brackets.toCharArray()) {
            if (each == '(') {
                numberParenthesesToClose++;
            } else {
                numberParenthesesToClose--;
            }

            cluster.add(each);

            if (numberParenthesesToClose < 0) {
                unbalanced = true;
            } else if (numberParenthesesToClose == 0) {
                char[] arr = new char[cluster.size()];
                for (int i = 0; i < cluster.size(); ++i) {
                    arr[i] = cluster.get(i);
                }

                clusters.add(new String(arr));
                cluster.clear();
            }
        }

        if (numberParenthesesToClose != 0) {
            unbalanced = true;
        }

        if (unbalanced) {
            return new ArrayList<String>();
        } else {
            return clusters;
        }
    }
}

