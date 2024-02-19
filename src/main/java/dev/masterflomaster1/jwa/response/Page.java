package dev.masterflomaster1.jwa.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

public final class Page {

    @SerializedName("pageid")
    private Integer pageId;

    @SerializedName("ns")
    private Integer ns;

    @SerializedName("missing")
    private Boolean missing;

    @SerializedName("title")
    private String title;

    @SerializedName("anoncontributors")
    private Integer anonContributors;

    @SerializedName("contentmodel")
    private String contentModel;

    @SerializedName("pagelanguage")
    private String pageLanguage;

    @SerializedName("pagelanguagehtmlcode")
    private String pageLanguageHtmlCode;

    @SerializedName("pagelanguagedir")
    private String pageLanguageDir;

    @SerializedName("categoryinfo")
    private CategoryInfo categoryInfo;

    @SerializedName("categories")
    private List<Category> categories;

    @SerializedName("revisions")
    private List<Revision> revisions;

    @SerializedName("imageinfo")
    private List<ImageInfo> imageInfo;

    @SerializedName("templates")
    private List<Template> templates;

    @SerializedName("pageviews")
    private Map<String, Integer> pageViews;

    @SerializedName("contributors")
    public List<Contributor> contributors;

    private Page() {

    }

    public Integer getPageId() {
        return pageId;
    }

    public Integer getNs() {
        return ns;
    }

    public Boolean isMissing() {
        return missing;
    }

    public String getTitle() {
        return title;
    }

    public CategoryInfo getCategoryInfo() {
        return categoryInfo;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public List<Revision> getRevisions() {
        return revisions;
    }

    public List<ImageInfo> getImageInfo() {
        return imageInfo;
    }

    public Map<String, Integer> getPageViews() {
        return pageViews;
    }

    public List<Template> getTemplates() {
        return templates;
    }

    public Integer getAnonContributors() {
        return anonContributors;
    }

    public List<Contributor> getContributors() {
        return contributors;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageId=" + pageId +
                ", ns=" + ns +
                ", missing=" + missing +
                ", title='" + title + '\'' +
                ", anonContributors=" + anonContributors +
                ", contentModel='" + contentModel + '\'' +
                ", pageLanguage='" + pageLanguage + '\'' +
                ", pageLanguageHtmlCode='" + pageLanguageHtmlCode + '\'' +
                ", pageLanguageDir='" + pageLanguageDir + '\'' +
                ", categoryInfo=" + categoryInfo +
                ", categories=" + categories +
                ", revisions=" + revisions +
                ", imageInfo=" + imageInfo +
                ", templates=" + templates +
                ", pageViews=" + pageViews +
                ", contributors=" + contributors +
                '}';
    }
}
