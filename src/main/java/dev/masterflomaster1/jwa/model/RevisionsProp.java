package dev.masterflomaster1.jwa.model;

import dev.masterflomaster1.jwa.WikiApiSyntaxException;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Get revision information.
 *
 * @see <a href="https://www.mediawiki.org/wiki/API:Revisions">https://www.mediawiki.org/wiki/API:Revisions</a>
 */
public class RevisionsProp extends AbstractProp {

    private Set<RvProp> rvProp;
    private int rvLimit;

    private RevisionsProp() {
        url = "&prop=revisions";
    }

    public enum RvProp {

        COMMENT ("comment"),
        CONTENT ("content"),
        CONTENT_MODEL ("contentmodel"),
        FLAGGED ("flagged"),
        FLAGS ("flags"),
        IDS ("ids"),
        ORESSCORES ("oresscores"),
        PARSED_COMMENT ("parsedcomment"),
        ROLES ("roles"),
        SHA1 ("sha1"),
        SIZE ("size"),
        SLOT_SHA1 ("slotsha1"),
        SLOT_SIZE ("slotsize"),
        TAGS ("tags"),
        TIMESTAMP ("timestamp"),
        USER ("user"),
        USER_ID ("userid");

        final String value;

        RvProp(String value) {
            this.value = value;
        }

        public String value() {
            return value;
        }
    }

    public static class Builder {

        private RevisionsProp revisionsProp = new RevisionsProp();

        public Builder rvProp(Set<RvProp> rvProp) throws WikiApiSyntaxException {
            if (revisionsProp.rvProp != null)
                throw new WikiApiSyntaxException("Field already called");

            revisionsProp.rvProp = rvProp;
            revisionsProp.url += "&rvprop=" + rvProp.stream()
                    .map(RvProp::value)
                    .collect(Collectors.joining("%7C"));
            return this;
        }

        /**
         *
         * @param rvLimit
         * @return
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
