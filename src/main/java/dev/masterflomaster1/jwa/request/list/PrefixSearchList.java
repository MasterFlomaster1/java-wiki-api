package dev.masterflomaster1.jwa.request.list;

import dev.masterflomaster1.jwa.common.Namespace;
import dev.masterflomaster1.jwa.internal.EnumValueProvider;
import dev.masterflomaster1.jwa.request.AbstractBuilder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.EnumSet;

/**
 * Perform a prefix search for page titles.
 * <p>
 * Despite the similarity in names, this module is not intended to be equivalent to Special:PrefixIndex; for that,
 * see action=query&list=allpages with the apprefix parameter. The purpose of this module is similar to
 * action=opensearch: to take user input and provide the best-matching titles. Depending on the search engine backend,
 * this might include typo correction, redirect avoidance, or other heuristics.
 *
 * @see <a href="https://www.mediawiki.org/wiki/API:Prefixsearch">API:Prefixsearch</a>
 */
@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@SuppressWarnings("SpellCheckingInspection")
public final class PrefixSearchList extends AbstractList {

    private String psSearch;
    private EnumSet<Namespace> psNamespace;
    private int psLimit;
    private int psOffset;
    private PsProfile psProfile;

    private PrefixSearchList() {
        super("prefixsearch");
    }

    public static class Builder extends AbstractBuilder {

        private final PrefixSearchList prefixSearchList = new PrefixSearchList();

        /**
         * Search string. This parameter is required.
         * @return {@code Builder}
         */
        public Builder psSearch(final String psSearch) {
            prefixSearchList.psSearch = psSearch;
            prefixSearchList.apiUrl.putQuery("pssearch", psSearch);
            return this;
        }

        /**
         * Namespaces to search. Ignored if {@code pssearch} begins with a valid namespace prefix.
         * @return {@code Builder}
         */
        public Builder psNamespace(final EnumSet<Namespace> psNamespace) {
            prefixSearchList.psNamespace = psNamespace;
            prefixSearchList.apiUrl.putQuery("psnamespace", merge(psNamespace));
            return this;
        }

        /**
         * How many total changes to return. Default: 10
         * @param psLimit The value must be between 1 and 500.
         * @return {@code Builder}
         */
        public Builder psLimit(final int psLimit) {
            prefixSearchList.psLimit = psLimit;
            prefixSearchList.apiUrl.putQuery("pslimit", psLimit);
            return this;
        }

        /**
         * When more results are available, use this to continue. More detailed information on how to continue queries
         * <a href="https://www.mediawiki.org/wiki/Special:MyLanguage/API:Continue">can be found on mediawiki.org</a>.
         * @param psOffset The value must be no less than 0.
         * @return {@code Builder}
         */
        public Builder psOffset(final int psOffset) {
            prefixSearchList.psOffset = psOffset;
            prefixSearchList.apiUrl.putQuery("psoffset", psOffset);
            return this;
        }

        /**
         * Search profile to use.
         * @return {@code Builder}
         */
        public Builder psProfile(final PsProfile psProfile) {
            prefixSearchList.psProfile = psProfile;
            prefixSearchList.apiUrl.putQuery("psprofile", psProfile.getValue());
            return this;
        }

        public PrefixSearchList build() {
            if (prefixSearchList.psSearch == null)
                throw new IllegalArgumentException("Parameter 'pssearch' is required");

            return prefixSearchList;
        }

    }

    @Getter
    public enum PsProfile implements EnumValueProvider {

        /**
         * Classic prefix, few punctuation characters and some diacritics removed.
         */
        CLASSIC("classic"),

        /**
         * Let the search engine decide on the best profile to use.
         */
        ENGINE_AUTOSELECT("engine_autoselect"),

        /**
         * Experimental fuzzy profile (may be removed at any time)
         */
        FAST_FUZZY("fast-fuzzy"),

        /**
         * Similar to normal with typo correction (two typos supported).
         */
        FUZZY("fuzzy"),

        /**
         * Few punctuation characters, some diacritics and stopwords removed.
         */
        NORMAL("normal"),

        /**
         * Strict profile with few punctuation characters removed but diacritics and stress marks are kept.
         */
        STRICT("strict");

        private final String value;

        PsProfile(String value) {
            this.value = value;
        }

    }

}
