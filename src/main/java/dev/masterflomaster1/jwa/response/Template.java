package dev.masterflomaster1.jwa.response;

import com.google.gson.annotations.SerializedName;

public final class Template {

    @SerializedName("ns")
    private Integer ns;

    @SerializedName("title")
    private String title;

    private Template() {

    }

    public Integer getNs() {
        return ns;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Template{" +
                "ns=" + ns +
                ", title='" + title + '\'' +
                '}';
    }
}
