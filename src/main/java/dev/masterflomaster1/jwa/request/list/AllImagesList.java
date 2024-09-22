package dev.masterflomaster1.jwa.request.list;

import dev.masterflomaster1.jwa.common.Dir;
import dev.masterflomaster1.jwa.common.Prop;
import dev.masterflomaster1.jwa.internal.EnumValueProvider;
import dev.masterflomaster1.jwa.request.AbstractBuilder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.Instant;
import java.util.EnumSet;
import java.util.Set;

/**
 * Enumerate all images sequentially.
 *
 * @see <a href="https://www.mediawiki.org/wiki/Special:MyLanguage/API:Allimages">API:Allimages</a>
 */
@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@SuppressWarnings("SpellCheckingInspection")
public final class AllImagesList extends AbstractList {

    private AiSort aiSort;
    private Dir.Mixed aiDir;
    private String aiFrom;
    private String aiTo;
    private String aiContinue;
    private Instant aiStart;
    private Instant aiEnd;
    private EnumSet<Prop> aiProp;
    private String aiPrefix;
    private long aiMinSize;
    private long aiMaxSize;
    private String aiSha1;
    private String aiSha1Base36;
    private String aiUser;
    private AiFilterBots aiFilterBots;
    private Set<String> aiMime;
    private int aiLimit;

    private AllImagesList() {
        super("allimages");
    }

    public static class Builder extends AbstractBuilder {

        private final AllImagesList allImagesList = new AllImagesList();

        /**
         * Property to sort by.
         * @return {@code Builder}
         */
        public Builder aiSort(AiSort aiSort) {
            allImagesList.aiSort = aiSort;
            allImagesList.apiUrl.putQuery("aisort", aiSort.getValue());
            return this;
        }

        /**
         * The direction in which to list.
         * @return {@code Builder}
         */
        public Builder aiDir(Dir.Mixed aiDir) {
            allImagesList.aiDir = aiDir;
            allImagesList.apiUrl.putQuery("aidir", aiDir.getValue());
            return this;
        }

        /**
         * The image title to start enumerating from. Can only be used with {@code aisort=name}.
         * @return {@code Builder}
         */
        public Builder aiFrom(String aiFrom) {
            allImagesList.aiFrom = aiFrom;
            allImagesList.apiUrl.putQuery("aifrom", aiFrom);
            return this;
        }

        /**
         * The image title to stop enumerating at. Can only be used with {@code aisort=name}.
         * @return {@code Builder}
         */
        public Builder aiTo(String aiTo) {
            allImagesList.aiTo = aiTo;
            allImagesList.apiUrl.putQuery("aito", aiTo);
            return this;
        }

        /**
         * When more results are available, use this to continue.
         * More detailed information on how to continue queries can be found on
         * <a href="https://www.mediawiki.org/wiki/API:Continue">mediawiki.org</a>.
         * @return {@code Builder}
         */
        public Builder aiContinue(String aiContinue) {
            allImagesList.aiContinue = aiContinue;
            allImagesList.apiUrl.putQuery("aicontinue", aiContinue);
            return this;
        }

        /**
         * The timestamp to start enumerating from. Can only be used with {@code aisort=timestamp}.
         * @return {@code Builder}
         */
        public Builder aiStart(Instant aiStart) {
            allImagesList.aiStart = aiStart;
            allImagesList.apiUrl.putQuery("aistart", aiStart.toString());
            return this;
        }

        /**
         * The timestamp to end enumerating. Can only be used with {@code aisort=timestamp}.
         * @return {@code Builder}
         */
        public Builder aiEnd(Instant aiEnd) {
            allImagesList.aiEnd = aiEnd;
            allImagesList.apiUrl.putQuery("aiend", aiEnd.toString());
            return this;
        }

        /**
         * Which file information to get.
         * @return {@code Builder}
         */
        public Builder aiProp(EnumSet<Prop> aiProp) {
            allImagesList.aiProp = aiProp;
            allImagesList.apiUrl.putQuery("aiprop", merge(aiProp));
            return this;
        }

        /**
         * Search for all image titles that begin with this value. Can only be used with {@code aisort=name}.
         * @return {@code Builder}
         */
        public Builder aiPrefix(String aiPrefix) {
            allImagesList.aiPrefix = aiPrefix;
            allImagesList.apiUrl.putQuery("aiprefix", aiPrefix);
            return this;
        }

        /**
         * Limit to images with at least this many bytes.
         * @return {@code Builder}
         */
        public Builder aiMinSize(long aiMinSize) {
            allImagesList.aiMinSize = aiMinSize;
            allImagesList.apiUrl.putQuery("aiminsize", aiMinSize);
            return this;
        }

        /**
         * Limit to images with at most this many bytes.
         * @return {@code Builder}
         */
        public Builder aiMaxSize(long aiMaxSize) {
            allImagesList.aiMaxSize = aiMaxSize;
            allImagesList.apiUrl.putQuery("aimaxsize", aiMaxSize);
            return this;
        }

        /**
         * SHA1 hash of image. Overrides aisha1base36.
         * @return {@code Builder}
         */
        public Builder aiSha1(String aiSha1) {
            allImagesList.aiSha1 = aiSha1;
            allImagesList.apiUrl.putQuery("aisha1", aiSha1);
            return this;
        }

        /**
         * SHA1 hash of image in base 36 (used in MediaWiki).
         * @return {@code Builder}
         */
        public Builder aiSha1Base36(String aiSha1Base36) {
            allImagesList.aiSha1Base36 = aiSha1Base36;
            allImagesList.apiUrl.putQuery("aisha1base36", aiSha1Base36);
            return this;
        }

        /**
         * Only return files where the last version was uploaded by this user.
         * Can only be used with {@code aisort=timestamp}. Cannot be used together with aifilterbots.
         * @return {@code Builder}
         */
        public Builder aiUser(String aiUser) {
            allImagesList.aiUser = aiUser;
            allImagesList.apiUrl.putQuery("aiuser", aiUser);
            return this;
        }

        /**
         * How to filter files uploaded by bots. Can only be used with {@code aisort=timestamp}.
         * Cannot be used together with aiuser.
         * @return {@code Builder}
         */
        public Builder aiFilterBots(AiFilterBots aiFilterBots) {
            allImagesList.aiFilterBots = aiFilterBots;
            allImagesList.apiUrl.putQuery("aifilterbots", aiFilterBots.getValue());
            return this;
        }

        /**
         * Disabled due to <a href="https://www.mediawiki.org/wiki/Special:MyLanguage/Manual:$wgMiserMode">miser mode</a>.
         * @param aiMime Maximum number of values is 50 (500 for clients that are allowed higher limits).
         * @return {@code Builder}
         */
        public Builder aiMime(final Set<String> aiMime) {
            allImagesList.aiMime = aiMime;
            allImagesList.apiUrl.putQuery("aimime", mergeString(aiMime));
            return this;
        }

        /**
         * How many images in total to return.
         * @param aiLimit The value must be between 1 and 500.
         * @return {@code Builder}
         */
        public Builder aiLimit(int aiLimit) {
            allImagesList.aiLimit = aiLimit;
            allImagesList.apiUrl.putQuery("ailimit", aiLimit);
            return this;
        }

        public AllImagesList build() {
            return allImagesList;
        }

    }

    @Getter
    public enum AiSort {

        NAME ("name"),
        TIMESTAMP ("timestamp");

        private final String value;

        AiSort(String value) {
            this.value = value;
        }

    }

    @Getter
    public enum AiFilterBots implements EnumValueProvider {

        ALL ("all"),
        BOTS ("bots"),
        NO_BOTS ("nobots");

        private final String value;

        AiFilterBots(String value) {
            this.value = value;
        }

    }

}
