package dev.masterflomaster1.jwa.common;

import dev.masterflomaster1.jwa.internal.EnumValueProvider;
import lombok.Getter;

/**
 * The direction in which to list.
 */
public abstract class Dir {

    @Getter
    public enum Time implements EnumValueProvider {

        NEWER ("newer"),
        OLDER ("older");

        private final String value;

        Time(String value) {
            this.value = value;
        }

    }

    @Getter
    public enum Order implements EnumValueProvider {

        ASCENDING ("ascending"),
        DESCENDING ("descending");

        private final String value;

        Order(String value) {
            this.value = value;
        }

    }

    @Getter
    public enum Mixed implements EnumValueProvider {

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
