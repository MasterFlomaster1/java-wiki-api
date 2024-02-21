package dev.masterflomaster1.jwa.request.action;

import dev.masterflomaster1.jwa.common.ContentFormat;
import dev.masterflomaster1.jwa.common.ContentModel;

import java.util.Set;

/**
 * Parses content and returns parser output.
 *
 * @see <a href="https://www.mediawiki.org/wiki/API:Parsing_wikitext">API:Parsing wikitext</a>
 */
public class ParseAction extends AbstractAction {

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

    }

    public static class Builder {

    }

    public enum Prop {

    }

    public enum UseSkin {

    }

}
