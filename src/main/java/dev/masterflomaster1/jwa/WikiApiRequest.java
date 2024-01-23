package dev.masterflomaster1.jwa;

import dev.masterflomaster1.jwa.model.IIProp;
import dev.masterflomaster1.jwa.model.Prop;
import dev.masterflomaster1.jwa.model.action.AbstractAction;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class WikiApiRequest {

    public final String url;

    WikiApiRequest(String url) {
        this.url = url;
    }

    public static class Builder {

        String base = "https://en.wikipedia.org/w/api.php";
        private final String format = "json";
        private AbstractAction action;

        public Builder setAction(AbstractAction action) {
            this.action = action;
            return this;
        }

        public WikiApiRequest build() {
            // Set action

            // Set format
            this.base += "&format=" + format;

            return new WikiApiRequest(base);
        }

    }

}
