package dev.masterflomaster1.jwa.request.list;

import dev.masterflomaster1.jwa.common.Dir;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Enumerate all categories.
 *
 * @see <a href="https://www.mediawiki.org/wiki/API:Allcategories">API:Allcategories</a>
 */
public class AllCategoriesList extends AbstractList {

    private String acFrom;
    private String acContinue;
    private String acTo;
    private String acPrefix;
    private Dir acDir;
    private int acMin;
    private int acMax;
    private int acLimit;
    private Set<AcProp> acProp;

    private AllCategoriesList() {
        url = "&list=allcategories";
    }

    public String getAcFrom() {
        return acFrom;
    }

    public String getAcContinue() {
        return acContinue;
    }

    public String getAcTo() {
        return acTo;
    }

    public String getAcPrefix() {
        return acPrefix;
    }

    public Dir getAcDir() {
        return acDir;
    }

    public int getAcMin() {
        return acMin;
    }

    public int getAcMax() {
        return acMax;
    }

    public int getAcLimit() {
        return acLimit;
    }

    public Set<AcProp> getAcProp() {
        return acProp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AllCategoriesList that = (AllCategoriesList) o;

        if (acMin != that.acMin) return false;
        if (acMax != that.acMax) return false;
        if (acLimit != that.acLimit) return false;
        if (!Objects.equals(acFrom, that.acFrom)) return false;
        if (!Objects.equals(acContinue, that.acContinue)) return false;
        if (!Objects.equals(acTo, that.acTo)) return false;
        if (!Objects.equals(acPrefix, that.acPrefix)) return false;
        if (acDir != that.acDir) return false;
        return Objects.equals(acProp, that.acProp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(acFrom, acContinue, acTo, acPrefix, acDir, acMin, acMax, acLimit, acProp);
    }

    public static class Builder {

        private final AllCategoriesList allCategoriesList = new AllCategoriesList();

        /**
         * The category to start enumerating from.
         * @return {@code Builder}
         */
        public Builder acFrom(String acFrom) {
            allCategoriesList.acFrom = acFrom;
            allCategoriesList.url += "&acfrom=" + URLEncoder.encode(acFrom, StandardCharsets.UTF_8);
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
            allCategoriesList.url += "&accontinue=" + URLEncoder.encode(acContinue, StandardCharsets.UTF_8);
            return this;
        }

        /**
         * The category to stop enumerating at.
         * @return {@code Builder}
         */
        public Builder acTo(String acTo) {
            allCategoriesList.acTo = acTo;
            allCategoriesList.url += "&acto=" + URLEncoder.encode(acTo, StandardCharsets.UTF_8);
            return this;
        }

        /**
         * Search for all category titles that begin with this value.
         * @return {@code Builder}
         */
        public Builder acPrefix(String acPrefix) {
            allCategoriesList.acPrefix = acPrefix;
            allCategoriesList.url += "&acprefix=" + URLEncoder.encode(acPrefix, StandardCharsets.UTF_8);
            return this;
        }

        /**
         * Direction to sort in.
         * @return {@code Builder}
         */
        public Builder acDir(Dir acDir) {
            allCategoriesList.acDir = acDir;
            allCategoriesList.url += "&acdir=" + acDir.getValue();
            return this;
        }

        /**
         * Only return categories with at least this many members.
         * @return {@code Builder}
         */
        public Builder acMin(int acMin) {
            allCategoriesList.acMin = acMin;
            allCategoriesList.url += "&acmin=" + acMin;
            return this;
        }

        /**
         * Only return categories with at most this many members.
         * @return {@code Builder}
         */
        public Builder acMax(int acMax) {
            allCategoriesList.acMax = acMax;
            allCategoriesList.url += "&acmax=" + acMax;
            return this;
        }

        /**
         * How many categories to return.
         * @param acLimit The value must be between 1 and 500.
         * @return {@code Builder}
         */
        public Builder acLimit(int acLimit) {
            allCategoriesList.acLimit = acLimit;
            allCategoriesList.url += "&aclimit=" + acLimit;
            return this;
        }

        /**
         * Which properties to get.
         * @return {@code Builder}
         */
        public Builder acProp(Set<AcProp> acProp) {
            allCategoriesList.acProp = acProp;
            allCategoriesList.url += "&acprop=" + acProp.stream()
                    .map(AcProp::getValue)
                    .collect(Collectors.joining("%7C"));
            return this;
        }

        public AllCategoriesList build() {
            return allCategoriesList;
        }

    }

    public enum AcProp {
        HIDDEN ("hidden"),
        SIZE ("size");

        private final String value;

        AcProp(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

}
