package dev.masterflomaster1.jwa.request.list;

import dev.masterflomaster1.jwa.util.WikiApiUrl;

public abstract class AbstractList {

    protected String name;
    protected final WikiApiUrl apiUrl = new WikiApiUrl();

    public String getName() {
        return name;
    }

    public WikiApiUrl getApiUrl() {
        return apiUrl;
    }
}
