package dev.masterflomaster1.jwa.response;

import com.google.gson.annotations.SerializedName;

public final class FileUsage {

    @SerializedName("pageid")
    private Integer pageId;

    @SerializedName("ns")
    private Integer ns;

    @SerializedName("title")
    private String title;

    @SerializedName("redirect")
    private Boolean redirect;

    private FileUsage() {

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

    public Boolean getRedirect() {
        return redirect;
    }

    @Override
    public String toString() {
        return "FileUsage{" +
                "pageId=" + pageId +
                ", ns=" + ns +
                ", title='" + title + '\'' +
                ", redirect=" + redirect +
                '}';
    }
}
