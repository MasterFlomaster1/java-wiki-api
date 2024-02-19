package dev.masterflomaster1.jwa.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public final class RecentChange {

    @SerializedName("type")
    private String type;

    @SerializedName("ns")
    private Integer ns;

    @SerializedName("title")
    private String title;

    @SerializedName("pageid")
    private Integer pageId;

    @SerializedName("revid")
    private Long revId;

    @SerializedName("old_revid")
    private Long oldRevId;

    @SerializedName("rcid")
    private Long rcId;

    @SerializedName("userid")
    private Integer userId;

    @SerializedName("bot")
    private Boolean bot;

    @SerializedName("new")
    private Boolean aNew;

    @SerializedName("minor")
    private Boolean minor;

    @SerializedName("oldlen")
    private Integer oldLen;

    @SerializedName("newlen")
    private Integer newLen;

    @SerializedName("timestamp")
    private String timestamp;

    @SerializedName("comment")
    private String comment;

    @SerializedName("parsedcomment")
    private String parsedComment;

    @SerializedName("redirect")
    private Boolean redirect;

    @SerializedName("tags")
    private List<String> tags;

    @SerializedName("sha1")
    private String sha1;

    private RecentChange() {

    }

    public String getType() {
        return type;
    }

    public Integer getNs() {
        return ns;
    }

    public String getTitle() {
        return title;
    }

    public Integer getPageId() {
        return pageId;
    }

    public Long getRevId() {
        return revId;
    }

    public Long getOldRevId() {
        return oldRevId;
    }

    public Long getRcId() {
        return rcId;
    }

    public Integer getUserId() {
        return userId;
    }

    public Boolean getBot() {
        return bot;
    }

    public Boolean getaNew() {
        return aNew;
    }

    public Boolean getMinor() {
        return minor;
    }

    public Integer getOldLen() {
        return oldLen;
    }

    public Integer getNewLen() {
        return newLen;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getComment() {
        return comment;
    }

    public String getParsedComment() {
        return parsedComment;
    }

    public Boolean getRedirect() {
        return redirect;
    }

    public List<String> getTags() {
        return tags;
    }

    public String getSha1() {
        return sha1;
    }

    @Override
    public String toString() {
        return "RecentChange{" +
                "type='" + type + '\'' +
                ", ns=" + ns +
                ", title='" + title + '\'' +
                ", pageId=" + pageId +
                ", revId=" + revId +
                ", oldRevId=" + oldRevId +
                ", rcId=" + rcId +
                ", userId=" + userId +
                ", bot=" + bot +
                ", aNew=" + aNew +
                ", minor=" + minor +
                ", oldLen=" + oldLen +
                ", newLen=" + newLen +
                ", timestamp='" + timestamp + '\'' +
                ", comment='" + comment + '\'' +
                ", parsedComment='" + parsedComment + '\'' +
                ", redirect=" + redirect +
                ", tags=" + tags +
                ", sha1='" + sha1 + '\'' +
                '}';
    }
}
