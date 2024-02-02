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

    public static class Builder {

        private final WikiApiRequest request = new WikiApiRequest();

        /**
         * Which action to perform.
         * @param action value
         * @return {@code Builder}
         */
        public Builder action(AbstractAction action) {
            request.action = action;
            request.url += action.getUrlPart();
            return this;
        }

        /**
         * The format of the output.
         * @param format value
         * @return {@code Builder}
         */
        public Builder format(AbstractFormat format) {
            return this;
        }

        /**
         * Include the hostname that served the request in the results.
         * @return {@code Builder}
         */
        public Builder servedBy() {
            request.url += "&servedby=1";
            return this;
        }

        /**
         * Include the current timestamp in the result.
         * @return {@code Builder}
         */
        public Builder curTimestamp() {
            request.url += "&curtimestamp=1";
            return this;
        }

        /**
         * Include the languages used for {@code uselang} and {@code errorlang} in the result.
         * @return {@code Builder}
         */
        public Builder responseLangInfo() {
            request.url += "&responselanginfo=1";
            return this;
        }

        public WikiApiRequest build() throws WikiApiSyntaxException {
            if (request.action == null)
                throw new WikiApiSyntaxException("You must specify one action to generate a request");

            request.url += "&format=json";
            request.url += "&formatversion=2";

            return request;
        }

    }

}
