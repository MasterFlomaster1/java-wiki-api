package dev.masterflomaster1.jwa.request.meta;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Get information about the current user.
 *
 * @see <a href="https://www.mediawiki.org/wiki/Special:MyLanguage/API:Userinfo">API:Userinfo</a>
 */
public class UserInfoMeta extends AbstractMeta {

    private Set<UiProp> uiProp;
    private String uiAttachedWiki;

    private UserInfoMeta() {
        url = "&meta=userinfo";
    }

    public Set<UiProp> getUiProp() {
        return uiProp;
    }

    public String getUiAttachedWiki() {
        return uiAttachedWiki;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserInfoMeta that = (UserInfoMeta) o;

        if (!Objects.equals(uiProp, that.uiProp)) return false;
        return Objects.equals(uiAttachedWiki, that.uiAttachedWiki);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uiProp, uiAttachedWiki);
    }

    public static class Builder {

        private final UserInfoMeta userInfoMeta = new UserInfoMeta();

        /**
         * Which pieces of information to include.
         * @return {@code Builder}
         */
        public Builder uiProp(Set<UiProp> uiProp) {
            userInfoMeta.uiProp = uiProp;
            userInfoMeta.url += "&uiprop=" + uiProp.stream()
                    .map(UiProp::getValue)
                    .collect(Collectors.joining("%7C"));
            return this;
        }

        /**
         * With {@code uiprop=centralids}, indicate whether the user is attached with the wiki identified by this ID.
         * @return {@code Builder}
         */
        public Builder uiAttachedWiki(String uiAttachedWiki) {
            userInfoMeta.uiAttachedWiki = uiAttachedWiki;
            userInfoMeta.url += "&uiattachedwiki=" + URLEncoder.encode(uiAttachedWiki, StandardCharsets.UTF_8);
            return this;
        }

        public UserInfoMeta build() {
            return userInfoMeta;
        }

    }

    public enum UiProp {

        /**
         * Tags if the current user is blocked, by whom, and for what reason.
         */
        BLOCK_INFO ("blockinfo"),

        /**
         * Adds a tag messages if the current user has pending messages.
         */
        HAS_MSG ("hasmsg"),

        /**
         * Lists all the groups the current user belongs to.
         */
        GROUPS ("groups"),

        /**
         * Lists groups that the current user has been explicitly assigned to, including the expiry date of each group
         * membership.
         */
        GROUP_MEMBERSHIPS ("groupmemberships"),

        /**
         * Lists all the groups the current user is automatically a member of.
         */
        IMPLICIT_GROUPS ("implicitgroups"),

        /**
         * Lists all the rights the current user has.
         */
        RIGHTS ("rights"),

        /**
         * Lists the groups the current user can add to and remove from.
         */
        CHANGEABLE_GROUPS ("changeablegroups"),

        /**
         * Lists all preferences the current user has set.
         */
        OPTIONS ("options"),

        /**
         * Adds the current user's edit count.
         */
        EDIT_COUNT ("editcount"),

        /**
         * Lists all rate limits applying to the current user.
         */
        RATE_LIMITS ("ratelimits"),

        /**
         * Lists all rate limits that would apply to the current user if they were not exempt from all ratelimits based
         * on user rights or ip
         */
        THEORETICAL_RATE_LIMITS ("theoreticalratelimits"),

        /**
         * Adds the user's email address and email authentication date.
         */
        EMAIL ("email"),

        /**
         * Adds the user's real name.
         */
        REAL_NAME ("realname"),

        /**
         * Echoes the {@code Accept-Language} header sent by the client in a structured format.
         */
        ACCEPT_LANG ("acceptlang"),

        /**
         * Adds the user's registration date.
         */
        REGISTRATION_DATE ("registrationdate"),

        /**
         * Adds the count of unread pages on the user's watchlist (maximum 999; returns 1000+ if more).
         */
        UNREAD_COUNT ("unreadcount"),

        /**
         * Adds the central IDs and attachment status for the user.
         */
        CENTRAL_IDS ("centralids"),

        /**
         * Adds the date of user's latest contribution.
         */
        LATEST_CONTRIB ("latestcontrib"),

        /**
         * Indicates whether the user is allowed to create accounts. To check whether some specific account can be
         * created, use {@code action=query&list=users&usprop=cancreate}.
         */
        CAN_CREATE_ACCOUNT ("cancreateaccount");

        private final String value;

        UiProp(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

    }

}
