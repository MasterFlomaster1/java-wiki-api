package dev.masterflomaster1.jwa.request.list;

import dev.masterflomaster1.jwa.common.Dir;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.EnumSet;
import java.util.stream.Collectors;

/**
 * Enumerate all deleted files sequentially.
 *
 * @see <a href="https://www.mediawiki.org/wiki/Special:MyLanguage/API:Filearchive">API:Filearchive</a>
 */
@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@SuppressWarnings("SpellCheckingInspection")
public final class FileArchiveList extends AbstractList {

    private String faFrom;
    private String faTo;
    private String faPrefix;
    private Dir.Order faDir;
    private String faSha1;
    private String faSha1Base36;
    private EnumSet<FaProp> faProp;
    private int faLimit;
    private String faContinue;

    private FileArchiveList() {
        name = "filearchive";
    }

    public static class Builder {

        private final FileArchiveList fileArchiveList = new FileArchiveList();

        /**
         * The image title to start enumerating from.
         * @return {@code Builder}
         */
        public Builder faFrom(final String faFrom) {
            fileArchiveList.faFrom = faFrom;
            fileArchiveList.apiUrl.putQuery("fafrom", faFrom);
            return this;
        }

        /**
         * The image title to stop enumerating at.
         * @return {@code Builder}
         */
        public Builder faTo(final String faTo) {
            fileArchiveList.faTo = faTo;
            fileArchiveList.apiUrl.putQuery("fato", faTo);
            return this;
        }

        /**
         * Search for all image titles that begin with this value.
         * @return {@code Builder}
         */
        public Builder faPrefix(final String faPrefix) {
            fileArchiveList.faPrefix = faPrefix;
            fileArchiveList.apiUrl.putQuery("faprefix", faPrefix);
            return this;
        }

        /**
         * The direction in which to list.
         * @return {@code Builder}
         */
        public Builder faDir(final Dir.Order faDir) {
            fileArchiveList.faDir = faDir;
            fileArchiveList.apiUrl.putQuery("fadir", faDir.getValue());
            return this;
        }

        /**
         * SHA1 hash of image. Overrides fasha1base36.
         * @return {@code Builder}
         */
        public Builder faSha1(final String faSha1) {
            fileArchiveList.faSha1 = faSha1;
            fileArchiveList.apiUrl.putQuery("fasha1", faSha1);
            return this;
        }

        /**
         * SHA1 hash of image in base 36 (used in MediaWiki).
         * @return {@code Builder}
         */
        public Builder faSha1Base36(final String faSha1Base36) {
            fileArchiveList.faSha1Base36 = faSha1Base36;
            fileArchiveList.apiUrl.putQuery("fasha1base36", faSha1Base36);
            return this;
        }

        /**
         * Which image information to get
         * @return {@code Builder}
         */
        public Builder faProp(final EnumSet<FaProp> faProp) {
            fileArchiveList.faProp = faProp;
            fileArchiveList.apiUrl.putQuery("faprop", faProp.stream()
                    .map(FaProp::getValue)
                    .collect(Collectors.joining("|")));
            return this;
        }

        /**
         * How many images in total to return.
         * @param faLimit The value must be between 1 and 500.
         * @return {@code Builder}
         */
        public Builder faLimit(final int faLimit) {
            fileArchiveList.faLimit = faLimit;
            fileArchiveList.apiUrl.putQuery("falimit", faLimit);
            return this;
        }

        /**
         * When more results are available, use this to continue.
         * More detailed information on how to continue queries can be found on
         * <a href="https://www.mediawiki.org/wiki/API:Continue">mediawiki.org</a>.
         * @return {@code Builder}
         */
        public Builder faContinue(final String faContinue) {
            fileArchiveList.faContinue = faContinue;
            fileArchiveList.apiUrl.putQuery("facontinue", faContinue);
            return this;
        }

        public FileArchiveList build() {
            return fileArchiveList;
        }

    }

    @Getter
    public enum FaProp {

        /**
         * Adds the filename of the archive version for non-latest versions.
         */
        ARCHIVE_NAME("archivename"),

        /**
         * Adds the bit depth of the version.
         */
        BIT_DEPTH("bitdepth"),

        /**
         * Adds description of the image version.
         */
        DESCRIPTION("description"),

        /**
         * Alias for size.
         */
        DIMENSIONS("dimensions"),

        /**
         * Adds the media type of the image.
         */
        MEDIA_TYPE("mediatype"),

        /**
         * Lists Exif metadata for the version of the image.
         */
        METADATA("metadata"),

        /**
         * Adds MIME of the image.
         */
        MIME("mime"),

        /**
         * Parse the description of the version.
         */
        PARSED_DESCRIPTION("parseddescription"),

        /**
         * Adds SHA-1 hash for the image.
         */
        SHA1("sha1"),

        /**
         * Adds the size of the image in bytes and the height, width and page count (if applicable).
         */
        SIZE("size"),

        /**
         * Adds timestamp for the uploaded version.
         */
        TIMESTAMP("timestamp"),

        /**
         * Adds user who uploaded the image version.
         */
        USER("user");

        private final String value;

        FaProp(String value) {
            this.value = value;
        }

    }

}
