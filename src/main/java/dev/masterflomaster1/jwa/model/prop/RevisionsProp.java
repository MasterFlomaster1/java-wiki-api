package dev.masterflomaster1.jwa.model.prop;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Get revision information.
 *
 * @see <a href="https://www.mediawiki.org/wiki/API:Revisions">API:Revisions</a>
 */
public class RevisionsProp extends AbstractProp {

    private Set<RvProp> rvProp;
    private int rvLimit;

    private RevisionsProp() {
        url = "&prop=revisions";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RevisionsProp that = (RevisionsProp) o;

        if (rvLimit != that.rvLimit) return false;
        return Objects.equals(rvProp, that.rvProp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rvProp, rvLimit);
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

    public static class Builder {

        private final RevisionsProp revisionsProp = new RevisionsProp();

        /**
         * Which properties to get for each revision.
         * @return {@code Builder}
         */
        public Builder rvProp(Set<RvProp> rvProp) {
            revisionsProp.rvProp = rvProp;
            revisionsProp.url += "&rvprop=" + rvProp.stream()
                    .map(RvProp::getValue)
                    .collect(Collectors.joining("%7C"));
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
            System.out.println(revisionsProp.rvLimit);
            revisionsProp.rvLimit = rvLimit;
            revisionsProp.url += "&rvlimit=" + rvLimit;
            return this;
        }

        public RevisionsProp build() {
            return revisionsProp;
        }

    }

}
