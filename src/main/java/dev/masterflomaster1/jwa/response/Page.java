package dev.masterflomaster1.jwa.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public final class Page {

    @SerializedName("pageid")
    private int pageId;

    @SerializedName("ns")
    private int ns;

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

    private Page() {

    }

    public int getPageId() {
        return pageId;
    }

    public int getNs() {
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

    @Override
    public String toString() {
        return "Page{" +
                "pageId=" + pageId +
                ", ns=" + ns +
                ", title='" + title + '\'' +
                ", categoryInfo=" + categoryInfo +
                ", categories=" + categories +
                '}';
    }
}
