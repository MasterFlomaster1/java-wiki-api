package dev.masterflomaster1.jwa.request.prop;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Get basic page information.
 *
 * @see <a href="https://www.mediawiki.org/wiki/API:Info">API:Info</a>
 */
public class InfoProp extends AbstractProp {

    private Set<InProp> inProp;
    private String inContinue;

    private InfoProp() {
        name = "info";
    }

    public Set<InProp> getInProp() {
        return inProp;
    }

    public String getInContinue() {
        return inContinue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        InfoProp infoProp = (InfoProp) o;

        if (!Objects.equals(inProp, infoProp.inProp)) return false;
        return Objects.equals(inContinue, infoProp.inContinue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inProp, inContinue);
    }

    /**
     * Additional properties to get
     */
    public enum InProp {

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

        public String getValue() {
            return value;
        }
    }

    public static class Builder {

        private final InfoProp infoProp = new InfoProp();

        /**
         * Which additional properties to get
         * @return {@code Builder}
         */
        public Builder inProp(Set<InProp> inProp) {
            infoProp.inProp = inProp;
            infoProp.apiUrl.putQuery("inprop", inProp.stream()
                    .map(InProp::getValue)
                    .collect(Collectors.joining("|")));
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
