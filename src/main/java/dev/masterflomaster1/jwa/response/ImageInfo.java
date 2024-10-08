package dev.masterflomaster1.jwa.response;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import dev.masterflomaster1.jwa.internal.json.TimestampDeserializer;
import lombok.Getter;
import lombok.ToString;

import java.time.Instant;
import java.util.Map;

@Getter
@ToString
@SuppressWarnings("SpellCheckingInspection")
public final class ImageInfo {

    @SerializedName("timestamp")
    @JsonAdapter(TimestampDeserializer.class)
    private Instant timestamp;

    @SerializedName("user")                private String user;
    @SerializedName("userid")              private Integer userid;
    @SerializedName("size")                private Integer size;
    @SerializedName("width")               private Integer width;
    @SerializedName("height")              private Integer height;
    @SerializedName("parsedcomment")       private String parsedComment;
    @SerializedName("comment")             private String comment;
    @SerializedName("html")                private String html;
    @SerializedName("canonicaltitle")      private String canonicalTitle;
    @SerializedName("url")                 private String url;
    @SerializedName("descriptionurl")      private String descriptionUrl;
    @SerializedName("descriptionshorturl") private String descriptionShortUrl;
    @SerializedName("sha1")                private String sha1;
    @SerializedName("extmetadata")         private Map<String, Map<String, String>> extMetadata;

    private ImageInfo() { }
}
