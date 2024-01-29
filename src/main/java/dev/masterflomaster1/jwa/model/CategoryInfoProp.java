package dev.masterflomaster1.jwa.model;

public class CategoryInfoProp extends AbstractProp {

    private String ciContinue;

    private CategoryInfoProp() {
        url += "&prop=categoryinfo";
    }

    public static class Builder {

        private final CategoryInfoProp categoryInfoProp = new CategoryInfoProp();

        /**
         * When more results are available, use this to continue.
         * @param ciContinue string
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
