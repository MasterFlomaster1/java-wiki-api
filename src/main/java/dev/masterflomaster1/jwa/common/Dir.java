package dev.masterflomaster1.jwa.common;

/**
 * The direction in which to list.
 */
public enum Dir {

    ASCENDING ("ascending"),
    DESCENDING ("descending");

    private final String value;

    Dir(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
