package dev.masterflomaster1.jwa.request.meta;

import dev.masterflomaster1.jwa.util.WikiApiUrl;
import lombok.Getter;

@Getter
public abstract class AbstractMeta {

    private final String name;
    protected final WikiApiUrl apiUrl = new WikiApiUrl();

    AbstractMeta(final String name) {
        this.name = name;
    }

}
