package dev.masterflomaster1.jwa.request.action;

import lombok.Getter;
import lombok.ToString;

/**
 * Check a username against AntiSpoof's normalisation checks.
 *
 * @see <a href="https://www.mediawiki.org/w/api.php?action=help&modules=antispoof">mediawiki.org</a>
 */
@Getter
@ToString
public final class AntiSpoofAction extends AbstractAction {

    private String username;

    private AntiSpoofAction() {
        apiUrl.setAction("antispoof");
    }

    public static class Builder {

        private final AntiSpoofAction antiSpoofAction = new AntiSpoofAction();

        /**
         * The username to check against AntiSpoof. This parameter is required.
         * @return {@code Builder}
         */
        public Builder username(String username) {
            antiSpoofAction.username = username;
            antiSpoofAction.apiUrl.putQuery("username", username);
            return this;
        }

        public AntiSpoofAction build() {
            if (antiSpoofAction.username == null)
                throw new IllegalArgumentException("Parameter 'username' is required");

            return antiSpoofAction;
        }

    }

}
