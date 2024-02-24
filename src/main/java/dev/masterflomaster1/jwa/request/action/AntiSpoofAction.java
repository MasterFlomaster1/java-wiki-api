package dev.masterflomaster1.jwa.request.action;

import dev.masterflomaster1.jwa.WikiApiSyntaxException;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * Check a username against AntiSpoof's normalisation checks.
 *
 * @see <a href="https://www.mediawiki.org/w/api.php?action=help&modules=antispoof">mediawiki.org</a>
 */
public class AntiSpoofAction extends AbstractAction {

    private String username;

    private AntiSpoofAction() {
        urlPart = "?action=antispoof";
    }

    public String getUsername() {
        return username;
    }

    public static class Builder {

        private final AntiSpoofAction antiSpoofAction = new AntiSpoofAction();

        /**
         * The username to check against AntiSpoof. This parameter is required.
         * @return {@code Builder}
         */
        public Builder username(String username) {
            antiSpoofAction.username = username;
            antiSpoofAction.urlPart += "&username=" + URLEncoder.encode(username, StandardCharsets.UTF_8);
            return this;
        }

        public AntiSpoofAction build() throws WikiApiSyntaxException {
            if (antiSpoofAction.username == null)
                throw new WikiApiSyntaxException("Parameter 'username' is required");

            return antiSpoofAction;
        }

    }

}
