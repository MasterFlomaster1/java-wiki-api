package dev.masterflomaster1.jwa.request.prop;

import dev.masterflomaster1.jwa.internal.EnumValueProvider;
import dev.masterflomaster1.jwa.request.AbstractBuilder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.EnumSet;

/**
 * Get basic page information.
 *
 * @see <a href="https://www.mediawiki.org/wiki/API:Info">API:Info</a>
 */
@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@SuppressWarnings("SpellCheckingInspection")
public final class InfoProp extends AbstractProp {

    private EnumSet<InProp> inProp;
    private String inContinue;

    private InfoProp() {
        super("info");
    }

    /**
     * Additional properties to get
     */
    @Getter
    public enum InProp implements EnumValueProvider {

        /**
         * The prefixed title of the
         * <a href="https://www.mediawiki.org/wiki/Special:MyLanguage/Help:Associated_pages">associated subject or talk page</a>.
         */
        ASSOCIATED_PAGE ("associatedpage"),

        /**
         * Gives the manner in which the page title is actually displayed.
         */
        DISPLAY_TITLE ("displaytitle"),

        /**
         * Gives the intro messages that should be shown to the user while editing this page or revision, as HTML.
         */
        EDIT_INTRO ("editintro"),

        /**
         * Gives the additional CSS classes (e.g. link colors) used for links to this page if they were to appear on the
         * page named by {@code inlinkcontext}.
         */
        LINK_CLASSES ("linkclasses"),

        /**
         * The watchlist notification timestamp of each page.
         */
        NOTIFICATION_TIMESTAMP ("notificationtimestamp"),

        /**
         * Gives the content to be shown in the editor when the page does not exist or while adding a new section.
         */
        PRELOAD_CONTENT ("preloadcontent"),

        /**
         * List the protection level of each page.
         */
        PROTECTION ("protection"),

        /**
         * The page ID of the parent page for each talk page.
         */
        SUBJECT_ID ("subjectid"),

        /**
         * The page ID of the talk page for each non-talk page.
         */
        TALK_ID ("talkid"),

        /**
         * Gives a full URL, an edit URL, and the canonical URL for each page.
         */
        URL ("url"),

        /**
         * Gives the display title in all variants of the site content language.
         */
        VARIANT_TITLES ("varianttitles"),

        /**
         * The number of watchers of each page who have visited recent edits to that page, if allowed.
         */
        VISITING_WATCHERS ("visitingwatchers"),

        /**
         * List the watched status of each page.
         */
        WATCHED ("watched"),

        /**
         * The number of watchers, if allowed.
         */
        WATCHERS ("watchers");

        private final String value;

        InProp(String value) {
            this.value = value;
        }

    }

    public static class Builder extends AbstractBuilder {

        private final InfoProp infoProp = new InfoProp();

        /**
         * Which additional properties to get
         * @return {@code Builder}
         */
        public Builder inProp(EnumSet<InProp> inProp) {
            infoProp.inProp = inProp;
            infoProp.apiUrl.putQuery("inprop", merge(inProp));
            return this;
        }

        /**
         * When more results are available, use this to continue.
         * More detailed information on how to continue queries can be found on
         * <a href="https://www.mediawiki.org/wiki/API:Continue">mediawiki.org</a>.
         * @return {@code Builder}
         */
        public Builder inContinue(String inContinue) {
            infoProp.inContinue = inContinue;
            infoProp.apiUrl.putQuery("incontinue", inContinue);
            return this;
        }

        public InfoProp build() {
            return infoProp;
        }

    }

}
