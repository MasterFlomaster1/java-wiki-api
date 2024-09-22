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
public final class CategoryMember {

    @SerializedName("ns")
    @JsonAdapter(NamespaceDeserializer.class)
    private Namespace ns;

    @SerializedName("timestamp")
    @JsonAdapter(TimestampDeserializer.class)
    private Instant timestamp;

    @SerializedName("pageid")        private Integer pageId;
    @SerializedName("title")         private String title;
    @SerializedName("sortkey")       private String sortKey;
    @SerializedName("sortkeyprefix") private String sortKeyPrefix;
    @SerializedName("type")          private String type;

    private CategoryMember() { }

}
