package dev.masterflomaster1.jwa.common;

import dev.masterflomaster1.jwa.internal.EnumValueProvider;
import lombok.Getter;

@Getter
public enum Tags implements EnumValueProvider {

    CONVENIENT_DISCUSSIONS ("convenient-discussions"),
    POSSIBLE_VANDALISM ("possible vandalism"),
    REPEATING_CHARACTERS ("repeating characters");

    private final String value;

    Tags(String value) {
        this.value = value;
    }

}
