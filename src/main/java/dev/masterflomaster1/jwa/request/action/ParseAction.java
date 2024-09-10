package dev.masterflomaster1.jwa.request.action;

import dev.masterflomaster1.jwa.common.ContentFormat;
import dev.masterflomaster1.jwa.common.ContentModel;
import lombok.Getter;
import lombok.ToString;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Parses content and returns parser output.
 *
 * @see <a href="https://www.mediawiki.org/wiki/API:Parsing_wikitext">API:Parsing wikitext</a>
 */
@Getter
@ToString
@SuppressWarnings("SpellCheckingInspection")
public final class ParseAction extends AbstractAction {

    private String title;
    private String text;
    private long revId;
    private String summary;
    private String page;
    private int pageId;
    private boolean redirects;
    private long oldId;
    private Set<Prop> prop;
    private String wrapOutputClass;
    private boolean parsoid;
    private boolean pst;
    private boolean onlyPst;
    private String section;
    private String sectionTitle;
    private boolean disableLimitReport;
    private boolean disableEditSection;
    private boolean disableStyleDeduplication;
    private boolean showStrategyKeys;
    private boolean preview;
    private boolean sectionPreview;
    private boolean disableToc;
    private UseSkin useSkin;
    private ContentFormat contentFormat;
    private ContentModel contentModel;
    private boolean mobileFormat;

    private ParseAction() {
        apiUrl.setAction("parse");
    }

    public static class Builder {

        private final ParseAction parseAction = new ParseAction();

        /**
         * Title of page the text belongs to.
         * If omitted, {@code contentmodel} must be specified, and API will be used as the title.
         * @return {@code Builder}
         */
        public Builder title(String title) {
            parseAction.title = title;
            parseAction.apiUrl.putQuery("title", title);
            return this;
        }

        /**
         * Text to parse. Use {@code title} or {@code contentmodel} to control the content model.
         * @return {@code Builder}
         */
        public Builder text(String text) {
            parseAction.text = text;
            parseAction.apiUrl.putQuery("text", text);
            return this;
        }

        /**
         * Revision ID, for {@code {{REVISIONID}}} and similar variables.
         * @return {@code Builder}
         */
        public Builder revId(long revId) {
            parseAction.revId = revId;
            parseAction.apiUrl.putQuery("revid", revId);
            return this;
        }

        /**
         * Summary to parse.
         * @return {@code Builder}
         */
        public Builder summary(String summary) {
            parseAction.summary = summary;
            parseAction.apiUrl.putQuery("summary", summary);
            return this;
        }

        /**
         * Parse the content of this page.
         * Cannot be used together with text and title.
         * @return {@code Builder}
         */
        public Builder page(String page) {
            parseAction.page = page;
            parseAction.apiUrl.putQuery("page", page);
            return this;
        }

        /**
         * Parse the content of this page. Overrides {@code page}.
         * @return {@code Builder}
         */
        public Builder pageId(int pageId) {
            parseAction.pageId = pageId;
            parseAction.apiUrl.putQuery("pageid", pageId);
            return this;
        }

        /**
         * If {@code page} or {@code pageid} is set to a redirect, resolve it
         * @return {@code Builder}
         */
        public Builder redirects() {
            parseAction.redirects = true;
            parseAction.apiUrl.putQuery("redirects", "1");
            return this;
        }

        /**
         * Parse the content of this revision. Overrides {@code page} and {@code pageid}.
         * @return {@code Builder}
         */
        public Builder oldId(long oldId) {
            parseAction.oldId = oldId;
            parseAction.apiUrl.putQuery("oldid", oldId);
            return this;
        }

        /**
         * Which pieces of information to get
         * @return {@code Builder}
         */
        public Builder prop(Set<Prop> prop) {
            parseAction.prop = prop;
            parseAction.apiUrl.putQuery("prop", prop.stream()
                    .map(Prop::getValue)
                    .collect(Collectors.joining("|")));
            return this;
        }

        /**
         * CSS class to use to wrap the parser output.
         * @return {@code Builder}
         */
        public Builder wrapOutputClass(String wrapOutputClass) {
            parseAction.wrapOutputClass = wrapOutputClass;
            parseAction.apiUrl.putQuery("wrapoutputclass", wrapOutputClass);
            return this;
        }

        /**
         * Generate HTML conforming to the <a href="https://www.mediawiki.org/wiki/Specs/HTML">MediaWiki DOM spec</a>
         * using <a href="https://www.mediawiki.org/wiki/Parsoid">Parsoid</a>.
         * @return {@code Builder}
         */
        public Builder parsoid() {
            parseAction.parsoid = true;
            parseAction.apiUrl.putQuery("parsoid", "1");
            return this;
        }

        /**
         * Do a pre-save transform on the input before parsing it. Only valid when used with text.
         * @return {@code Builder}
         */
        public Builder pst() {
            parseAction.pst = true;
            parseAction.apiUrl.putQuery("pst", "1");
            return this;
        }

        /**
         * Do a pre-save transform (PST) on the input, but don't parse it. Returns the same wikitext, after a PST has
         * been applied. Only valid when used with {@code text}.
         * @return {@code Builder}
         */
        public Builder onlyPst() {
            parseAction.onlyPst = true;
            parseAction.apiUrl.putQuery("onlypst", "1");
            return this;
        }

        /**
         * Only parse the content of the section with this identifier.
         * When {@code new}, parse {@code text} and {@code sectiontitle} as if adding a new section to the page.
         * {@code new} is allowed only when specifying {@code text}.
         * @return {@code Builder}
         */
        public Builder section(String section) {
            parseAction.section = section;
            parseAction.apiUrl.putQuery("section", section);
            return this;
        }

        /**
         * New section title when {@code section} is {@code new}.
         * @return {@code Builder}
         */
        public Builder sectionTitle(String sectionTitle) {
            parseAction.sectionTitle = sectionTitle;
            parseAction.apiUrl.putQuery("sectiontitle", sectionTitle);
            return this;
        }

        /**
         * Omit the limit report ("NewPP limit report") from the parser output.
         * @return {@code Builder}
         */
        public Builder disableLimitReport() {
            parseAction.disableLimitReport = true;
            parseAction.apiUrl.putQuery("disablelimitreport", "1");
            return this;
        }

        /**
         * Omit edit section links from the parser output.
         * @return {@code Builder}
         */
        public Builder disableEditSection() {
            parseAction.disableEditSection = true;
            parseAction.apiUrl.putQuery("disableeditsection", "1");
            return this;
        }

        /**
         * Do not deduplicate inline stylesheets in the parser output.
         * @return {@code Builder}
         */
        public Builder disableStyleDeduplication() {
            parseAction.disableStyleDeduplication = true;
            parseAction.apiUrl.putQuery("disablestylededuplication", "1");
            return this;
        }

        /**
         * Whether to include internal merge strategy information in jsconfigvars.
         * @return {@code Builder}
         */
        public Builder showStrategyKeys() {
            parseAction.showStrategyKeys = true;
            parseAction.apiUrl.putQuery("showstrategykeys", "1");
            return this;
        }

        /**
         * Parse in preview mode.
         * @return {@code Builder}
         */
        public Builder preview() {
            parseAction.preview = true;
            parseAction.apiUrl.putQuery("preview", "1");
            return this;
        }

        /**
         * Parse in section preview mode (enables preview mode too).
         * @return {@code Builder}
         */
        public Builder sectionPreview() {
            parseAction.sectionPreview = true;
            parseAction.apiUrl.putQuery("sectionpreview", "1");
            return this;
        }

        /**
         * Omit table of contents in output.
         * @return {@code Builder}
         */
        public Builder disableToc() {
            parseAction.disableToc = true;
            parseAction.apiUrl.putQuery("disabletoc", "1");
            return this;
        }

        /**
         * Apply the selected skin to the parser output.
         * May affect the following properties: {@code text}, {@code langlinks}, {@code headitems}, {@code modules},
         * {@code jsconfigvars}, {@code indicators}.
         * @return {@code Builder}
         */
        public Builder useSkin(UseSkin useSkin) {
            parseAction.useSkin = useSkin;
            parseAction.apiUrl.putQuery("useskin", useSkin.getValue());
            return this;
        }

        /**
         * Content serialization format used for the input text. Only valid when used with text.
         * @return {@code Builder}
         */
        public Builder contentFormat(ContentFormat contentFormat) {
            parseAction.contentFormat = contentFormat;
            parseAction.apiUrl.putQuery("contentformat", contentFormat);
            return this;
        }

        /**
         * Content model of the input text. If omitted, title must be specified, and default will be the model of the
         * specified title. Only valid when used with text.
         * @return {@code Builder}
         */
        public Builder contentModel(ContentModel contentModel) {
            parseAction.contentModel = contentModel;
            parseAction.apiUrl.putQuery("contentmodel", contentModel.getValue());
            return this;
        }

        /**
         * Return parse output in a format suitable for mobile devices.
         * @return {@code Builder}
         */
        public Builder mobileFormat() {
            parseAction.mobileFormat = true;
            parseAction.apiUrl.putQuery("mobileformat", "1");
            return this;
        }

        public ParseAction build() {
            return parseAction;
        }

    }

    @Getter
    public enum Prop {

        CATEGORIES ("categories");

        private final String value;

        Prop(String value) {
            this.value = value;
        }

    }

    @Getter
    public enum UseSkin {

        API_OUTPUT ("apioutput"),
        COLOGNE_BLUE ("cologneblue"),
        CONTENT_TRANSLATION ("contenttranslation"),
        FALLBACK ("fallback"),
        MINERVA ("minerva"),
        MODERN ("modern"),
        MONOBOOK ("monobook"),
        TIMELESS ("timeless"),
        VECTOR ("vactor"),
        VECTOR_2022 ("vector");

        private final String value;

        UseSkin(String value) {
            this.value = value;
        }

    }

}
