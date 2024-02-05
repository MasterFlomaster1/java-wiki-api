package dev.masterflomaster1.jwa.model.prop;

/**
 * Returns all files contained on the given pages.
 *
 * @see <a href="https://www.mediawiki.org/wiki/API:Images">API:Images</a>
 */
public class ImagesProp extends AbstractProp {

    private int imLimit;
    private String imContinue;

    private ImagesProp() {
        url += "&prop=images";
    }

    public static class Builder {

        private final ImagesProp imagesProp = new ImagesProp();

        public ImagesProp build() {
            return imagesProp;
        }

    }

}
