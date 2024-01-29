package dev.masterflomaster1.jwa.model;

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

        public Builder ip(String ip) {
            torBlockAction.ip = ip;
            torBlockAction.urlPart += "&ip=" + ip;
            return this;
        }

        public TorBlockAction build() {
            return torBlockAction;
        }

    }


}
