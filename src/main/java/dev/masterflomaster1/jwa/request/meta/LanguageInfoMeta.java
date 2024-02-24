package dev.masterflomaster1.jwa.request.meta;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Return information about available languages.
 */
public class LanguageInfoMeta extends AbstractMeta {

    private Set<LiProp> liProp;
    private Set<String> liCode;
    private String liContinue;

    private LanguageInfoMeta() {
        url = "&meta=languageinfo";
    }

    public Set<LiProp> getLiProp() {
        return liProp;
    }

    public Set<String> getLiCode() {
        return liCode;
    }

    public String getLiContinue() {
        return liContinue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LanguageInfoMeta that = (LanguageInfoMeta) o;

        if (!Objects.equals(liProp, that.liProp)) return false;
        if (!Objects.equals(liCode, that.liCode)) return false;
        return Objects.equals(liContinue, that.liContinue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(liProp, liCode, liContinue);
    }

    public static class Builder {

        private final LanguageInfoMeta languageInfoMeta = new LanguageInfoMeta();

        /**
         * Which information to get for each language.
         * @return {@code Builder}
         */
        public Builder liProp(Set<LiProp> liProp) {
            languageInfoMeta.liProp = liProp;
            languageInfoMeta.url += "&liprop=" + liProp.stream()
                    .map(LiProp::getValue)
                    .collect(Collectors.joining("%7C"));
            return this;
        }

        /**
         * Language codes of the languages that should be returned, or {@code *} for all languages.
         * @param liCode Maximum number of values is 50 (500 for clients that are allowed higher limits).
         * @return {@code Builder}
         */
        public Builder liCode(Set<String> liCode) {
            languageInfoMeta.liCode = liCode;
            languageInfoMeta.url += "&licode=" + liCode.stream()
                    .map(str -> URLEncoder.encode(str, StandardCharsets.UTF_8))
                    .collect(Collectors.joining("%7C"));
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
            languageInfoMeta.url += "&licontinue=" + URLEncoder.encode(liContinue, StandardCharsets.UTF_8);
            return this;
        }

        public LanguageInfoMeta build() {
            return languageInfoMeta;
        }

    }

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

        public String getValue() {
            return value;
        }

    }

}
