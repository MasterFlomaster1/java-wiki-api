package dev.masterflomaster1.jwa.request.prop;

import dev.masterflomaster1.jwa.common.Namespace;
import dev.masterflomaster1.jwa.common.Show;
import dev.masterflomaster1.jwa.internal.EnumValueProvider;
import dev.masterflomaster1.jwa.request.AbstractBuilder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.EnumSet;

/**
 * Returns all links from the given pages.
 *
 * @see <a href="https://www.mediawiki.org/wiki/Special:MyLanguage/API:Linkshere">API:Linkshere</a>
 */
@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@SuppressWarnings("SpellCheckingInspection")
public final class LinksHereProp extends AbstractProp {

    private EnumSet<LhProp> lhProp;
    private EnumSet<Namespace> lhNamespace;
    private EnumSet<Show.Redirect> lhShow;
    private int lhLimit;
    private String lhContinue;

    private LinksHereProp() {
        super("linkshere");
    }

    public static class Builder extends AbstractBuilder {

        private final LinksHereProp linksHereProp = new LinksHereProp();

        /**
         * Which properties to get.
         * @return {@code Builder}
         */
        public Builder lhProp(final EnumSet<LhProp> lhProp) {
            linksHereProp.lhProp = lhProp;
            linksHereProp.apiUrl.putQuery("lhProp", merge(lhProp));
            return this;
        }

        /**
         * Only include pages in these namespaces.
         * @return {@code Builder}
         */
        public Builder lhNamespace(final EnumSet<Namespace> lhNamespace) {
            linksHereProp.lhNamespace = lhNamespace;
            linksHereProp.apiUrl.putQuery("lhNamespace", merge(lhNamespace));
            return this;
        }

        /**
         * Show only items that meet these criteria.
         * @return {@code Builder}
         */
        public Builder lhShow(final EnumSet<Show.Redirect> lhShow) {
            linksHereProp.lhShow = lhShow;
            linksHereProp.apiUrl.putQuery("lhShow", merge(lhShow));
            return this;
        }

        /**
         * How many redirects to return.
         * @param lhLimit The value must be between 1 and 500.
         * @return {@code Builder}
         */
        public Builder lhLimit(final int lhLimit) {
            linksHereProp.lhLimit = lhLimit;
            linksHereProp.apiUrl.putQuery("lhlimit", lhLimit);
            return this;
        }

        /**
         * When more results are available, use this to continue.
         * More detailed information on how to continue queries can be found on
         * <a href="https://www.mediawiki.org/wiki/API:Continue">mediawiki.org</a>.
         * @return {@code Builder}
         */
        public Builder lhContinue(final String lhContinue) {
            linksHereProp.lhContinue = lhContinue;
            linksHereProp.apiUrl.putQuery("lhcontinue", lhContinue);
            return this;
        }

        public LinksHereProp build() {
            return linksHereProp;
        }

    }

    @Getter
    public enum LhProp implements EnumValueProvider {

        /**
         * Page ID of each page.
         */
        PAGE_ID("pageid"),

        /**
         * Title of each page.
         */
        TITLE("title"),

        /**
         * Flag if the page is a redirect.
         */
        REDIRECT("redirect");

        private final String value;

        LhProp(String value) {
            this.value = value;
        }

    }

}
