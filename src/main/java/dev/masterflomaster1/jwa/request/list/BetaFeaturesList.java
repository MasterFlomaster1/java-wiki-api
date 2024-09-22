package dev.masterflomaster1.jwa.request.list;

import dev.masterflomaster1.jwa.request.AbstractBuilder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * List all BetaFeatures.
 *
 * @see <a href="https://www.mediawiki.org/wiki/Extension:BetaFeatures">Extension:BetaFeatures</a>
 */
@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@SuppressWarnings("SpellCheckingInspection")
public final class BetaFeaturesList extends AbstractList {

    private boolean bfCounts;

    private BetaFeaturesList() {
        super("betafeatures");
    }

    public static class Builder extends AbstractBuilder {

        private final BetaFeaturesList betaFeaturesList = new BetaFeaturesList();

        /**
         * Whether to fetch how many users have enabled a certain preference.
         * @return {@code Builder}
         */
        public Builder bdCounts() {
            betaFeaturesList.bfCounts = true;
            betaFeaturesList.apiUrl.putQuery("bfcounts", "");
            return this;
        }

        public BetaFeaturesList build() {
            return betaFeaturesList;
        }

    }

}
