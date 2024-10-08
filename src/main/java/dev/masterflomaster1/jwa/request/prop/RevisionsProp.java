package dev.masterflomaster1.jwa.request.prop;

import dev.masterflomaster1.jwa.common.Dir;
import dev.masterflomaster1.jwa.internal.EnumValueProvider;
import dev.masterflomaster1.jwa.request.AbstractBuilder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.Instant;
import java.util.EnumSet;

/**
 * Get revision information.
 *
 * @see <a href="https://www.mediawiki.org/wiki/API:Revisions">API:Revisions</a>
 */
@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@SuppressWarnings("SpellCheckingInspection")
public final class RevisionsProp extends AbstractProp {

    private EnumSet<RvProp> rvProp;
    private EnumSet<RvSlots> rvSlots;
    private int rvLimit;
    private String rvSection;
    private Instant rvStart;
    private Instant rvEnd;
    private Dir.Time rvDir;
    private String rvUser;
    private String rvExcludeUser;
    private String rvTag;
    private String rvContinue;

    private RevisionsProp() {
        super("revisions");
    }

    public static class Builder extends AbstractBuilder {

        private final RevisionsProp revisionsProp = new RevisionsProp();

        /**
         * Which properties to get for each revision.
         * @return {@code Builder}
         */
        public Builder rvProp(EnumSet<RvProp> rvProp) {
            revisionsProp.rvProp = rvProp;
            revisionsProp.apiUrl.putQuery("rvprop", merge(rvProp));
            return this;
        }

        /**
         * Which revision slots to return data for, when slot-related properties are included in {@code rvprops}.
         * If omitted, data from the main slot will be returned in a backwards-compatible format.
         * @return {@code Builder}
         */
        public Builder rvSlots(EnumSet<RvSlots> rvSlots) {
            revisionsProp.rvSlots = rvSlots;
            revisionsProp.apiUrl.putQuery("rvslots", merge(rvSlots));
            return this;
        }

        /**
         * Limit how many revisions will be returned. If {@code rvprop=content}, {@code rvprop=parsetree},
         * {@code rvdiffto} or {@code rvdifftotext} is used, the limit is 50. If {@code rvparse} is used, the limit is 1.
         * May only be used with a single page (mode #2).
         * The value must be between 1 and 500.
         * @return {@code Builder}
         */
        public Builder rvLimit(int rvLimit) {
            revisionsProp.rvLimit = rvLimit;
            revisionsProp.apiUrl.putQuery("rvlimit", rvLimit);
            return this;
        }

        /**
         * Only retrieve the content of the section with this identifier.
         * @return {@code Builder}
         */
        public Builder rvSection(String rvSection) {
            revisionsProp.rvSection = rvSection;
            revisionsProp.apiUrl.putQuery("rvsection", rvSection);
            return this;
        }

        /**
         * From which revision timestamp to start enumeration.
         * May only be used with a single page (mode #2).
         * @return {@code Builder}
         */
        public Builder rvStart(Instant rvStart) {
            revisionsProp.rvStart = rvStart;
            revisionsProp.apiUrl.putQuery("rvstart", rvStart.toString());
            return this;
        }

        /**
         * Enumerate up to this timestamp.
         * May only be used with a single page (mode #2).
         * @return {@code Builder}
         */
        public Builder rvEnd(Instant rvEnd) {
            revisionsProp.rvEnd = rvEnd;
            revisionsProp.apiUrl.putQuery("rvend", rvEnd.toString());
            return this;
        }

        /**
         * In which direction to enumerate.
         * May only be used with a single page (mode #2).
         * @return {@code Builder}
         */
        public Builder rvDir(Dir.Time rvDir) {
            revisionsProp.rvDir = rvDir;
            revisionsProp.apiUrl.putQuery("rvdir", rvDir.getValue());
            return this;
        }

        /**
         * Only include revisions made by user.
         * May only be used with a single page (mode #2).
         * @return {@code Builder}
         */
        public Builder rvUser(String rvUser) {
            revisionsProp.rvUser = rvUser;
            revisionsProp.apiUrl.putQuery("rvuser", rvUser);
            return this;
        }

        /**
         * Exclude revisions made by user.
         * May only be used with a single page (mode #2).
         * @return {@code Builder}
         */
        public Builder rvExcludeUser(String rvExcludeUser) {
            revisionsProp.rvExcludeUser = rvExcludeUser;
            revisionsProp.apiUrl.putQuery("rvexcludeuser", rvExcludeUser);
            return this;
        }

        /**
         * Only list revisions tagged with this tag.
         * @return {@code Builder}
         */
        public Builder rvTag(String rvTag) {
            revisionsProp.rvTag = rvTag;
            revisionsProp.apiUrl.putQuery("rvtag", rvTag);
            return this;
        }

        /**
         * When more results are available, use this to continue.
         * More detailed information on how to continue queries can be found on
         * <a href="https://www.mediawiki.org/wiki/API:Continue">mediawiki.org</a>.
         * @return {@code Builder}
         */
        public Builder rvContinue(String rvContinue) {
            revisionsProp.rvContinue = rvContinue;
            revisionsProp.apiUrl.putQuery("rvcontinue", rvContinue);
            return this;
        }

        public RevisionsProp build() {
            return revisionsProp;
        }

    }

    @Getter
    public enum RvProp implements EnumValueProvider {

        /**
         * Comment by the user for the revision. If the comment has been revision deleted, a {@code commenthidden}
         * property will be returned.
         */
        COMMENT ("comment"),

        /**
         * Content of each revision slot. If the content has been revision deleted, a {@code texthidden} property will
         * be returned. For performance reasons, if this option is used, {@code rvlimit} is enforced to 50.
         */
        CONTENT ("content"),

        /**
         * Content model ID of each revision slot.
         */
        CONTENT_MODEL ("contentmodel"),

        /**
         * Revision flags (minor).
         */
        FLAGS ("flags"),

        /**
         * The ID of the revision.
         */
        IDS ("ids"),

        /**
         * Parsed comment by the user for the revision. If the comment has been revision deleted, a
         * {@code commenthidden} property will be returned.
         */
        PARSED_COMMENT ("parsedcomment"),

        /**
         * List content slot roles that exist in the revision.
         */
        ROLES ("roles"),

        /**
         * SHA-1 (base 16) of the revision. If the content has been revision deleted, a {@code sha1hidden} property will
         * be returned.
         */
        SHA1 ("sha1"),

        /**
         * Length (bytes) of the revision.
         */
        SIZE ("size"),

        /**
         * SHA-1 (base 16) of each revision slot. If the content has been revision deleted, a {@code sha1hidden}
         * property will be returned.
         */
        SLOT_SHA1 ("slotsha1"),

        /**
         * Length (bytes) of each revision slot.
         */
        SLOT_SIZE ("slotsize"),

        /**
         * Tags for the revision.
         */
        TAGS ("tags"),

        /**
         *
         The timestamp of the revision.
         */
        TIMESTAMP ("timestamp"),

        /**
         * User that made the revision. If the user has been revision deleted, a {@code userhidden} property will be
         * returned.
         */
        USER ("user"),

        /**
         * User ID of the revision creator. If the user has been revision deleted, a {@code userhidden} property will be
         * returned.
         */
        USER_ID ("userid");

        private final String value;

        RvProp(String value) {
            this.value = value;
        }

    }

    @Getter
    public enum RvSlots implements EnumValueProvider {

        ALL_VALUES("*"),
        MAIN("main");

        private final String value;

        RvSlots(String value) {
            this.value = value;
        }

    }

}
