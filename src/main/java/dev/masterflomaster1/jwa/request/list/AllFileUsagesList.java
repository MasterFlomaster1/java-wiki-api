package dev.masterflomaster1.jwa.request.list;

import dev.masterflomaster1.jwa.common.Dir;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * List all file usages, including non-existing.
 *
 * @see <a href="https://www.mediawiki.org/wiki/Special:MyLanguage/API:Allfileusages">API:Allfileusages</a>
 */
public class AllFileUsagesList extends AbstractList {

    private String afContinue;
    private String afFrom;
    private String afTo;
    private String afPrefix;
    private boolean afUnique;
    private Set<AfProp> afProp;
    private int afLimit;
    private Dir afDir;

    private AllFileUsagesList() {
        name = "allfileusages";
    }

    public String getAfContinue() {
        return afContinue;
    }

    public String getAfFrom() {
        return afFrom;
    }

    public String getAfTo() {
        return afTo;
    }

    public String getAfPrefix() {
        return afPrefix;
    }

    public boolean isAfUnique() {
        return afUnique;
    }

    public Set<AfProp> getAfProp() {
        return afProp;
    }

    public int getAfLimit() {
        return afLimit;
    }

    public Dir getAfDir() {
        return afDir;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AllFileUsagesList that = (AllFileUsagesList) o;

        if (afUnique != that.afUnique) return false;
        if (afLimit != that.afLimit) return false;
        if (!Objects.equals(afContinue, that.afContinue)) return false;
        if (!Objects.equals(afFrom, that.afFrom)) return false;
        if (!Objects.equals(afTo, that.afTo)) return false;
        if (!Objects.equals(afPrefix, that.afPrefix)) return false;
        if (!Objects.equals(afProp, that.afProp)) return false;
        return afDir == that.afDir;
    }

    @Override
    public int hashCode() {
        return Objects.hash(afContinue, afFrom, afTo, afPrefix, afUnique, afProp, afLimit, afDir);
    }

    public static class Builder {

        private final AllFileUsagesList allFileUsagesList = new AllFileUsagesList();

        /**
         * When more results are available, use this to continue.
         * More detailed information on how to continue queries can be found on
         * <a href="https://www.mediawiki.org/wiki/API:Continue">mediawiki.org</a>.
         * @return {@code Builder}
         */
        public Builder afContinue(String afContinue) {
            allFileUsagesList.afContinue = afContinue;
            allFileUsagesList.apiUrl.putQuery("afcontinue", afContinue);
            return this;
        }

        /**
         * The title of the file to start enumerating from.
         * @return {@code Builder}
         */
        public Builder afFrom(String afFrom) {
            allFileUsagesList.afFrom = afFrom;
            allFileUsagesList.apiUrl.putQuery("affrom", afFrom);
            return this;
        }

        /**
         * The title of the file to stop enumerating at
         * @return {@code Builder}
         */
        public Builder afTo(String afTo) {
            allFileUsagesList.afTo = afTo;
            allFileUsagesList.apiUrl.putQuery("afto", afTo);
            return this;
        }

        /**
         * Search for all file titles that begin with this value.
         * @return {@code Builder}
         */
        public Builder afPrefix(String afPrefix) {
            allFileUsagesList.afPrefix = afPrefix;
            allFileUsagesList.apiUrl.putQuery("afprefix", afPrefix);
            return this;
        }

        /**
         * Only show distinct file titles. Cannot be used with {@code afprop=ids}. When used as a generator, yields
         * target pages instead of source pages.
         * @return {@code Builder}
         */
        public Builder afUnique() {
            allFileUsagesList.afUnique = true;
            allFileUsagesList.apiUrl.putQuery("afunique", "1");
            return this;
        }

        /**
         * Which pieces of information to include
         * @return {@code Builder}
         */
        public Builder afProp(Set<AfProp> afProp) {
            allFileUsagesList.afProp = afProp;
            allFileUsagesList.apiUrl.putQuery("afprop", afProp.stream()
                    .map(AfProp::getValue)
                    .collect(Collectors.joining("|")));
            return this;
        }

        /**
         * How many total items to return.
         * @param afLimit The value must be between 1 and 500.
         * @return {@code Builder}
         */
        public Builder afLimit(int afLimit) {
            allFileUsagesList.afLimit = afLimit;
            allFileUsagesList.apiUrl.putQuery("aflimit", afLimit);
            return this;
        }

        /**
         * The direction in which to list.
         * @return {@code Builder}
         */
        public Builder afDir(Dir afDir) {
            allFileUsagesList.afDir = afDir;
            allFileUsagesList.apiUrl.putQuery("afdir", afDir.getValue());
            return this;
        }

        public AllFileUsagesList build() {
            return allFileUsagesList;
        }

    }

    public enum AfProp {

        IDS ("ids"),
        TITLE ("title");

        private final String value;

        AfProp(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

    }

}
