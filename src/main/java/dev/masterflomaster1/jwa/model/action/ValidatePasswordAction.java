package dev.masterflomaster1.jwa.model.action;

import dev.masterflomaster1.jwa.WikiApiSyntaxException;

/**
 * Validate a password against the wiki's password policies.
 * Validity is reported as {@code Good} if the password is acceptable, {@code Change} if the password may be used for
 * login but must be changed, or {@code Invalid} if the password is not usable.
 *
 * @see <a href="https://www.mediawiki.org/wiki/API:Validatepassword">API:Validatepassword</a>
 */
public class ValidatePasswordAction extends AbstractAction {

    private String password;
    private String user;
    private String email;
    private String realName;

    private ValidatePasswordAction() {
        urlPart = "?action=validatepassword";
    }

    public String getPassword() {
        return password;
    }

    public String getUser() {
        return user;
    }

    public String getEmail() {
        return email;
    }

    public String getRealName() {
        return realName;
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
            validatePasswordAction.urlPart += "&password=" + password;
            return this;
        }

        /**
         * Username, for use when testing account creation. The named user must not exist.
         * @param user user, by any of username and user ID (e.g. "#12345")
         * @return {@code Builder}
         */
        public Builder user(String user) {
            validatePasswordAction.user = user;
            validatePasswordAction.urlPart += "&user=" + user;
            return this;
        }

        /**
         * Email address, for use when testing account creation.
         * @return {@code Builder}
         */
        public Builder email(String email) {
            validatePasswordAction.email = email;
            validatePasswordAction.urlPart += "&email=" + email;
            return this;
        }

        /**
         * Real name, for use when testing account creation.
         * @return {@code Builder}
         */
        public Builder realName(String realName) {
            validatePasswordAction.realName = realName;
            validatePasswordAction.urlPart += "&realname" + realName;
            return this;
        }

        public ValidatePasswordAction build() throws WikiApiSyntaxException {
            if (validatePasswordAction.password == null)
                throw new WikiApiSyntaxException("Parameter 'password' is required");

            return validatePasswordAction;
        }

    }

}
