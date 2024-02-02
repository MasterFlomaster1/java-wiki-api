package dev.masterflomaster1.jwa.model;

import dev.masterflomaster1.jwa.WikiApiSyntaxException;

/**
 * Check if an IP address is blocked as a Tor exit node.
 *
 * @see <a href="https://www.mediawiki.org/wiki/API:Main_page">https://www.mediawiki.org/wiki/API:Main_page</a>
 */
public class TorBlockAction extends AbstractAction {

    private String ip;

    public String getIp() {
        return ip;
    }

    private TorBlockAction() {
        urlPart = "?action=torblock";
    }

    public static class Builder {

        private final TorBlockAction torBlockAction = new TorBlockAction();

        /**
         * The IP address to check. This parameter is required.
         * @param ip value
         * @return {@code Builder}
         */
        public Builder ip(String ip) {
            torBlockAction.ip = ip;
            torBlockAction.urlPart += "&ip=" + ip;
            return this;
        }

        public TorBlockAction build() throws WikiApiSyntaxException {
            if (torBlockAction.ip == null)
                throw new WikiApiSyntaxException("One or more required parameters are missing");

            return torBlockAction;
        }

    }


}
