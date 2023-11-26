package edu.hw7;

import java.util.concurrent.atomic.AtomicInteger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task1 {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final int TEN_THOUSANDS_ITERATIONS = 10000;

    private Task1() {

    }

    static int multipleThreadsIncreaseTheNumber(int countOfThreads) throws InterruptedException {
        AtomicInteger number = new AtomicInteger(0);

        for (int i = 0; i < countOfThreads; ++i) {
            int finalI = i;
            Runnable runnable = () -> {
                LOGGER.trace("Thread {} starts", finalI);
                for (int j = 0; j < TEN_THOUSANDS_ITERATIONS; ++j) {
                    number.incrementAndGet();
                }
            };

            Thread thread = new Thread(runnable);

            thread.start();
            thread.join();
        }

        return number.get();
    }
}

