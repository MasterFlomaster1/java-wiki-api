package dev.masterflomaster1.jwa.request.prop;

import dev.masterflomaster1.jwa.common.Group;
import dev.masterflomaster1.jwa.common.Rights;
import dev.masterflomaster1.jwa.request.AbstractBuilder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.EnumSet;

/**
 * Get the list of logged-in contributors and the count of anonymous contributors to a page.
 *
 * @see <a href="https://www.mediawiki.org/wiki/API:Contributors">API:Contributors</a>
 */
@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@SuppressWarnings("SpellCheckingInspection")
public final class ContributorsProp extends AbstractProp {

    private EnumSet<Group> pcGroup;
    private EnumSet<Group> pcExcludeGroup;
    private EnumSet<Rights> pcRights;
    private EnumSet<Rights> pcExcludeRights;
    private int pcLimit;
    private String pcContinue;

    private ContributorsProp() {
        super("contributors");
    }

    public static class Builder extends AbstractBuilder {

        private final ContributorsProp contributorsProp = new ContributorsProp();

        /**
         * Only include users in the given groups. Does not include implicit or auto-promoted groups like *, user, or
         * autoconfirmed.
         * @return {@code Builder}
         */
        public Builder pcGroup(EnumSet<Group> pcGroup) {
            contributorsProp.pcGroup = pcGroup;
            contributorsProp.apiUrl.putQuery("pcgroup", merge(pcGroup));
            return this;
        }

        /**
         * Exclude users in the given groups. Does not include implicit or auto-promoted groups like *, user, or
         * autoconfirmed.
         * @return {@code Builder}
         */
        public Builder pcExcludeGroup(EnumSet<Group> pcExcludeGroup) {
            contributorsProp.pcExcludeGroup = pcExcludeGroup;
            contributorsProp.apiUrl.putQuery("pcexcludegroup", merge(pcExcludeGroup));
            return this;
        }

        /**
         * Only include users having the given rights. Does not include rights granted by implicit or auto-promoted
         * groups like *, user, or autoconfirmed.
         * Maximum number of values is 50 (500 for clients that are allowed higher limits).
         * @return {@code Builder}
         */
        public Builder pcRights(EnumSet<Rights> pcRights) {
            contributorsProp.pcRights = pcRights;
            contributorsProp.apiUrl.putQuery("pcrights", merge(pcRights));
            return this;
        }

        /**
         * Exclude users having the given rights. Does not include rights granted by implicit or auto-promoted groups
         * like *, user, or autoconfirmed.
         * Maximum number of values is 50 (500 for clients that are allowed higher limits).
         * @return {@code Builder}
         */
        public Builder pcExcludeRights(EnumSet<Rights> pcExcludeRights) {
            contributorsProp.pcExcludeRights = pcExcludeRights;
            contributorsProp.apiUrl.putQuery("pcexcluderights", merge(pcExcludeRights));
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
