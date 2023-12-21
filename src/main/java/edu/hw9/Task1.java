package edu.hw9;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static java.lang.Double.max;
import static java.lang.Double.min;

public class Task1 {
    private static final Logger LOGGER = LogManager.getLogger();

    static class SynchronizedSet {
        private volatile Set<String> strings = ConcurrentHashMap.newKeySet();

        synchronized boolean put(String string) {
            if (strings.contains(string)) {
                return false;
            }
            strings.add(string);
            return true;
        }

        synchronized void delete(String string) {
            strings.remove(string);
        }
    }

    static class StatsCollector {
        private final ConcurrentHashMap<String, Double> sumMap;
        private final ConcurrentHashMap<String, Integer> amountMap;
        private final ConcurrentMap<String, Double> averageMap;
        private final ConcurrentMap<String, Double> maximumMap;
        private final ConcurrentMap<String, Double> minimumMap;
        private final ConcurrentMap<String, AtomicInteger> metrics;
        private final SynchronizedSet synchronizedSet = new SynchronizedSet();

        StatsCollector() {
            this.sumMap = new ConcurrentHashMap<>();
            this.averageMap = new ConcurrentHashMap<>();
            this.amountMap = new ConcurrentHashMap<>();
            this.maximumMap = new ConcurrentHashMap<>();
            this.minimumMap = new ConcurrentHashMap<>();
            this.metrics = new ConcurrentHashMap<>();
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

                while (true) {
                    if (synchronizedSet.put(metricName)) {
                        System.out.println(1 + metricName);
                        if (sumMap.containsKey(metricName)) {
                            double oldSum = sumMap.get(metricName);
                            Integer oldAmount = amountMap.get(metricName);
                            double oldMaximum = maximumMap.get(metricName);
                            double oldMinimum = minimumMap.get(metricName);

                            sumMap.put(metricName, oldSum + sum);
                            amountMap.put(metricName, oldAmount + array.length);
                            LOGGER.trace(
                                "Metric name: {}, sum: {}, amount: {}",
                                metricName,
                                sumMap.get(metricName),
                                amountMap.get(metricName)
                            );
                            averageMap.put(
                                metricName,
                                (oldSum + sum) / (oldAmount + array.length)
                            );
                            maximumMap.put(metricName, max(maximum, oldMaximum));
                            minimumMap.put(metricName, min(minimum, oldMinimum));
                        } else {
                            sumMap.put(metricName, sum);
                            amountMap.put(metricName, array.length);
                            averageMap.put(metricName, average);
                            maximumMap.put(metricName, maximum);
                            minimumMap.put(metricName, minimum);
                        }

                        synchronizedSet.delete(metricName);
                        System.out.println(2 + metricName);
                        break;
                    }
                }
            }
        }

        public Map<String, Double> stats() {
            Map<String, Double> informationFields = new HashMap<>();

            for (var each : sumMap.keySet()) {
                while (true) {
                    if (synchronizedSet.put(each)) {
                        Double sum = sumMap.get(each);
                        Double average = averageMap.get(each);
                        Double maximum = maximumMap.get(each);
                        Double minimum = minimumMap.get(each);

                        informationFields.put(each + "Sum", sum);
                        informationFields.put(each + "Average", average);
                        informationFields.put(each + "Maximum", maximum);
                        informationFields.put(each + "Minimum", minimum);

                        synchronizedSet.delete(each);
                        break;
                    }
                }
            }
            return informationFields;
        }
    }
}

