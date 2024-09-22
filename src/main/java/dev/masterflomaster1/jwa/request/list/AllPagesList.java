package dev.masterflomaster1.jwa.request.list;

import dev.masterflomaster1.jwa.common.Dir;
import dev.masterflomaster1.jwa.common.FilterRedir;
import dev.masterflomaster1.jwa.common.Namespace;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.EnumSet;
import java.util.stream.Collectors;

/**
 * Enumerate all pages sequentially in a given namespace.
 *
 * @see <a href="https://www.mediawiki.org/wiki/Special:MyLanguage/API:Allpages">API:Allpages</a>
 */
@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@SuppressWarnings("SpellCheckingInspection")
public final class AllPagesList extends AbstractList {

    private String apFrom;
    private String apContinue;
    private String apTo;
    private String apPrefix;
    private Namespace apNamespace;
    private FilterRedir apFilterRedir;
    private ApFilterLangLinks apFilterLangLinks;
    private int apMinSize;
    private int apMaxSize;
    private EnumSet<ApPrType> apPrType;
    private EnumSet<ApPrLevel> apPrLevel;
    private ApPrFilterCascade apPrFilterCascade;
    private ApPrExpiry apPrExpiry;
    private int apLimit;
    private Dir.Order apDir;

    private AllPagesList() {
        name = "allpages";
    }

    public static class Builder {

        private final AllPagesList allPagesList = new AllPagesList();

        /**
         * The page title to start enumerating from.
         * @return {@code Builder}
         */
        public Builder apFrom(final String apFrom) {
            allPagesList.apFrom = apFrom;
            allPagesList.apiUrl.putQuery("apfrom", apFrom);
            return this;
        }

        /**
         * When more results are available, use this to continue.
         * More detailed information on how to continue queries can be found on
         * <a href="https://www.mediawiki.org/wiki/API:Continue">mediawiki.org</a>.
         * @return {@code Builder}
         */
        public Builder apContinue(final String apContinue) {
            allPagesList.apContinue = apContinue;
            allPagesList.apiUrl.putQuery("apcontinue", apContinue);
            return this;
        }

        /**
         * The page title to stop enumerating at.
         * @return {@code Builder}
         */
        public Builder apTo(final String apTo) {
            allPagesList.apTo = apTo;
            allPagesList.apiUrl.putQuery("apto", apTo);
            return this;
        }

        /**
         * Search for all page titles that begin with this value.
         * @return {@code Builder}
         */
        public Builder apPrefix(final String apPrefix) {
            allPagesList.apPrefix = apPrefix;
            allPagesList.apiUrl.putQuery("apprefix", apPrefix);
            return this;
        }

        /**
         * The namespace to enumerate.
         * @return {@code Builder}
         */
        public Builder apNamespace(final Namespace apNamespace) {
            allPagesList.apNamespace = apNamespace;
            allPagesList.apiUrl.putQuery("apnamespace", apNamespace.getValue());
            return this;
        }

        /**
         * Which pages to list.
         * @return {@code Builder}
         */
        public Builder apFilterRedir(final FilterRedir apFilterRedir) {
            allPagesList.apFilterRedir = apFilterRedir;
            allPagesList.apiUrl.putQuery("apfilterredir", apFilterRedir.getValue());
            return this;
        }

        /**
         * Filter based on whether a page has langlinks. Note that this may not consider langlinks added by extensions.
         * @return {@code Builder}
         */
        public Builder apFilterLangLinks(final ApFilterLangLinks apFilterLangLinks) {
            allPagesList.apFilterLangLinks = apFilterLangLinks;
            allPagesList.apiUrl.putQuery("apfilterlanglinks", apFilterLangLinks.getValue());
            return this;
        }

        /**
         * Limit to pages with at least this many bytes.
         * @return {@code Builder}
         */
        public Builder apMinSize(final int apMinSize) {
            allPagesList.apMinSize = apMinSize;
            allPagesList.apiUrl.putQuery("apminsize", apMinSize);
            return this;
        }

        /**
         * Limit to pages with at most this many bytes.
         * @return {@code Builder}
         */
        public Builder apMaxSize(final int apMaxSize) {
            allPagesList.apMaxSize = apMaxSize;
            allPagesList.apiUrl.putQuery("apmaxsize", apMaxSize);
            return this;
        }

        /**
         * Limit to protected pages only.
         * @return {@code Builder}
         */
        public Builder apPrType(final EnumSet<ApPrType> apPrType) {
            allPagesList.apPrType = apPrType;
            allPagesList.apiUrl.putQuery("apprtype", apPrType.stream()
                    .map(ApPrType::getValue)
                    .collect(Collectors.joining("|")));
            return this;
        }

        /**
         * Filter protections based on protection level (must be used with apprtype= parameter).
         * @return {@code Builder}
         */
        public Builder apPrLevel(final EnumSet<ApPrLevel> apPrLevel) {
            allPagesList.apPrLevel = apPrLevel;
            allPagesList.apiUrl.putQuery("apprlevel", apPrLevel.stream()
                    .map(ApPrLevel::getValue)
                    .collect(Collectors.joining("|")));
            return this;
        }

        /**
         * Filter protections based on cascadingness (ignored when apprtype isn't set).
         * @return {@code Builder}
         */
        public Builder apPrFilterCascade(final ApPrFilterCascade apPrFilterCascade) {
            allPagesList.apPrFilterCascade = apPrFilterCascade;
            allPagesList.apiUrl.putQuery("apprfiltercascade", apPrFilterCascade.getValue());
            return this;
        }

        /**
         * Which protection expiry to filter the page on.
         * @return {@code Builder}
         */
        public Builder apPrExpiry(final ApPrExpiry apPrExpiry) {
            allPagesList.apPrExpiry = apPrExpiry;
            allPagesList.apiUrl.putQuery("apprexpiry", apPrExpiry.getValue());
            return this;
        }

        /**
         * How many images in total to return.
         * @param apLimit The value must be between 1 and 500.
         * @return {@code Builder}
         */
        public Builder apLimit(final int apLimit) {
            allPagesList.apLimit = apLimit;
            allPagesList.apiUrl.putQuery("aplimit", apLimit);
            return this;
        }

        /**
         * The direction in which to list.
         * @return {@code Builder}
         */
        public Builder apDir(final Dir.Order apDir) {
            allPagesList.apDir = apDir;
            allPagesList.apiUrl.putQuery("apdir", apDir.getValue());
            return this;
        }

        public AllPagesList build() {
            return allPagesList;
        }

    }

    @Getter
    public enum ApFilterLangLinks {

        ALL("all"),
        WITH_LANG_LINKS("withlanglinks"),
        WITHOUT_LANG_LINKS("withoutlanglinks");

        private final String value;

        ApFilterLangLinks(String value) {
            this.value = value;
        }

    }

    @Getter
    public enum ApPrType {

        EDIT("edit"),
        MOVE("move"),
        UPLOAD("upload");

        private final String value;

        ApPrType(String value) {
            this.value = value;
        }

    }

    @Getter
    public enum ApPrLevel {

        EMPTY(" "),
        AUTO_CONFIRMED("autoconfirmed"),
        EXTENDED_CONFIRMED("extendedconfirmed"),
        SYSOP("sysop"),
        TEMPLATE_EDITOR("templateeditor");

        private final String value;

        ApPrLevel(String value) {
            this.value = value;
        }

    }

    @Getter
    public enum ApPrFilterCascade {

        ALL("all"),
        CASCADING("cascading"),
        NON_CASCADING("noncascading");

        private final String value;

        ApPrFilterCascade(String value) {
            this.value = value;
        }

    }

    @Getter
    public enum ApPrExpiry {

        /**
         * Get pages with any protections expiry.
         */
        ALL("all"),

        /**
         * Get only pages with a definite (specific) protection expiry.
         */
        DEFINITE("definite"),

        /**
         * Get only pages with indefinite protection expiry.
         */
        INDEFINITE("indefinite");

        private final String value;

        ApPrExpiry(String value) {
            this.value = value;
        }

    }

}
