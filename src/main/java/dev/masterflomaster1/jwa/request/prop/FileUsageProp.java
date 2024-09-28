package dev.masterflomaster1.jwa.request.prop;

import dev.masterflomaster1.jwa.common.Namespace;
import dev.masterflomaster1.jwa.common.Show;
import dev.masterflomaster1.jwa.internal.EnumValueProvider;
import dev.masterflomaster1.jwa.request.AbstractBuilder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.EnumSet;

/**
 * Find all pages that use the given files.
 *
 * @see <a href="https://www.mediawiki.org/wiki/API:Fileusage">API:Fileusage</a>
 */
@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@SuppressWarnings("SpellCheckingInspection")
public final class FileUsageProp extends AbstractProp {

    private EnumSet<FuProp> fuProp;
    private EnumSet<Namespace> fuNamespace;
    private EnumSet<Show.Redirect> fuShow;
    private int fuLimit;
    private String fuContinue;

    private FileUsageProp() {
        super("fileusage");
    }

    /**
     * Which properties to get
     */
    @Getter
    public enum FuProp implements EnumValueProvider {

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

    public static class Builder extends AbstractBuilder {

        private final FileUsageProp fileUsageProp = new FileUsageProp();

        /**
         * Which properties to get
         * @return {@code Builder}
         */
        public Builder fuProp(EnumSet<FuProp> fuProp) {
            fileUsageProp.fuProp = fuProp;
            fileUsageProp.apiUrl.putQuery("fuprop", merge(fuProp));
            return this;
        }

        /**
         * Only include pages in these namespaces.
         * @return {@code Builder}
         */
        public Builder fuNamespace(EnumSet<Namespace> fuNamespace) {
            fileUsageProp.fuNamespace = fuNamespace;
            fileUsageProp.apiUrl.putQuery("funamespace", merge(fuNamespace));
            return this;
        }

        /**
         * Show only items that meet these criteria.
         * @return {@code Builder}
         */
        public Builder fuShow(EnumSet<Show.Redirect> fuShow) {
            fileUsageProp.fuShow = fuShow;
            fileUsageProp.apiUrl.putQuery("fushow", merge(fuShow));
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
