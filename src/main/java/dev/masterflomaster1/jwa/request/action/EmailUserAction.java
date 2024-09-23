package dev.masterflomaster1.jwa.request.action;

import dev.masterflomaster1.jwa.request.AbstractBuilder;
import lombok.Getter;
import lombok.ToString;
import okhttp3.FormBody;

/**
 * Email a user.
 *
 * @see <a href="https://www.mediawiki.org/wiki/Special:MyLanguage/API:Email">API:Email</a>
 */
@Getter
@ToString
@SuppressWarnings("SpellCheckingInspection")
public final class EmailUserAction extends AbstractAction implements IPost {

    private String target;
    private String subject;
    private String text;
    private boolean ccMe;
    private String token;

    private EmailUserAction() {
        apiUrl.setAction("emailuser");
    }

    @Override
    public FormBody getPostBody() {
        return new FormBody.Builder()
                .add("token", token)
                .build();
    }

    public static class Builder extends AbstractBuilder {

        private final EmailUserAction emailUserAction = new EmailUserAction();

        /**
         * User to send the email to. This parameter is required.
         * @return {@code Builder}
         */
        public Builder target(String target) {
            emailUserAction.target = target;
            emailUserAction.apiUrl.putQuery("target", target);
            return this;
        }

        /**
         * Subject header. This parameter is required.
         * @return {@code Builder}
         */
        public Builder subject(String subject) {
            emailUserAction.subject = subject;
            emailUserAction.apiUrl.putQuery("subject", subject);
            return this;
        }

        /**
         * Email body. This parameter is required.
         * @return {@code Builder}
         */
        public Builder text(String text) {
            emailUserAction.text = text;
            emailUserAction.apiUrl.putQuery("text", text);
            return this;
        }

        /**
         * Send a copy of this mail to me.
         * @return {@code Builder}
         */
        public Builder ccMe() {
            emailUserAction.ccMe = true;
            emailUserAction.apiUrl.putQuery("ccme", "1");
            return this;
        }

        /**
         * A "csrf" token retrieved from
         * <a href="https://www.mediawiki.org/w/api.php?action=help&modules=query%2Btokens">action=query&meta=tokens</a>
         * This parameter is required.
         * @return {@code Builder}
         */
        public Builder token(String token) {
            emailUserAction.token = token;
            emailUserAction.apiUrl.putQuery("token", token);
            return this;
        }

        public EmailUserAction build() {
            if (emailUserAction.target == null)
                throw new IllegalArgumentException("Parameter 'target' is required");

            if (emailUserAction.subject == null)
                throw new IllegalArgumentException("Parameter 'subject' is required");

            if (emailUserAction.text == null)
                throw new IllegalArgumentException("Parameter 'text' is required");

            if (emailUserAction.token == null)
                throw new IllegalArgumentException("Parameter 'token' is required");

            return emailUserAction;
        }

    }

}
