package dev.masterflomaster1.jwa.model.prop;

import dev.masterflomaster1.jwa.common.Dir;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Returns all files contained on the given pages.
 *
 * @see <a href="https://www.mediawiki.org/wiki/API:Images">API:Images</a>
 */
public class ImagesProp extends AbstractProp {

    private int imLimit;
    private String imContinue;
    private Set<String> imImages;
    private Dir imDir;

    private ImagesProp() {
        url += "&prop=images";
    }

    public int getImLimit() {
        return imLimit;
    }

    public String getImContinue() {
        return imContinue;
    }

    public Set<String> getImImages() {
        return imImages;
    }

    public Dir getImDir() {
        return imDir;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ImagesProp that = (ImagesProp) o;

        if (imLimit != that.imLimit) return false;
        if (!Objects.equals(imContinue, that.imContinue)) return false;
        if (!Objects.equals(imImages, that.imImages)) return false;
        return imDir == that.imDir;
    }

    @Override
    public int hashCode() {
        return Objects.hash(imLimit, imContinue, imImages, imDir);
    }

    public static class Builder {

        private final ImagesProp imagesProp = new ImagesProp();

        /**
         * How many files to return.
         * @param imLimit The value must be between 1 and 500.
         * @return {@code Builder}
         */
        public Builder imLimit(int imLimit) {
            imagesProp.imLimit = imLimit;
            imagesProp.url += "&imlimit=" + imLimit;
            return this;
        }

        /**
         * When more results are available, use this to continue.
         * More detailed information on how to continue queries can be found on
         * <a href="https://www.mediawiki.org/wiki/API:Continue">mediawiki.org</a>.
         * @return {@code Builder}
         */
        public Builder imContinue(String imContinue) {
            imagesProp.imContinue = imContinue;
            imagesProp.url += "&imcontinue=" + URLEncoder.encode(imContinue, StandardCharsets.UTF_8);
            return this;
        }

        /**
         * Only list these files. Useful for checking whether a certain page has a certain file.
         * @param imImages Maximum number of values is 50 (500 for clients that are allowed higher limits).
         * @return {@code Builder}
         */
        public Builder imImages(Set<String> imImages) {
            imagesProp.imImages = imImages;
            imagesProp.url += "&imimages=" + imImages.stream()
                    .map(str -> URLEncoder.encode(str, StandardCharsets.UTF_8))
                    .collect(Collectors.joining("%7C"));
            return this;
        }

        /**
         * The direction in which to list.
         * @return {@code Builder}
         */
        public Builder imDir(Dir imDir) {
            imagesProp.imDir = imDir;
            imagesProp.url += "&imdir=" + imDir.getValue();
            return this;
        }

        public ImagesProp build() {
            return imagesProp;
        }

    }

}
