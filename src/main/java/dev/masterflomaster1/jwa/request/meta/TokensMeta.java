package dev.masterflomaster1.jwa.request.meta;

import dev.masterflomaster1.jwa.internal.EnumValueProvider;
import dev.masterflomaster1.jwa.request.AbstractBuilder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.EnumSet;

/**
 * Gets tokens for data-modifying actions.
 *
 * @see <a href="https://www.mediawiki.org/wiki/API:Tokens">API:Tokens</a>
 */
@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@SuppressWarnings("SpellCheckingInspection")
public final class TokensMeta extends AbstractMeta {

    private EnumSet<Type> type;

    private TokensMeta() {
        super("tokens");
    }

    public static class Builder extends AbstractBuilder {

        private final TokensMeta tokensMeta = new TokensMeta();

        /**
         * Types of token to request.
         * @return {@code Builder}
         */
        public Builder type(EnumSet<Type> type) {
            tokensMeta.type = type;
            tokensMeta.apiUrl.putQuery("type", merge(type));
            return this;
        }

        public TokensMeta build() {
            return tokensMeta;
        }

    }

    @Getter
    public enum Type implements EnumValueProvider {

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
