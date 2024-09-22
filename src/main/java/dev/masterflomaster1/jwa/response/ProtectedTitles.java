package dev.masterflomaster1.jwa.response;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import dev.masterflomaster1.jwa.common.Namespace;
import dev.masterflomaster1.jwa.json.NamespaceDeserializer;
import dev.masterflomaster1.jwa.json.TimestampDeserializer;
import lombok.Getter;
import lombok.ToString;

import java.time.Instant;

@Getter
@ToString
@SuppressWarnings("SpellCheckingInspection")
public final class ProtectedTitles {

    @SerializedName("ns")
    @JsonAdapter(NamespaceDeserializer.class)
    private Namespace ns;

    @SerializedName("timestamp")
    @JsonAdapter(TimestampDeserializer.class)
    private Instant timestamp;

    @SerializedName("expiry")
    @JsonAdapter(TimestampDeserializer.class)
    private Instant expiry;

    @SerializedName("title")         private String title;
    @SerializedName("user")          private String user;
    @SerializedName("userid")        private Integer userId;
    @SerializedName("comment")       private String comment;
    @SerializedName("parsedcomment") private String parsedComment;
    @SerializedName("level")         private String level;

    private ProtectedTitles() { }

}
