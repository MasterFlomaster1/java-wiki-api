package dev.masterflomaster1.jwa.request.prop;

import dev.masterflomaster1.jwa.common.Protocol;
import dev.masterflomaster1.jwa.request.AbstractBuilder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * Returns all external URLs (not interwikis) from the given pages.
 *
 * @see <a href="https://www.mediawiki.org/wiki/API:Extlinks">API:Extlinks</a>
 */
@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@SuppressWarnings("SpellCheckingInspection")
public final class ExtLinksProp extends AbstractProp {

    private int elLimit;
    private String elContinue;
    private Protocol elProtocol;
    private String elQuery;

    private ExtLinksProp() {
        super("extlinks");
    }

    public static class Builder extends AbstractBuilder {

        private final ExtLinksProp extLinksProp = new ExtLinksProp();

        /**
         * How many links to return.
         * @param elLimit The value must be between 1 and 500.
         * @return {@code Builder}
         */
        public Builder elLimit(int elLimit) {
            extLinksProp.elLimit = elLimit;
            extLinksProp.apiUrl.putQuery("ellimit", elLimit);
            return this;
        }

        /**
         * When more results are available, use this to continue.
         * More detailed information on how to continue queries can be found on
         * <a href="https://www.mediawiki.org/wiki/API:Continue">mediawiki.org</a>.
         * @return {@code Builder}
         */
        public Builder elContinue(String elContinue) {
            extLinksProp.elContinue = elContinue;
            extLinksProp.apiUrl.putQuery("elcontinue", elContinue);
            return this;
        }

        /**
         * Protocol of the URL. If empty and {@code elquery} is set, the protocol is {@code http} and {@code https}.
         * Leave both this and {@code elquery} empty to list all external links.
         * @return {@code Builder}
         */
        public Builder elProtocol(Protocol elProtocol) {
            extLinksProp.elProtocol = elProtocol;
            extLinksProp.apiUrl.putQuery("elprotocol", elProtocol.getValue());
            return this;
        }

        /**
         * Search string without protocol. Useful for checking whether a certain page contains a certain external url.
         * @return {@code Builder}
         */
        public Builder elQuery(String elQuery) {
            extLinksProp.elQuery = elQuery;
            extLinksProp.apiUrl.putQuery("elquery", elQuery);
            return this;
        }

        public ExtLinksProp build() {
            return extLinksProp;
        }

    }

}
