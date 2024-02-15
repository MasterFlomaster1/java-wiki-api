package dev.masterflomaster1.jwa.response;

import com.google.gson.annotations.SerializedName;

public final class Category {

    @SerializedName("ns")
    private Integer ns;

    @SerializedName("title")
    private String title;

    private Category() {

    }

    public Integer getNs() {
        return ns;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Category{" +
                "ns=" + ns +
                ", title='" + title + '\'' +
                '}';
    }
}
