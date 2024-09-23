package dev.masterflomaster1.jwa.response;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import dev.masterflomaster1.jwa.common.Namespace;
import dev.masterflomaster1.jwa.internal.json.NamespaceDeserializer;
import dev.masterflomaster1.jwa.internal.json.TimestampDeserializer;
import lombok.Getter;
import lombok.ToString;

import java.time.Instant;

@Getter
@ToString
@SuppressWarnings("SpellCheckingInspection")
public final class Compare {

    @SerializedName("fromid")            private Integer fromId;
    @SerializedName("fromrevid")         private Long fromRevId;

    @SerializedName("fromns")
    @JsonAdapter(NamespaceDeserializer.class)
    private Namespace fromNs;

    @SerializedName("fromtitle")         private String fromTitle;
    @SerializedName("fromsize")          private Integer fromSize;

    @SerializedName("fromtimestamp")
    @JsonAdapter(TimestampDeserializer.class)
    private Instant fromTimestamp;

    @SerializedName("fromuser")          private String fromUser;
    @SerializedName("fromuserid")        private Integer fromUserId;
    @SerializedName("fromcomment")       private String fromComment;
    @SerializedName("fromparsedcomment") private String fromParsedComment;

    @SerializedName("toid")              private Integer toId;
    @SerializedName("torevid")           private Long toRevId;

    @SerializedName("tons")
    @JsonAdapter(NamespaceDeserializer.class)
    private Namespace toNs;

    @SerializedName("totitle")           private String toTitle;
    @SerializedName("tosize")            private Integer toSize;

    @SerializedName("totimestamp")
    @JsonAdapter(TimestampDeserializer.class)
    private Instant toTimestamp;

    @SerializedName("touser")            private String toUser;
    @SerializedName("touserid")          private Integer toUserId;
    @SerializedName("tocomment")         private String toComment;
    @SerializedName("toparsedcomment")   private String toParsedComment;
    @SerializedName("prev")              private Long prev;
    @SerializedName("next")              private Long next;
    @SerializedName("diffsize")          private Integer diffSize;
    @SerializedName("body")              private String body;


    private Compare() { }
}
