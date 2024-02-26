package dev.masterflomaster1.jwa.request.action;

import dev.masterflomaster1.jwa.util.WikiApiUrl;

public abstract class AbstractAction {

    protected final WikiApiUrl apiUrl = new WikiApiUrl();

    public WikiApiUrl getApiUrl() {
        return apiUrl;
    }
}
