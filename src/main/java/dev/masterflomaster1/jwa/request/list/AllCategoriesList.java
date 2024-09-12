package dev.masterflomaster1.jwa.request.list;

import dev.masterflomaster1.jwa.common.Dir;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.EnumSet;
import java.util.stream.Collectors;

/**
 * Enumerate all categories.
 *
 * @see <a href="https://www.mediawiki.org/wiki/API:Allcategories">API:Allcategories</a>
 */
@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@SuppressWarnings("SpellCheckingInspection")
public final class AllCategoriesList extends AbstractList {

    private String acFrom;
    private String acContinue;
    private String acTo;
    private String acPrefix;
    private Dir acDir;
    private int acMin;
    private int acMax;
    private int acLimit;
    private EnumSet<AcProp> acProp;

    private AllCategoriesList() {
        name = "allcategories";
    }

    public static class Builder {

        private final AllCategoriesList allCategoriesList = new AllCategoriesList();

        /**
         * The category to start enumerating from.
         * @return {@code Builder}
         */
        public Builder acFrom(String acFrom) {
            allCategoriesList.acFrom = acFrom;
            allCategoriesList.apiUrl.putQuery("acfrom", acFrom);
            return this;
        }

        /**
         * When more results are available, use this to continue.
         * More detailed information on how to continue queries can be found on
         * <a href="https://www.mediawiki.org/wiki/API:Continue">mediawiki.org</a>.
         * @return {@code Builder}
         */
        public Builder acContinue(String acContinue) {
            allCategoriesList.acContinue = acContinue;
            allCategoriesList.apiUrl.putQuery("accontinue", acContinue);
            return this;
        }

        /**
         * The category to stop enumerating at.
         * @return {@code Builder}
         */
        public Builder acTo(String acTo) {
            allCategoriesList.acTo = acTo;
            allCategoriesList.apiUrl.putQuery("acto", acTo);
            return this;
        }

        /**
         * Search for all category titles that begin with this value.
         * @return {@code Builder}
         */
        public Builder acPrefix(String acPrefix) {
            allCategoriesList.acPrefix = acPrefix;
            allCategoriesList.apiUrl.putQuery("acprefix", acPrefix);
            return this;
        }

        /**
         * Direction to sort in.
         * @return {@code Builder}
         */
        public Builder acDir(Dir acDir) {
            allCategoriesList.acDir = acDir;
            allCategoriesList.apiUrl.putQuery("acdir", acDir.getValue());
            return this;
        }

        /**
         * Only return categories with at least this many members.
         * @return {@code Builder}
         */
        public Builder acMin(int acMin) {
            allCategoriesList.acMin = acMin;
            allCategoriesList.apiUrl.putQuery("acmin", acMin);
            return this;
        }

        /**
         * Only return categories with at most this many members.
         * @return {@code Builder}
         */
        public Builder acMax(int acMax) {
            allCategoriesList.acMax = acMax;
            allCategoriesList.apiUrl.putQuery("acmax", acMax);
            return this;
        }

        /**
         * How many categories to return.
         * @param acLimit The value must be between 1 and 500.
         * @return {@code Builder}
         */
        public Builder acLimit(int acLimit) {
            allCategoriesList.acLimit = acLimit;
            allCategoriesList.apiUrl.putQuery("aclimit", acLimit);
            return this;
        }

        /**
         * Which properties to get.
         * @return {@code Builder}
         */
        public Builder acProp(EnumSet<AcProp> acProp) {
            allCategoriesList.acProp = acProp;
            allCategoriesList.apiUrl.putQuery("acprop", acProp.stream()
                    .map(AcProp::getValue)
                    .collect(Collectors.joining("|")));
            return this;
        }

        public AllCategoriesList build() {
            return allCategoriesList;
        }

    }

    @Getter
    public enum AcProp {
        HIDDEN ("hidden"),
        SIZE ("size");

        private final String value;

        AcProp(String value) {
            this.value = value;
        }

    }

}
