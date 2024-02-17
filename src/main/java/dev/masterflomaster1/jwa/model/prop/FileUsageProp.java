package dev.masterflomaster1.jwa.model.prop;

import java.util.Set;

/**
 * Find all pages that use the given files.
 *
 * @see <a href="https://www.mediawiki.org/wiki/API:Fileusage">API:Fileusage</a>
 */
public class FileUsageProp extends AbstractProp {

    private Set<FuProp> fuProp;
    private Set<FuNamespace> fuNamespace;
    private Set<FuShow> fuShow;
    private int fuLimit;
    private String fuContinue;

    private FileUsageProp() {
        url += "&prop=fileusage";
    }

    public Set<FuProp> getFuProp() {
        return fuProp;
    }

    public Set<FuNamespace> getFuNamespace() {
        return fuNamespace;
    }

    public Set<FuShow> getFuShow() {
        return fuShow;
    }

    public int getFuLimit() {
        return fuLimit;
    }

    public String getFuContinue() {
        return fuContinue;
    }

    /**
     * Which properties to get
     */
    public enum FuProp {

        /**
         * Page ID of each page.
         */
        PAGE_ID ("pageid"),

        /**
         * Flag if the page is a redirect.
         */
        REDIRECT ("redirect"),

        /**
         * Title of each page.
         */
        TITLE ("title");

        private final String value;

        FuProp(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    /**
     * @see <a href="https://en.wikipedia.org/wiki/Wikipedia:Namespace">Wikipedia:Namespace</a>
     */
    public enum FuNamespace {
        ALL_NAMESPACES ("*"),
        MEDIA (""),
        SPECIAL (""),
        ARTICLE (""),
        TALK (""),
        USER (""),
        USER_TALK (""),
        WIKIPEDIA (""),
        WIKIPEDIA_TALK (""),
        FILE (""),
        FILE_TALK (""),
        MEDIAWIKI (""),
        MEDIAWIKI_TALK (""),
        TEMPLATE (""),
        TEMPLATE_TALK (""),
        HELP (""),
        HELP_TALK (""),
        CATEGORY (""),
        CATEGORY_TALK (""),
        PORTAL (""),
        PORTAL_TALK (""),
        DRAFT (""),
        DRAFT_TALK (""),
        TIMED_TEXT (""),
        TIMED_TEXT_TALK (""),
        MODULE (""),
        MODULE_TALK (""),
        GADGET (""),
        GADGET_TALK (""),
        GADGET_DEFINITION (""),
        GADGET_DEFINITION_TALK ("");

        private final String value;

        FuNamespace(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    /**
     * Show only items that meet these criteria.
     */
    public enum FuShow {

        /**
         * Only show redirects.
         */
        REDIRECT ("redirect"),

        /**
         * Only show non-redirects.
         */
        NOT_REDIRECT ("!redirect");

        private final String value;

        FuShow(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public static class Builder {

        private final FileUsageProp fileUsageProp = new FileUsageProp();

        /**
         * Which properties to get
         * @return {@code Builder}
         */
        public Builder fuProp(Set<FuProp> fuProp) {
            fileUsageProp.fuProp = fuProp;
            return this;
        }

        /**
         * Only include pages in these namespaces.
         * @return {@code Builder}
         */
        public Builder fuNamespace(Set<FuNamespace> fuNamespace) {
            fileUsageProp.fuNamespace = fuNamespace;
            return this;
        }

        /**
         * Show only items that meet these criteria.
         * @return {@code Builder}
         */
        public Builder fuShow(Set<FuShow> fuShow) {
            fileUsageProp.fuShow = fuShow;
            return this;
        }

        /**
         * How many to return.
         * The value must be between 1 and 500.
         * @return {@code Builder}
         */
        public Builder fuLimit(int fuLimit) {
            fileUsageProp.fuLimit = fuLimit;
            return this;
        }

        /**
         * When more results are available, use this to continue.
         * More detailed information on how to continue queries can be found on
         * <a href="https://www.mediawiki.org/wiki/API:Continue">mediawiki.org</a>.
         * @return {@code Builder}
         */
        public Builder fuContinue(String fuContinue) {
            fileUsageProp.fuContinue = fuContinue;
            return this;
        }

        public FileUsageProp build() {
            return fileUsageProp;
        }

    }

}