package dev.masterflomaster1.jwa.common;

public enum Namespace {

    MEDIA (-2),
    SPECIAL (-1),
    MAIN (0),
    TALK (1);

    private final int value;

    Namespace(int value) {
        this.value = value;
    }

    public String getValue() {
        return String.valueOf(value);
    }
}
