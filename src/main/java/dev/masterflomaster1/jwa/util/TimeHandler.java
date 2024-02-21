package dev.masterflomaster1.jwa.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeHandler {

    private final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");

    public static String format(LocalDateTime value) {
        return formatter.format(value);
    }

}
