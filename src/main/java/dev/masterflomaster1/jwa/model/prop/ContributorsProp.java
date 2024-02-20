package dev.masterflomaster1.jwa.model.prop;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Set;

/**
 * Get the list of logged-in contributors and the count of anonymous contributors to a page.
 *
 * @see <a href="https://www.mediawiki.org/wiki/API:Contributors">API:Contributors</a>
 */
public class ContributorsProp extends AbstractProp {

    private Set<PcGroup> pcGroup;
    private Set<PcGroup> pcExcludeGroup;
    private Set<PcRights> pcRights;
    private Set<PcRights> pcExcludeRights;
    private int pcLimit;
    private String pcContinue;

    private ContributorsProp() {
        url += "&prop=contributors";
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
            return this;
        }

        /**
         * Exclude users in the given groups. Does not include implicit or auto-promoted groups like *, user, or
         * autoconfirmed.
         * @return {@code Builder}
         */
        public Builder pcExcludeGroup(Set<PcGroup> pcExcludeGroup) {
            contributorsProp.pcExcludeGroup = pcExcludeGroup;
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
            return this;
        }

        /**
         * How many contributors to return.
         * @param pcLimit The value must be between 1 and 500.
         * @return {@code Builder}
         */
        public Builder pcLimit(int pcLimit) {
            contributorsProp.pcLimit = pcLimit;
            contributorsProp.url += "&pclimit=" + pcLimit;
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
            contributorsProp.url += "&pccontinue=" + URLEncoder.encode(pcContinue, StandardCharsets.UTF_8);
            return this;
        }


        public ContributorsProp build() {
            return contributorsProp;
        }

    }

}
