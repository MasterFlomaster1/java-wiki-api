package dev.masterflomaster1.jwa.request.action;

import dev.masterflomaster1.jwa.WikiApiSyntaxException;

/**
 * Check the validity of a token from {@code action=query&meta=tokens}.
 *
 * @see <a href="https://www.mediawiki.org/wiki/Special:MyLanguage/API:Checktoken">API:Checktoken</a>
 */
public class CheckTokenAction extends AbstractAction {

    private Type type;
    private String token;
    private int maxTokenAge;

    private CheckTokenAction() {
        apiUrl.setAction("checktoken");
    }

    public Type getType() {
        return type;
    }

    public String getToken() {
        return token;
    }

    public int getMaxTokenAge() {
        return maxTokenAge;
    }

    public static class Builder {

        private final CheckTokenAction checkTokenAction = new CheckTokenAction();

        /**
         * Type of token being tested. This parameter is required.
         * @return {@code Builder}
         */
        public Builder type(Type type) {
            checkTokenAction.type = type;
            checkTokenAction.apiUrl.putQuery("type", type.getValue());
            return this;
        }

        /**
         * Token to test. This parameter is required.
         * @return {@code Builder}
         */
        public Builder token(String token) {
            checkTokenAction.token = token;
            checkTokenAction.apiUrl.putQuery("token", token);
            return this;
        }

        /**
         * Maximum allowed age of the token, in seconds.
         * @return {@code Builder}
         */
        public Builder maxTokenAge(int maxTokenAge) {
            checkTokenAction.maxTokenAge = maxTokenAge;
            checkTokenAction.apiUrl.putQuery("maxtokenage", maxTokenAge);
            return this;
        }

        public CheckTokenAction build() throws WikiApiSyntaxException {
            if (checkTokenAction.type == null)
                throw new WikiApiSyntaxException("Parameter 'type' is required");

            if (checkTokenAction.token == null)
                throw new WikiApiSyntaxException("Parameter 'token' is required");

            return checkTokenAction;
        }

    }

    public enum Type {

        CREATE_ACCOUNT ("createaccount"),
        CSRF ("csrf"),
        DELETE_GLOBAL_ACCOUNT ("deleteglobalaccount"),
        LOGIN ("login"),
        PATROL ("patrol"),
        ROLLBACK ("rollback"),
        SET_GLOBAL_ACCOUNT_STATUS ("setglobalaccountstatus"),
        USER_RIGHTS ("userrights"),
        WATCH ("watch");

        private final String value;

        Type(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

    }

}
