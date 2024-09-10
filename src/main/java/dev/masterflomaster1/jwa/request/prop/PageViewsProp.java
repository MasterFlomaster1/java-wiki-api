package dev.masterflomaster1.jwa.request.prop;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * Shows per-page pageview data (the number of daily pageviews for each of the last pvipdays days).
 *
 * @see <a href="https://www.mediawiki.org/w/api.php?action=help&modules=query%2Bpageviews">www.mediawiki.org</a>
 * @see <a href="https://www.mediawiki.org/wiki/Extension:PageViewInfo">Extension:PageViewInfo</a>
 */
@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@SuppressWarnings("SpellCheckingInspection")
public final class PageViewsProp extends AbstractProp {

    private int pvIpDays;
    private String pvIpContinue;

    private PageViewsProp() {
        name = "pageviews";
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
