package dev.masterflomaster1.jwa.response;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public final class ImageInfo {

    @SerializedName("timestamp")
    private String timestamp;

    @SerializedName("user")
    private String user;

    @SerializedName("userid")
    private Integer userid;

    @SerializedName("size")
    private Integer size;

    @SerializedName("width")
    private Integer width;

    @SerializedName("height")
    private Integer height;

    @SerializedName("parsedcomment")
    private String parsedComment;

    @SerializedName("comment")
    private String comment;

    @SerializedName("html")
    private String html;

    @SerializedName("canonicaltitle")
    private String canonicalTitle;

    @SerializedName("url")
    private String url;

    @SerializedName("descriptionurl")
    private String descriptionUrl;

    @SerializedName("descriptionshorturl")
    private String descriptionShortUrl;

    @SerializedName("sha1")
    private String sha1;

    @SerializedName("extmetadata")
    private Map<String, Map<String, String>> extMetadata;

    private ImageInfo() {

    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getUser() {
        return user;
    }

    public Integer getUserid() {
        return userid;
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

    public String getParsedComment() {
        return parsedComment;
    }

    public String getComment() {
        return comment;
    }

    public String getHtml() {
        return html;
    }

    public String getCanonicalTitle() {
        return canonicalTitle;
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

    public String getSha1() {
        return sha1;
    }

    public Map<String, Map<String, String>> getExtMetadata() {
        return extMetadata;
    }

    @Override
    public String toString() {
        return "ImageInfo{" +
                "timestamp='" + timestamp + '\'' +
                ", user='" + user + '\'' +
                ", userid=" + userid +
                ", size=" + size +
                ", width=" + width +
                ", height=" + height +
                ", parsedComment='" + parsedComment + '\'' +
                ", comment='" + comment + '\'' +
                ", html='" + html + '\'' +
                ", canonicalTitle='" + canonicalTitle + '\'' +
                ", url='" + url + '\'' +
                ", descriptionUrl='" + descriptionUrl + '\'' +
                ", descriptionShortUrl='" + descriptionShortUrl + '\'' +
                ", sha1='" + sha1 + '\'' +
                ", extMetadata=" + extMetadata +
                '}';
    }
}
