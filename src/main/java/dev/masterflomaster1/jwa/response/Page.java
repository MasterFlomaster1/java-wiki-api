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

    @SerializedName("isreviewed")
    private Boolean isReviewed;

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

    @SerializedName("touched")
    private String touched;

    @SerializedName("lastrevid")
    private Long lastRevId;

    @SerializedName("length")
    private Integer length;

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
    private List<Contributor> contributors;

    @SerializedName("extlinks")
    private List<Map<String, String>> extLinks;

    @SerializedName("globalusage")
    private List<Map<String, String>> globalUsage;

    @SerializedName("images")
    private List<Map<String, String>> images;

    @SerializedName("redirects")
    private List<Redirect> redirects;

    @SerializedName("videoinfo")
    private List<VideoInfo> videoInfo;

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

    public List<Map<String, String>> getExtLinks() {
        return extLinks;
    }

    public List<Map<String, String>> getGlobalUsage() {
        return globalUsage;
    }

    public String getTouched() {
        return touched;
    }

    public Long getLastRevId() {
        return lastRevId;
    }

    public Integer getLength() {
        return length;
    }

    public List<Map<String, String>> getImages() {
        return images;
    }

    public List<Redirect> getRedirects() {
        return redirects;
    }

    public Boolean isReviewed() {
        return isReviewed;
    }

    public List<VideoInfo> getVideoInfo() {
        return videoInfo;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageId=" + pageId +
                ", ns=" + ns +
                ", missing=" + missing +
                ", title='" + title + '\'' +
                ", isReviewed=" + isReviewed +
                ", anonContributors=" + anonContributors +
                ", contentModel='" + contentModel + '\'' +
                ", pageLanguage='" + pageLanguage + '\'' +
                ", pageLanguageHtmlCode='" + pageLanguageHtmlCode + '\'' +
                ", pageLanguageDir='" + pageLanguageDir + '\'' +
                ", touched='" + touched + '\'' +
                ", lastRevId=" + lastRevId +
                ", length=" + length +
                ", categoryInfo=" + categoryInfo +
                ", categories=" + categories +
                ", revisions=" + revisions +
                ", imageInfo=" + imageInfo +
                ", templates=" + templates +
                ", pageViews=" + pageViews +
                ", contributors=" + contributors +
                ", extLinks=" + extLinks +
                ", globalUsage=" + globalUsage +
                ", images=" + images +
                ", redirects=" + redirects +
                ", videoInfo=" + videoInfo +
                '}';
    }
}
