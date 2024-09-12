package dev.masterflomaster1.jwa.request.action;

import lombok.Getter;
import lombok.ToString;

import java.util.EnumSet;
import java.util.stream.Collectors;

/**
 * Get the difference between two pages.
 *
 * @see <a href="https://www.mediawiki.org/wiki/API:Compare">API:Compare</a>
 */
@Getter
@ToString
@SuppressWarnings("SpellCheckingInspection")
public final class CompareAction extends AbstractAction {

    private String fromTitle;
    private int fromId;
    private long fromRev;
    private boolean fromPst;
    private String toTitle;
    private int toId;
    private long toRev;
    private ToRelative toRelative;
    private boolean toPst;
    private EnumSet<Prop> prop;
    private EnumSet<Slots> slots;
    private DiffType diffType;

    private CompareAction() {
        apiUrl.setAction("compare");
    }

    public static class Builder {

        private final CompareAction compareAction = new CompareAction();

        /**
         * First title to compare.
         * @return {@code Builder}
         */
        public Builder fromTitle(String fromTitle) {
            compareAction.fromTitle = fromTitle;
            compareAction.apiUrl.putQuery("fromtitle", fromTitle);
            return this;
        }

        /**
         * First page ID to compare.
         * @return {@code Builder}
         */
        public Builder fromId(int fromId) {
            compareAction.fromId = fromId;
            compareAction.apiUrl.putQuery("fromid", fromId);
            return this;
        }

        /**
         * First revision to compare.
         * @return {@code Builder}
         */
        public Builder fromRev(long fromRev) {
            compareAction.fromRev = fromRev;
            compareAction.apiUrl.putQuery("fromrev", fromRev);
            return this;
        }

        /**
         * Do a pre-save transform on {@code fromtext-{slot}}
         * @return {@code Builder}
         */
        public Builder fromPst() {
            compareAction.fromPst = true;
            compareAction.apiUrl.putQuery("frompst", "1");
            return this;
        }

        /**
         * Second title to compare.
         * @return {@code Builder}
         */
        public Builder toTitle(String toTitle) {
            compareAction.toTitle = toTitle;
            compareAction.apiUrl.putQuery("toTitle", toTitle);
            return this;
        }

        /**
         * Second page ID to compare.
         * @return {@code Builder}
         */
        public Builder toId(int toId) {
            compareAction.toId = toId;
            compareAction.apiUrl.putQuery("toTitle", toId);
            return this;
        }

        /**
         * Second revision to compare.
         * @return {@code Builder}
         */
        public Builder toRev(long toRev) {
            compareAction.toRev = toRev;
            compareAction.apiUrl.putQuery("torev", toRev);
            return this;
        }

        /**
         * Use a revision relative to the revision determined from {@code fromtitle}, {@code fromid} or {@code fromrev}.
         * All of the other 'to' options will be ignored.
         * @return {@code Builder}
         */
        public Builder toRelative(ToRelative toRelative) {
            compareAction.toRelative = toRelative;
            compareAction.apiUrl.putQuery("torelative", toRelative.getValue());
            return this;
        }

        /**
         * Do a pre-save transform on {@code totext}.
         * @return {@code Builder}
         */
        public Builder toPst() {
            compareAction.toPst = true;
            compareAction.apiUrl.putQuery("topst", "1");
            return this;
        }

        /**
         * Which pieces of information to get.
         * @return {@code Builder}
         */
        public Builder prop(EnumSet<Prop> prop) {
            compareAction.prop = prop;
            compareAction.apiUrl.putQuery("prop", prop.stream()
                    .map(Prop::getValue)
                    .collect(Collectors.joining("|")));
            return this;
        }

        /**
         * Return individual diffs for these slots, rather than one combined diff for all slots.
         * @return {@code Builder}
         */
        public Builder slots(EnumSet<Slots> slots) {
            compareAction.slots = slots;
            compareAction.apiUrl.putQuery("slots", slots.stream()
                    .map(Slots::getValue)
                    .collect(Collectors.joining("|")));
            return this;
        }

        /**
         * Return the comparison formatted as inline HTML.
         * @return {@code Builder}
         */
        public Builder diffType(DiffType diffType) {
            compareAction.diffType = diffType;
            compareAction.apiUrl.putQuery("difftype", diffType.getValue());
            return this;
        }

        public CompareAction build() {
            return compareAction;
        }

    }

    @Getter
    public enum ToRelative {

        CUR ("cur"),
        NEXT ("next"),
        PREV ("prev");

        private final String value;

        ToRelative(String value) {
            this.value = value;
        }

    }

    @Getter
    public enum Prop {

        /**
         * The comment on the 'from' and 'to' revisions. If the comment has been revision deleted, a
         * {@code fromcommenthidden} or {@code tocommenthidden} property will be returned.
         */
        COMMENT ("comment"),

        /**
         * The diff HTML.
         */
        DIFF ("diff"),

        /**
         * The size of the diff HTML, in bytes.
         */
        DIFF_SIZE ("diffsize"),

        /**
         * The page and revision IDs of the 'from' and 'to' revisions.
         */
        IDS ("ids"),

        /**
         * The parsed comment on the 'from' and 'to' revisions. If the comment has been revision deleted, a
         * {@code fromcommenthidden} or {@code tocommenthidden} property will be returned.
         */
        PARSED_COMMENT ("parsedcomment"),

        /**
         * The revision IDs of the revision previous to 'from' and after 'to', if any.
         */
        REL ("rel"),

        /**
         * The size of the 'from' and 'to' revisions.
         */
        SIZE ("size"),

        /**
         * The timestamp of the 'from' and 'to' revisions.
         */
        TIMESTAMP ("timestamp"),

        /**
         * The page titles of the 'from' and 'to' revisions.
         */
        TITLE ("title"),

        /**
         * The username and ID of the 'from' and 'to' revisions. If the user has been revision deleted, a
         * {@code fromuserhidden} or {@code touserhidden} property will be returned.
         */
        USER ("user");

        private final String value;

        Prop(String value) {
            this.value = value;
        }

    }

    @Getter
    public enum Slots {
        ALL_VALUES ("*"),
        MAIN ("main");

        private final String value;

        Slots(String value) {
            this.value = value;
        }

    }

    @Getter
    public enum DiffType {

        INLINE ("inline"),
        TABLE ("table"),
        UNIFIED ("unified");

        private final String value;

        DiffType(String value) {
            this.value = value;
        }

    }

}
