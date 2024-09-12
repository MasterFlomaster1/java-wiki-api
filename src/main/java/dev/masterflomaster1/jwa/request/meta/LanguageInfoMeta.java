package dev.masterflomaster1.jwa.request.meta;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.EnumSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Return information about available languages.
 */
@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@SuppressWarnings("SpellCheckingInspection")
public final class LanguageInfoMeta extends AbstractMeta {

    private EnumSet<LiProp> liProp;
    private Set<String> liCode;
    private String liContinue;

    private LanguageInfoMeta() {
        name = "languageinfo";
    }

    public static class Builder {

        private final LanguageInfoMeta languageInfoMeta = new LanguageInfoMeta();

        /**
         * Which information to get for each language.
         * @return {@code Builder}
         */
        public Builder liProp(EnumSet<LiProp> liProp) {
            languageInfoMeta.liProp = liProp;
            languageInfoMeta.apiUrl.putQuery("liprop", liProp.stream()
                    .map(LiProp::getValue)
                    .collect(Collectors.joining("|")));
            return this;
        }

        /**
         * Language codes of the languages that should be returned, or {@code *} for all languages.
         * @param liCode Maximum number of values is 50 (500 for clients that are allowed higher limits).
         * @return {@code Builder}
         */
        public Builder liCode(Set<String> liCode) {
            languageInfoMeta.liCode = liCode;
            languageInfoMeta.apiUrl.putQuery("licode", String.join("|", liCode));
            return this;
        }

        /**
         * When more results are available, use this to continue.
         * More detailed information on how to continue queries can be found on
         * <a href="https://www.mediawiki.org/wiki/API:Continue">mediawiki.org</a>.
         * @return {@code Builder}
         */
        public Builder liContinue(String liContinue) {
            languageInfoMeta.liContinue = liContinue;
            languageInfoMeta.apiUrl.putQuery("licontinue", liContinue);
            return this;
        }

        public LanguageInfoMeta build() {
            return languageInfoMeta;
        }

    }

    @Getter
    public enum LiProp {

        /**
         * The autonym of the language, that is, the name in that language.
         */
        AUTONYM ("autonym"),

        /**
         * The BCP-47 language code.
         */
        BCP47 ("bcp47"),

        /**
         * The language code. (This code is MediaWiki-specific, though there are overlaps with other standards.)
         */
        CODE ("code"),

        /**
         * The writing direction of the language (either {@code ltr} or {@code rtl}).
         */
        DIR ("dir"),

        /**
         * The language codes of the fallback languages configured for this language. The implicit final fallback to
         * 'en' is not included (but some languages may fall back to 'en' explicitly).
         */
        FALLBACKS ("fallbacks"),

        /**
         * The name of the language in the language specified by the {@code uselang} parameter, with language fallbacks
         * applied if necessary.
         */
        NAME ("name"),

        /**
         * The short names for language variants used for language conversion links.
         */
        VARIANT_NAMES ("variantnames"),

        /**
         * The language codes of the variants supported by this language.
         */
        VARIANTS ("variants");

        final String value;

        LiProp(String value) {
            this.value = value;
        }

    }

}
