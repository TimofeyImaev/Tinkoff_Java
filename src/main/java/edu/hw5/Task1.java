package edu.hw5;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task1 {
    private final static DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd, HH:mm");
    private final static Logger LOGGER = LogManager.getLogger();

    private Task1() {

    }

    public static Duration averageSessionDuration(String[] sessionsStartAndTime) {
        Duration durationsSum = Duration.ZERO;

        if (sessionsStartAndTime.length == 0) {
            return Duration.ZERO;
        }

        for (var session : sessionsStartAndTime) {
            String[] startAndEndTime = session.split(" - ");

            LOGGER.trace("Parsing {} and {} to LocalDateTime", startAndEndTime[0], startAndEndTime[1]);

            LocalDateTime sessionStart = LocalDateTime.parse(startAndEndTime[0], DATE_TIME_FORMATTER);
            LocalDateTime sessionEnd = LocalDateTime.parse(startAndEndTime[1], DATE_TIME_FORMATTER);

            durationsSum = durationsSum.plus(Duration.between(sessionStart, sessionEnd));
        }

        return durationsSum.dividedBy(sessionsStartAndTime.length);
    }
}
