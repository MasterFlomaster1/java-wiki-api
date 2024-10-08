package dev.masterflomaster1.jwa.request.list;

import dev.masterflomaster1.jwa.common.Dir;
import dev.masterflomaster1.jwa.common.Namespace;
import dev.masterflomaster1.jwa.internal.EnumValueProvider;
import dev.masterflomaster1.jwa.request.AbstractBuilder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.Instant;
import java.util.EnumSet;

/**
 * List all pages in a given category.
 *
 * @see <a href="https://www.mediawiki.org/wiki/API:Categorymembers">API:Categorymembers</a>
 */
@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@SuppressWarnings("SpellCheckingInspection")
public final class CategoryMembersList extends AbstractList {

    private String cmTitle;
    private int cmPageId;
    private EnumSet<CmProp> cmProp;
    private EnumSet<Namespace> cmNamespace;
    private EnumSet<CmType> cmType;
    private String cmContinue;
    private int cmLimit;
    private CmSort cmSort;
    private Dir.Mixed cmDir;
    private Instant cmStart;
    private Instant cmEnd;
    private String cmStartHexSortKey;
    private String cmEndHexSortKey;
    private String cmStartSortKeyPrefix;
    private String cmEndSortKeyPrefix;

    private CategoryMembersList() {
        super("categorymembers");
    }

    public static class Builder extends AbstractBuilder {

        private final CategoryMembersList categoryMembersList = new CategoryMembersList();

        /**
         * Which category to enumerate (required). Must include the {@code Category:} prefix. Cannot be used together
         * with cmpageid.
         * @return {@code Builder}
         */
        public Builder cmTitle(final String cmTitle) {
            categoryMembersList.cmTitle = cmTitle;
            categoryMembersList.apiUrl.putQuery("cmtitle", cmTitle);
            return this;
        }

        /**
         * Page ID of the category to enumerate. Cannot be used together with cmtitle.
         * @return {@code Builder}
         */
        public Builder cmPageId(final int cmPageId) {
            categoryMembersList.cmPageId = cmPageId;
            categoryMembersList.apiUrl.putQuery("cmpageid", cmPageId);
            return this;
        }

        /**
         * Which pieces of information to include
         * @return {@code Builder}
         */
        public Builder cmProp(final EnumSet<CmProp> cmProp) {
            categoryMembersList.cmProp = cmProp;
            categoryMembersList.apiUrl.putQuery("cmprop", merge(cmProp));
            return this;
        }

        /**
         * Only include pages in these namespaces. Note that {@code cmtype=subcat} or {@code cmtype=file} may be used
         * instead of {@code cmnamespace=14 or 6}.
         * @return {@code Builder}
         */
        public Builder cmNamespace(final EnumSet<Namespace> cmNamespace) {
            categoryMembersList.cmNamespace = cmNamespace;
            categoryMembersList.apiUrl.putQuery("cmnamespace", merge(cmNamespace));
            return this;
        }

        /**
         * Which type of category members to include. Ignored when {@code cmsort=timestamp} is set.
         * @return {@code Builder}
         */
        public Builder cmType(final EnumSet<CmType> cmType) {
            categoryMembersList.cmType = cmType;
            categoryMembersList.apiUrl.putQuery("cmtype", merge(cmType));
            return this;
        }

        /**
         * When more results are available, use this to continue.
         * More detailed information on how to continue queries can be found on
         * <a href="https://www.mediawiki.org/wiki/API:Continue">mediawiki.org</a>.
         * @return {@code Builder}
         */
        public Builder cmContinue(final String cmContinue) {
            categoryMembersList.cmContinue = cmContinue;
            categoryMembersList.apiUrl.putQuery("cmcontinue", cmContinue);
            return this;
        }

        /**
         * How many total changes to return. Default: 10
         * @param cmLimit The value must be between 1 and 500.
         * @return {@code Builder}
         */
        public Builder cmLimit(final int cmLimit) {
            categoryMembersList.cmLimit = cmLimit;
            categoryMembersList.apiUrl.putQuery("cmlimit", cmLimit);
            return this;
        }

        /**
         * Property to sort by.
         * @return {@code Builder}
         */
        public Builder cmSort(final CmSort cmSort) {
            categoryMembersList.cmSort = cmSort;
            categoryMembersList.apiUrl.putQuery("cmsort", cmSort.getValue());
            return this;
        }

        /**
         * In which direction to sort.
         * @return {@code Builder}
         */
        public Builder cmDir(final Dir.Mixed cmDir) {
            categoryMembersList.cmDir = cmDir;
            categoryMembersList.apiUrl.putQuery("cmdir", cmDir.getValue());
            return this;
        }

        /**
         * Timestamp to start listing from. Can only be used with {@code cmsort=timestamp}.
         * @return {@code Builder}
         */
        public Builder cmStart(final Instant cmStart) {
            categoryMembersList.cmStart = cmStart;
            categoryMembersList.apiUrl.putQuery("cmstart", cmStart.toString());
            return this;
        }

        /**
         * Timestamp to end listing at. Can only be used with {@code cmsort=timestamp}.
         * @return {@code Builder}
         */
        public Builder cmEnd(final Instant cmEnd) {
            categoryMembersList.cmEnd = cmEnd;
            categoryMembersList.apiUrl.putQuery("cmend", cmEnd.toString());
            return this;
        }

        /**
         * Sortkey to start listing from, as returned by {@code cmprop=sortkey}. Can only be used with
         * {@code cmsort=sortkey}.
         * @return {@code Builder}
         */
        public Builder cmStartHexSortKey(final String cmStartHexSortKey) {
            categoryMembersList.cmStartHexSortKey = cmStartHexSortKey;
            categoryMembersList.apiUrl.putQuery("cmstarthexsortkey", cmStartHexSortKey);
            return this;
        }

        /**
         * Sortkey to end listing at, as returned by {@code cmprop=sortkey}. Can only be used with
         * {@code cmsort=sortkey}.
         * @return {@code Builder}
         */
        public Builder cmEndHexSortKey(final String cmEndHexSortKey) {
            categoryMembersList.cmEndHexSortKey = cmEndHexSortKey;
            categoryMembersList.apiUrl.putQuery("cmendhexsortkey", cmEndHexSortKey);
            return this;
        }

        /**
         * Sortkey prefix to start listing from. Can only be used with {@code cmsort=sortkey}. Overrides
         * {@code cmstarthexsortkey}.
         * @return {@code Builder}
         */
        public Builder cmStartSortKeyPrefix(final String cmStartSortKeyPrefix) {
            categoryMembersList.cmStartSortKeyPrefix = cmStartSortKeyPrefix;
            categoryMembersList.apiUrl.putQuery("cmstartsortkeyprefix", cmStartSortKeyPrefix);
            return this;
        }

        /**
         * Sortkey prefix to end listing before (not at; if this value occurs it will not be included!). Can only be
         * used with {@code cmsort=sortkey}. Overrides {@code cmendhexsortkey}.
         * @return {@code Builder}
         */
        public Builder cmEndSortKeyPrefix(final String cmEndSortKeyPrefix) {
            categoryMembersList.cmEndSortKeyPrefix = cmEndSortKeyPrefix;
            categoryMembersList.apiUrl.putQuery("cmendsortkeyprefix", cmEndSortKeyPrefix);
            return this;
        }

        public CategoryMembersList build() {
            return categoryMembersList;
        }

    }

    @Getter
    public enum CmProp implements EnumValueProvider {

        IDS("ids"),
        TITLE("title"),
        SORT_KEY("sortkey"),
        SORT_KEY_PREFIX("sortkeyprefix"),
        TYPE("type"),
        TIMESTAMP("timestamp");

        private final String value;

        CmProp(String value) {
            this.value = value;
        }

    }

    @Getter
    public enum CmType implements EnumValueProvider {

        FILE("file"),
        PAGE("page"),
        SUBCAT("subcat");

        private final String value;

        CmType(String value) {
            this.value = value;
        }

    }

    @Getter
    public enum CmSort implements EnumValueProvider {

        SORT_KEY("sortkey"),
        TIMESTAMP("timestamp");

        private final String value;

        CmSort(String value) {
            this.value = value;
        }

    }

}
