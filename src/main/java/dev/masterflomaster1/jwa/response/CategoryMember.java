package dev.masterflomaster1.jwa.response;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@SuppressWarnings("SpellCheckingInspection")
public final class CategoryMember {

    @SerializedName("pageid") private Integer pageId;
    @SerializedName("ns") private Integer ns;
    @SerializedName("title") private String title;
    @SerializedName("sortkey") private String sortKey;
    @SerializedName("sortkeyprefix") private String sortKeyPrefix;
    @SerializedName("type") private String type;
    @SerializedName("timestamp") private String timestamp;

    private CategoryMember() { }

}
