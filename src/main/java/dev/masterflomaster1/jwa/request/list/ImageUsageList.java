package dev.masterflomaster1.jwa.request.list;

import dev.masterflomaster1.jwa.common.Dir;
import dev.masterflomaster1.jwa.common.FilterRedir;
import dev.masterflomaster1.jwa.common.Namespace;
import dev.masterflomaster1.jwa.request.AbstractBuilder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.EnumSet;

/**
 * Find all pages that use the given image title.
 *
 * @see <a href="https://www.mediawiki.org/wiki/Special:MyLanguage/API:Imageusage">API:Imageusage</a>
 */
@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@SuppressWarnings("SpellCheckingInspection")
public final class ImageUsageList extends AbstractList {

    private String iuTitle;
    private int iuPageId;
    private String iuContinue;
    private EnumSet<Namespace> iuNamespace;
    private Dir.Order iuDir;
    private FilterRedir iuFilterRedir;
    private int iuLimit;
    private boolean iuRedirect;

    private ImageUsageList() {
        super("imageusage");
    }

    public static class Builder extends AbstractBuilder {

        private final ImageUsageList imageUsageList = new ImageUsageList();

        /**
         * Title to search. Cannot be used together with iupageid.
         * @return {@code Builder}
         */
        public Builder iuTitle(final String iuTitle) {
            imageUsageList.iuTitle = iuTitle;
            imageUsageList.apiUrl.putQuery("iutitle", iuTitle);
            return this;
        }

        /**
         * Page ID to search. Cannot be used together with iutitle.
         * @return {@code Builder}
         */
        public Builder iuPageId(final int iuPageId) {
            imageUsageList.iuPageId = iuPageId;
            imageUsageList.apiUrl.putQuery("iupageid", iuPageId);
            return this;
        }

        /**
         * When more results are available, use this to continue.
         * More detailed information on how to continue queries can be found on
         * <a href="https://www.mediawiki.org/wiki/API:Continue">mediawiki.org</a>.
         * @return {@code Builder}
         */
        public Builder iuContinue(final String iuContinue) {
            imageUsageList.iuContinue = iuContinue;
            imageUsageList.apiUrl.putQuery("iucontinue", iuContinue);
            return this;
        }

        /**
         * The namespace to enumerate.
         * @return {@code Builder}
         */
        public Builder iuNamespace(final EnumSet<Namespace> iuNamespace) {
            imageUsageList.iuNamespace = iuNamespace;
            imageUsageList.apiUrl.putQuery("iunamespace", merge(iuNamespace));
            return this;
        }

        /**
         * The direction in which to list.
         * @return {@code Builder}
         */
        public Builder iuDir(final Dir.Order iuDir) {
            imageUsageList.iuDir = iuDir;
            imageUsageList.apiUrl.putQuery("iudir", iuDir.getValue());
            return this;
        }

        /**
         * How to filter for redirects. If set to nonredirects when iuredirect is enabled, this is only applied to the
         * second level.
         * @return {@code Builder}
         */
        public Builder iuFilterRedir(final FilterRedir iuFilterRedir) {
            imageUsageList.iuFilterRedir = iuFilterRedir;
            imageUsageList.apiUrl.putQuery("iufilterredir", iuFilterRedir.getValue());
            return this;
        }

        /**
         * How many total pages to return. If {@code iuredirect} is enabled, the limit applies to each level separately
         * (which means up to 2 * {@code iulimit} results may be returned).
         * @param iuLimit The value must be between 1 and 500.
         * @return {@code Builder}
         */
        public Builder iuLimit(final int iuLimit) {
            imageUsageList.iuLimit = iuLimit;
            imageUsageList.apiUrl.putQuery("iulimit", iuLimit);
            return this;
        }

        /**
         * If linking page is a redirect, find all pages that link to that redirect as well. Maximum limit is halved.
         * @return {@code Builder}
         */
        public Builder iuRedirect() {
            imageUsageList.iuRedirect = true;
            imageUsageList.apiUrl.putQuery("iuredirect", "1");
            return this;
        }

        public ImageUsageList build() {
            return imageUsageList;
        }

    }

}
