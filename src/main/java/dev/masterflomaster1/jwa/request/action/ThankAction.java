package dev.masterflomaster1.jwa.request.action;

import dev.masterflomaster1.jwa.WikiApiSyntaxException;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * Send a thank-you notification to an editor.
 *
 * @see <a href="https://www.mediawiki.org/wiki/Extension:Thanks#API_Documentation">Extension:Thanks</a>
 */
public class ThankAction extends AbstractAction {

    private int rev;
    private int log;
    private String token;
    private String source;

    private ThankAction() {
        urlPart = "?action=thank";
    }

    public int getRev() {
        return rev;
    }

    public int getLog() {
        return log;
    }

    public String getToken() {
        return token;
    }

    public String getSource() {
        return source;
    }

    public static class Builder {

        private final ThankAction thankAction = new ThankAction();

        /**
         * Revision ID to thank someone for. This or 'log' must be provided.
         * @param rev The value must be no less than 1.
         * @return {@code Builder}
         */
        public Builder rev(int rev) {
            thankAction.rev = rev;
            thankAction.urlPart += "&rev=" + rev;
            return this;
        }

        /**
         * Log ID to thank someone for. This or 'rev' must be provided.
         * @param log The value must be no less than 1.
         * @return {@code Builder}
         */
        public Builder log(int log) {
            thankAction.log = log;
            thankAction.urlPart += "&log=" + log;
            return this;
        }

        /**
         * A "csrf" token retrieved from
         * <a href="https://www.mediawiki.org/w/api.php?action=help&modules=query%2Btokens">action=query&meta=tokens</a>
         * This parameter is required.
         * @return {@code Builder}
         */
        public Builder token(String token) {
            thankAction.token = token;
            thankAction.urlPart += "&token=" + URLEncoder.encode(token, StandardCharsets.UTF_8);
            return this;
        }

        /**
         * A short string describing the source of the request, for example {@code diff} or {@code history}.
         * @return {@code Builder}
         */
        public Builder source(String source) {
            thankAction.source = source;
            thankAction.urlPart += "&source=" + source;
            return this;
        }

        public ThankAction build() throws WikiApiSyntaxException {
            if (thankAction.token == null)
                throw new WikiApiSyntaxException("Parameter 'token' is required");

            return thankAction;
        }

    }
}
