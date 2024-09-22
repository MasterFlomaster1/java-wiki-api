package dev.masterflomaster1.jwa.request.list;

import dev.masterflomaster1.jwa.common.Namespace;
import dev.masterflomaster1.jwa.common.Protocol;
import dev.masterflomaster1.jwa.internal.EnumValueProvider;
import dev.masterflomaster1.jwa.request.AbstractBuilder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.EnumSet;

/**
 * Enumerate pages that contain a given URL.
 *
 * @see <a href="https://www.mediawiki.org/wiki/Special:MyLanguage/API:Exturlusage">API:Exturlusage</a>
 */
@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@SuppressWarnings("SpellCheckingInspection")
public final class ExtUrlUsageList extends AbstractList {

    private EnumSet<EuProp> euProp;
    private String euContinue;
    private Protocol euProtocol;
    private String euQuery;
    private EnumSet<Namespace> euNamespace;
    private int euLimit;

    private ExtUrlUsageList() {
        super("exturlusage");
    }

    public static class Builder extends AbstractBuilder {

        private final ExtUrlUsageList extUrlUsageList = new ExtUrlUsageList();

        /**
         * Which pieces of information to include.
         * @return {@code Builder}
         */
        public Builder euProp(final EnumSet<EuProp> euProp) {
            extUrlUsageList.euProp = euProp;
            extUrlUsageList.apiUrl.putQuery("euprop", merge(euProp));
            return this;
        }

        /**
         * When more results are available, use this to continue.
         * More detailed information on how to continue queries can be found on
         * <a href="https://www.mediawiki.org/wiki/API:Continue">mediawiki.org</a>.
         * @return {@code Builder}
         */
        public Builder euContinue(final String euContinue) {
            extUrlUsageList.euContinue = euContinue;
            extUrlUsageList.apiUrl.putQuery("eucontinue", euContinue);
            return this;
        }

        /**
         * Protocol of the URL. If empty and {@code euquery} is set, the protocol is http and https. Leave both this
         * and {@code euquery} empty to list all external links.
         * @return {@code Builder}
         */
        public Builder euProtocol(final Protocol euProtocol) {
            extUrlUsageList.euProtocol = euProtocol;
            extUrlUsageList.apiUrl.putQuery("euprotocol", euProtocol.getValue());
            return this;
        }

        /**
         * Search string without protocol. Leave empty to list all external links.
         * @return {@code Builder}
         *
         * @see <a href="https://en.wikipedia.org/wiki/Special:LinkSearch">Special:LinkSearch</a>
         */
        public Builder euQuery(final String euQuery) {
            extUrlUsageList.euQuery = euQuery;
            extUrlUsageList.apiUrl.putQuery("euquery", euQuery);
            return this;
        }

        /**
         * The page namespaces to enumerate.
         * @return {@code Builder}
         */
        public Builder euNamespace(final EnumSet<Namespace> euNamespace) {
            extUrlUsageList.euNamespace = euNamespace;
            extUrlUsageList.apiUrl.putQuery("eunamespace", merge(euNamespace));
            return this;
        }

        /**
         * How many total changes to return. Default: 10
         * @param euLimit The value must be between 1 and 500.
         * @return {@code Builder}
         */
        public Builder euLimit(final int euLimit) {
            extUrlUsageList.euLimit = euLimit;
            extUrlUsageList.apiUrl.putQuery("eulimit", euLimit);
            return this;
        }

        public ExtUrlUsageList build() {
            return extUrlUsageList;
        }

    }

    @Getter
    public enum EuProp implements EnumValueProvider {

        /**
         * Adds the ID of page.
         */
        IDS("ids"),

        /**
         * Adds the title and namespace ID of the page.
         */
        TITLE("title"),

        /**
         * Adds the URL used in the page.
         */
        URL("url");

        private final String value;

        EuProp(String value) {
            this.value = value;
        }

    }

}
