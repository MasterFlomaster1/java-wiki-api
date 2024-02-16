package dev.masterflomaster1.jwa.response;

import com.google.gson.annotations.SerializedName;

public final class Revision {

    @SerializedName("revid")
    private Long revId;

    @SerializedName("parentid")
    private Long parentId;

    @SerializedName("minor")
    private Boolean minor;

    @SerializedName("user")
    private String user;

    @SerializedName("userid")
    private Integer userId;

    @SerializedName("timestamp")
    private String timestamp;

    @SerializedName("size")
    private Integer size;

    @SerializedName("sha1")
    private String sha1;

    @SerializedName("contentmodel")
    private String contentModel;

    @SerializedName("contentformat")
    private String contentFormat;

    @SerializedName("content")
    private String content;

    @SerializedName("comment")
    private String comment;

    @SerializedName("parsedcomment")
    private String parsedComment;

    private Revision() {

    }

    public Long getRevId() {
        return revId;
    }

    public Long getParentId() {
        return parentId;
    }

    public Boolean isMinor() {
        return minor;
    }

    public String getUser() {
        return user;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public Integer getSize() {
        return size;
    }

    public String getSha1() {
        return sha1;
    }

    public String getContentModel() {
        return contentModel;
    }

    public String getContentFormat() {
        return contentFormat;
    }

    public String getContent() {
        return content;
    }

    public String getComment() {
        return comment;
    }

    public String getParsedComment() {
        return parsedComment;
    }

    @Override
    public String toString() {
        return "Revision{" +
                "revId=" + revId +
                ", parentId=" + parentId +
                ", minor=" + minor +
                ", user='" + user + '\'' +
                ", userId=" + userId +
                ", timestamp='" + timestamp + '\'' +
                ", size=" + size +
                ", sha1='" + sha1 + '\'' +
                ", contentModel='" + contentModel + '\'' +
                ", contentFormat='" + contentFormat + '\'' +
                ", content='" + content + '\'' +
                ", comment='" + comment + '\'' +
                ", parsedComment='" + parsedComment + '\'' +
                '}';
    }
}
