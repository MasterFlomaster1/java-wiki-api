package dev.masterflomaster1.jwa.model;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Return general information about the site.
 *
 * @see <a href="https://www.mediawiki.org/wiki/API:Siteinfo">https://www.mediawiki.org/wiki/API:Siteinfo</a>
 */
public class SiteInfoMeta extends AbstractMeta {

    private Set<SiProp> siProp;
    private boolean siShowAllDb;
    private boolean siNumberInGroup;

    private SiteInfoMeta() {
        url = "&meta=siteinfo";
    }

    public Set<SiProp> getSiProp() {
        return siProp;
    }

    public boolean isSiShowAllDb() {
        return siShowAllDb;
    }

    public boolean isSiNumberInGroup() {
        return siNumberInGroup;
    }

    public enum SiProp {

        /**
         * Overall system information.
         */
        GENERAL ("general"),

        /**
         * Returns a list of protocols that are allowed in external links.
         */
        PROTOCOLS ("protocols");

        final String value;

        SiProp(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
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
            siteInfoMeta.url += "&siprop=" + siProp.stream()
                    .map(SiProp::getValue)
                    .collect(Collectors.joining("%7C"));
            return this;
        }

        /**
         * List all database servers, not just the one lagging the most.
         * @return {@code Builder}
         */
        public Builder siShowAllDb() {
            siteInfoMeta.siShowAllDb = true;
            siteInfoMeta.url += "&sishowalldb=1";
            return this;
        }

        /**
         * Lists the number of users in user groups.
         * @return {@code Builder}
         */
        public Builder siNumberInGroup() {
            siteInfoMeta.siNumberInGroup = true;
            siteInfoMeta.url += "&sinumberingroup=1";
            return this;
        }

        public SiteInfoMeta build() {
            return siteInfoMeta;
        }

    }


}
