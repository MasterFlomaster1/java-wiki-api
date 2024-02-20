package dev.masterflomaster1.jwa.response;

import com.google.gson.annotations.SerializedName;

public final class Redirect {

    @SerializedName("pageid")
    private Integer pageId;

    @SerializedName("ns")
    private Integer ns;

    @SerializedName("title")
    private String title;

    private Redirect() {
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

    @Override
    public String toString() {
        return "Redirect{" +
                "pageId=" + pageId +
                ", ns=" + ns +
                ", title='" + title + '\'' +
                '}';
    }
}
