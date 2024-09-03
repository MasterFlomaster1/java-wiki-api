package dev.masterflomaster1.jwa.request.prop;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Get the list of logged-in contributors and the count of anonymous contributors to a page.
 *
 * @see <a href="https://www.mediawiki.org/wiki/API:Contributors">API:Contributors</a>
 */
public final class ContributorsProp extends AbstractProp {

    private Set<PcGroup> pcGroup;
    private Set<PcGroup> pcExcludeGroup;
    private Set<PcRights> pcRights;
    private Set<PcRights> pcExcludeRights;
    private int pcLimit;
    private String pcContinue;

    private ContributorsProp() {
        name = "contributors";
    }

    public Set<PcGroup> getPcGroup() {
        return pcGroup;
    }

    public Set<PcGroup> getPcExcludeGroup() {
        return pcExcludeGroup;
    }

    public Set<PcRights> getPcRights() {
        return pcRights;
    }

    public Set<PcRights> getPcExcludeRights() {
        return pcExcludeRights;
    }

    public int getPcLimit() {
        return pcLimit;
    }

    public String getPcContinue() {
        return pcContinue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContributorsProp that = (ContributorsProp) o;

        if (pcLimit != that.pcLimit) return false;
        if (!Objects.equals(pcGroup, that.pcGroup)) return false;
        if (!Objects.equals(pcExcludeGroup, that.pcExcludeGroup))
            return false;
        if (!Objects.equals(pcRights, that.pcRights)) return false;
        if (!Objects.equals(pcExcludeRights, that.pcExcludeRights))
            return false;
        return Objects.equals(pcContinue, that.pcContinue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pcGroup, pcExcludeGroup, pcRights, pcExcludeRights, pcLimit, pcContinue);
    }

    public enum PcGroup {

        ABUSE_FILTER ("");

        private final String value;

        PcGroup(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public enum PcRights {
        EDIT ("edit");

        private final String value;

        PcRights(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public static class Builder {

        private final ContributorsProp contributorsProp = new ContributorsProp();

        /**
         * Only include users in the given groups. Does not include implicit or auto-promoted groups like *, user, or
         * autoconfirmed.
         * @return {@code Builder}
         */
        public Builder pcGroup(Set<PcGroup> pcGroup) {
            contributorsProp.pcGroup = pcGroup;
            contributorsProp.apiUrl.putQuery("pcgroup", pcGroup.stream()
                    .map(PcGroup::getValue)
                    .collect(Collectors.joining("|")));
            return this;
        }

        /**
         * Exclude users in the given groups. Does not include implicit or auto-promoted groups like *, user, or
         * autoconfirmed.
         * @return {@code Builder}
         */
        public Builder pcExcludeGroup(Set<PcGroup> pcExcludeGroup) {
            contributorsProp.pcExcludeGroup = pcExcludeGroup;
            contributorsProp.apiUrl.putQuery("pcexcludegroup", pcExcludeGroup.stream()
                    .map(PcGroup::getValue)
                    .collect(Collectors.joining("|")));
            return this;
        }

        /**
         * Only include users having the given rights. Does not include rights granted by implicit or auto-promoted
         * groups like *, user, or autoconfirmed.
         * Maximum number of values is 50 (500 for clients that are allowed higher limits).
         * @return {@code Builder}
         */
        public Builder pcRights(Set<PcRights> pcRights) {
            contributorsProp.pcRights = pcRights;
            contributorsProp.apiUrl.putQuery("pcrights", pcRights.stream()
                    .map(PcRights::getValue)
                    .collect(Collectors.joining("|")));
            return this;
        }

        /**
         * Exclude users having the given rights. Does not include rights granted by implicit or auto-promoted groups
         * like *, user, or autoconfirmed.
         * Maximum number of values is 50 (500 for clients that are allowed higher limits).
         * @return {@code Builder}
         */
        public Builder pcExcludeRights(Set<PcRights> pcExcludeRights) {
            contributorsProp.pcExcludeRights = pcExcludeRights;
            contributorsProp.apiUrl.putQuery("pcexcluderights", pcExcludeRights.stream()
                    .map(PcRights::getValue)
                    .collect(Collectors.joining("|")));
            return this;
        }

        /**
         * How many contributors to return.
         * @param pcLimit The value must be between 1 and 500.
         * @return {@code Builder}
         */
        public Builder pcLimit(int pcLimit) {
            contributorsProp.pcLimit = pcLimit;
            contributorsProp.apiUrl.putQuery("pclimit", pcLimit);
            return this;
        }

        /**
         * When more results are available, use this to continue.
         * More detailed information on how to continue queries can be found on
         * <a href="https://www.mediawiki.org/wiki/API:Continue">mediawiki.org</a>.
         * @return {@code Builder}
         */
        public Builder pcContinue(String pcContinue) {
            contributorsProp.pcContinue = pcContinue;
            contributorsProp.apiUrl.putQuery("pccontinue", pcContinue);
            return this;
        }


        public ContributorsProp build() {
            return contributorsProp;
        }

    }

}
