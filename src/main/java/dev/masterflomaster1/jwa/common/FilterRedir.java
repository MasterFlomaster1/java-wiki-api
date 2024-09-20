package dev.masterflomaster1.jwa.common;

import lombok.Getter;

@Getter
@SuppressWarnings("SpellCheckingInspection")
public enum FilterRedir {

    ALL("all"),
    NON_REDIRECTS("nonredirects"),
    REDIRECTS("redirects");

    private final String value;

    FilterRedir(String value) {
        this.value = value;
    }

}
