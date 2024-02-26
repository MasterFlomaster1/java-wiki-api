package dev.masterflomaster1.jwa.request.action;

/**
 * Fetch a {@code centralauthtoken} for making an authenticated request to an attached wiki.
 *
 * @see <a href="https://www.mediawiki.org/w/api.php?action=help&modules=centralauthtoken">mediawiki.org</a>
 */
public class CentralAuthTokenAction extends AbstractAction {

    private CentralAuthTokenAction() {
        apiUrl.setAction("centralauthtoken");
    }

    public static class Builder {

        private final CentralAuthTokenAction centralAuthTokenAction = new CentralAuthTokenAction();

        public CentralAuthTokenAction build() {
            return centralAuthTokenAction;
        }

    }

}
