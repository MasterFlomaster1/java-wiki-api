package dev.masterflomaster1.jwa.request.prop;

import dev.masterflomaster1.jwa.common.Namespace;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Find all pages that use the given files.
 *
 * @see <a href="https://www.mediawiki.org/wiki/API:Fileusage">API:Fileusage</a>
 */
@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
public final class FileUsageProp extends AbstractProp {

    private Set<FuProp> fuProp;
    private Set<Namespace> fuNamespace;
    private Set<FuShow> fuShow;
    private int fuLimit;
    private String fuContinue;

    private FileUsageProp() {
        name = "fileusage";
    }

    /**
     * Which properties to get
     */
    @Getter
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

    }

    /**
     * Show only items that meet these criteria.
     */
    @Getter
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

    }

    public static class Builder {

        private final FileUsageProp fileUsageProp = new FileUsageProp();

        /**
         * Which properties to get
         * @return {@code Builder}
         */
        public Builder fuProp(Set<FuProp> fuProp) {
            fileUsageProp.fuProp = fuProp;
            fileUsageProp.apiUrl.putQuery("fuprop", fuProp.stream()
                    .map(FuProp::getValue)
                    .collect(Collectors.joining("|")));
            return this;
        }

        /**
         * Only include pages in these namespaces.
         * @return {@code Builder}
         */
        public Builder fuNamespace(Set<Namespace> fuNamespace) {
            fileUsageProp.fuNamespace = fuNamespace;
            fileUsageProp.apiUrl.putQuery("funamespace", fuNamespace.stream()
                    .map(Namespace::getValue)
                    .collect(Collectors.joining("|")));
            return this;
        }

        /**
         * Show only items that meet these criteria.
         * @return {@code Builder}
         */
        public Builder fuShow(Set<FuShow> fuShow) {
            fileUsageProp.fuShow = fuShow;
            fileUsageProp.apiUrl.putQuery("fushow", fuShow.stream()
                    .map(FuShow::getValue)
                    .collect(Collectors.joining("|")));
            return this;
        }

        /**
         * How many to return.
         * The value must be between 1 and 500.
         * @return {@code Builder}
         */
        public Builder fuLimit(int fuLimit) {
            fileUsageProp.fuLimit = fuLimit;
            fileUsageProp.apiUrl.putQuery("fulimit", fuLimit);
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
            fileUsageProp.apiUrl.putQuery("fucontinue", fuContinue);
            return this;
        }

        public FileUsageProp build() {
            return fileUsageProp;
        }

    }

}
