package dev.masterflomaster1.jwa.common;

import lombok.Getter;

/**
 * The direction in which to list.
 */
@Getter
public enum Dir {

    ASCENDING ("ascending"),
    DESCENDING ("descending");

    private final String value;

    Dir(String value) {
        this.value = value;
    }

}
