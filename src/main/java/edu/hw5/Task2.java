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

    private Task2() {

    }

    static ArrayList<String> allFridaysThirteenthOfYheYear(int year) {
        LocalDate verifiableDate = LocalDate.of(year, 1, 1);
        ArrayList<String> fridaysThirteenth = new ArrayList<>();

        while (verifiableDate.getYear() == year) {
            if (verifiableDate.getDayOfMonth() == THIRTEEN && verifiableDate.getDayOfWeek().equals(FRIDAY)) {
                fridaysThirteenth.add(verifiableDate.toString());
            }

            verifiableDate = verifiableDate.plusDays(1);
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
