package dev.masterflomaster1.jwa.request.meta;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Return general information about the site.
 *
 * @see <a href="https://www.mediawiki.org/wiki/API:Siteinfo">https://www.mediawiki.org/wiki/API:Siteinfo</a>
 */
@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
public final class SiteInfoMeta extends AbstractMeta {

    private Set<SiProp> siProp;
    private boolean siShowAllDb;
    private boolean siNumberInGroup;

    private SiteInfoMeta() {
        name = "siteinfo";
    }

    @Getter
    public enum SiProp {

        /**
         * Overall system information.
         */
        GENERAL ("general"),
        NAMESPACE_ALIASES ("namespacealiases"),
        NAMESPACES ("namespaces"),

        /**
         * Returns a list of protocols that are allowed in external links.
         */
        PROTOCOLS ("protocols"),
        STATISTICS ("statistics");

        final String value;

        SiProp(String value) {
            this.value = value;
        }

    }

    public static class Builder {

        private final SiteInfoMeta siteInfoMeta = new SiteInfoMeta();

        /**
         * Which information to get.
         * @param siProp value
         * @return {@code Builder}
         */
        public Builder siProp(Set<SiProp> siProp) {
            siteInfoMeta.siProp = siProp;
            siteInfoMeta.apiUrl.putQuery("siprop", siProp.stream()
                    .map(SiProp::getValue)
                    .collect(Collectors.joining("|")));
            return this;
        }

        /**
         * List all database servers, not just the one lagging the most.
         * @return {@code Builder}
         */
        public Builder siShowAllDb() {
            siteInfoMeta.siShowAllDb = true;
            siteInfoMeta.apiUrl.putQuery("sishowalldb", "1");
            return this;
        }

        /**
         * Lists the number of users in user groups.
         * @return {@code Builder}
         */
        public Builder siNumberInGroup() {
            siteInfoMeta.siNumberInGroup = true;
            siteInfoMeta.apiUrl.putQuery("sinumberingroup", "1");
            return this;
        }

        public SiteInfoMeta build() {
            return siteInfoMeta;
        }

    }


}
