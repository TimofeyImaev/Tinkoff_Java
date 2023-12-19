package edu.hw5;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static java.time.DayOfWeek.FRIDAY;

public class Task2 {
    private final static Logger LOGGER = LogManager.getLogger();
    private final static int THIRTEEN = 13;
    private final static int AMOUNT_OF_MONTH_IN_YEAR = 12;

    private Task2() {

    }

    static ArrayList<String> allFridaysThirteenthOfYheYear(int year) {
        ArrayList<String> fridaysThirteenth = new ArrayList<>();

        for (int month = 1; month <= AMOUNT_OF_MONTH_IN_YEAR; ++month) {
            LocalDate verifiableDate = LocalDate.of(year, month, THIRTEEN);

            if (verifiableDate.getDayOfMonth() == THIRTEEN && verifiableDate.getDayOfWeek().equals(FRIDAY)) {
                fridaysThirteenth.add(verifiableDate.toString());
            }
        }

        return fridaysThirteenth;
    }

    static LocalDate closestFridayThirteenth(LocalDate date) {
        LocalDate verifiableDate = date.with(TemporalAdjusters.next(FRIDAY));

        while (verifiableDate.getDayOfMonth() != THIRTEEN) {
            LOGGER.trace("Cheking date {}", verifiableDate);

            verifiableDate = verifiableDate.with(TemporalAdjusters.next(FRIDAY));
        }

        return verifiableDate;
    }
}
