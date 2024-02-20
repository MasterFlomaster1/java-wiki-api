package dev.masterflomaster1.jwa.model.prop;

import dev.masterflomaster1.jwa.util.ISO639Language;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Returns file information and upload history.
 *
 * @see <a href="https://www.mediawiki.org/wiki/API:Imageinfo">API:Imageinfo</a>
 */
public class ImageInfoProp extends AbstractProp {

    private Set<IIProp> iiProp;
    private int iiLimit;
    private String iiStart;
    private String iiEnd;
    private int iiUrlWidth;
    private int iiUrlHeight;
    private ISO639Language iiExtMetadataLanguage;
    private boolean iiExtMetadataMultiLang;

    private ImageInfoProp() {
        url = "&prop=imageinfo";
    }

    public Set<IIProp> getIiProp() {
        return iiProp;
    }

    public int getIiLimit() {
        return iiLimit;
    }

    public String getIiStart() {
        return iiStart;
    }

    public String getIiEnd() {
        return iiEnd;
    }

    public int getIiUrlWidth() {
        return iiUrlWidth;
    }

    public int getIiUrlHeight() {
        return iiUrlHeight;
    }

    public ISO639Language getIiExtMetadataLanguage() {
        return iiExtMetadataLanguage;
    }

    public boolean isIiExtMetadataMultiLang() {
        return iiExtMetadataMultiLang;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ImageInfoProp that = (ImageInfoProp) o;

        if (iiLimit != that.iiLimit) return false;
        if (iiUrlWidth != that.iiUrlWidth) return false;
        if (iiUrlHeight != that.iiUrlHeight) return false;
        if (iiExtMetadataMultiLang != that.iiExtMetadataMultiLang) return false;
        if (!Objects.equals(iiProp, that.iiProp)) return false;
        if (!Objects.equals(iiStart, that.iiStart)) return false;
        if (!Objects.equals(iiEnd, that.iiEnd)) return false;
        return iiExtMetadataLanguage == that.iiExtMetadataLanguage;
    }

    @Override
    public int hashCode() {
        return Objects.hash(iiProp, iiLimit, iiStart, iiEnd, iiUrlWidth, iiUrlHeight, iiExtMetadataLanguage,
                iiExtMetadataMultiLang);
    }

    public enum IIProp {

        /**
         * Adds the filename of the archive version for non-latest versions. If the file has been revision deleted,
         * a {@code filehidden} property will be returned.
         */
        ARCHIVE_NAME ("archivename"),

        /**
         * Adds whether the file is on the
         * <a href="https://en.wikipedia.org/wiki/MediaWiki:Bad_image_list">MediaWiki:Bad image list</a>
         */
        BAD_FILE ("badfile"),

        /**
         * Adds the bit depth of the version. If the file has been revision deleted, a {@code filehidden} property will
         * be returned.
         */
        BIT_DEPTH ("bitdepth"),

        /**
         * Adds the canonical title of the file. If the file has been revision deleted, a {@code filehidden} property
         * will be returned.
         */
        CANONICAL_TITLE ("canonicaltitle"),

        /**
         * Comment on the version. If the comment has been revision deleted, a {@code commenthidden} property will be
         * returned.
         */
        COMMENT ("comment"),

        /**
         * Lists file format generic metadata for the version of the file. If the file has been revision deleted, a
         * {@code filehidden} property will be returned.
         */
        COMMON_METADATA ("commonmetadata"),

        /**
         * Alias for size.
         */
        DIMENSIONS ("dimensions"),

        /**
         * Lists formatted metadata combined from multiple sources. Results are HTML formatted. If the file has been
         * revision deleted, a {@code filehidden} property will be returned.
         */
        EXTMETADATA ("extmetadata"),

        /**
         * Adds the media type of the file. If the file has been revision deleted, a {@code filehidden} property will be
         * returned.
         */
        MEDIA_TYPE ("mediatype"),

        /**
         * Lists Exif metadata for the version of the file. If the file has been revision deleted, a {@code filehidden}
         * property will be returned.
         */
        METADATA ("metadata"),

        /**
         * Adds MIME type of the file. If the file has been revision deleted, a {@code filehidden} property will be
         * returned.
         */
        MIME ("mime"),

        /**
         * Parse the comment on the version. If the comment has been revision deleted, a {@code commenthidden} property
         * will be returned.
         */
        PARSED_COMMENT ("parsedcomment"),

        /**
         * Adds SHA-1 hash for the file. If the file has been revision deleted, a {@code filehidden} property will be
         * returned.
         */
        SHA1 ("sha1"),

        /**
         * Adds the size of the file in bytes and the height, width and page count (if applicable).
         */
        SIZE ("size"),

        /**
         * Adds MIME type of the image thumbnail (requires url and param {@code iiurlwidth}). If the file has been
         * revision deleted, a {@code filehidden} property will be returned.
         */
        THUMB_MIME ("thumbmime"),

        /**
         * Adds timestamp for the uploaded version.
         */
        TIMESTAMP ("timestamp"),

        /**
         * Used by the Special:Upload page to get information about an existing file. Not intended for use outside
         * MediaWiki core.
         */
        UPLOAD_WARNING ("uploadwarning"),

        /**
         * Gives URL to the file and the description page. If the file has been revision deleted, a {@code filehidden}
         * property will be returned.
         */
        URL ("url"),

        /**
         * Adds the user who uploaded each file version. If the user has been revision deleted, a {@code userhidden}
         * property will be returned.
         */
        USER ("user"),

        /**
         * Add the ID of the user that uploaded each file version. If the user has been revision deleted, a
         * {@code userhidden} property will be returned.
         */
        USER_ID ("userid");

        public final String value;

        IIProp(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public static class Builder {

        private final ImageInfoProp imageInfoProp = new ImageInfoProp();

        /**
         * Which file information to get
         * @return {@code Builder}
         */
        public Builder iiProp(Set<IIProp> iiProp) {
            imageInfoProp.iiProp = iiProp;
            imageInfoProp.url += "&iiprop=" + iiProp.stream()
                    .map(ImageInfoProp.IIProp::getValue)
                    .collect(Collectors.joining("%7C"));
            return this;
        }

        /**
         * How many file revisions to return per file. Default: 1.
         * @param iiLimit The value must be between 1 and 500.
         * @return {@code Builder}
         */
        public Builder iiLimit(int iiLimit) {
            imageInfoProp.iiLimit = iiLimit;
            imageInfoProp.url += "&iilimit=" + iiLimit;
            return this;
        }

        /**
         * Timestamp to start listing from.
         * @param iiStart date
         * @return {@code Builder}
         */
        public Builder iiStart(String iiStart) {
            imageInfoProp.iiStart = iiStart;
            imageInfoProp.url += "&iistart=" + URLEncoder.encode(iiStart, StandardCharsets.UTF_8);
            return this;
        }

        /**
         * Timestamp to stop listing at.
         * @param iiEnd date
         * @return {@code Builder}
         */
        public Builder iiEnd(String iiEnd) {
            imageInfoProp.iiEnd = iiEnd;
            imageInfoProp.url += "&iiend=" + URLEncoder.encode(iiEnd, StandardCharsets.UTF_8);
            return this;
        }

        /**
         * If iiprop=url is set, a URL to an image scaled to this width will be returned. For performance reasons if
         * this option is used, no more than 50 scaled images will be returned.
         * @return {@code Builder}
         */
        public Builder iiUrlWidth(int iiUrlWidth) {
            imageInfoProp.iiUrlWidth = iiUrlWidth;
            imageInfoProp.url += "iiurlwidth=" + iiUrlWidth;
            return this;
        }

        /**
         * Similar to {@code iiurlwidth}.
         * @return {@code Builder}
         */
        public Builder iiUrlHeight(int iiUrlHeight) {
            imageInfoProp.iiUrlHeight = iiUrlHeight;
            imageInfoProp.url += "iiurlheight=" + iiUrlHeight;
            return this;
        }

        /**
         * What language to fetch {@code extmetadata} in. This affects both which translation to fetch, if multiple are
         * available, as well as how things like numbers and various values are formatted.
         * @param iiExtMetadataLanguage value
         * @return {@code Builder}
         */
        public Builder iiExtMetadataLanguage(ISO639Language iiExtMetadataLanguage) {
            imageInfoProp.iiExtMetadataLanguage = iiExtMetadataLanguage;
            return this;
        }

        /**
         * If translations for extmetadata property are available, fetch all of them.
         * @return {@code Builder}
         */
        public Builder iiExtMetadataMultiLang() {
            imageInfoProp.iiExtMetadataMultiLang = true;
            return this;
        }

        public ImageInfoProp build() {
            return imageInfoProp;
        }

    }

}
