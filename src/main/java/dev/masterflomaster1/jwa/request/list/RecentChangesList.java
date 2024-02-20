package dev.masterflomaster1.jwa.request.list;

import dev.masterflomaster1.jwa.common.Namespace;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Enumerate recent changes.
 *
 * @see <a href="https://www.mediawiki.org/wiki/API:RecentChanges">API:RecentChanges</a>
 */
public class RecentChangesList extends AbstractList {

    private LocalDateTime rcStart;
    private LocalDateTime rcEnd;
    private RcDir rcDir;
    private Namespace rcNamespace;
    private String rcUser;
    private String rcExcludeUser;
    private String rcTag;
    private Set<RcProp> rcProp;
    private Set<RcShow> rcShow;
    private int rcLimit;
    private Set<RcType> rcType;
    private boolean rcTopOnly;
    private String rcTitle;
    private String rcContinue;
    private boolean rcGenerateRevisions;

    private RecentChangesList() {
        url = "&list=recentchanges";
    }

    public LocalDateTime getRcStart() {
        return rcStart;
    }

    public LocalDateTime getRcEnd() {
        return rcEnd;
    }

    public RcDir getRcDir() {
        return rcDir;
    }

    public Namespace getRcNamespace() {
        return rcNamespace;
    }

    public String getRcUser() {
        return rcUser;
    }

    public String getRcExcludeUser() {
        return rcExcludeUser;
    }

    public String getRcTag() {
        return rcTag;
    }

    public Set<RcProp> getRcProp() {
        return rcProp;
    }

    public Set<RcShow> getRcShow() {
        return rcShow;
    }

    public int getRcLimit() {
        return rcLimit;
    }

    public Set<RcType> getRcType() {
        return rcType;
    }

    public boolean isRcTopOnly() {
        return rcTopOnly;
    }

    public String getRcTitle() {
        return rcTitle;
    }

    public String getRcContinue() {
        return rcContinue;
    }

    public boolean isRcGenerateRevisions() {
        return rcGenerateRevisions;
    }

    public static class Builder {

        private final RecentChangesList recentChangesList = new RecentChangesList();

        /**
         * The timestamp to start enumerating from.
         * @return {@code Builder}
         */
        public Builder rcStart(LocalDateTime rcStart) {
            recentChangesList.rcStart = rcStart;
            recentChangesList.url += "&rcstart=" + URLEncoder.encode(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'").format(rcStart), StandardCharsets.UTF_8);
            return this;
        }

        /**
         * The timestamp to end enumerating.
         * @return {@code Builder}
         */
        public Builder rcEnd(LocalDateTime rcEnd) {
            recentChangesList.rcEnd = rcEnd;
            recentChangesList.url += "&rcend=" + URLEncoder.encode(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'").format(rcEnd), StandardCharsets.UTF_8);
            return this;
        }

        /**
         * In which direction to enumerate.
         * @return {@code Builder}
         */
        public Builder rcDir(RcDir rcDir) {
            recentChangesList.rcDir = rcDir;
            recentChangesList.url += "&rcdir=" + rcDir.value;
            return this;
        }

        /**
         * Filter changes to only these namespaces.
         * @return {@code Builder}
         */
        public Builder rcNamespace(Namespace rcNamespace) {
            recentChangesList.rcNamespace = rcNamespace;
            recentChangesList.url += "&rcnamespace=" + rcNamespace.getValue();
            return this;
        }

        /**
         * Only list changes by this user.
         * @param rcUser user, by any of username, IP, Temporary user, IP range and user ID (e.g. "#12345")
         * @return {@code Builder}
         */
        public Builder rcUser(String rcUser) {
            recentChangesList.rcUser = rcUser;
            recentChangesList.url += "&rcuser=" + rcUser;
            return this;
        }

        /**
         * Don't list changes by this user.
         * @param rcExcludeUser user, by any of username, IP, Temporary user, IP range and user ID (e.g. "#12345")
         * @return {@code Builder}
         */
        public Builder rcExcludeUser(String rcExcludeUser) {
            recentChangesList.rcExcludeUser = rcExcludeUser;
            recentChangesList.url += "&rcexcludeuser=" + rcExcludeUser;
            return this;
        }

        /**
         * Only list changes tagged with this tag.
         * @return {@code Builder}
         */
        public Builder rcTag(String rcTag) {
            recentChangesList.rcTag = rcTag;
            recentChangesList.url += "&rctag=" + rcTag;
            return this;
        }

        /**
         * Include additional pieces of information.
         * @return {@code Builder}
         */
        public Builder rcProp(Set<RcProp> rcProp) {
            recentChangesList.rcProp = rcProp;
            recentChangesList.url += "&rcprop=" + rcProp.stream()
                    .map(RcProp::getValue)
                    .collect(Collectors.joining("%7C"));
            return this;
        }

        /**
         * Show only items that meet these criteria. For example, to see only minor edits done by logged-in users,
         * set rcshow=minor|!anon.
         *
         * When using {@code oresreview} or {@code !oresreview}, revisions without a score (e.g. very old revisions) are
         * considered as not needing review even if they would need review if scored.
         * @return {@code Builder}
         */
        public Builder rcShow(Set<RcShow> rcShow) {
            recentChangesList.rcShow = rcShow;
            recentChangesList.url = "&rcshow=" + rcShow.stream()
                    .map(RcShow::getValue)
                    .collect(Collectors.joining("%7C"));
            return this;
        }

        /**
         * How many total changes to return. Default: 10
         * @param rcLimit The value must be between 1 and 500.
         * @return {@code Builder}
         */
        public Builder rcLimit(int rcLimit) {
            recentChangesList.rcLimit = rcLimit;
            recentChangesList.url += "&rclimit=" + rcLimit;
            return this;
        }

        /**
         * Which types of changes to show. Default: edit|new|log|categorize
         * @return {@code Builder}
         */
        public Builder rcType(Set<RcType> rcType) {
            recentChangesList.rcType = rcType;
            recentChangesList.url += "&rctype=" + rcType.stream()
                    .map(RcType::getValue)
                    .collect(Collectors.joining("%7C"));
            return this;
        }

        /**
         * Only list changes which are the latest revision.
         * @return {@code Builder}
         */
        public Builder rcTopOnly() {
            recentChangesList.rcTopOnly = true;
            recentChangesList.url += "&rctoponly=1";
            return this;
        }

        /**
         * Filter entries to those related to a page.
         * @return {@code Builder}
         */
        public Builder rcTitle(String rcTitle) {
            recentChangesList.rcTitle = rcTitle;
            recentChangesList.url += "&rctitle=" + URLEncoder.encode(rcTitle, StandardCharsets.UTF_8);
            return this;
        }

        /**
         * When more results are available, use this to continue.
         * More detailed information on how to continue queries can be found on
         * <a href="https://www.mediawiki.org/wiki/API:Continue">mediawiki.org</a>.
         * @return {@code Builder}
         */
        public Builder rcContinue(String rcContinue) {
            recentChangesList.rcContinue = rcContinue;
            recentChangesList.url += "&rccontinue=" + URLEncoder.encode(rcContinue, StandardCharsets.UTF_8);
            return this;
        }

        /**
         * When being used as a generator, generate revision IDs rather than titles. Recent change entries without
         * associated revision IDs (e.g. most log entries) will generate nothing.
         * @return {@code Builder}
         */
        public Builder rcGenerateRevisions() {
            recentChangesList.rcGenerateRevisions = true;
            recentChangesList.url += "&rcgeneraterevisions=1";
            return this;
        }

        public RecentChangesList build() {
            return recentChangesList;
        }

    }

    /**
     * In which direction to enumerate.
     */
    public enum RcDir {
        NEWER ("newer"),
        OLDER ("older");

        private final String value;

        RcDir(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    /**
     * Which types of changes to show.
     */
    public enum RcType {
        CATEGORIZE ("categorize"),
        EDIT ("edit"),
        EXTERNAL ("external"),
        LOG ("log"),
        NEW ("new");

        private final String value;

        RcType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public enum RcProp {
        COMMENT ("comment"),
        FLAGS ("flags"),
        IDS ("ids"),
        LOG_INFO ("loginfo"),
        PARSED_COMMENT ("parsedcomment"),
        PATROLLED ("patrolled"),
        REDIRECT ("redirect"),
        SHA_1 ("sha1"),
        SIZES ("sizes"),
        TAGS ("tags"),
        TIMESTAMP ("timestamp"),
        TITLE ("title"),
        USER ("user"),
        USER_ID ("userid");

        private final String value;

        RcProp(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public enum RcShow {
        NOT_ANON ("!anon"),
        NOT_AUTO_PATROLLED ("!autopatrolled"),
        NOT_BOT ("!bot"),
        NOT_MINOR ("!minor"),
        NOT_ORES_REVIEW ("!oresreview"),
        NOT_PATROLLED ("!patrolled"),
        NOT_REDIRECT ("!redirect"),
        ANON ("anon"),
        AUTO_PATROLLED ("autopatrolled"),
        BOT ("bot"),
        MINOR ("minor"),
        ORES_REVIEW ("oresreview"),
        PATROLLED ("patrolled"),
        REDIRECT ("redirect"),
        UNPATROLLED ("unpatrolled");

        private final String value;

        RcShow(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

}
