package dev.masterflomaster1.jwa;

import dev.masterflomaster1.jwa.model.AbstractAction;
import dev.masterflomaster1.jwa.model.AbstractFormat;

public class WikiApiRequest {

    private String url = "https://en.wikipedia.org/w/api.php";
    private AbstractAction action;

    private WikiApiRequest() {
    }

    public String getUrl() {
        return url;
    }

    public enum Format { JSON, JSON_FM, NONE, PHP, PHP_FM, RAW_FM, XML, XML_FM }

    public static class Builder {

        private final WikiApiRequest request = new WikiApiRequest();

        private final String format = "json";

        public Builder action(AbstractAction action) {
            request.action = action;
            request.url += action.getUrlPart();
            return this;
        }

        public Builder format(AbstractFormat format) {
            return this;
        }

        public Builder servedBy() {
            return this;
        }

        public Builder curTimestamp() {
            return this;
        }

        public WikiApiRequest build() throws WikiApiException {
            if (request.action == null)
                throw new WikiApiException("You must specify one action to generate a request");

            request.url += "&format=" + format;
            request.url += "&formatversion=2";

            return request;
        }

    }

}
