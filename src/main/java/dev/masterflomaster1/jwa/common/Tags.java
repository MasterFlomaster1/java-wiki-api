package dev.masterflomaster1.jwa.common;

import lombok.Getter;

@Getter
public enum Tags {

    CONVENIENT_DISCUSSIONS ("convenient-discussions"),
    POSSIBLE_VANDALISM ("possible vandalism"),
    REPEATING_CHARACTERS ("repeating characters");

    private final String value;

    Tags(String value) {
        this.value = value;
    }

}
