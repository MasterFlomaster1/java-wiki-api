package dev.masterflomaster1.jwa.request.action;

import lombok.Getter;
import lombok.ToString;
import okhttp3.FormBody;

/**
 * Validate a password against the wiki's password policies.
 * Validity is reported as {@code Good} if the password is acceptable, {@code Change} if the password may be used for
 * login but must be changed, or {@code Invalid} if the password is not usable.
 *
 * @see <a href="https://www.mediawiki.org/wiki/API:Validatepassword">API:Validatepassword</a>
 */
@Getter
@ToString
@SuppressWarnings("SpellCheckingInspection")
public final class ValidatePasswordAction extends AbstractAction implements IPost {

    private String password;
    private String user;
    private String email;
    private String realName;

    private ValidatePasswordAction() {
        apiUrl.setAction("validatepassword");
    }

    @Override
    public FormBody getPostBody() {
        return new FormBody.Builder()
                .add("action", "validatepassword")
                .add("password", password)
                .build();
    }

    public static class Builder {

        private final ValidatePasswordAction validatePasswordAction = new ValidatePasswordAction();

        /**
         * Password to validate.
         * @param password This parameter is required.
         * @return {@code Builder}
         */
        public Builder password(String password) {
            validatePasswordAction.password = password;
            return this;
        }

        /**
         * Username, for use when testing account creation. The named user must not exist.
         * @param user user, by any of username and user ID (e.g. "#12345")
         * @return {@code Builder}
         */
        public Builder user(String user) {
            validatePasswordAction.user = user;
            validatePasswordAction.apiUrl.putQuery("user", user);
            return this;
        }

        /**
         * Email address, for use when testing account creation.
         * @return {@code Builder}
         */
        public Builder email(String email) {
            validatePasswordAction.email = email;
            validatePasswordAction.apiUrl.putQuery("email", email);
            return this;
        }

        /**
         * Real name, for use when testing account creation.
         * @return {@code Builder}
         */
        public Builder realName(String realName) {
            validatePasswordAction.realName = realName;
            validatePasswordAction.apiUrl.putQuery("realname", realName);
            return this;
        }

        public ValidatePasswordAction build() {
            if (validatePasswordAction.password == null)
                throw new IllegalArgumentException("Parameter 'password' is required");

            return validatePasswordAction;
        }

    }

}
