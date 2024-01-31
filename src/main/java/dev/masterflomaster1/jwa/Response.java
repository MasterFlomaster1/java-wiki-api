package dev.masterflomaster1.jwa;

import com.google.gson.annotations.SerializedName;

public class Response {

    @SerializedName("batchcomplete")
    private boolean batchComplete;

    @SerializedName("servedby")
    private String servedBy;

    @SerializedName("curtimestamp")
    private String curTimestamp;

    @SerializedName("uselang")
    private String userLang;

    @SerializedName("errorlang")
    private String errorLang;

    @Override
    public String toString() {
        return "Response{" +
                "batchComplete=" + batchComplete +
                ", servedBy='" + servedBy + '\'' +
                ", curTimestamp='" + curTimestamp + '\'' +
                ", userLang='" + userLang + '\'' +
                ", errorLang='" + errorLang + '\'' +
                '}';
    }
}
