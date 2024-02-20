package dev.masterflomaster1.jwa.request.meta;

public class TokensMeta extends AbstractMeta {

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

        private String value;

        Type(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

}
