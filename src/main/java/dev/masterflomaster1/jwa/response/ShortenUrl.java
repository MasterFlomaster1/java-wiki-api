package dev.masterflomaster1.jwa.response;

import com.google.gson.annotations.SerializedName;

public final class ShortenUrl {

    @SerializedName("shorturl")
    private String shortUrl;

    @SerializedName("shorturlalt")
    private String shortUrlAlt;

    @SerializedName("qrcode")
    private String qrCode;

    private ShortenUrl() {

    }

    public String getShortUrl() {
        return shortUrl;
    }

    public String getShortUrlAlt() {
        return shortUrlAlt;
    }

    public String getQrCode() {
        return qrCode;
    }

    @Override
    public String toString() {
        return "ShortenUrl{" +
                "shortUrl='" + shortUrl + '\'' +
                ", shortUrlAlt='" + shortUrlAlt + '\'' +
                ", qrCode='" + qrCode + '\'' +
                '}';
    }
}
