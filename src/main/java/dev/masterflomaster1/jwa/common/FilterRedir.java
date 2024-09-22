package dev.masterflomaster1.jwa.common;

import dev.masterflomaster1.jwa.internal.EnumValueProvider;
import lombok.Getter;

@Getter
@SuppressWarnings("SpellCheckingInspection")
public enum FilterRedir implements EnumValueProvider {

    ALL("all"),
    NON_REDIRECTS("nonredirects"),
    REDIRECTS("redirects");

    private final String value;

    FilterRedir(String value) {
        this.value = value;
    }

}
