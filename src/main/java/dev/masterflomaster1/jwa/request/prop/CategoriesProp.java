package dev.masterflomaster1.jwa.request.prop;

import dev.masterflomaster1.jwa.common.Dir;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * List all categories the pages belong to.
 *
 * @see <a href="https://www.mediawiki.org/wiki/API:Categories">API:Categories</a>
 */
@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@SuppressWarnings("SpellCheckingInspection")
public final class CategoriesProp extends AbstractProp {

    private Set<ClProp> clProp;
    private ClShow clShow;
    private int clLimit;
    private String clContinue;
    private Set<String> clCategories;
    private Dir clDir;

    private CategoriesProp() {
        name = "categories";
    }

    public static class Builder {

        private final CategoriesProp categoriesProp = new CategoriesProp();

        /**
         * Which additional properties to get for each category
         * @return {@code Builder}
         */
        public Builder clProp(Set<ClProp> clProp) {
            categoriesProp.clProp = clProp;
            categoriesProp.apiUrl.putQuery("clProp", clProp.stream()
                    .map(ClProp::getValue)
                    .collect(Collectors.joining("|")));
            return this;
        }

        /**
         * Which kind of categories to show.
         * @return {@code Builder}
         */
        public Builder clShow(ClShow clShow) {
            categoriesProp.clShow = clShow;
            categoriesProp.apiUrl.putQuery("clshow", clShow.value);
            return this;
        }

        /**
         * How many categories to return. The value must be between 1 and 500.
         * @return {@code Builder}
         */
        public Builder clLimit(int clLimit) {
            categoriesProp.clLimit = clLimit;
            categoriesProp.apiUrl.putQuery("cllimit", clLimit);
            return this;
        }

        /**
         * When more results are available, use this to continue.
         * More detailed information on how to continue queries can be found on
         * <a href="https://www.mediawiki.org/wiki/API:Continue">mediawiki.org</a>.
         * @return {@code Builder}
         */
        public Builder clContinue(String clContinue) {
            categoriesProp.clContinue = clContinue;
            categoriesProp.apiUrl.putQuery("clcontinue", clContinue);
            return this;
        }

        /**
         * Only list these categories. Useful for checking whether a certain page is in a certain category.
         * @param clCategories Maximum number of values is 50 (500 for clients that are allowed higher limits).
         * @return {@code Builder}
         */
        public Builder clCategories(Set<String> clCategories) {
            categoriesProp.clCategories = clCategories;
            categoriesProp.apiUrl.putQuery("clcategories", String.join("|", clCategories));
            return this;
        }

        /**
         * The direction in which to list.
         * @return {@code Builder}
         */
        public Builder clDir(Dir clDir) {
            categoriesProp.clDir = clDir;
            categoriesProp.apiUrl.putQuery("cldir", clDir.getValue());
            return this;
        }

        public CategoriesProp build() {
            return categoriesProp;
        }

    }

    /**
     * Which additional properties to get for each category:
     */
    @Getter
    public enum ClProp {

        /**
         * Tags categories that are hidden with {@code __HIDDENCAT__}.
         */
        HIDDEN ("hidden"),

        /**
         * Adds the sortkey (hexadecimal string) and sortkey prefix (human-readable part) for the category.
         */
        SORT_KEY ("sortkey"),

        /**
         * Adds timestamp of when the category was added.
         */
        TIMESTAMP ("timestamp");

        private final String value;

        ClProp(String value) {
            this.value = value;
        }

    }

    /**
     * Which kind of categories to show.
     */
    @Getter
    public enum ClShow {
        HIDDEN ("hidden"),
        UNHIDDEN ("!hidden");

        private final String value;

        ClShow(String value) {
            this.value = value;
        }

    }

}
