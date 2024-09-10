package dev.masterflomaster1.jwa.common;

import lombok.Getter;

@Getter
@SuppressWarnings("SpellCheckingInspection")
public enum Generator {

    /**
     * Enumerate all categories.
     */
    ALL_CATEGORIES ("allcategories"),

    /**
     * List all deleted revisions by a user or in a namespace.
     */
    ALL_DELETED_REVISIONS ("alldeletedrevisions"),

    /**
     * List all file usages, including non-existing.
     */
    ALL_FILE_USAGES ("allfileusages"),

    /**
     * Enumerate all images sequentially.
     */
    ALL_IMAGES ("allimages"),

    /**
     * Enumerate all links that point to a given namespace.
     */
    ALL_LINKS ("alllinks"),

    /**
     * Enumerate all pages sequentially in a given namespace.
     */
    ALL_PAGES ("allpages"),

    /**
     * List all redirects to a namespace.
     */
    ALL_REDIRECTS ("allredirects"),

    /**
     * List all revisions.
     */
    ALL_REVISIONS ("allrevisions"),

    /**
     * List all transclusions (pages embedded using {{x}}), including non-existing.
     */
    ALL_TRANSCLUSIONS ("alltransclusions"),

    /**
     * Find all pages that link to the given page.
     */
    BACKLINKS ("backlinks"),

    /**
     * List all categories the pages belong to.
     */
    CATEGORIES ("categories"),

    /**
     * List all pages in a given category.
     */
    CATEGORY_MEMBERS ("categorymembers"),

    /**
     * Query Content Translation database for translations.
     */
    CONTENT_TRANSLATION ("contenttranslation"),

    /**
     * Get suggestion lists for Content Translation.
     */
    CONTENT_TRANSLATION_SUGGESTIONS ("contenttranslationsuggestions"),

    /**
     * Get deleted revision information.
     */
    DELETED_REVISIONS ("deletedrevisions"),

    /**
     * List all files that are duplicates of the given files based on hash values.
     */
    DUPLICATE_FILES ("duplicatefiles"),

    /**
     * Find all pages that embed (transclude) the given title.
     */
    EMBEDDED_IN ("embeddedin"),

    /**
     * Enumerate pages that contain a given URL.
     */
    EXT_URL_USAGE ("exturlusage"),

    /**
     * Find all pages that use the given files.
     */
    FILE_USAGE ("fileusage"),

    /**
     * Returns pages having coordinates that are located in a certain area.
     */
    GEO_SEARCH ("geosearch"),

    /**
     * Returns all files contained on the given pages.
     */
    IMAGES ("images"),

    /**
     * Find all pages that use the given image title.
     */
    IMAGE_USAGE ("imageusage"),

    /**
     * Find all pages that link to the given interwiki link.
     */
    IW_BACKLINKS ("iwbacklinks"),

    /**
     * Find all pages that link to the given language link.
     */
    LANG_BACKLINKS ("langbacklinks"),

    /**
     * Returns all links from the given pages.
     */
    LINKS ("links"),

    /**
     * Find all pages that link to the given pages.
     */
    LINK_SHARE ("linkshare"),

    /**
     * Lists the most viewed pages (based on last day's pageview count).
     */
    MOST_VIEWED ("mostviewed"),

    /**
     * Enumerates pages that have changes pending review.
     */
    OLD_REVIEWED_PAGES ("oldreviewedpages"),

    /**
     * List all pages using a given page property.
     */
    PAGES_WITH_PROP ("pageswithprop"),

    /**
     * Perform a prefix search for page titles.
     */
    PREFIX_SEARCH ("prefixsearch"),

    /**
     * List all pages associated with one or more projects.
     */
    PROJECT_PAGES ("projectpages"),

    /**
     * List all titles protected from creation.
     */
    PROTECTED_TITLES ("protectedtitles"),

    /**
     * Get a list provided by a QueryPage-based special page.
     */
    QUERY_PAGE ("querypage"),

    /**
     * Get a set of random pages.
     */
    RANDOM ("random"),

    /**
     * Enumerate recent changes.
     */
    RECENT_CHANGES ("recentchanges"),

    /**
     * Returns all redirects to the given pages.
     */
    REDIRECTS ("redirects"),

    /**
     * Get revision information.
     */
    REVISIONS ("revisions"),

    /**
     * Perform a full text search.
     */
    SEARCH ("search"),

    /**
     * Returns all pages transcluded on the given pages.
     */
    TEMPLATES ("templates"),

    /**
     * Find all pages that transclude the given pages.
     */
    TRANSCLUDED_IN ("transcludedin"),

    /**
     * Get recent changes to pages in the current user's watchlist.
     */
    WATCHLIST ("watchlist"),

    /**
     * Get all pages on the current user's watchlist.
     */
    WATCHLIST_RAW ("watchlistraw"),

    /**
     * Returns all pages that use the given entity IDs.
     */
    WB_LIST_ENTITY_USAGE ("wblistentityusage");

    private final String value;

    Generator(String value) {
        this.value = value;
    }

}
