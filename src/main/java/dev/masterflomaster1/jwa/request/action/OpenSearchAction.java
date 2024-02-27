package dev.masterflomaster1.jwa.request.action;

import dev.masterflomaster1.jwa.WikiApiSyntaxException;
import dev.masterflomaster1.jwa.common.Namespace;

import java.util.Set;
import java.util.stream.Collectors;

public class OpenSearchAction extends AbstractAction {

    private String search;
    private Set<Namespace> namespace;
    private int limit;
    private Profile profile;
    private Redirects redirects;
    private Format format;
    private boolean warningsAsError;

    private OpenSearchAction() {
        apiUrl.setAction("opensearch");
    }

    public String getSearch() {
        return search;
    }

    public Set<Namespace> getNamespace() {
        return namespace;
    }

    public int getLimit() {
        return limit;
    }

    public Profile getProfile() {
        return profile;
    }

    public Redirects getRedirects() {
        return redirects;
    }

    public Format getFormat() {
        return format;
    }

    public boolean isWarningsAsError() {
        return warningsAsError;
    }

    public static class Builder {

        private final OpenSearchAction openSearchAction = new OpenSearchAction();

        /**
         * Search string. This parameter is required.
         * @return {@code Builder}
         */
        public Builder search(String search) {
            openSearchAction.search = search;
            openSearchAction.apiUrl.putQuery("search", search);
            return this;
        }

        /**
         * Namespaces to search. Ignored if search begins with a valid namespace prefix.
         * @return {@code Builder}
         */
        public Builder namespace(Set<Namespace> namespace) {
            openSearchAction.namespace = namespace;
            openSearchAction.apiUrl.putQuery("namespace", namespace.stream()
                    .map(Namespace::getValue)
                    .collect(Collectors.joining("|")));
            return this;
        }

        /**
         * Maximum number of results to return.
         * @param limit The value must be between 1 and 500.
         * @return {@code Builder}
         */
        public Builder limit(int limit) {
            openSearchAction.limit = limit;
            openSearchAction.apiUrl.putQuery("limit", limit);
            return this;
        }

        /**
         * Search profile to use.
         * @return {@code Builder}
         */
        public Builder profile(Profile profile) {
            openSearchAction.profile = profile;
            openSearchAction.apiUrl.putQuery("profile", profile.getValue());
            return this;
        }

        /**
         * How to handle redirects.
         * For historical reasons, the default is "return" for format=json and "resolve" for other formats.
         * @return {@code Builder}
         */
        public Builder redirects(Redirects redirects) {
            openSearchAction.redirects = redirects;
            openSearchAction.apiUrl.putQuery("redirects", redirects.getValue());
            return this;
        }

        /**
         * The format of the output.
         * @return {@code Builder}
         */
        public Builder format(Format format) {
            openSearchAction.format = format;
            openSearchAction.apiUrl.putQuery("format", format.getValue());
            return this;
        }

        /**
         * If warnings are raised with format=json, return an API error instead of ignoring them.
         * @return {@code Builder}
         */
        public Builder warningsAsError() {
            openSearchAction.warningsAsError = true;
            openSearchAction.apiUrl.putQuery("warningsaserror", "1");
            return this;
        }

        public OpenSearchAction build() {
            if (openSearchAction.search == null)
                throw new WikiApiSyntaxException("Parameter 'search' is required");

            return openSearchAction;
        }

    }

    public enum Profile {

        /**
         * Classic prefix, few punctuation characters and some diacritics removed.
         */
        CLASSIC ("classic"),

        /**
         * Let the search engine decide on the best profile to use.
         */
        ENGINE_AUTO_SELECT ("engine_autoselect"),

        /**
         * Experimental fuzzy profile (may be removed at any time)
         */
        FAST_FUZZY ("fast-fuzzy"),

        /**
         * Similar to normal with typo correction (two typos supported).
         */
        FUZZY ("fuzzy"),

        /**
         * Few punctuation characters, some diacritics and stopwords removed.
         */
        NORMAL ("normal"),

        /**
         * Strict profile with few punctuation characters removed but diacritics and stress marks are kept.
         */
        STRICT ("strict");

        private final String value;

        Profile(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public enum Redirects {

        /**
         * Return the target page. May return fewer than limit results.
         */
        RESOLVE ("resolve"),

        /**
         * Return the redirect itself.
         */
        RETURN ("return");

        private final String value;

        Redirects(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

    }

    public enum Format {

        JSON ("json"),
        JSON_FM ("jsonfm"),
        XML ("xml"),
        XML_FM ("xml");

        private final String value;

        Format(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

    }

}
