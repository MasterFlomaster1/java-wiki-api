package dev.masterflomaster1.jwa.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public final class Page {

    @SerializedName("pageid")
    private Integer pageId;

    @SerializedName("ns")
    private Integer ns;

    @SerializedName("title")
    private String title;

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

    private Page() {

    }

    public Integer getPageId() {
        return pageId;
    }

    public Integer getNs() {
        return ns;
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

    @Override
    public String toString() {
        return "Page{" +
                "pageId=" + pageId +
                ", ns=" + ns +
                ", title='" + title + '\'' +
                ", contentModel='" + contentModel + '\'' +
                ", pageLanguage='" + pageLanguage + '\'' +
                ", pageLanguageHtmlCode='" + pageLanguageHtmlCode + '\'' +
                ", pageLanguageDir='" + pageLanguageDir + '\'' +
                ", categoryInfo=" + categoryInfo +
                ", categories=" + categories +
                ", revisions=" + revisions +
                ", imageInfo=" + imageInfo +
                '}';
    }
}