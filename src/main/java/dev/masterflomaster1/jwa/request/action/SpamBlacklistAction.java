package dev.masterflomaster1.jwa.request.action;

import dev.masterflomaster1.jwa.request.AbstractBuilder;
import lombok.Getter;
import lombok.ToString;

import java.util.Set;

/**
 * Validate one or more URLs against the spam block list.
 *
 * @see <a href="https://www.mediawiki.org/wiki/Extension:SpamBlacklist/API">Extension:SpamBlacklist</a>
 */
@Getter
@ToString
@SuppressWarnings("SpellCheckingInspection")
public final class SpamBlacklistAction extends AbstractAction {

    private Set<String> url;

    private SpamBlacklistAction() {
        apiUrl.setAction("spamblacklist");
    }

    public static class Builder extends AbstractBuilder {

        private final SpamBlacklistAction spamBlacklistAction = new SpamBlacklistAction();

        /**
         * URLs to validate against the block list.
         * @param url Maximum number of values is 50 (500 for clients that are allowed higher limits).
         * @return {@code Builder}
         */
        public Builder url(Set<String> url) {
            spamBlacklistAction.url = url;
            spamBlacklistAction.apiUrl.putQuery("url", mergeString(url));
            return this;
        }

        public SpamBlacklistAction build() {
            return spamBlacklistAction;
        }

    }

}
