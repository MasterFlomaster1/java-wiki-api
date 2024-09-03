package dev.masterflomaster1.jwa.request.list;

import dev.masterflomaster1.jwa.util.WikiApiUrl;
import lombok.Getter;

@Getter
public abstract class AbstractList {

    protected String name;
    protected final WikiApiUrl apiUrl = new WikiApiUrl();

}
