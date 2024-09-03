package dev.masterflomaster1.jwa.response;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public final class CategoryInfo {

    @SerializedName("size")
    private Integer size;

    @SerializedName("pages")
    private Integer pages;

    @SerializedName("files")
    private Integer files;

    @SerializedName("subcats")
    private Integer subCats;

    @SerializedName("hidden")
    private Boolean hidden;

    @SerializedName("category")
    private String category;

    private CategoryInfo() { }
}
