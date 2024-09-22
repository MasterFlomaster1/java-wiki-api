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
public final class FileArchive {

    @SerializedName("ns")
    @JsonAdapter(NamespaceDeserializer.class)
    private Namespace ns;

    @SerializedName("timestamp")
    @JsonAdapter(TimestampDeserializer.class)
    private Instant timestamp;

    @SerializedName("userid")            private Integer userId;
    @SerializedName("name")              private String name;
    @SerializedName("title")             private String title;
    @SerializedName("parseddescription") private String parsedDescription;
    @SerializedName("description")       private String description;

    private FileArchive() { }

}
