package dev.masterflomaster1.jwa.request.action;

import lombok.Getter;
import lombok.ToString;

/**
 * Check if an IP address is blocked as a Tor exit node.
 *
 * @see <a href="https://www.mediawiki.org/w/api.php?action=help&modules=torblock">www.mediawiki.org</a>
 */
@Getter
@ToString
@SuppressWarnings("SpellCheckingInspection")
public final class TorBlockAction extends AbstractAction {

    private String ip;

    private TorBlockAction() {
        apiUrl.setAction("torblock");
    }

    public static class Builder {

        private final TorBlockAction torBlockAction = new TorBlockAction();

        /**
         * The IP address to check. This parameter is required.
         * @return {@code Builder}
         */
        public Builder ip(String ip) {
            torBlockAction.ip = ip;
            torBlockAction.apiUrl.putQuery("ip", ip);
            return this;
        }

        public TorBlockAction build() {
            if (torBlockAction.ip == null)
                throw new IllegalArgumentException("Parameter 'ip' is required");

            return torBlockAction;
        }

    }


}
