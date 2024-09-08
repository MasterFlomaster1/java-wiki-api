package dev.masterflomaster1.jwa.request.meta;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Gets tokens for data-modifying actions.
 *
 * @see <a href="https://www.mediawiki.org/wiki/API:Tokens">API:Tokens</a>
 */
@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
public final class TokensMeta extends AbstractMeta {

    private Set<Type> type;

    private TokensMeta() {
        name = "tokens";
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

    @Getter
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

    }

}
