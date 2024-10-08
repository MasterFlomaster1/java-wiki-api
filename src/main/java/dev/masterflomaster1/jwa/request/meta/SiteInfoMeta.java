package dev.masterflomaster1.jwa.request.meta;

import dev.masterflomaster1.jwa.internal.EnumValueProvider;
import dev.masterflomaster1.jwa.request.AbstractBuilder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.EnumSet;

/**
 * Return general information about the site.
 *
 * @see <a href="https://www.mediawiki.org/wiki/API:Siteinfo">https://www.mediawiki.org/wiki/API:Siteinfo</a>
 */
@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@SuppressWarnings("SpellCheckingInspection")
public final class SiteInfoMeta extends AbstractMeta {

    private EnumSet<SiProp> siProp;
    private boolean siShowAllDb;
    private boolean siNumberInGroup;

    private SiteInfoMeta() {
        super("siteinfo");
    }

    @Getter
    public enum SiProp implements EnumValueProvider {

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

        private final String value;

        SiProp(String value) {
            this.value = value;
        }

    }

    public static class Builder extends AbstractBuilder {

        private final SiteInfoMeta siteInfoMeta = new SiteInfoMeta();

        /**
         * Which information to get.
         * @param siProp value
         * @return {@code Builder}
         */
        public Builder siProp(EnumSet<SiProp> siProp) {
            siteInfoMeta.siProp = siProp;
            siteInfoMeta.apiUrl.putQuery("siprop", merge(siProp));
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
