package edu.hw9;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import static java.lang.Double.max;
import static java.lang.Double.min;

public class Task1 {

    static class StatsCollector {
        private final ConcurrentHashMap<String, Double> sumMap;
        private final ConcurrentMap<String, Double> averageMap;
        private final ConcurrentMap<String, Double> maximumMap;
        private final ConcurrentMap<String, Double> minimumMap;

        StatsCollector() {
            this.sumMap = new ConcurrentHashMap<>();
            this.averageMap = new ConcurrentHashMap<>();
            this.maximumMap = new ConcurrentHashMap<>();
            this.minimumMap = new ConcurrentHashMap<>();
        }

        public void push(String metricName, Double[] array) {
            if (array.length > 0) {

                Double sum = (double) 0;
                Double average = (double) 0;
                Double maximum = array[0];
                Double minimum = array[0];

                for (var each : array) {
                    sum += each;
                    average += each;
                    maximum = max(maximum, each);
                    minimum = min(minimum, each);
                }

                average /= array.length;

                sumMap.put(metricName, sum);
                averageMap.put(metricName, average);
                maximumMap.put(metricName, maximum);
                minimumMap.put(metricName, minimum);
            }
        }

        public Map<String, Double> stats() {
            ConcurrentMap<String, Double> informationFields = new ConcurrentHashMap<>();

            for (var each : sumMap.keySet()) {
                Double sum = sumMap.get(each);
                Double average = averageMap.get(each);
                Double maximum = maximumMap.get(each);
                Double minimum = minimumMap.get(each);

                informationFields.put(each + "Sum", sum);
                informationFields.put(each + "Average", average);
                informationFields.put(each + "Maximum", maximum);
                informationFields.put(each + "Minimum", minimum);
            }
            return informationFields;
        }
    }
}

