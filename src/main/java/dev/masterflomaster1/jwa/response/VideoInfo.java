package dev.masterflomaster1.jwa.response;

import com.google.gson.annotations.SerializedName;

public final class VideoInfo {

    @SerializedName("timestamp")
    private String timestamp;

    @SerializedName("user")
    private String user;

    @SerializedName("userid")
    private Integer userId;

    @SerializedName("size")
    private Integer size;

    @SerializedName("width")
    private Integer width;

    @SerializedName("height")
    private Integer height;

    @SerializedName("duration")
    private Integer duration;

    @SerializedName("comment")
    private String comment;

    @SerializedName("sha1")
    private String sha1;

    @SerializedName("url")
    private String url;

    @SerializedName("descriptionurl")
    private String descriptionUrl;

    @SerializedName("descriptionshorturl")
    private String descriptionShortUrl;

    @SerializedName("bitdepth")
    private Integer bitDepth;

    @SerializedName("canonicaltitle")
    private String canonicalTitle;

    private VideoInfo() {

    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getUser() {
        return user;
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getSize() {
        return size;
    }

    public Integer getWidth() {
        return width;
    }

    public Integer getHeight() {
        return height;
    }

    public Integer getDuration() {
        return duration;
    }

    public String getComment() {
        return comment;
    }

    public String getSha1() {
        return sha1;
    }

    public String getUrl() {
        return url;
    }

    public String getDescriptionUrl() {
        return descriptionUrl;
    }

    public String getDescriptionShortUrl() {
        return descriptionShortUrl;
    }

    public Integer getBitDepth() {
        return bitDepth;
    }

    public String getCanonicalTitle() {
        return canonicalTitle;
    }

    @Override
    public String toString() {
        return "VideoInfo{" +
                "timestamp='" + timestamp + '\'' +
                ", user='" + user + '\'' +
                ", userId=" + userId +
                ", size=" + size +
                ", width=" + width +
                ", height=" + height +
                ", duration=" + duration +
                ", comment='" + comment + '\'' +
                ", sha1='" + sha1 + '\'' +
                ", url='" + url + '\'' +
                ", descriptionUrl='" + descriptionUrl + '\'' +
                ", descriptionShortUrl='" + descriptionShortUrl + '\'' +
                ", bitDepth=" + bitDepth +
                ", canonicalTitle='" + canonicalTitle + '\'' +
                '}';
    }
}
