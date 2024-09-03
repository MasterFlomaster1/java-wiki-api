package dev.masterflomaster1.jwa.request.meta;

import java.util.Objects;

/**
 * Shows sitewide pageview data (daily pageview totals for each of the last {@code pvisdays} days).
 *
 * @see <a href="https://www.mediawiki.org/wiki/Special:MyLanguage/Extension:PageViewInfo">Extension:PageViewInfo</a>
 */
public final class SiteViewsMeta extends AbstractMeta {

    private PvIsMetric pvIsMetric;
    private int pvIsDays;

    private SiteViewsMeta() {
        name = "siteviews";
    }

    public PvIsMetric getPvIsMetric() {
        return pvIsMetric;
    }

    public int getPvIsDays() {
        return pvIsDays;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pvIsDays, pvIsMetric);
    }

    public static class Builder {

        private final SiteViewsMeta siteViewsMeta = new SiteViewsMeta();

        /**
         * The metric to use for counting views. Depending on what backend is used, not all metrics might be supported.
         * @return {@code Builder}
         */
        public Builder pvIsMetric(PvIsMetric pvIsMetric) {
            siteViewsMeta.pvIsMetric = pvIsMetric;
            siteViewsMeta.apiUrl.putQuery("pvismetric", pvIsMetric.getValue());
            return this;
        }

        /**
         * The number of days to show.
         * @param pvIsDays The value must be between 1 and 60.
         * @return {@code Builder}
         */
        public Builder pvIsDays(int pvIsDays) {
            siteViewsMeta.pvIsDays = pvIsDays;
            siteViewsMeta.apiUrl.putQuery("pvisdays", pvIsDays);
            return this;
        }

        public SiteViewsMeta build() {
            return siteViewsMeta;
        }

    }

    public enum PvIsMetric {

        /**
         * Plain pageviews.
         */
        PAGE_VIEWS ("pageviews"),

        /**
         * Unique visitors.
         */
        UNIQUES ("uniques");

        private final String value;

        PvIsMetric(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

    }

}
