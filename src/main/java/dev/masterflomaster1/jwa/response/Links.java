package dev.masterflomaster1.jwa.response;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import dev.masterflomaster1.jwa.common.Namespace;
import dev.masterflomaster1.jwa.internal.json.NamespaceDeserializer;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public final class Links {

    @SerializedName("ns")
    @JsonAdapter(NamespaceDeserializer.class)
    private Namespace ns;

    @SerializedName("title") private String title;

    private Links() { }

}
