package dev.masterflomaster1.jwa.request.action;

import dev.masterflomaster1.jwa.internal.EnumValueProvider;
import dev.masterflomaster1.jwa.request.AbstractBuilder;
import lombok.Getter;
import lombok.ToString;

import java.util.EnumSet;

/**
 * Get Wikimedia sites list.
 *
 * @see <a href="https://www.mediawiki.org/wiki/Special:MyLanguage/API:Sitematrix">API:Sitematrix</a>
 */
@Getter
@ToString
@SuppressWarnings("SpellCheckingInspection")
public final class SiteMatrixAction extends AbstractAction {

    private EnumSet<SmType> smType;
    private EnumSet<SmState> smState;
    private EnumSet<SmLangProp> smLangProp;
    private EnumSet<SmSiteProp> smSiteProp;
    private int smLimit;
    private String smContinue;

    private SiteMatrixAction() {
        apiUrl.setAction("sitematrix");
    }

    public static class Builder extends AbstractBuilder {

        private final SiteMatrixAction siteMatrixAction = new SiteMatrixAction();

        /**
         * Filter the Site Matrix by type
         * @return {@code Builder}
         */
        public Builder smType(EnumSet<SmType> smType) {
            siteMatrixAction.smType = smType;
            siteMatrixAction.apiUrl.putQuery("smtype", merge(smType));
            return this;
        }

        /**
         * Filter the Site Matrix by wiki state.
         * @return {@code Builder}
         */
        public Builder smState(EnumSet<SmState> smState) {
            siteMatrixAction.smState = smState;
            siteMatrixAction.apiUrl.putQuery("smstate", merge(smState));
            return this;
        }

        /**
         * Which information about a language to return.
         * @return {@code Builder}
         */
        public Builder smLangProp(EnumSet<SmLangProp> smLangProp) {
            siteMatrixAction.smLangProp = smLangProp;
            siteMatrixAction.apiUrl.putQuery("smlangprop", merge(smLangProp));
            return this;
        }

        /**
         * Which information about a site to return.
         * @return {@code Builder}
         */
        public Builder smSiteProp(EnumSet<SmSiteProp> smSiteProp) {
            siteMatrixAction.smSiteProp = smSiteProp;
            siteMatrixAction.apiUrl.putQuery("smsiteprop", merge(smSiteProp));
            return this;
        }

        /**
         * Maximum number of results.
         * @param smLimit The value must be between 1 and 5000.
         * @return {@code Builder}
         */
        public Builder smLimit(int smLimit) {
            siteMatrixAction.smLimit = smLimit;
            siteMatrixAction.apiUrl.putQuery("smlimit", smLimit);
            return this;
        }

        /**
         * When more results are available, use this to continue.
         * More detailed information on how to continue queries can be found on
         * <a href="https://www.mediawiki.org/wiki/API:Continue">mediawiki.org</a>.
         * @return {@code Builder}
         */
        public Builder smContinue(String smContinue) {
            siteMatrixAction.smContinue = smContinue;
            siteMatrixAction.apiUrl.putQuery("smcontine", smContinue);
            return this;
        }

        public SiteMatrixAction build() {
            return siteMatrixAction;
        }

    }

    @Getter
    public enum SmType implements EnumValueProvider {

        /**
         * Wikimedia projects under this language code.
         */
        LANGUAGE ("language"),

        /**
         * One off and multilingual Wikimedia projects.
         */
        SPECIAL ("special");

        private final String value;

        SmType(String value) {
            this.value = value;
        }

    }

    @Getter
    public enum SmState implements EnumValueProvider {

        ALL ("all"),
        CLOSED ("closed"),
        FISHBOWL ("fishbowl"),
        NON_GLOBAL ("nonglobal"),
        PRIVATE ("private");

        private final String value;

        SmState(String value) {
            this.value = value;
        }

    }

    @Getter
    public enum SmLangProp implements EnumValueProvider {

        CODE ("code"),
        DIR ("dir"),
        LOCAL_NAME ("localname"),
        NAME ("name"),
        SITE ("site");

        private final String value;

        SmLangProp(String value) {
            this.value = value;
        }

    }

    @Getter
    public enum SmSiteProp implements EnumValueProvider {

        CODE ("code"),
        DB_NAME ("dbname"),
        LANG ("lang"),
        SITE_NAME ("sitename"),
        URL ("url");

        private final String value;

        SmSiteProp(String value) {
            this.value = value;
        }

    }

}
