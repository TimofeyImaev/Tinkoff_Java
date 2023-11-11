package edu.hw5;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;

public class Task3 {
    private final static int THREE = 3;
    private final static int NINE = 9;

    private Task3() {

    }

    static boolean isNumeric(String string) {
        if (!string.isEmpty() && string.charAt(0) != '0') {
            boolean isNumber = true;
            for (var each : string.toCharArray()) {
                if (each < '0' || each > '9') {
                    isNumber = false;
                    break;
                }
            }

            return isNumber;
        }

        return false;
    }

    static Optional<LocalDate> parseDate(String string) {
        Today todayParser = new Today();
        Yesterday yesterdayParser = new Yesterday();
        Tomorrow tomorrowParser = new Tomorrow();
        DashDate dashDateParser = new DashDate();
        SlashDate slashDateParser = new SlashDate();
        DayAgo dayAgoParser = new DayAgo();
        DaysAgo daysAgoParser = new DaysAgo();

        todayParser.setNext(yesterdayParser);
        yesterdayParser.setNext(tomorrowParser);
        tomorrowParser.setNext(dashDateParser);
        dashDateParser.setNext(slashDateParser);
        slashDateParser.setNext(dayAgoParser);
        dayAgoParser.setNext(daysAgoParser);

        return todayParser.parseDate(string);
    }

    abstract static class DataParser {
        DataParser next;

        public void setNext(DataParser nextDataParser) {
            this.next = nextDataParser;
        }

        public abstract Optional<LocalDate> parseDate(String string);
    }

    static class Today extends DataParser {

        @Override
        public Optional<LocalDate> parseDate(String string) {
            if (string.equals("today")) {
                return Optional.of(LocalDate.now());
            } else if (next != null) {
                return next.parseDate(string);
            }

            return Optional.empty();
        }
    }

    static class Tomorrow extends DataParser {

        @Override
        public Optional<LocalDate> parseDate(String string) {
            if (string.equals("tomorrow")) {
                return Optional.of(LocalDate.now().plusDays(1));
            } else if (next != null) {
                return next.parseDate(string);
            }

            return Optional.empty();
        }
    }

    static class Yesterday extends DataParser {

        @Override
        public Optional<LocalDate> parseDate(String string) {
            if (string.equals("yesterday")) {
                return Optional.of(LocalDate.now().minusDays(1));
            } else if (next != null) {
                return next.parseDate(string);
            }

            return Optional.empty();
        }
    }

    static class DashDate extends DataParser {

        @Override
        public Optional<LocalDate> parseDate(String string) {
            if (string.contains("-") && string.split("-").length == THREE
                && Arrays.stream(string.split("-")).allMatch(Task3::isNumeric)) {
                String[] splitedString = string.split("-");

                return Optional.of(LocalDate.of(
                    Integer.parseInt(splitedString[0]),
                    Integer.parseInt(splitedString[1]),
                    Integer.parseInt(splitedString[2])
                ));
            } else if (next != null) {
                return next.parseDate(string);
            }

            return Optional.empty();
        }
    }

    static class SlashDate extends DataParser {

        @Override
        public Optional<LocalDate> parseDate(String string) {
            if (string.contains("/") && string.split("/").length == THREE
                && Arrays.stream(string.split("/")).allMatch(Task3::isNumeric)) {
                String[] splitedString = string.split("/");

                return Optional.of(LocalDate.of(
                    Integer.parseInt(splitedString[2]),
                    Integer.parseInt(splitedString[1]),
                    Integer.parseInt(splitedString[0])
                ));
            } else if (next != null) {
                return next.parseDate(string);
            }

            return Optional.empty();
        }
    }

    static class DayAgo extends DataParser {

        @Override
        public Optional<LocalDate> parseDate(String string) {
            if (string.length() == NINE && string.endsWith(" day ago")
                && isNumeric(string.substring(0, 1))) {
                String substring = string.substring(0, 1);
                return Optional.of(LocalDate.now()
                    .minusDays(Integer.parseInt(substring)));
            } else if (next != null) {
                return next.parseDate(string);
            }

            return Optional.empty();
        }
    }

    static class DaysAgo extends DataParser {

        @Override
        public Optional<LocalDate> parseDate(String string) {
            if (string.length() > NINE && string.endsWith(" days ago")
                && isNumeric(string.substring(0, string.length() - NINE))) {
                String substring = string.substring(0, string.length() - NINE);
                return Optional.of(LocalDate.now()
                    .minusDays(Integer.parseInt(substring)));
            } else if (next != null) {
                return next.parseDate(string);
            }

            return Optional.empty();
        }
    }
}
