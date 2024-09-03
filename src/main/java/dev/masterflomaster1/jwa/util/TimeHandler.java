package dev.masterflomaster1.jwa.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class TimeHandler {

    private TimeHandler() { }

    private final static DateTimeFormatter ISO8601_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");

    public static String formatISO8601(LocalDateTime value) {
        return ISO8601_FORMATTER.format(value);
    }

}
