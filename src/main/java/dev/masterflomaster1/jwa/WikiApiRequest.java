package dev.masterflomaster1.jwa;

import dev.masterflomaster1.jwa.model.action.AbstractAction;

public class WikiApiRequest {

    private final String url;

    private WikiApiRequest(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public enum Format { JSON, JSON_FM, NONE, PHP, PHP_FM, RAW_FM, XML, XML_FM }

    public static class Builder {

        private WikiApiRequest request;

        private String base = "https://en.wikipedia.org/w/api.php";
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
