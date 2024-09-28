package dev.masterflomaster1.jwa.request.prop;

import dev.masterflomaster1.jwa.common.Dir;
import dev.masterflomaster1.jwa.common.Namespace;
import dev.masterflomaster1.jwa.request.AbstractBuilder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.EnumSet;
import java.util.Set;

/**
 * Returns all links from the given pages.
 *
 * @see <a href="https://www.mediawiki.org/wiki/Special:MyLanguage/API:Links">API:Links</a>
 */
@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@SuppressWarnings("SpellCheckingInspection")
public final class LinksProp extends AbstractProp {

    private EnumSet<Namespace> plNamespace;
    private int plLimit;
    private String plContinue;
    private Set<String> plTitles;
    private Dir.Order plDir;

    private LinksProp() {
        super("links");
    }

    public static class Builder extends AbstractBuilder {

        private final LinksProp linksProp = new LinksProp();

        /**
         * Show links in these namespaces only.
         * @return {@code Builder}
         */
        public Builder plNamespace(final EnumSet<Namespace> plNamespace) {
            linksProp.plNamespace = plNamespace;
            linksProp.apiUrl.putQuery("plnamespace", merge(plNamespace));
            return this;
        }

        /**
         * How many redirects to return.
         * @param plLimit The value must be between 1 and 500.
         * @return {@code Builder}
         */
        public Builder plLimit(final int plLimit) {
            linksProp.plLimit = plLimit;
            linksProp.apiUrl.putQuery("pllimit", plLimit);
            return this;
        }

        /**
         * When more results are available, use this to continue.
         * More detailed information on how to continue queries can be found on
         * <a href="https://www.mediawiki.org/wiki/API:Continue">mediawiki.org</a>.
         * @return {@code Builder}
         */
        public Builder plContinue(final String plContinue) {
            linksProp.plContinue = plContinue;
            linksProp.apiUrl.putQuery("plcontinue", plContinue);
            return this;
        }

        /**
         * Only list links to these titles. Useful for checking whether a certain page links to a certain title.
         * @param plTitles Maximum number of values is 50 (500 for clients that are allowed higher limits).
         * @return {@code Builder}
         */
        public Builder plTitles(final Set<String> plTitles) {
            linksProp.plTitles = plTitles;
            linksProp.apiUrl.putQuery("pltitles", mergeString(plTitles));
            return this;
        }

        /**
         * The direction in which to list.
         * @return {@code Builder}
         */
        public Builder plDir(final Dir.Order plDir) {
            linksProp.plDir = plDir;
            linksProp.apiUrl.putQuery("pldir", plDir.getValue());
            return this;
        }

        public LinksProp build() {
            return linksProp;
        }

    }

}
