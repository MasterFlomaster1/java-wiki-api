package dev.masterflomaster1.jwa.request.list;

import dev.masterflomaster1.jwa.common.Dir;
import dev.masterflomaster1.jwa.common.Namespace;
import dev.masterflomaster1.jwa.internal.EnumValueProvider;
import dev.masterflomaster1.jwa.request.AbstractBuilder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.Instant;
import java.util.EnumSet;
import java.util.Set;

/**
 * Get all edits by a user.
 *
 * @see <a href="https://www.mediawiki.org/wiki/Special:MyLanguage/API:Usercontribs">API:Usercontribs</a>
 */
@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@SuppressWarnings("SpellCheckingInspection")
public final class UsersContribsList extends AbstractList {

    private int ucLimit;
    private Instant ucStart;
    private Instant ucEnd;
    private String ucContinue;
    private Set<String> ucUser;
    private Set<Integer> ucUserIds;
    private String ucUserPrefix;
    private String ucIpRange;
    private Dir.Time ucDir;
    private EnumSet<Namespace> ucNamespace;
    private EnumSet<UcProp> ucProp;
    private EnumSet<UcShow> ucShow;
    private String ucTag;

    private UsersContribsList() {
        super("usercontribs");
    }

    public static class Builder extends AbstractBuilder {

        private final UsersContribsList usersContribsList = new UsersContribsList();

        /**
         * The maximum number of contributions to return.
         * @param ucLimit The value must be between 1 and 500.
         * @return {@code Builder}
         */
        public Builder ucLimit(int ucLimit) {
            usersContribsList.ucLimit = ucLimit;
            usersContribsList.apiUrl.putQuery("uclimit", ucLimit);
            return this;
        }

        /**
         * The start timestamp to return from, i.e. revisions before this timestamp.
         * @return {@code Builder}
         */
        public Builder ucStart(Instant ucStart) {
            usersContribsList.ucStart = ucStart;
            usersContribsList.apiUrl.putQuery("ucstart", ucStart.toString());
            return this;
        }

        /**
         * The end timestamp to return to, i.e. revisions after this timestamp.
         * @return {@code Builder}
         */
        public Builder ucEnd(Instant ucEnd) {
            usersContribsList.ucEnd = ucEnd;
            usersContribsList.apiUrl.putQuery("ucend", ucEnd.toString());
            return this;
        }

        /**
         * When more results are available, use this to continue.
         * More detailed information on how to continue queries can be found on
         * <a href="https://www.mediawiki.org/wiki/API:Continue">mediawiki.org</a>.
         * @return {@code Builder}
         */
        public Builder ucContinue(String ucContinue) {
            usersContribsList.ucContinue = ucContinue;
            usersContribsList.apiUrl.putQuery("uccontinue", ucContinue);
            return this;
        }

        /**
         * The users to retrieve contributions for. Cannot be used with {@code ucuserids}, {@code ucuserprefix}, or
         * {@code uciprange}.
         * @param ucUser Maximum number of values is 50 (500 for clients that are allowed higher limits).
         * @return {@code Builder}
         */
        public Builder ucUser(Set<String> ucUser) {
            usersContribsList.ucUser = ucUser;
            usersContribsList.apiUrl.putQuery("ucuser", mergeString(ucUser));
            return this;
        }

        /**
         * The user IDs to retrieve contributions for. Cannot be used with {@code ucuserids}, {@code ucuserprefix}, or
         * {@code uciprange}.
         * @param ucUserIds Maximum number of values is 50 (500 for clients that are allowed higher limits).
         * @return {@code Builder}
         */
        public Builder ucUserIds(Set<Integer> ucUserIds) {
            usersContribsList.ucUserIds = ucUserIds;
            usersContribsList.apiUrl.putQuery("ucuserids", mergeInt(ucUserIds));
            return this;
        }

        /**
         * Retrieve contributions for all users whose names begin with this value. Cannot be used with
         * {@code ucuserids}, {@code ucuserprefix}, or {@code uciprange}.
         * @return {@code Builder}
         */
        public Builder ucUserPrefix(String ucUserPrefix) {
            usersContribsList.ucUserPrefix = ucUserPrefix;
            usersContribsList.apiUrl.putQuery("ucuserprefix", ucUserPrefix);
            return this;
        }

        /**
         * The CIDR range to retrieve contributions for.
         * Cannot be used with {@code ucuserids}, {@code ucuserprefix}, or {@code uciprange}.
         * @return {@code Builder}
         */
        public Builder ucIpRange(String ucIpRange) {
            usersContribsList.ucIpRange = ucIpRange;
            usersContribsList.apiUrl.putQuery("uciprange", ucIpRange);
            return this;
        }

        /**
         * In which direction to enumerate
         * @return {@code Builder}
         */
        public Builder ucDir(Dir.Time ucDir) {
            usersContribsList.ucDir = ucDir;
            usersContribsList.apiUrl.putQuery("ucdir", ucDir.getValue());
            return this;
        }

        /**
         * Only list contributions in these namespaces.
         * @return {@code Builder}
         */
        public Builder ucNamespace(EnumSet<Namespace> ucNamespace) {
            usersContribsList.ucNamespace = ucNamespace;
            usersContribsList.apiUrl.putQuery("ucnamespace", merge(ucNamespace));
            return this;
        }

        /**
         * Include additional pieces of information.
         * @return {@code Builder}
         */
        public Builder ucProp(EnumSet<UcProp> ucProp) {
            usersContribsList.ucProp = ucProp;
            usersContribsList.apiUrl.putQuery("ucprop", merge(ucProp));
            return this;
        }

        /**
         * Show only items that meet these criteria, e.g. non minor edits only: ucshow=!minor.
         * @return {@code Builder}
         */
        public Builder ucShow(EnumSet<UcShow> ucShow) {
            usersContribsList.ucShow = ucShow;
            usersContribsList.apiUrl.putQuery("ucshow", merge(ucShow));
            return this;
        }

        /**
         * Only list revisions tagged with this tag.
         * @return {@code Builder}
         */
        public Builder ucTag(String ucTag) {
            usersContribsList.ucTag = ucTag;
            usersContribsList.apiUrl.putQuery("uctag", ucTag);
            return this;
        }

        public UsersContribsList build() {
            return usersContribsList;
        }

    }

    @Getter
    public enum UcProp implements EnumValueProvider {

        COMMENT ("comment"),
        FLAGS ("flags"),
        IDS ("ids"),
        ORESSCORES ("oresscores"),
        PARSED_COMMENT ("parsedcomment"),
        PATROLLED ("patrolled"),
        SIZE ("size"),
        SIZE_DIFF ("sizediff"),
        TAGS ("tags"),
        TIMESTAMP ("timestamp"),
        TITLE ("title");

        private final String value;

        UcProp(String value) {
            this.value = value;
        }

    }

    @Getter
    public enum UcShow implements EnumValueProvider {

        NOT_AUTO_PATROLLED ("!autopatrolled"),
        NOT_MINOR ("!minor"),
        NOT_NEW ("!new"),
        NOT_ORES_REVIEW ("!oresreview"),
        NOT_PATROLLED ("!patrolled"),
        NOT_TOP ("!top"),
        AUTO_PATROLLED ("autopatrolled"),
        MINOR ("minor"),
        NEW ("new"),
        ORES_REVIEW ("oresreview"),
        PATROLLED ("patrolled"),
        TOP ("top");

        private final String value;

        UcShow(String value) {
            this.value = value;
        }

    }

}
