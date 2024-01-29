package dev.masterflomaster1.jwa.model;

import java.util.Set;

/**
 * List all categories the pages belong to.
 */
public class CategoriesProp extends AbstractProp {

    private Set<ClProp> clProp;

    private int clLimit;

    /**
     * Which additional properties to get for each category:
     */
    public enum ClProp {

        /**
         * Tags categories that are hidden with {@code __HIDDENCAT__}.
         */
        HIDDEN,

        /**
         * Adds the sortkey (hexadecimal string) and sortkey prefix (human-readable part) for the category.
         */
        SORT_KEY,

        /**
         * Adds timestamp of when the category was added.
         */
        TIMESTAMP
    }

    /**
     * The direction in which to list.
     */
    public enum ClDir {



    }

}
