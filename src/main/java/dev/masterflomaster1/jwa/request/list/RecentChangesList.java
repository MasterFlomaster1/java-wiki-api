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

/**
 * Enumerate recent changes.
 *
 * @see <a href="https://www.mediawiki.org/wiki/API:RecentChanges">API:RecentChanges</a>
 */
@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@SuppressWarnings("SpellCheckingInspection")
public final class RecentChangesList extends AbstractList {

    private Instant rcStart;
    private Instant rcEnd;
    private Dir.Time rcDir;
    private Namespace rcNamespace;
    private String rcUser;
    private String rcExcludeUser;
    private String rcTag;
    private EnumSet<RcProp> rcProp;
    private EnumSet<RcShow> rcShow;
    private int rcLimit;
    private EnumSet<RcType> rcType;
    private boolean rcTopOnly;
    private String rcTitle;
    private String rcContinue;
    private boolean rcGenerateRevisions;

    private RecentChangesList() {
        super("recentchanges");
    }

    public static class Builder extends AbstractBuilder {

        private final RecentChangesList recentChangesList = new RecentChangesList();

        /**
         * The timestamp to start enumerating from.
         * @return {@code Builder}
         */
        public Builder rcStart(Instant rcStart) {
            recentChangesList.rcStart = rcStart;
            recentChangesList.apiUrl.putQuery("rcstart", rcStart.toString());
            return this;
        }

        /**
         * The timestamp to end enumerating.
         * @return {@code Builder}
         */
        public Builder rcEnd(Instant rcEnd) {
            recentChangesList.rcEnd = rcEnd;
            recentChangesList.apiUrl.putQuery("rcend", rcEnd.toString());
            return this;
        }

        /**
         * In which direction to enumerate.
         * @return {@code Builder}
         */
        public Builder rcDir(Dir.Time rcDir) {
            recentChangesList.rcDir = rcDir;
            recentChangesList.apiUrl.putQuery("rcdir", rcDir.getValue());
            return this;
        }

        /**
         * Filter changes to only these namespaces.
         * @return {@code Builder}
         */
        public Builder rcNamespace(Namespace rcNamespace) {
            recentChangesList.rcNamespace = rcNamespace;
            recentChangesList.apiUrl.putQuery("rcnamespace", rcNamespace.getValue());
            return this;
        }

        /**
         * Only list changes by this user.
         * @param rcUser user, by any of username, IP, Temporary user, IP range and user ID (e.g. "#12345")
         * @return {@code Builder}
         */
        public Builder rcUser(String rcUser) {
            recentChangesList.rcUser = rcUser;
            recentChangesList.apiUrl.putQuery("rcuser", rcUser);
            return this;
        }

        /**
         * Don't list changes by this user.
         * @param rcExcludeUser user, by any of username, IP, Temporary user, IP range and user ID (e.g. "#12345")
         * @return {@code Builder}
         */
        public Builder rcExcludeUser(String rcExcludeUser) {
            recentChangesList.rcExcludeUser = rcExcludeUser;
            recentChangesList.apiUrl.putQuery("rcexcludeuser", rcExcludeUser);
            return this;
        }

        /**
         * Only list changes tagged with this tag.
         * @return {@code Builder}
         */
        public Builder rcTag(String rcTag) {
            recentChangesList.rcTag = rcTag;
            recentChangesList.apiUrl.putQuery("rctag", rcTag);
            return this;
        }

        /**
         * Include additional pieces of information.
         * @return {@code Builder}
         */
        public Builder rcProp(EnumSet<RcProp> rcProp) {
            recentChangesList.rcProp = rcProp;
            recentChangesList.apiUrl.putQuery("rcprop", merge(rcProp));
            return this;
        }

        /**
         * Show only items that meet these criteria. For example, to see only minor edits done by logged-in users,
         * set rcshow=minor|!anon.
         * When using {@code oresreview} or {@code !oresreview}, revisions without a score (e.g. very old revisions) are
         * considered as not needing review even if they would need review if scored.
         * @return {@code Builder}
         */
        public Builder rcShow(EnumSet<RcShow> rcShow) {
            recentChangesList.rcShow = rcShow;
            recentChangesList.apiUrl.putQuery("rcshow", merge(rcShow));
            return this;
        }

        /**
         * How many total changes to return. Default: 10
         * @param rcLimit The value must be between 1 and 500.
         * @return {@code Builder}
         */
        public Builder rcLimit(int rcLimit) {
            recentChangesList.rcLimit = rcLimit;
            recentChangesList.apiUrl.putQuery("rclimit", rcLimit);
            return this;
        }

        /**
         * Which types of changes to show. Default: edit|new|log|categorize
         * @return {@code Builder}
         */
        public Builder rcType(EnumSet<RcType> rcType) {
            recentChangesList.rcType = rcType;
            recentChangesList.apiUrl.putQuery("rctype", merge(rcType));
            return this;
        }

        /**
         * Only list changes which are the latest revision.
         * @return {@code Builder}
         */
        public Builder rcTopOnly() {
            recentChangesList.rcTopOnly = true;
            recentChangesList.apiUrl.putQuery("rctoponly", "1");
            return this;
        }

        /**
         * Filter entries to those related to a page.
         * @return {@code Builder}
         */
        public Builder rcTitle(String rcTitle) {
            recentChangesList.rcTitle = rcTitle;
            recentChangesList.apiUrl.putQuery("rctitle", rcTitle);
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
            recentChangesList.apiUrl.putQuery("rccontinue", rcContinue);
            return this;
        }

        /**
         * When being used as a generator, generate revision IDs rather than titles. Recent change entries without
         * associated revision IDs (e.g. most log entries) will generate nothing.
         * @return {@code Builder}
         */
        public Builder rcGenerateRevisions() {
            recentChangesList.rcGenerateRevisions = true;
            recentChangesList.apiUrl.putQuery("rcgeneraterevisions", "1");
            return this;
        }

        public RecentChangesList build() {
            return recentChangesList;
        }

    }

    /**
     * Which types of changes to show.
     */
    @Getter
    public enum RcType implements EnumValueProvider {
        CATEGORIZE ("categorize"),
        EDIT ("edit"),
        EXTERNAL ("external"),
        LOG ("log"),
        NEW ("new");

        private final String value;

        RcType(String value) {
            this.value = value;
        }

    }

    @Getter
    public enum RcProp implements EnumValueProvider {
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

    }

    @Getter
    public enum RcShow implements EnumValueProvider {
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

    }

}
