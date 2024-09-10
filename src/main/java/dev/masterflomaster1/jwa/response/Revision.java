package dev.masterflomaster1.jwa.response;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@SuppressWarnings("SpellCheckingInspection")
public final class Revision {

    @SerializedName("revid")         private Long revId;
    @SerializedName("parentid")      private Long parentId;
    @SerializedName("minor")         private Boolean minor;
    @SerializedName("user")          private String user;
    @SerializedName("userid")        private Integer userId;
    @SerializedName("timestamp")     private String timestamp;
    @SerializedName("size")          private Integer size;
    @SerializedName("sha1")          private String sha1;
    @SerializedName("contentmodel")  private String contentModel;
    @SerializedName("contentformat") private String contentFormat;
    @SerializedName("content")       private String content;
    @SerializedName("comment")       private String comment;
    @SerializedName("parsedcomment") private String parsedComment;

    private Revision() { }
}
