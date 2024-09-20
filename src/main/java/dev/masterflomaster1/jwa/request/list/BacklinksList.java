package dev.masterflomaster1.jwa.request.list;

import dev.masterflomaster1.jwa.common.Dir;
import dev.masterflomaster1.jwa.common.FilterRedir;
import dev.masterflomaster1.jwa.common.Namespace;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.EnumSet;
import java.util.stream.Collectors;

/**
 * Find all pages that link to the given page.
 *
 * @see <a href="https://www.mediawiki.org/wiki/Special:MyLanguage/API:Backlinks">API:Backlinks</a>
 */
@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@SuppressWarnings("SpellCheckingInspection")
public final class BacklinksList extends AbstractList {

    private String blTitle;
    private int blPageId;
    private String blContinue;
    private EnumSet<Namespace> blNamespace;
    private Dir.Order blDir;
    private FilterRedir blFilterRedir;
    private int blLimit;
    private boolean blRedirect;

    private BacklinksList() {
        name = "backlinks";
    }

    public static class Builder {

        private final BacklinksList backlinksList = new BacklinksList();

        /**
         * Title to search. Cannot be used together with {@code blpageid}.
         * @return {@code Builder}
         */
        public Builder blTitle(final String title) {
            backlinksList.blTitle = title;
            backlinksList.apiUrl.putQuery("bltitle", title);
            return this;
        }

        /**
         * Page ID to search. Cannot be used together with {@code bltitle}.
         * @return {@code Builder}
         */
        public Builder blPageId(final int pageId) {
            backlinksList.blPageId = pageId;
            backlinksList.apiUrl.putQuery("blpageid", pageId);
            return this;
        }

        /**
         * When more results are available, use this to continue.
         * More detailed information on how to continue queries can be found on
         * <a href="https://www.mediawiki.org/wiki/API:Continue">mediawiki.org</a>.
         * @return {@code Builder}
         */
        public Builder blContinue(final String blContinue) {
            backlinksList.blContinue = blContinue;
            backlinksList.apiUrl.putQuery("blcontinue", blContinue);
            return this;
        }

        /**
         * The namespace to enumerate.
         * @return {@code Builder}
         */
        public Builder blNamespace(final EnumSet<Namespace> namespace) {
            backlinksList.blNamespace = namespace;
            backlinksList.apiUrl.putQuery("blnamespace", namespace.stream()
                    .map(Namespace::getValue)
                    .collect(Collectors.joining("|")));
            return this;
        }

        /**
         * The direction in which to list.
         * @return {@code Builder}
         */
        public Builder blDir(final Dir.Order dir) {
            backlinksList.blDir = dir;
            backlinksList.apiUrl.putQuery("bldir", dir.getValue());
            return this;
        }

        /**
         * How to filter for redirects. If set to {@code nonredirects} when blredirect is enabled, this is only applied
         * to the second level.
         * @return {@code Builder}
         */
        public Builder blFilterRedir(final FilterRedir filterRedir) {
            backlinksList.blFilterRedir = filterRedir;
            backlinksList.apiUrl.putQuery("blfilterredir", filterRedir.getValue());
            return this;
        }

        /**
         * How many total pages to return. If {@code blredirect} is enabled, the limit applies to each level separately
         * (which means up to 2 * bllimit results may be returned).
         * @param limit The value must be between 1 and 500.
         * @return {@code Builder}
         */
        public Builder blLimit(final int limit) {
            backlinksList.blLimit = limit;
            backlinksList.apiUrl.putQuery("bllimit", limit);
            return this;
        }

        /**
         * If linking page is a redirect, find all pages that link to that redirect as well. Maximum limit is halved.
         * @return {@code Builder}
         */
        public Builder blRedirect() {
            backlinksList.blRedirect = true;
            backlinksList.apiUrl.putQuery("blredirect", "1");
            return this;
        }

        public BacklinksList build() {
            return backlinksList;
        }

    }

}
