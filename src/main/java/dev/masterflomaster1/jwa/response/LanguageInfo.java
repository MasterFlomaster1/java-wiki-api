package dev.masterflomaster1.jwa.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

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

    private LanguageInfo() {

    }

    public String getCode() {
        return code;
    }

    public String getBcp47() {
        return bcp47;
    }

    public String getDir() {
        return dir;
    }

    public String getAutonym() {
        return autonym;
    }

    public String getName() {
        return name;
    }

    public List<String> getFallbacks() {
        return fallbacks;
    }

    public List<String> getVariants() {
        return variants;
    }

    public Map<String, String> getVariantNames() {
        return variantNames;
    }

    @Override
    public String toString() {
        return "LanguageInfo{" +
                "code='" + code + '\'' +
                ", bcp47='" + bcp47 + '\'' +
                ", dir='" + dir + '\'' +
                ", autonym='" + autonym + '\'' +
                ", name='" + name + '\'' +
                ", fallbacks=" + fallbacks +
                ", variants=" + variants +
                ", variantNames=" + variantNames +
                '}';
    }
}
