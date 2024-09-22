package dev.masterflomaster1.jwa.response;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import dev.masterflomaster1.jwa.common.Namespace;
import dev.masterflomaster1.jwa.internal.json.NamespaceDeserializer;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@SuppressWarnings("SpellCheckingInspection")
public final class ExtUrlUsage {

    @SerializedName("pageid") private Integer pageId;
    @SerializedName("title")  private String title;
    @SerializedName("url")    private String url;

    @SerializedName("ns")
    @JsonAdapter(NamespaceDeserializer.class)
    private Namespace ns;

    private ExtUrlUsage() { }

}
