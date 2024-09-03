package dev.masterflomaster1.jwa.request.prop;

import dev.masterflomaster1.jwa.util.TimeHandler;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Get revision information.
 *
 * @see <a href="https://www.mediawiki.org/wiki/API:Revisions">API:Revisions</a>
 */
public final class RevisionsProp extends AbstractProp {

    private Set<RvProp> rvProp;
    private int rvLimit;
    private String rvSection;
    private LocalDateTime rvStart;
    private LocalDateTime rvEnd;
    private RvDir rvDir;
    private String rvUser;
    private String rvExcludeUser;
    private String rvTag;
    private String rvContinue;

    private RevisionsProp() {
        name = "revisions";
    }

    public Set<RvProp> getRvProp() {
        return rvProp;
    }

    public int getRvLimit() {
        return rvLimit;
    }

    public String getRvSection() {
        return rvSection;
    }

    public LocalDateTime getRvStart() {
        return rvStart;
    }

    public LocalDateTime getRvEnd() {
        return rvEnd;
    }

    public RvDir getRvDir() {
        return rvDir;
    }

    public String getRvUser() {
        return rvUser;
    }

    public String getRvExcludeUser() {
        return rvExcludeUser;
    }

    public String getRvTag() {
        return rvTag;
    }

    public String getRvContinue() {
        return rvContinue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RevisionsProp that = (RevisionsProp) o;

        if (rvLimit != that.rvLimit) return false;
        if (!Objects.equals(rvProp, that.rvProp)) return false;
        if (!Objects.equals(rvSection, that.rvSection)) return false;
        if (!Objects.equals(rvStart, that.rvStart)) return false;
        if (!Objects.equals(rvEnd, that.rvEnd)) return false;
        if (rvDir != that.rvDir) return false;
        if (!Objects.equals(rvUser, that.rvUser)) return false;
        if (!Objects.equals(rvExcludeUser, that.rvExcludeUser))
            return false;
        if (!Objects.equals(rvTag, that.rvTag)) return false;
        return Objects.equals(rvContinue, that.rvContinue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rvProp, rvLimit, rvSection, rvStart, rvEnd, rvDir, rvUser, rvExcludeUser, rvTag, rvContinue);
    }

    public static class Builder {

        private final RevisionsProp revisionsProp = new RevisionsProp();

        /**
         * Which properties to get for each revision.
         * @return {@code Builder}
         */
        public Builder rvProp(Set<RvProp> rvProp) {
            revisionsProp.rvProp = rvProp;
            revisionsProp.apiUrl.putQuery("rvprop", rvProp.stream()
                    .map(RvProp::getValue)
                    .collect(Collectors.joining("|")));
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
        public Builder rvStart(LocalDateTime rvStart) {
            revisionsProp.rvStart = rvStart;
            revisionsProp.apiUrl.putQuery("rvstart", TimeHandler.formatISO8601(rvStart));
            return this;
        }

        /**
         * Enumerate up to this timestamp.
         * May only be used with a single page (mode #2).
         * @return {@code Builder}
         */
        public Builder rvEnd(LocalDateTime rvEnd) {
            revisionsProp.rvEnd = rvEnd;
            revisionsProp.apiUrl.putQuery("rvend", TimeHandler.formatISO8601(rvEnd));
            return this;
        }

        /**
         * In which direction to enumerate.
         * May only be used with a single page (mode #2).
         * @return {@code Builder}
         */
        public Builder rvDir(RvDir rvDir) {
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

    public enum RvProp {

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

        public String getValue() {
            return value;
        }
    }

    public enum RvDir {

        NEWER ("newer"),
        OLDER ("older");

        private final String value;

        RvDir(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

    }

}
