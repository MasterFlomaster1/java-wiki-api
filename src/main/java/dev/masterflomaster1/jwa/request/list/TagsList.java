package dev.masterflomaster1.jwa.request.list;

import dev.masterflomaster1.jwa.internal.EnumValueProvider;
import dev.masterflomaster1.jwa.request.AbstractBuilder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.EnumSet;

/**
 * List change tags.
 *
 * @see <a href="https://www.mediawiki.org/wiki/API:Tags">API:Tags</a>
 */
@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@SuppressWarnings("SpellCheckingInspection")
public final class TagsList extends AbstractList {

    private String tgContinue;
    private int tgLimit;
    private EnumSet<TgProp> tgProp;

    private TagsList() {
        super("tags");
    }

    public static class Builder extends AbstractBuilder {

        private final TagsList tagsList = new TagsList();

        /**
         * When more results are available, use this to continue.
         * More detailed information on how to continue queries can be found on
         * <a href="https://www.mediawiki.org/wiki/API:Continue">mediawiki.org</a>.
         * @return {@code Builder}
         */
        public Builder tgContinue(final String tgContinue) {
            tagsList.tgContinue = tgContinue;
            tagsList.apiUrl.putQuery("tgcontinue", tgContinue);
            return this;
        }

        /**
         * How many total changes to return. Default: 10
         * @param tgLimit The value must be between 1 and 500.
         * @return {@code Builder}
         */
        public Builder tgLimit(final int tgLimit) {
            tagsList.tgLimit = tgLimit;
            tagsList.apiUrl.putQuery("tglimit", tgLimit);
            return this;
        }

        /**
         * Which properties to get
         * @return {@code Builder}
         */
        public Builder tgProp(final EnumSet<TgProp> tgProp) {
            tagsList.tgProp = tgProp;
            tagsList.apiUrl.putQuery("tgprop", merge(tgProp));
            return this;
        }

        public TagsList build() {
            return tagsList;
        }

    }

    @Getter
    public enum TgProp implements EnumValueProvider {

        /**
         * Adds system message for the tag.
         */
        ACTIVE("active"),

        /**
         * Adds description of the tag.
         */
        DEFINED("defined"),

        /**
         * Adds the number of revisions and log entries that have this tag.
         */
        DESCRIPTION("description"),

        /**
         * Indicate whether the tag is defined.
         */
        DISPLAY_NAME("displayname"),

        /**
         * Gets the sources of the tag, which may include extension for extension-defined tags and manual for tags
         * that may be applied manually by users.
         */
        HIT_COUNT("hitcount"),

        /**
         * Whether the tag is still being applied.
         */
        SOURCE("source");

        private final String value;

        TgProp(String value) {
            this.value = value;
        }

    }

}
