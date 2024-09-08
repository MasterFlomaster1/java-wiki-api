package dev.masterflomaster1.jwa.response;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
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

    private VideoInfo() { }
}
