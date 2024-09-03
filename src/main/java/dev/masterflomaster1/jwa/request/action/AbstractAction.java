package dev.masterflomaster1.jwa.request.action;

import dev.masterflomaster1.jwa.util.WikiApiUrl;
import lombok.Getter;

@Getter
public abstract class AbstractAction {

    protected final WikiApiUrl apiUrl = new WikiApiUrl();

}
