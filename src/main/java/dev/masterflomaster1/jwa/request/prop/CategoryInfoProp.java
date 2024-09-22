package dev.masterflomaster1.jwa.request.prop;

import dev.masterflomaster1.jwa.request.AbstractBuilder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

/**
 * Returns information about the given categories.
 *
 * @see <a href="https://www.mediawiki.org/wiki/API:Categoryinfo">API:Categoryinfo</a>
 */
@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@SuppressWarnings("SpellCheckingInspection")
public final class CategoryInfoProp extends AbstractProp {

    private String ciContinue;

    private CategoryInfoProp() {
        super("categoryinfo");
    }

    public static class Builder extends AbstractBuilder {

        private final CategoryInfoProp categoryInfoProp = new CategoryInfoProp();

        /**
         * When more results are available, use this to continue.
         * More detailed information on how to continue queries can be found on
         * <a href="https://www.mediawiki.org/wiki/API:Continue">mediawiki.org</a>.
         * @return {@code Builder}
         */
        public Builder ciContinue(String ciContinue) {
            categoryInfoProp.ciContinue = ciContinue;
            categoryInfoProp.apiUrl.putQuery("cicontinue", ciContinue);
            return this;
        }

        public CategoryInfoProp build() {
            return categoryInfoProp;
        }

    }

}
