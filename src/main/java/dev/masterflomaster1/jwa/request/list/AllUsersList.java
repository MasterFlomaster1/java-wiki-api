package dev.masterflomaster1.jwa.request.list;

import dev.masterflomaster1.jwa.common.Dir;
import dev.masterflomaster1.jwa.common.Group;
import dev.masterflomaster1.jwa.common.Rights;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.EnumSet;
import java.util.stream.Collectors;

/**
 * Enumerate all registered users.
 *
 * @see <a href="https://www.mediawiki.org/wiki/Special:MyLanguage/API:Allusers">API:Allusers</a>
 */
@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@SuppressWarnings("SpellCheckingInspection")
public final class AllUsersList extends AbstractList {

    private String auFrom;
    private String auTo;
    private String auPrefix;
    private Dir.Order auDir;
    private EnumSet<Group> auGroup;
    private EnumSet<Group> auExcludeGroup;
    private EnumSet<Rights> auRights;
    private EnumSet<AuProp> auProp;
    private int auLimit;
    private boolean auWithEditsOnly;
    private boolean auActiveUsers;
    private boolean auAttachedWiki;

    private AllUsersList() {
        name = "allusers";
    }

    public static class Builder {

        private final AllUsersList allUsersList = new AllUsersList();

        /**
         * The username to start enumerating from.
         * @return {@code Builder}
         */
        public Builder auFrom(final String auFrom) {
            allUsersList.auFrom = auFrom;
            allUsersList.apiUrl.putQuery("aufrom", auFrom);
            return this;
        }

        /**
         * The username to stop enumerating at.
         * @return {@code Builder}
         */
        public Builder auTo(final String auTo) {
            allUsersList.auTo = auTo;
            allUsersList.apiUrl.putQuery("auto", auTo);
            return this;
        }

        /**
         * Search for all users that begin with this value.
         * @return {@code Builder}
         */
        public Builder auPrefix(final String auPrefix) {
            allUsersList.auPrefix = auPrefix;
            allUsersList.apiUrl.putQuery("auprefix", auPrefix);
            return this;
        }

        /**
         * Direction to sort in.
         * @return {@code Builder}
         */
        public Builder auDir(final Dir.Order auDir) {
            allUsersList.auDir = auDir;
            allUsersList.apiUrl.putQuery("auorder", auDir.getValue());
            return this;
        }

        /**
         * Only include users in the given groups. Does not include implicit or auto-promoted groups like *, user,
         * or autoconfirmed.
         * @return {@code Builder}
         */
        public Builder auGroup(final EnumSet<Group> auGroup) {
            allUsersList.auGroup = auGroup;
            allUsersList.apiUrl.putQuery("augroup", auGroup.stream()
                    .map(Group::getValue)
                    .collect(Collectors.joining("|")));
            return this;
        }

        /**
         * Exclude users in the given groups.
         * @return {@code Builder}
         */
        public Builder auExcludeGroup(final EnumSet<Group> auExcludeGroup) {
            allUsersList.auExcludeGroup = auExcludeGroup;
            allUsersList.apiUrl.putQuery("auexcludegroup", auExcludeGroup.stream()
                    .map(Group::getValue)
                    .collect(Collectors.joining("|")));
            return this;
        }

        /**
         * Only include users with the given rights. Does not include rights granted by implicit or auto-promoted
         * groups like *, user, or autoconfirmed.
         * Maximum number of values is 50 (500 for clients that are allowed higher limits).
         * @return {@code Builder}
         */
        public Builder auRights(final EnumSet<Rights> auRights) {
            allUsersList.auRights = auRights;
            allUsersList.apiUrl.putQuery("aurights", auRights.stream()
                    .map(Rights::getValue)
                    .collect(Collectors.joining("|")));
            return this;
        }

        /**
         * Which pieces of information to include
         * @return {@code Builder}
         */
        public Builder auProp(final EnumSet<AuProp> auProp) {
            allUsersList.auProp = auProp;
            allUsersList.apiUrl.putQuery("auprop", auProp.stream()
                    .map(AuProp::getValue)
                    .collect(Collectors.joining("|")));
            return this;
        }

        /**
         * How many images in total to return.
         * @param auLimit The value must be between 1 and 500.
         * @return {@code Builder}
         */
        public Builder auLimit(final int auLimit) {
            allUsersList.auLimit = auLimit;
            allUsersList.apiUrl.putQuery("aulimit", auLimit);
            return this;
        }

        /**
         * Only list users who have made edits.
         * @return {@code Builder}
         */
        public Builder auWithEditsOnly() {
            allUsersList.auWithEditsOnly = true;
            allUsersList.apiUrl.putQuery("auwitheditsonly", "1");
            return this;
        }

        /**
         * Only list users active in the last 30 days.
         * @return {@code Builder}
         */
        public Builder auActiveUsers() {
            allUsersList.auActiveUsers = true;
            allUsersList.apiUrl.putQuery("auactiveusers", "1");
            return this;
        }

        /**
         * With {@code auprop=centralids}, also indicate whether the user is attached with the wiki identified by this
         * ID.
         * @return {@code Builder}
         */
        public Builder auAttachedWiki() {
            allUsersList.auAttachedWiki = true;
            allUsersList.apiUrl.putQuery("auattachedwiki", "1");
            return this;
        }

        public AllUsersList build() {
            return allUsersList;
        }

    }

    @Getter
    public enum AuProp {

        /**
         * Adds the information about a current block on the user.
         */
        BLOCK_INFO("blockinfo"),

        /**
         * Adds the central IDs and attachment status for the user.
         */
        CENTRAL_IDS("centralids"),

        /**
         * Adds the edit count of the user.
         */
        EDIT_COUNT("editcount"),

        /**
         * Lists groups that the user is in. This uses more server resources and may return fewer results than the limit.
         */
        GROUPS("groups"),

        /**
         * Lists all the groups the user is automatically in.
         */
        IMPLICIT_GROUPS("implicitgroups"),

        /**
         * Adds the timestamp of when the user registered if available (may be blank).
         */
        REGISTRATION("registration"),

        /**
         * Lists rights that the user has.
         */
        RIGHTS("rights");

        private final String value;

        AuProp(String value) {
            this.value = value;
        }

    }

}
