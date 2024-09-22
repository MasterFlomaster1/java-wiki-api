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
 * List all titles protected from creation.
 *
 * @see <a href="https://www.mediawiki.org/wiki/Special:MyLanguage/API:Protectedtitles">API:Protectedtitles</a>
 */
@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@SuppressWarnings("SpellCheckingInspection")
public final class ProtectedTitlesList extends AbstractList {

    private EnumSet<Namespace> ptNamespace;
    private EnumSet<PtLevel> ptLevel;
    private int ptLimit;
    private Dir.Time ptDir;
    private Instant ptStart;
    private Instant ptEnd;
    private EnumSet<PtProp> ptProp;
    private String ptContinue;

    private ProtectedTitlesList() {
        super("protectedtitles");
    }

    public static class Builder extends AbstractBuilder {

        private final ProtectedTitlesList protectedTitlesList = new ProtectedTitlesList();

        /**
         * Only list titles in these namespaces.
         * @return {@code Builder}
         */
        public Builder ptNamespace(final EnumSet<Namespace> ptNamespace) {
            protectedTitlesList.ptNamespace = ptNamespace;
            protectedTitlesList.apiUrl.putQuery("ptnamespace", merge(ptNamespace));
            return this;
        }

        /**
         * Only list titles with these protection levels.
         * @return {@code Builder}
         */
        public Builder ptLevel(final EnumSet<PtLevel> ptLevel) {
            protectedTitlesList.ptLevel = ptLevel;
            protectedTitlesList.apiUrl.putQuery("ptlevel", merge(ptLevel));
            return this;
        }

        /**
         * How many images in total to return.
         * @param ptLimit The value must be between 1 and 500.
         * @return {@code Builder}
         */
        public Builder ptLimit(final int ptLimit) {
            protectedTitlesList.ptLimit = ptLimit;
            protectedTitlesList.apiUrl.putQuery("ptlimit", ptLimit);
            return this;
        }

        /**
         * In which direction to enumerate.
         * @return {@code Builder}
         */
        public Builder ptDir(final Dir.Time ptDir) {
            protectedTitlesList.ptDir = ptDir;
            protectedTitlesList.apiUrl.putQuery("ptdir", ptDir.getValue());
            return this;
        }

        /**
         * Start listing at this protection timestamp.
         * @return {@code Builder}
         */
        public Builder ptStart(final Instant ptStart) {
            protectedTitlesList.ptStart = ptStart;
            protectedTitlesList.apiUrl.putQuery("ptstart", ptStart.toString());
            return this;
        }

        /**
         * Stop listing at this protection timestamp.
         * @return {@code Builder}
         */
        public Builder ptEnd(final Instant ptEnd) {
            protectedTitlesList.ptEnd = ptEnd;
            protectedTitlesList.apiUrl.putQuery("ptend", ptEnd.toString());
            return this;
        }

        /**
         * Which properties to get
         * @return {@code Builder}
         */
        public Builder ptProp(final EnumSet<PtProp> ptProp) {
            protectedTitlesList.ptProp = ptProp;
            protectedTitlesList.apiUrl.putQuery("ptprop", merge(ptProp));
            return this;
        }

        /**
         * When more results are available, use this to continue.
         * More detailed information on how to continue queries can be found on
         * <a href="https://www.mediawiki.org/wiki/API:Continue">mediawiki.org</a>.
         * @return {@code Builder}
         */
        public Builder ptContinue(final String ptContinue) {
            protectedTitlesList.ptContinue = ptContinue;
            protectedTitlesList.apiUrl.putQuery("ptcontinue", ptContinue);
            return this;
        }

        public ProtectedTitlesList build() {
            return protectedTitlesList;
        }

    }

    @Getter
    public enum PtLevel implements EnumValueProvider {

        AUTO_CONFIRMED("autoconfirmed"),
        EXTENDED_CONFIRMED("extendedconfirmed"),
        SYSOP("sysop"),
        TEMPLATE_EDITOR("templateeditor");

        private final String value;

        PtLevel(String value) {
            this.value = value;
        }

    }

    @Getter
    public enum PtProp implements EnumValueProvider {

        /**
         * Adds the comment for the protection.
         */
        COMMENT("comment"),

        /**
         * Adds the timestamp of when the protection will be lifted.
         */
        EXPIRY("expiry"),

        /**
         * Adds the protection level.
         */
        LEVEL("level"),

        /**
         * Adds the parsed comment for the protection.
         */
        PARSED_COMMENT("parsedcomment"),

        /**
         * Adds the timestamp of when protection was added.
         */
        TIMESTAMP("timestamp"),

        /**
         * Adds the user that added the protection.
         */
        USER("user"),

        /**
         * Adds the user ID that added the protection.
         */
        USER_ID("userid");

        private final String value;

        PtProp(String value) {
            this.value = value;
        }

    }

}
