package dev.masterflomaster1.jwa.common;

import dev.masterflomaster1.jwa.internal.EnumValueProvider;
import lombok.Getter;

public abstract class Show {

    @Getter
    public enum Redirect implements EnumValueProvider {

        /**
         * Only show redirects.
         */
        REDIRECT ("redirect"),

        /**
         * Only show non-redirects.
         */
        NOT_REDIRECT ("!redirect");

        private final String value;

        Redirect(String value) {
            this.value = value;
        }

    }

}
