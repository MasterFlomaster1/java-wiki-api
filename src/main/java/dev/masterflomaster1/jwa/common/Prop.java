package dev.masterflomaster1.jwa.common;

import lombok.Getter;

@Getter
@SuppressWarnings("SpellCheckingInspection")
public enum Prop {

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

    Prop(String value) {
        this.value = value;
    }

}
