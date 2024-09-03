package dev.masterflomaster1.jwa.response;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
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

    private RecentChange() { }
}
