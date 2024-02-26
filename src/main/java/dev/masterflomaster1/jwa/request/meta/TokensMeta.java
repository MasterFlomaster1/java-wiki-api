package dev.masterflomaster1.jwa.request.meta;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Gets tokens for data-modifying actions.
 *
 * @see <a href="https://www.mediawiki.org/wiki/API:Tokens">API:Tokens</a>
 */
public class TokensMeta extends AbstractMeta {

    private Set<Type> type;

    private TokensMeta() {
        name = "tokens";
    }

    public Set<Type> getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TokensMeta that = (TokensMeta) o;

        return type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }

    public static class Builder {

        private final TokensMeta tokensMeta = new TokensMeta();

        /**
         * Types of token to request.
         * @return {@code Builder}
         */
        public Builder type(Set<Type> type) {
            tokensMeta.type = type;
            tokensMeta.apiUrl.putQuery("type", type.stream()
                    .map(Type::getValue)
                    .collect(Collectors.joining("|")));
            return this;
        }

        public TokensMeta build() {
            return tokensMeta;
        }

    }

    public enum Type {

        ALL_VALUES ("*"),
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
