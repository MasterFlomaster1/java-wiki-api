package dev.masterflomaster1.jwa.response;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import dev.masterflomaster1.jwa.common.Namespace;
import dev.masterflomaster1.jwa.internal.json.NamespaceListDeserializer;
import dev.masterflomaster1.jwa.internal.json.TimestampDeserializer;
import lombok.Getter;
import lombok.ToString;

import java.time.Instant;
import java.util.List;

@Getter
@ToString
@SuppressWarnings("SpellCheckingInspection")
public final class Blocks {

    @SerializedName("id")                private Integer id;
    @SerializedName("user")              private String user;
    @SerializedName("userid")            private Integer userId;
    @SerializedName("by")                private String by;
    @SerializedName("byid")              private Integer byId;
    @SerializedName("reason")            private String reason;
    @SerializedName("automatic")         private Boolean automatic;
    @SerializedName("anononly")          private Boolean anononly;
    @SerializedName("nocreate")          private Boolean nocreate;
    @SerializedName("autoblock")         private Boolean autoblock;
    @SerializedName("noemail")           private Boolean noemail;
    @SerializedName("hidden")            private Boolean hidden;
    @SerializedName("allowusertalk")     private Boolean allowusertalk;
    @SerializedName("partial")           private Boolean partial;
    @SerializedName("restrictions")      private Restrictions restrictions;

    @SerializedName("timestamp")
    @JsonAdapter(TimestampDeserializer.class)
    private Instant timestamp;

    @SerializedName("expiry")
    @JsonAdapter(TimestampDeserializer.class)
    private Instant expiry;

    private Blocks() { }

    @Getter
    @ToString
    static final class Restrictions {

        @SerializedName("pages") private List<BasePage> pages;

        @JsonAdapter(NamespaceListDeserializer.class)
        @SerializedName("namespaces")
        private List<Namespace> namespaces;

        private Restrictions() { }

    }

}
