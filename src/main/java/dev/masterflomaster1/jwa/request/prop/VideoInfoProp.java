package dev.masterflomaster1.jwa.request.prop;

import dev.masterflomaster1.jwa.common.Prop;
import dev.masterflomaster1.jwa.request.AbstractBuilder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.Instant;
import java.util.EnumSet;
import java.util.Set;

@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@SuppressWarnings("SpellCheckingInspection")
public final class VideoInfoProp extends AbstractProp {

    private EnumSet<Prop> viProp;
    private int viLimit;
    private Instant viStart;
    private Instant viEnd;
    private int viUrlWidth;
    private int viUrlHeight;
    private String viMetadataVersion;
    private String viExtMetadataLanguage;
    private boolean viExtMetadataMultiLang;
    private Set<String> viExtMetadataFilter;
    private String viUrlParam;
    private String viBadFileContextTitle;
    private String viContinue;
    private boolean viLocalOnly;

    private VideoInfoProp() {
        super("videoinfo");
    }

    public static class Builder extends AbstractBuilder {

        private final VideoInfoProp videoInfoProp = new VideoInfoProp();

        /**
         * Which file information to get
         * @return {@code Builder}
         */
        public Builder viProp(EnumSet<Prop> viProp) {
            videoInfoProp.viProp = viProp;
            videoInfoProp.apiUrl.putQuery("viprop", merge(viProp));
            return this;
        }

        /**
         * How many file revisions to return per file.
         * @param viLimit The value must be between 1 and 500.
         * @return {@code Builder}
         */
        public Builder viLimit(int viLimit) {
            videoInfoProp.viLimit = viLimit;
            videoInfoProp.apiUrl.putQuery("vilimit", viLimit);
            return this;
        }

        /**
         * Timestamp to start listing from.
         * @return {@code Builder}
         */
        public Builder viStart(Instant viStart) {
            videoInfoProp.viStart = viStart;
            videoInfoProp.apiUrl.putQuery("vistart", viStart.toString());
            return this;
        }

        /**
         * Timestamp to stop listing at.
         * @return {@code Builder}
         */
        public Builder viEnd(Instant viEnd) {
            videoInfoProp.viEnd = viEnd;
            videoInfoProp.apiUrl.putQuery("viend", viEnd.toString());
            return this;
        }

        /**
         * If viprop=url is set, a URL to an image scaled to this width will be returned. For performance reasons if
         * this option is used, no more than 50 scaled images will be returned.
         * @return {@code Builder}
         */
        public Builder viUrlWidth(int viUrlWidth) {
            videoInfoProp.viUrlWidth = viUrlWidth;
            videoInfoProp.apiUrl.putQuery("viurlwidth", viUrlWidth);
            return this;
        }

        /**
         * Similar to {@code viurlwidth}.
         * @return {@code Builder}
         */
        public Builder viUrlHeight(int viUrlHeight) {
            videoInfoProp.viUrlHeight = viUrlHeight;
            videoInfoProp.apiUrl.putQuery("viurlheight", viUrlHeight);
            return this;
        }

        /**
         * Version of metadata to use. If {@code latest} is specified, use latest version. Defaults to {@code 1} for
         * backwards compatibility.
         * @return {@code Builder}
         */
        public Builder viMetadataVersion(String viMetadataVersion) {
            videoInfoProp.viMetadataVersion = viMetadataVersion;
            videoInfoProp.apiUrl.putQuery("vimetadataversion", viMetadataVersion);
            return this;
        }

        /**
         * What language to fetch {@code extmetadata} in. This affects both which translation to fetch, if multiple are
         * available, as well as how things like numbers and various values are formatted.
         * @return {@code Builder}
         */
        public Builder viExtMetadataLanguage(String viExtMetadataLanguage) {
            videoInfoProp.viExtMetadataLanguage = viExtMetadataLanguage;
            videoInfoProp.apiUrl.putQuery("viextmetadatalanguage", viExtMetadataLanguage);
            return this;
        }

        /**
         * If translations for extmetadata property are available, fetch all of them.
         * @return {@code Builder}
         */
        public Builder viExtMetadataMultiLang() {
            videoInfoProp.viExtMetadataMultiLang = true;
            videoInfoProp.apiUrl.putQuery("viextmetadatamultilang", "1");
            return this;
        }

        /**
         * If specified and non-empty, only these keys will be returned for viprop=extmetadata.
         * Maximum number of values is 50 (500 for clients that are allowed higher limits).
         * @return {@code Builder}
         */
        public Builder viExtMetadataFilter(Set<String> viExtMetadataFilter) {
            videoInfoProp.viExtMetadataFilter = viExtMetadataFilter;
            videoInfoProp.apiUrl.putQuery("viextmetadatafilter", mergeString(viExtMetadataFilter));
            return this;
        }

        /**
         * A handler specific parameter string.
         * For example, PDFs might use {@code page15-100px}. {@code viurlwidth} must be used and be consistent with
         * {@code viurlparam}.
         * @return {@code Builder}
         */
        public Builder viUrlParam(String viUrlParam) {
            videoInfoProp.viUrlParam = viUrlParam;
            videoInfoProp.apiUrl.putQuery("viurlparam", viUrlParam);
            return this;
        }

        /**
         * If {@code badfilecontexttitleprop=badfile} is set, this is the page title used when evaluating the
         * <a href="https://en.wikipedia.org/wiki/MediaWiki:Bad_image_list">MediaWiki:Bad image list</a>.
         * @return {@code Builder}
         */
        public Builder viBadFileContextTitle(String viBadFileContextTitle) {
            videoInfoProp.viBadFileContextTitle = viBadFileContextTitle;
            videoInfoProp.apiUrl.putQuery("vibadfilecontexttitle", viBadFileContextTitle);
            return this;
        }

        /**
         * When more results are available, use this to continue.
         * More detailed information on how to continue queries can be found on
         * <a href="https://www.mediawiki.org/wiki/API:Continue">mediawiki.org</a>.
         * @return {@code Builder}
         */
        public Builder viContinue(String viContinue) {
            videoInfoProp.viContinue = viContinue;
            videoInfoProp.apiUrl.putQuery("vicontinue", viContinue);
            return this;
        }

        /**
         * Look only for files in the local repository.
         * @return {@code Builder}
         */
        public Builder viLocalOnly() {
            videoInfoProp.viLocalOnly = true;
            videoInfoProp.apiUrl.putQuery("vilocalonly", "1");
            return this;
        }

        public VideoInfoProp build() {
            return videoInfoProp;
        }

    }

}
