package dev.masterflomaster1.jwa.request.prop;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CategoryInfoProp that = (CategoryInfoProp) o;

        return Objects.equals(ciContinue, that.ciContinue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ciContinue);
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
            categoryInfoProp.url += "&cicontinue=" + URLEncoder.encode(ciContinue, StandardCharsets.UTF_8);
            return this;
        }

        public CategoryInfoProp build() {
            return categoryInfoProp;
        }

    }

}
