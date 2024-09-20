package dev.masterflomaster1.jwa;

import dev.masterflomaster1.jwa.request.action.AbstractAction;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@SuppressWarnings("SpellCheckingInspection")
public final class WikiApiRequest {

    private String url = "https://en.wikipedia.org/w/api.php";
    private AbstractAction action;
    private String assertUser;
    private String requestId;
    private boolean servedBy;
    private boolean curTimestamp;
    private boolean responseLangInfo;
    private String useLang;
    private String variant;

    private WikiApiRequest() { }

    public static class Builder {

        private final WikiApiRequest wikiApiRequest = new WikiApiRequest();

        /**
         * Which action to perform.
         * @param action value
         * @return {@code Builder}
         */
        public Builder action(AbstractAction action) {
            wikiApiRequest.action = action;
            wikiApiRequest.url += action.getApiUrl().build();
            return this;
        }

        /**
         * Verify the current user is the named user.
         * @return {@code Builder}
         */
        public Builder assertUser(String assertUser) {
            wikiApiRequest.assertUser = assertUser;
            wikiApiRequest.url += "&assertuser=" + assertUser;
            return this;
        }

        /**
         * Any value given here will be included in the response. May be used to distinguish requests.
         * @return {@code Builder}
         */
        public Builder requestId(String requestId) {
            wikiApiRequest.requestId = requestId;
            wikiApiRequest.url += "&requestid=" + requestId;
            return this;
        }

        /**
         * Include the hostname that served the request in the results.
         * @return {@code Builder}
         */
        public Builder servedBy() {
            wikiApiRequest.servedBy = true;
            wikiApiRequest.url += "&servedby=1";
            return this;
        }

        /**
         * Include the current timestamp in the result.
         * @return {@code Builder}
         */
        public Builder curTimestamp() {
            wikiApiRequest.curTimestamp = true;
            wikiApiRequest.url += "&curtimestamp=1";
            return this;
        }

        /**
         * Include the languages used for {@code uselang} and {@code errorlang} in the result.
         * @return {@code Builder}
         */
        public Builder responseLangInfo() {
            wikiApiRequest.responseLangInfo = true;
            wikiApiRequest.url += "&responselanginfo=1";
            return this;
        }

        /**
         * Language to use for message translations. {@code action=query&meta=siteinfo} with {@code siprop=languages}
         * returns a list of language codes, or specify {@code user} to use the current user's language preference, or
         * specify {@code content} to use this wiki's content language.
         * @return {@code Builder}
         */
        public Builder useLang(String useLang) {
            wikiApiRequest.useLang = useLang;
            wikiApiRequest.url += "&uselang=" + useLang;
            return this;
        }

        /**
         * Variant of the language. Only works if the base language supports variant conversion.
         * @return {@code Builder}
         */
        public Builder variant(String variant) {
            wikiApiRequest.variant = variant;
            wikiApiRequest.url += "&variant=" + variant;
            return this;
        }

        public WikiApiRequest build() {
            if (wikiApiRequest.action == null)
                throw new IllegalArgumentException("You must specify one action to generate a request");

            wikiApiRequest.url += "&format=json";
            wikiApiRequest.url += "&formatversion=2";

            return wikiApiRequest;
        }

    }

}
