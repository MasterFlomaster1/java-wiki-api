package dev.masterflomaster1.jwa.response;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public final class ShortenUrl {

    @SerializedName("shorturl")
    private String shortUrl;

    @SerializedName("shorturlalt")
    private String shortUrlAlt;

    @SerializedName("qrcode")
    private String qrCode;

    private ShortenUrl() { }
}
