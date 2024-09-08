package dev.masterflomaster1.jwa.response;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.Map;

@Getter
@ToString
public final class LanguageInfo {

    @SerializedName("code")
    private String code;

    @SerializedName("bcp")
    private String bcp47;

    @SerializedName("dir")
    private String dir;

    @SerializedName("autonym")
    private String autonym;

    @SerializedName("name")
    private String name;

    @SerializedName("fallbacks")
    private List<String> fallbacks;

    @SerializedName("variants")
    private List<String> variants;

    @SerializedName("variantnames")
    private Map<String, String> variantNames;

    private LanguageInfo() { }
}
