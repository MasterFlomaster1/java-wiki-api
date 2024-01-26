package dev.masterflomaster1.jwa.model.prop;

import java.util.Set;

public class Revisions extends AbstractProp {

    /**
     * Which properties to get for each revision
     */
    private Set<RvProp> rvProp;

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
