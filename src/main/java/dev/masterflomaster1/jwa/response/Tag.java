package dev.masterflomaster1.jwa.response;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
@SuppressWarnings("SpellCheckingInspection")
public final class Tag {

    @SerializedName("name")        private String name;
    @SerializedName("displayname") private String displayName;
    @SerializedName("description") private String description;
    @SerializedName("hitcount")    private Integer hitCount;
    @SerializedName("defined")     private Boolean defined;
    @SerializedName("source")      private List<String> source;
    @SerializedName("active")      private Boolean active;

    private Tag() { }

}
