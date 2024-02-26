package dev.masterflomaster1.jwa.request.prop;

import java.util.Objects;

/**
 * Shows per-page pageview data (the number of daily pageviews for each of the last pvipdays days).
 *
 * @see <a href="https://www.mediawiki.org/w/api.php?action=help&modules=query%2Bpageviews">www.mediawiki.org</a>
 * @see <a href="https://www.mediawiki.org/wiki/Extension:PageViewInfo">Extension:PageViewInfo</a>
 */
public class PageViewsProp extends AbstractProp {

    private int pvIpDays;
    private String pvIpContinue;

    private PageViewsProp() {
        name = "pageviews";
    }

    public int getPvIpDays() {
        return pvIpDays;
    }

    public String getPvIpContinue() {
        return pvIpContinue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PageViewsProp that = (PageViewsProp) o;

        if (pvIpDays != that.pvIpDays) return false;
        return Objects.equals(pvIpContinue, that.pvIpContinue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pvIpDays, pvIpContinue);
    }

    public static class Builder {

        private final PageViewsProp pageViewsProp = new PageViewsProp();

        /**
         * The number of days to show.
         * @param pvIpDays The value must be between 1 and 60.
         * @return {@code Builder}
         */
        public Builder pvIpDays(int pvIpDays) {
            pageViewsProp.pvIpDays = pvIpDays;
            pageViewsProp.apiUrl.putQuery("pvipdays", pvIpDays);
            return this;
        }

        /**
         * When more results are available, use this to continue.
         * More detailed information on how to continue queries can be found on
         * <a href="https://www.mediawiki.org/wiki/API:Continue">mediawiki.org</a>.
         * @return {@code Builder}
         */
        public Builder pvIpContinue(String pvIpContinue) {
            pageViewsProp.pvIpContinue = pvIpContinue;
            pageViewsProp.apiUrl.putQuery("pvipcontinue", pvIpContinue);
            return this;
        }

        public PageViewsProp build() {
            return pageViewsProp;
        }

    }

}
