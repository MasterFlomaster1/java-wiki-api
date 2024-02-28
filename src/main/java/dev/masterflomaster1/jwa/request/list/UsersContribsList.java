package dev.masterflomaster1.jwa.request.list;

import dev.masterflomaster1.jwa.common.Namespace;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Get all edits by a user.
 *
 * @see <a href="https://www.mediawiki.org/wiki/Special:MyLanguage/API:Usercontribs">API:Usercontribs</a>
 */
public class UsersContribsList extends AbstractList {

    private int ucLimit;
    private LocalDateTime ucStart;
    private LocalDateTime ucEnd;
    private String ucContinue;
    private Set<String> ucUser;
    private Set<Integer> ucUserIds;
    private String ucUserPrefix;
    private String ucIpRange;
    private UcDir ucDir;
    private Set<Namespace> ucNamespace;
    private Set<UcProp> ucProp;
    private Set<UcShow> ucShow;
    private String ucTag;

    private UsersContribsList() {
        name = "usercontribs";
    }

    public int getUcLimit() {
        return ucLimit;
    }

    public LocalDateTime getUcStart() {
        return ucStart;
    }

    public LocalDateTime getUcEnd() {
        return ucEnd;
    }

    public String getUcContinue() {
        return ucContinue;
    }

    public Set<String> getUcUser() {
        return ucUser;
    }

    public Set<Integer> getUcUserIds() {
        return ucUserIds;
    }

    public String getUcUserPrefix() {
        return ucUserPrefix;
    }

    public String getUcIpRange() {
        return ucIpRange;
    }

    public UcDir getUcDir() {
        return ucDir;
    }

    public Set<Namespace> getUcNamespace() {
        return ucNamespace;
    }

    public Set<UcProp> getUcProp() {
        return ucProp;
    }

    public Set<UcShow> getUcShow() {
        return ucShow;
    }

    public String getUcTag() {
        return ucTag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsersContribsList that = (UsersContribsList) o;

        if (ucLimit != that.ucLimit) return false;
        if (!Objects.equals(ucStart, that.ucStart)) return false;
        if (!Objects.equals(ucEnd, that.ucEnd)) return false;
        if (!Objects.equals(ucContinue, that.ucContinue)) return false;
        if (!Objects.equals(ucUser, that.ucUser)) return false;
        if (!Objects.equals(ucUserIds, that.ucUserIds)) return false;
        if (!Objects.equals(ucUserPrefix, that.ucUserPrefix)) return false;
        if (!Objects.equals(ucIpRange, that.ucIpRange)) return false;
        if (ucDir != that.ucDir) return false;
        if (!Objects.equals(ucNamespace, that.ucNamespace)) return false;
        if (!Objects.equals(ucProp, that.ucProp)) return false;
        if (!Objects.equals(ucShow, that.ucShow)) return false;
        return Objects.equals(ucTag, that.ucTag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ucLimit, ucStart, ucEnd, ucContinue, ucUser, ucUserIds, ucUserPrefix, ucIpRange, ucDir,
                ucNamespace, ucProp, ucShow, ucTag);
    }

    public static class Builder {

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
        public Builder ucStart(LocalDateTime ucStart) {
            usersContribsList.ucStart = ucStart;
            usersContribsList.apiUrl.putQuery("ucstart", ucStart);
            return this;
        }

        /**
         * The end timestamp to return to, i.e. revisions after this timestamp.
         * @return {@code Builder}
         */
        public Builder ucEnd(LocalDateTime ucEnd) {
            usersContribsList.ucEnd = ucEnd;
            usersContribsList.apiUrl.putQuery("ucend", ucEnd);
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
            usersContribsList.apiUrl.putQuery("ucuser", String.join("|", ucUser));
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
            usersContribsList.apiUrl.putQuery("ucuserids", ucUserIds.stream()
                    .map(Object::toString)
                    .collect(Collectors.joining("|")));
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
        public Builder ucDir(UcDir ucDir) {
            usersContribsList.ucDir = ucDir;
            usersContribsList.apiUrl.putQuery("ucdir", ucDir.getValue());
            return this;
        }

        /**
         * Only list contributions in these namespaces.
         * @return {@code Builder}
         */
        public Builder ucNamespace(Set<Namespace> ucNamespace) {
            usersContribsList.ucNamespace = ucNamespace;
            usersContribsList.apiUrl.putQuery("ucnamespace", ucNamespace.stream()
                    .map(Namespace::getValue)
                    .collect(Collectors.joining("|")));
            return this;
        }

        /**
         * Include additional pieces of information.
         * @return {@code Builder}
         */
        public Builder ucProp(Set<UcProp> ucProp) {
            usersContribsList.ucProp = ucProp;
            usersContribsList.apiUrl.putQuery("ucprop", ucProp.stream()
                    .map(UcProp::getValue)
                    .collect(Collectors.joining("|")));
            return this;
        }

        /**
         * Show only items that meet these criteria, e.g. non minor edits only: ucshow=!minor.
         * @return {@code Builder}
         */
        public Builder ucShow(Set<UcShow> ucShow) {
            usersContribsList.ucShow = ucShow;
            usersContribsList.apiUrl.putQuery("ucshow", ucShow.stream()
                    .map(UcShow::getValue)
                    .collect(Collectors.joining("|")));
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

    public enum UcDir {

        NEWER ("newer"),
        OLDER ("older");

        private final String value;

        UcDir(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

    }

    public enum UcProp {

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

        public String getValue() {
            return value;
        }

    }

    public enum UcShow {

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

        public String getValue() {
            return value;
        }
    }

}
