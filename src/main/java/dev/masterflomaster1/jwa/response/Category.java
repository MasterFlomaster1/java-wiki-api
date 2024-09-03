package dev.masterflomaster1.jwa.response;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public final class Category {

    @SerializedName("ns")
    private Integer ns;

    @SerializedName("title")
    private String title;

    private Category() { }
}
