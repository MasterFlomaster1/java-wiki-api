package dev.masterflomaster1.jwa.response;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public final class FileUsage {

    @SerializedName("pageid")
    private Integer pageId;

    @SerializedName("ns")
    private Integer ns;

    @SerializedName("title")
    private String title;

    @SerializedName("redirect")
    private Boolean redirect;

    private FileUsage() { }
}
