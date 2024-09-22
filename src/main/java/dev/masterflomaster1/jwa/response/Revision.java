package dev.masterflomaster1.jwa.response;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import dev.masterflomaster1.jwa.internal.json.TimestampDeserializer;
import lombok.Getter;
import lombok.ToString;

import java.time.Instant;

@Getter
@ToString
@SuppressWarnings("SpellCheckingInspection")
public final class Revision {

    @SerializedName("timestamp")
    @JsonAdapter(TimestampDeserializer.class)
    private Instant timestamp;

    @SerializedName("revid")         private Long revId;
    @SerializedName("parentid")      private Long parentId;
    @SerializedName("minor")         private Boolean minor;
    @SerializedName("user")          private String user;
    @SerializedName("userid")        private Integer userId;
    @SerializedName("size")          private Integer size;
    @SerializedName("sha1")          private String sha1;
    @SerializedName("contentmodel")  private String contentModel;
    @SerializedName("contentformat") private String contentFormat;
    @SerializedName("content")       private String content;
    @SerializedName("comment")       private String comment;
    @SerializedName("parsedcomment") private String parsedComment;

    private Revision() { }
}
