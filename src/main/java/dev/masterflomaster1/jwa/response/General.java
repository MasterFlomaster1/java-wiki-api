package dev.masterflomaster1.jwa.response;

import com.google.gson.annotations.SerializedName;

public final class General {

    @SerializedName("mainpage")
    private String mainPage;

    @SerializedName("base")
    private String base;

    @SerializedName("sitename")
    private String siteName;

    @SerializedName("phpversion")
    private String phpVersion;

    @SerializedName("dbversion")
    private String dbVersion;

    private General() {

    }

    @Override
    public String toString() {
        return "General{" +
                "mainPage='" + mainPage + '\'' +
                ", base='" + base + '\'' +
                ", siteName='" + siteName + '\'' +
                ", phpVersion='" + phpVersion + '\'' +
                ", dbVersion='" + dbVersion + '\'' +
                '}';
    }
}
