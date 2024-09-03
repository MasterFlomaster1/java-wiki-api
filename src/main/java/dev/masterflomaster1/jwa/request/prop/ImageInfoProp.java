package dev.masterflomaster1.jwa.request.prop;

import dev.masterflomaster1.jwa.common.Prop;
import dev.masterflomaster1.jwa.util.TimeHandler;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Returns file information and upload history.
 *
 * @see <a href="https://www.mediawiki.org/wiki/API:Imageinfo">API:Imageinfo</a>
 */
@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
public final class ImageInfoProp extends AbstractProp {

    private Set<Prop> iiProp;
    private int iiLimit;
    private LocalDateTime iiStart;
    private LocalDateTime iiEnd;
    private int iiUrlWidth;
    private int iiUrlHeight;
    private String iiExtMetadataLanguage;
    private boolean iiExtMetadataMultiLang;

    private ImageInfoProp() {
        name = "imageinfo";
    }

    public static class Builder {

        private final ImageInfoProp imageInfoProp = new ImageInfoProp();

        /**
         * Which file information to get
         * @return {@code Builder}
         */
        public Builder iiProp(Set<Prop> iiProp) {
            imageInfoProp.iiProp = iiProp;
            imageInfoProp.apiUrl.putQuery("iiprop", iiProp.stream()
                    .map(Prop::getValue)
                    .collect(Collectors.joining("|")));
            return this;
        }

        /**
         * How many file revisions to return per file. Default: 1.
         * @param iiLimit The value must be between 1 and 500.
         * @return {@code Builder}
         */
        public Builder iiLimit(int iiLimit) {
            imageInfoProp.iiLimit = iiLimit;
            imageInfoProp.apiUrl.putQuery("iilimit", iiLimit);
            return this;
        }

        /**
         * Timestamp to start listing from.
         * @return {@code Builder}
         */
        public Builder iiStart(LocalDateTime iiStart) {
            imageInfoProp.iiStart = iiStart;
            imageInfoProp.apiUrl.putQuery("iistart", TimeHandler.formatISO8601(iiStart));
            return this;
        }

        /**
         * Timestamp to stop listing at.
         * @return {@code Builder}
         */
        public Builder iiEnd(LocalDateTime iiEnd) {
            imageInfoProp.iiEnd = iiEnd;
            imageInfoProp.apiUrl.putQuery("iiend", TimeHandler.formatISO8601(iiEnd));
            return this;
        }

        /**
         * If iiprop=url is set, a URL to an image scaled to this width will be returned. For performance reasons if
         * this option is used, no more than 50 scaled images will be returned.
         * @return {@code Builder}
         */
        public Builder iiUrlWidth(int iiUrlWidth) {
            imageInfoProp.iiUrlWidth = iiUrlWidth;
            imageInfoProp.apiUrl.putQuery("iiurlwidth", iiUrlWidth);
            return this;
        }

        /**
         * Similar to {@code iiurlwidth}.
         * @return {@code Builder}
         */
        public Builder iiUrlHeight(int iiUrlHeight) {
            imageInfoProp.iiUrlHeight = iiUrlHeight;
            imageInfoProp.apiUrl.putQuery("iiurlheight", iiUrlHeight);
            return this;
        }

        /**
         * What language to fetch {@code extmetadata} in. This affects both which translation to fetch, if multiple are
         * available, as well as how things like numbers and various values are formatted.
         * @param iiExtMetadataLanguage value
         * @return {@code Builder}
         */
        public Builder iiExtMetadataLanguage(String iiExtMetadataLanguage) {
            imageInfoProp.iiExtMetadataLanguage = iiExtMetadataLanguage;
            imageInfoProp.apiUrl.putQuery("iiextmetadatalanguage", iiExtMetadataLanguage);
            return this;
        }

        /**
         * If translations for extmetadata property are available, fetch all of them.
         * @return {@code Builder}
         */
        public Builder iiExtMetadataMultiLang() {
            imageInfoProp.iiExtMetadataMultiLang = true;
            imageInfoProp.apiUrl.putQuery("iiextmetadatamultilang", "1");
            return this;
        }

        public ImageInfoProp build() {
            return imageInfoProp;
        }

    }

}
