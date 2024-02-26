package dev.masterflomaster1.jwa.request.prop;

import dev.masterflomaster1.jwa.common.Namespace;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Find all pages that use the given files.
 *
 * @see <a href="https://www.mediawiki.org/wiki/API:Fileusage">API:Fileusage</a>
 */
public class FileUsageProp extends AbstractProp {

    private Set<FuProp> fuProp;
    private Set<Namespace> fuNamespace;
    private Set<FuShow> fuShow;
    private int fuLimit;
    private String fuContinue;

    private FileUsageProp() {
        name = "fileusage";
    }

    public Set<FuProp> getFuProp() {
        return fuProp;
    }

    public Set<Namespace> getFuNamespace() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FileUsageProp that = (FileUsageProp) o;

        if (fuLimit != that.fuLimit) return false;
        if (!Objects.equals(fuProp, that.fuProp)) return false;
        if (!Objects.equals(fuNamespace, that.fuNamespace)) return false;
        if (!Objects.equals(fuShow, that.fuShow)) return false;
        return Objects.equals(fuContinue, that.fuContinue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fuProp, fuNamespace, fuShow, fuLimit, fuContinue);
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
