package dev.masterflomaster1.jwa.model.prop;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class VideoInfoProp extends AbstractProp {

    private Set<ViProp> viProp;
    private int viLimit;
    private LocalDateTime viStart;
    private LocalDateTime viEnd;
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
        url = "&prop=videoinfo";
    }

    public Set<ViProp> getViProp() {
        return viProp;
    }

    public int getViLimit() {
        return viLimit;
    }

    public LocalDateTime getViStart() {
        return viStart;
    }

    public LocalDateTime getViEnd() {
        return viEnd;
    }

    public int getViUrlWidth() {
        return viUrlWidth;
    }

    public int getViUrlHeight() {
        return viUrlHeight;
    }

    public String getViMetadataVersion() {
        return viMetadataVersion;
    }

    public String getViExtMetadataLanguage() {
        return viExtMetadataLanguage;
    }

    public boolean isViExtMetadataMultiLang() {
        return viExtMetadataMultiLang;
    }

    public Set<String> getViExtMetadataFilter() {
        return viExtMetadataFilter;
    }

    public String getViUrlParam() {
        return viUrlParam;
    }

    public String getViBadFileContextTitle() {
        return viBadFileContextTitle;
    }

    public String getViContinue() {
        return viContinue;
    }

    public boolean isViLocalOnly() {
        return viLocalOnly;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VideoInfoProp that = (VideoInfoProp) o;

        if (viLimit != that.viLimit) return false;
        if (viUrlWidth != that.viUrlWidth) return false;
        if (viUrlHeight != that.viUrlHeight) return false;
        if (viExtMetadataMultiLang != that.viExtMetadataMultiLang) return false;
        if (viLocalOnly != that.viLocalOnly) return false;
        if (!Objects.equals(viProp, that.viProp)) return false;
        if (!Objects.equals(viStart, that.viStart)) return false;
        if (!Objects.equals(viEnd, that.viEnd)) return false;
        if (!Objects.equals(viMetadataVersion, that.viMetadataVersion))
            return false;
        if (!Objects.equals(viExtMetadataLanguage, that.viExtMetadataLanguage))
            return false;
        if (!Objects.equals(viExtMetadataFilter, that.viExtMetadataFilter))
            return false;
        if (!Objects.equals(viUrlParam, that.viUrlParam)) return false;
        if (!Objects.equals(viBadFileContextTitle, that.viBadFileContextTitle))
            return false;
        return Objects.equals(viContinue, that.viContinue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(viProp, viLimit, viStart, viEnd, viUrlWidth, viUrlHeight, viMetadataVersion,
                viExtMetadataLanguage, viExtMetadataMultiLang, viExtMetadataFilter, viUrlParam, viBadFileContextTitle,
                viContinue, viLocalOnly);
    }

    public static class Builder {

        private final VideoInfoProp videoInfoProp = new VideoInfoProp();

        /**
         * Which file information to get
         * @return {@code Builder}
         */
        public Builder viProp(Set<ViProp> viProp) {
            videoInfoProp.viProp = viProp;
            videoInfoProp.url += "&viprop=" + viProp.stream()
                    .map(ViProp::getValue)
                    .collect(Collectors.joining("%7C"));
            return this;
        }

        /**
         * How many file revisions to return per file.
         * @param viLimit The value must be between 1 and 500.
         * @return {@code Builder}
         */
        public Builder viLimit(int viLimit) {
            videoInfoProp.viLimit = viLimit;
            videoInfoProp.url += "&vilimit=" + viLimit;
            return this;
        }

        /**
         * Timestamp to start listing from.
         * @return {@code Builder}
         */
        public Builder viStart(LocalDateTime viStart) {
            videoInfoProp.viStart = viStart;
            videoInfoProp.url += "&vistart=" + URLEncoder.encode(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'").format(viStart), StandardCharsets.UTF_8);
            return this;
        }

        /**
         * Timestamp to stop listing at.
         * @return {@code Builder}
         */
        public Builder viEnd(LocalDateTime viEnd) {
            videoInfoProp.viEnd = viEnd;
            videoInfoProp.url += "&viend=" + URLEncoder.encode(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'").format(viEnd), StandardCharsets.UTF_8);
            return this;
        }

        /**
         * If viprop=url is set, a URL to an image scaled to this width will be returned. For performance reasons if
         * this option is used, no more than 50 scaled images will be returned.
         * @return {@code Builder}
         */
        public Builder viUrlWidth(int viUrlWidth) {
            videoInfoProp.viUrlWidth = viUrlWidth;
            videoInfoProp.url += "&viurlwidth=" + viUrlWidth;
            return this;
        }

        /**
         * Similar to {@code viurlwidth}.
         * @return {@code Builder}
         */
        public Builder viUrlHeight(int viUrlHeight) {
            videoInfoProp.viUrlHeight = viUrlHeight;
            videoInfoProp.url += "&viurlheight=" + viUrlHeight;
            return this;
        }

        /**
         * Version of metadata to use. If {@code latest} is specified, use latest version. Defaults to {@code 1} for
         * backwards compatibility.
         * @return {@code Builder}
         */
        public Builder viMetadataVersion(String viMetadataVersion) {
            videoInfoProp.viMetadataVersion = viMetadataVersion;
            videoInfoProp.url += "&vimetadataversion=" + viMetadataVersion;
            return this;
        }

        /**
         * What language to fetch {@code extmetadata} in. This affects both which translation to fetch, if multiple are
         * available, as well as how things like numbers and various values are formatted.
         * @return {@code Builder}
         */
        public Builder viExtMetadataLanguage(String viExtMetadataLanguage) {
            videoInfoProp.viExtMetadataLanguage = viExtMetadataLanguage;
            videoInfoProp.url += "&viextmetadatalanguage=" + viExtMetadataLanguage;
            return this;
        }

        /**
         * If translations for extmetadata property are available, fetch all of them.
         * @return {@code Builder}
         */
        public Builder viExtMetadataMultiLang() {
            videoInfoProp.viExtMetadataMultiLang = true;
            videoInfoProp.url += "&viextmetadatamultilang=1";
            return this;
        }

        /**
         * If specified and non-empty, only these keys will be returned for viprop=extmetadata.
         * Maximum number of values is 50 (500 for clients that are allowed higher limits).
         * @return {@code Builder}
         */
        public Builder viExtMetadataFilter(Set<String> viExtMetadataFilter) {
            videoInfoProp.viExtMetadataFilter = viExtMetadataFilter;
            videoInfoProp.url += "&viextmetadatafilter=" +viExtMetadataFilter.stream()
                    .map(str -> URLEncoder.encode(str, StandardCharsets.UTF_8))
                    .collect(Collectors.joining("%7C"));
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
            videoInfoProp.url += "&viurlparam=" + URLEncoder.encode(viUrlParam, StandardCharsets.UTF_8);
            return this;
        }

        /**
         * If {@code badfilecontexttitleprop=badfile} is set, this is the page title used when evaluating the
         * <a href="https://en.wikipedia.org/wiki/MediaWiki:Bad_image_list">MediaWiki:Bad image list</a>.
         * @return {@code Builder}
         */
        public Builder viBadFileContextTitle(String viBadFileContextTitle) {
            videoInfoProp.viBadFileContextTitle = viBadFileContextTitle;
            videoInfoProp.url += "&vibadfilecontexttitle=" + URLEncoder.encode(viBadFileContextTitle, StandardCharsets.UTF_8);
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
            videoInfoProp.url += "&vicontinue=" + URLEncoder.encode(viContinue, StandardCharsets.UTF_8);
            return this;
        }

        /**
         * Look only for files in the local repository.
         * @return {@code Builder}
         */
        public Builder viLocalOnly() {
            videoInfoProp.viLocalOnly = true;
            videoInfoProp.url += "&vilocalonly=1";
            return this;
        }

        public VideoInfoProp build() {
            return videoInfoProp;
        }

    }

    public enum ViProp {
        USER_ID ("userid");

        public final String value;

        ViProp(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

}
