package dev.masterflomaster1.jwa.model.prop;

import dev.masterflomaster1.jwa.model.UrlHelper;

import java.util.Set;

public class Revisions extends AbstractProp {

    /**
     * Which properties to get for each revision
     */
    private Set<RvProp> rvProp;
    private int rvLimit;

    private Revisions() {
        url = "&prop=revisions";
    }

    public static class Builder {

        private Revisions revisions = new Revisions();

        public Builder setRvProp(Set<RvProp> rvProp) {
            revisions.rvProp = rvProp;
            revisions.url += "&rvprop=" + UrlHelper.concat(rvProp);
            return this;
        }

        public Builder setRvLimit(int rvLimit) {
            revisions.rvLimit = rvLimit;
            revisions.url += "&rvlimit=" + rvLimit;
            return this;
        }

        public Revisions build() {
            return revisions;
        }

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

}
