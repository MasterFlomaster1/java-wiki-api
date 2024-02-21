package dev.masterflomaster1.jwa.response;

import com.google.gson.annotations.SerializedName;

public final class CategoryInfo {

    @SerializedName("size")
    private Integer size;

    @SerializedName("pages")
    private Integer pages;

    @SerializedName("files")
    private Integer files;

    @SerializedName("subcats")
    private Integer subCats;

    @SerializedName("hidden")
    private Boolean hidden;

    @SerializedName("category")
    private String category;

    private CategoryInfo() {

    }

    public Integer getSize() {
        return size;
    }

    public Integer getPages() {
        return pages;
    }

    public Integer getFiles() {
        return files;
    }

    public Integer getSubCats() {
        return subCats;
    }

    public Boolean isHidden() {
        return hidden;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "CategoryInfo{" +
                "size=" + size +
                ", pages=" + pages +
                ", files=" + files +
                ", subCats=" + subCats +
                ", hidden=" + hidden +
                ", category='" + category + '\'' +
                '}';
    }
}
