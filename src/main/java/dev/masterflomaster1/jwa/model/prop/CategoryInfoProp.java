package dev.masterflomaster1.jwa.model.prop;

/**
 * Returns information about the given categories.
 *
 * @see <a href="https://www.mediawiki.org/wiki/API:Categoryinfo">API:Categoryinfo</a>
 */
public class CategoryInfoProp extends AbstractProp {

    private String ciContinue;

    private CategoryInfoProp() {
        url += "&prop=categoryinfo";
    }

    public String getCiContinue() {
        return ciContinue;
    }

    public static class Builder {

        private final CategoryInfoProp categoryInfoProp = new CategoryInfoProp();

        /**
         * When more results are available, use this to continue.
         * More detailed information on how to continue queries can be found on
         * <a href="https://www.mediawiki.org/wiki/API:Continue">mediawiki.org</a>.
         * @return {@code Builder}
         */
        public Builder ciContinue(String ciContinue) {
            categoryInfoProp.ciContinue = ciContinue;
            return this;
        }

        public CategoryInfoProp build() {
            return categoryInfoProp;
        }

    }

}
