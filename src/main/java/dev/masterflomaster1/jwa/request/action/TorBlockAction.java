package dev.masterflomaster1.jwa.request.action;

import dev.masterflomaster1.jwa.WikiApiSyntaxException;

/**
 * Check if an IP address is blocked as a Tor exit node.
 *
 * @see <a href="https://www.mediawiki.org/w/api.php?action=help&modules=torblock">www.mediawiki.org</a>
 */
public final class TorBlockAction extends AbstractAction {

    private String ip;

    public String getIp() {
        return ip;
    }

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

        public TorBlockAction build() throws WikiApiSyntaxException {
            if (torBlockAction.ip == null)
                throw new WikiApiSyntaxException("Parameter 'ip' is required");

            return torBlockAction;
        }

    }


}
