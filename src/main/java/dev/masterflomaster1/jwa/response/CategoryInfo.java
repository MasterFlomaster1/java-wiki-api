package dev.masterflomaster1.jwa.response;

import com.google.gson.annotations.SerializedName;

public final class CategoryInfo {

    @SerializedName("size")
    private int size;

    @SerializedName("pages")
    private int pages;

    @SerializedName("files")
    private int files;

    @SerializedName("subcats")
    private int subCats;

    @SerializedName("hidden")
    private boolean hidden;

    private CategoryInfo() {

    }

    public int getSize() {
        return size;
    }

    public int getPages() {
        return pages;
    }

    public int getFiles() {
        return files;
    }

    public int getSubCats() {
        return subCats;
    }

    public boolean isHidden() {
        return hidden;
    }

    @Override
    public String toString() {
        return "CategoryInfo{" +
                "size=" + size +
                ", pages=" + pages +
                ", files=" + files +
                ", subCats=" + subCats +
                ", hidden=" + hidden +
                '}';
    }
}
