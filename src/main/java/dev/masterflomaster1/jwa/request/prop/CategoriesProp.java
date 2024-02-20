package dev.masterflomaster1.jwa.request.prop;

import dev.masterflomaster1.jwa.common.Dir;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * List all categories the pages belong to.
 *
 * @see <a href="https://www.mediawiki.org/wiki/API:Categories">API:Categories</a>
 */
public class CategoriesProp extends AbstractProp {

    private Set<ClProp> clProp;
    private ClShow clShow;
    private int clLimit;
    private Dir clDir;

    private CategoriesProp() {
        url += "&prop=categories";
    }

    public Set<ClProp> getClProp() {
        return clProp;
    }

    public ClShow getClShow() {
        return clShow;
    }

    public int getClLimit() {
        return clLimit;
    }

    public Dir getClDir() {
        return clDir;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CategoriesProp that = (CategoriesProp) o;

        if (clLimit != that.clLimit) return false;
        if (!Objects.equals(clProp, that.clProp)) return false;
        if (clShow != that.clShow) return false;
        return clDir == that.clDir;
    }

    @Override
    public int hashCode() {
        return Objects.hash(clProp, clShow, clLimit, clDir);
    }

    /**
     * Which additional properties to get for each category:
     */
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

        public String getValue() {
            return value;
        }
    }

    /**
     * Which kind of categories to show.
     */
    public enum ClShow {
        HIDDEN ("hidden"),
        UNHIDDEN ("!hidden");

        private final String value;

        ClShow(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public static class Builder {

        private final CategoriesProp categoriesProp = new CategoriesProp();

        /**
         * Which additional properties to get for each category
         * @return {@code Builder}
         */
        public Builder clProp(Set<ClProp> clProp) {
            categoriesProp.clProp = clProp;
            categoriesProp.url += "&clProp=" + clProp.stream()
                    .map(ClProp::getValue)
                    .collect(Collectors.joining("%7C"));
            return this;
        }

        /**
         * Which kind of categories to show.
         * @return {@code Builder}
         */
        public Builder clShow(ClShow clShow) {
            categoriesProp.clShow = clShow;
            categoriesProp.url += "&clshow=" + clShow.value;
            return this;
        }

        /**
         * How many categories to return. The value must be between 1 and 500.
         * @return {@code Builder}
         */
        public Builder clLimit(int clLimit) {
            categoriesProp.clLimit = clLimit;
            categoriesProp.url += "&cllimit=" + clLimit;
            return this;
        }

        /**
         * The direction in which to list.
         * @return {@code Builder}
         */
        public Builder clDir(Dir clDir) {
            categoriesProp.clDir = clDir;
            categoriesProp.url += "&cldir=" + clDir.getValue();
            return this;
        }

        public CategoriesProp build() {
            return categoriesProp;
        }

    }

}
