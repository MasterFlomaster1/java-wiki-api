package dev.masterflomaster1.jwa.request.meta;

import dev.masterflomaster1.jwa.util.WikiApiUrl;

public abstract class AbstractMeta {

    protected final WikiApiUrl apiUrl = new WikiApiUrl();
    protected String name;

    public WikiApiUrl getApiUrl() {
        return apiUrl;
    }

    public String getName() {
        return name;
    }

}
