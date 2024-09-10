package dev.masterflomaster1.jwa.request.prop;

import dev.masterflomaster1.jwa.common.Dir;
import dev.masterflomaster1.jwa.common.Namespace;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Returns all pages transcluded on the given pages.
 *
 * @see <a href="https://www.mediawiki.org/wiki/API:Templates">API:Templates</a>
 */
@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@SuppressWarnings("SpellCheckingInspection")
public final class TemplatesProp extends AbstractProp {

    private Set<Namespace> tlNamespace;
    private int tlLimit;
    private String tlContinue;
    private Set<String> tlTemplates;
    private Dir tlDir;

    private TemplatesProp() {
        name = "templates";
    }

    public static class Builder {

        private final TemplatesProp templatesProp = new TemplatesProp();

        /**
         * Show templates in these namespaces only.
         * @return {@code Builder}
         */
        public Builder tlNamespace(Set<Namespace> tlNamespace) {
            templatesProp.tlNamespace = tlNamespace;
            templatesProp.apiUrl.putQuery("tlnamespace", tlNamespace.stream()
                    .map(Namespace::getValue)
                    .collect(Collectors.joining("|")));
            return this;
        }

        /**
         * How many templates to return. Default: 10
         * @param tlLimit The value must be between 1 and 500.
         * @return {@code Builder}
         */
        public Builder tlLimit(int tlLimit) {
            templatesProp.tlLimit = tlLimit;
            templatesProp.apiUrl.putQuery("tllimit", tlLimit);
            return this;
        }

        /**
         * When more results are available, use this to continue.
         * More detailed information on how to continue queries can be found on
         * <a href="https://www.mediawiki.org/wiki/API:Continue">mediawiki.org</a>.
         * @return {@code Builder}
         */
        public Builder tlContinue(String tlContinue) {
            templatesProp.tlContinue = tlContinue;
            templatesProp.apiUrl.putQuery("tlcontinue", tlContinue);
            return this;
        }

        /**
         * Only list these templates. Useful for checking whether a certain page uses a certain template.
         * @param tlTemplates Maximum number of values is 50 (500 for clients that are allowed higher limits).
         * @return {@code Builder}
         */
        public Builder tlTemplates(Set<String> tlTemplates) {
            templatesProp.tlTemplates = tlTemplates;
            templatesProp.apiUrl.putQuery("tltemplates", String.join("|", tlTemplates));
            return this;
        }

        /**
         * The direction in which to list. Default: ascending
         * @return {@code Builder}
         */
        public Builder tlDir(Dir tlDir) {
            templatesProp.tlDir = tlDir;
            templatesProp.apiUrl.putQuery("tldir", tlDir.getValue());
            return this;
        }

        public TemplatesProp build() {
            return templatesProp;
        }

    }

}
