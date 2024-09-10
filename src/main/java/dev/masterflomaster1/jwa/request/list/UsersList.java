package dev.masterflomaster1.jwa.request.list;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Get information about a list of users.
 *
 * @see <a href="https://www.mediawiki.org/wiki/API:Users">API:Users</a>
 */
@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@SuppressWarnings("SpellCheckingInspection")
public final class UsersList extends AbstractList {

    private Set<UsProp> usProp;
    private String usAttachedWiki;
    private Set<String> usUsers;
    private Set<Integer> usUserIds;

    private UsersList() {
        name = "users";
    }

    public static class Builder {

        private final UsersList usersList = new UsersList();

        /**
         * Which pieces of information to include
         * @return {@code Builder}
         */
        public Builder usProp(Set<UsProp> usProp) {
            usersList.usProp = usProp;
            usersList.apiUrl.putQuery("usprop", usProp.stream()
                    .map(UsProp::getValue)
                    .collect(Collectors.joining("|")));
            return this;
        }

        /**
         * With {@code usprop=centralids}, indicate whether the user is attached with the wiki identified by this ID.
         * @return {@code Builder}
         */
        public Builder usAttachedWiki(String usAttachedWiki) {
            usersList.usAttachedWiki = usAttachedWiki;
            usersList.apiUrl.putQuery("usattachedwiki", usAttachedWiki);
            return this;
        }

        /**
         * A list of users to obtain information for.
         * @param usUsers Maximum number of values is 50 (500 for clients that are allowed higher limits).
         * @return {@code Builder}
         */
        public Builder usUsers(Set<String> usUsers) {
            usersList.usUsers = usUsers;
            usersList.apiUrl.putQuery("ususers", String.join("|", usUsers));
            return this;
        }

        /**
         * A list of user IDs to obtain information for.
         * @param usUserIds Maximum number of values is 50 (500 for clients that are allowed higher limits).
         * @return {@code Builder}
         */
        public Builder usUserIds(Set<Integer> usUserIds) {
            usersList.usUserIds = usUserIds;
            usersList.apiUrl.putQuery("ususerids", usUserIds.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining("|")));
            return this;
        }

        public UsersList build() {
            return usersList;
        }

    }

    /**
     * Which pieces of information to include
     */
    @Getter
    public enum UsProp {

        /** Tags if the user is blocked, by whom, and for what reason. */
        BLOCK_INFO ("blockinfo"),

        /** Lists all the groups each user belongs to. */
        GROUPS ("groups"),

        /**
         * Lists groups that each user has been explicitly assigned to, including the expiry date of each group
         * membership.
         */
        GROUP_MEMBERSHIP ("groupmemberships"),

        /** Lists all the groups a user is automatically a member of. */
        IMPLICIT_GROUPS ("implicitgroups"),

        /** Lists all the rights each user has. */
        RIGHTS ("rights"),

        /** Adds the user's edit count. */
        EDIT_COUNT ("editcount"),

        /** Adds the user's registration timestamp. */
        REGISTRATION ("registration"),

        /**
         * Tags if the user can and wants to receive email through Special:Emailuser.
         */
        EMAILABLE ("emailable"),

        /** Tags the gender of the user. Returns "male", "female", or "unknown". */
        GENDER ("gender"),

        /** Adds the central IDs and attachment status for the user. */
        CENTRAL_IDS ("centralids"),

        /**
         *Indicates whether an account for valid but unregistered usernames can be created. To check whether the current
         * user can perform the account creation, use {@code action=query&meta=userinfo&uiprop=cancreateaccount}.
         */
        CAN_CREATE ("cancreate");

        private final String value;

        UsProp(String value) {
            this.value = value;
        }

    }

}
