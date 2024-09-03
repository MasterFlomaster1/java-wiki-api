package dev.masterflomaster1.jwa.request.action;

import java.util.Set;

/**
 * Validate one or more URLs against the spam block list.
 *
 * @see <a href="https://www.mediawiki.org/wiki/Extension:SpamBlacklist/API">Extension:SpamBlacklist</a>
 */
public final class SpamBlacklistAction extends AbstractAction {

    private Set<String> url;

    private SpamBlacklistAction() {
        apiUrl.setAction("spamblacklist");
    }

    public Set<String> getUrl() {
        return url;
    }

    public static class Builder {

        private final SpamBlacklistAction spamBlacklistAction = new SpamBlacklistAction();

        /**
         * URLs to validate against the block list.
         * @param url Maximum number of values is 50 (500 for clients that are allowed higher limits).
         * @return {@code Builder}
         */
        public Builder url(Set<String> url) {
            spamBlacklistAction.url = url;
            spamBlacklistAction.apiUrl.putQuery("url", String.join("|", url));
            return this;
        }

        public SpamBlacklistAction build() {
            return spamBlacklistAction;
        }

    }

}
