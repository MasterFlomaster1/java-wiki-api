package dev.masterflomaster1.jwa.request.action;

import dev.masterflomaster1.jwa.request.AbstractBuilder;
import lombok.Getter;
import lombok.ToString;
import okhttp3.FormBody;

/**
 * Send a thank-you notification to an editor.
 *
 * @see <a href="https://www.mediawiki.org/wiki/Extension:Thanks#API_Documentation">Extension:Thanks</a>
 */
@Getter
@ToString
public final class ThankAction extends AbstractAction implements IPost {

    private int rev;
    private int log;
    private String token;
    private String source;

    private ThankAction() {
        apiUrl.setAction("thank");
    }

    @Override
    public FormBody getPostBody() {
        return new FormBody.Builder()
                .add("action", "thank")
                .add("token", token)
                .build();
    }

    public static class Builder extends AbstractBuilder {

        private final ThankAction thankAction = new ThankAction();

        /**
         * Revision ID to thank someone for. This or 'log' must be provided.
         * @param rev The value must be no less than 1.
         * @return {@code Builder}
         */
        public Builder rev(int rev) {
            thankAction.rev = rev;
            thankAction.apiUrl.putQuery("rev", rev);
            return this;
        }

        /**
         * Log ID to thank someone for. This or 'rev' must be provided.
         * @param log The value must be no less than 1.
         * @return {@code Builder}
         */
        public Builder log(int log) {
            thankAction.log = log;
            thankAction.apiUrl.putQuery("log", log);
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
            thankAction.apiUrl.putQuery("token", token);
            return this;
        }

        /**
         * A short string describing the source of the request, for example {@code diff} or {@code history}.
         * @return {@code Builder}
         */
        public Builder source(String source) {
            thankAction.source = source;
            thankAction.apiUrl.putQuery("source", source);
            return this;
        }

        public ThankAction build() {
            if (thankAction.token == null)
                throw new IllegalArgumentException("Parameter 'token' is required");

            return thankAction;
        }

    }
}
