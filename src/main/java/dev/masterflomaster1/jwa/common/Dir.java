package dev.masterflomaster1.jwa.common;

import lombok.Getter;

/**
 * The direction in which to list.
 */
public abstract class Dir {

    @Getter
    public enum Time {

        NEWER ("newer"),
        OLDER ("older");

        private final String value;

        Time(String value) {
            this.value = value;
        }

    }

    @Getter
    public enum Order {

        ASCENDING ("ascending"),
        DESCENDING ("descending");

        private final String value;

        Order(String value) {
            this.value = value;
        }

    }

    @Getter
    public enum Mixed {

        ASCENDING ("ascending"),
        DESCENDING ("descending"),
        NEWER ("newer"),
        OLDER ("older");

        private final String value;

        Mixed(String value) {
            this.value = value;
        }

    }

}
