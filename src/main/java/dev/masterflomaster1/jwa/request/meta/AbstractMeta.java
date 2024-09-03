package dev.masterflomaster1.jwa.request.meta;

import dev.masterflomaster1.jwa.util.WikiApiUrl;
import lombok.Getter;

@Getter
public abstract class AbstractMeta {

    protected final WikiApiUrl apiUrl = new WikiApiUrl();
    protected String name;

}
