package dev.masterflomaster1.jwa.request.action;

import dev.masterflomaster1.jwa.request.AbstractBuilder;
import lombok.Getter;
import lombok.ToString;

/**
 * Fetch a {@code centralauthtoken} for making an authenticated request to an attached wiki.
 *
 * @see <a href="https://www.mediawiki.org/w/api.php?action=help&modules=centralauthtoken">mediawiki.org</a>
 */
@Getter
@ToString
@SuppressWarnings("SpellCheckingInspection")
public final class CentralAuthTokenAction extends AbstractAction {

    private CentralAuthTokenAction() {
        apiUrl.setAction("centralauthtoken");
    }

    public static class Builder extends AbstractBuilder {

        private final CentralAuthTokenAction centralAuthTokenAction = new CentralAuthTokenAction();

        public CentralAuthTokenAction build() {
            return centralAuthTokenAction;
        }

    }

}
