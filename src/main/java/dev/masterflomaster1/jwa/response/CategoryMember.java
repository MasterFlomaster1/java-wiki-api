package dev.masterflomaster1.jwa.response;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import dev.masterflomaster1.jwa.common.Namespace;
import dev.masterflomaster1.jwa.json.NamespaceDeserializer;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@SuppressWarnings("SpellCheckingInspection")
public final class CategoryMember {

    @SerializedName("pageid")        private Integer pageId;

    @SerializedName("ns")
    @JsonAdapter(NamespaceDeserializer.class)
    private Namespace ns;

    @SerializedName("title")         private String title;
    @SerializedName("sortkey")       private String sortKey;
    @SerializedName("sortkeyprefix") private String sortKeyPrefix;
    @SerializedName("type")          private String type;
    @SerializedName("timestamp")     private String timestamp;

    private CategoryMember() { }

}
