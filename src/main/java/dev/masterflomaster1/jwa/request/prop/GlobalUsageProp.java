package dev.masterflomaster1.jwa.request.prop;

import dev.masterflomaster1.jwa.common.Namespace;
import dev.masterflomaster1.jwa.internal.EnumValueProvider;
import dev.masterflomaster1.jwa.request.AbstractBuilder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.EnumSet;

/**
 * Returns global image usage for a certain image.
 *
 * @see <a href="https://www.mediawiki.org/w/api.php?action=help&modules=query%2Bglobalusage">www.mediawiki.org</a>
 */
@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@SuppressWarnings("SpellCheckingInspection")
public final class GlobalUsageProp extends AbstractProp {

    private EnumSet<GuProp> guProp;
    private int guLimit;
    private EnumSet<Namespace> guNamespace;
    private String guContinue;
    private boolean guFilterLocal;

    private GlobalUsageProp() {
        super("globalusage");
    }

    public static class Builder extends AbstractBuilder {

        private final GlobalUsageProp globalUsageProp = new GlobalUsageProp();

        /**
         * Which properties to return.
         * @return {@code Builder}
         */
        public Builder guProp(EnumSet<GuProp> guProp) {
            globalUsageProp.guProp = guProp;
            globalUsageProp.apiUrl.putQuery("guprop", merge(guProp));
            return this;
        }

        /**
         * How many links to return.
         * @param guLimit The value must be between 1 and 500.
         * @return {@code Builder}
         */
        public Builder guLimit(int guLimit) {
            globalUsageProp.guLimit = guLimit;
            globalUsageProp.apiUrl.putQuery("gulimit", guLimit);
            return this;
        }

        /**
         * Limit results to these namespaces.
         * @return {@code Builder}
         */
        public Builder guNamespace(EnumSet<Namespace> guNamespace) {
            globalUsageProp.guNamespace = guNamespace;
            globalUsageProp.apiUrl.putQuery("gunamespace", merge(guNamespace));
            return this;
        }

        /**
         * When more results are available, use this to continue.
         * More detailed information on how to continue queries can be found on
         * <a href="https://www.mediawiki.org/wiki/API:Continue">mediawiki.org</a>.
         * @return {@code Builder}
         */
        public Builder guContinue(String guContinue) {
            globalUsageProp.guContinue = guContinue;
            globalUsageProp.apiUrl.putQuery("gucontinue", guContinue);
            return this;
        }

        /**
         * Filter local usage of the file.
         * @return {@code Builder}
         */
        public Builder guFilterLocal() {
            globalUsageProp.guFilterLocal = true;
            globalUsageProp.apiUrl.putQuery("gufilterlocal", "1");
            return this;
        }

        public GlobalUsageProp build() {
            return globalUsageProp;
        }

    }

    @Getter
    public enum GuProp implements EnumValueProvider {
        NAMESPACE ("namespace"),
        PAGE_ID ("pageid"),
        URL ("url");

        private final String value;

        GuProp(String value) {
            this.value = value;
        }

    }

}
