package dev.masterflomaster1.jwa.request.action;

import dev.masterflomaster1.jwa.common.Generator;
import okhttp3.FormBody;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Add or remove pages from the current user's watchlist.
 *
 * @see <a href="https://www.mediawiki.org/wiki/Special:MyLanguage/API:Watch">API:Watch</a>
 */
public final class WatchAction extends AbstractAction implements IPost {

    private String expiry;
    private boolean unwatch;
    private String continue_;
    private Set<String> titles;
    private Set<Integer> pageIds;
    private Set<Long> revIds;
    private Generator generator;
    private boolean redirects;
    private boolean convertTitles;
    private String token;

    private WatchAction() {
        apiUrl.setAction("watch");
    }

    public String getExpiry() {
        return expiry;
    }

    public boolean isUnwatch() {
        return unwatch;
    }

    public String getContinue() {
        return continue_;
    }

    public Set<String> getTitles() {
        return titles;
    }

    public Set<Integer> getPageIds() {
        return pageIds;
    }

    public Set<Long> getRevIds() {
        return revIds;
    }

    public Generator getGenerator() {
        return generator;
    }

    public boolean isRedirects() {
        return redirects;
    }

    public boolean isConvertTitles() {
        return convertTitles;
    }

    public String getToken() {
        return token;
    }

    @Override
    public FormBody getPostBody() {
        return new FormBody.Builder()
                .add("token", token)
                .build();
    }

    public static class Builder {

        private final WatchAction watchAction = new WatchAction();

        /**
         * Expiry timestamp to be applied to all given pages. Omit this parameter entirely to leave any current expiries unchanged.
         * @return {@code Builder}
         */
        public Builder expiry(String expiry) {
            watchAction.expiry = expiry;
            watchAction.apiUrl.putQuery("expiry", expiry);
            return this;
        }

        /**
         * If set the page will be unwatched rather than watched.
         * @return {@code Builder}
         */
        public Builder unwatch() {
            watchAction.unwatch = true;
            watchAction.apiUrl.putQuery("unwatch", "1");
            return this;
        }

        /**
         * When more results are available, use this to continue.
         * More detailed information on how to continue queries can be found on
         * <a href="https://www.mediawiki.org/wiki/API:Continue">mediawiki.org</a>.
         * @return {@code Builder}
         */
        public Builder continue_(String continue_) {
            watchAction.continue_ = continue_;
            watchAction.apiUrl.putQuery("continue", continue_);
            return this;
        }

        /**
         * A list of titles to work on.
         * @param titles Maximum number of values is 50 (500 for clients that are allowed higher limits).
         * @return {@code Builder}
         */
        public Builder titles(Set<String> titles) {
            watchAction.titles = titles;
            watchAction.apiUrl.putQuery("titles", String.join("|", titles));
            return this;
        }

        /**
         * A list of page IDs to work on.
         * @param pageIds Maximum number of values is 50 (500 for clients that are allowed higher limits).
         * @return {@code Builder}
         */
        public Builder pageIds(Set<Integer> pageIds) {
            watchAction.pageIds = pageIds;
            watchAction.apiUrl.putQuery("pageids", pageIds.stream()
                    .map(Object::toString)
                    .collect(Collectors.joining("|")));
            return this;
        }

        /**
         * A list of revision IDs to work on. Note that almost all query modules will convert revision IDs to the
         * corresponding page ID and work on the latest revision instead. Only prop=revisions uses exact revisions for
         * its response.
         * @param revIds Maximum number of values is 50 (500 for clients that are allowed higher limits).
         * @return {@code Builder}
         */
        public Builder revIds(Set<Long> revIds) {
            watchAction.revIds = revIds;
            watchAction.apiUrl.putQuery("revids", revIds.stream()
                    .map(Objects::toString)
                    .collect(Collectors.joining("|")));
            return this;
        }

        /**
         * Get the list of pages to work on by executing the specified query module.
         * TODO: Note: Generator parameter names must be prefixed with a "g"
         * @return {@code Builder}
         */
        public Builder generator(Generator generator) {
            watchAction.generator = generator;
            watchAction.apiUrl.putQuery("generator", generator.getValue());
            return this;
        }

        /**
         * Automatically resolve redirects in {@code titles}, {@code pageids}, and {@code revids}, and in pages returned
         * by generator.
         * @return {@code Builder}
         */
        public Builder redirects() {
            watchAction.redirects = true;
            watchAction.apiUrl.putQuery("redirects", "1");
            return this;
        }

        /**
         * Convert titles to other variants if necessary. Only works if the wiki's content language supports variant
         * conversion. Languages that support variant conversion include ban, en, crh, gan, iu, ku, sh, shi, sr, tg,
         * tly, uz, wuu and zh.
         * @return {@code Builder}
         */
        public Builder convertTitles() {
            watchAction.convertTitles = true;
            watchAction.apiUrl.putQuery("converttitles", "1");
            return this;
        }

        /**
         * A "csrf" token retrieved from
         * <a href="https://www.mediawiki.org/w/api.php?action=help&modules=query%2Btokens">action=query&meta=tokens</a>
         * This parameter is required.
         * @return {@code Builder}
         */
        public Builder token(String token) {
            watchAction.token = token;
            return this;
        }

        public WatchAction build() {
            return watchAction;
        }

    }

}
