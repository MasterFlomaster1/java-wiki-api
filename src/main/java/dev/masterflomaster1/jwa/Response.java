package dev.masterflomaster1.jwa;

import com.google.gson.annotations.SerializedName;
import dev.masterflomaster1.jwa.response.Error;
import dev.masterflomaster1.jwa.response.Query;

public final class Response {

    @SerializedName("batchcomplete")
    private boolean batchComplete;

    @SerializedName("error")
    private Error error;

    @SerializedName("servedby")
    private String servedBy;

    @SerializedName("curtimestamp")
    private String curTimestamp;

    @SerializedName("uselang")
    private String userLang;

    @SerializedName("errorlang")
    private String errorLang;

    @SerializedName("query")
    private Query query;

    private Response() {

    }

    public boolean isBatchComplete() {
        return batchComplete;
    }

    public Error getError() {
        return error;
    }

    public String getServedBy() {
        return servedBy;
    }

    public String getCurTimestamp() {
        return curTimestamp;
    }

    public String getUserLang() {
        return userLang;
    }

    public String getErrorLang() {
        return errorLang;
    }

    public Query getQuery() {
        return query;
    }

    @Override
    public String toString() {
        return "Response{" +
                "batchComplete=" + batchComplete +
                ", error=" + error +
                ", servedBy='" + servedBy + '\'' +
                ", curTimestamp='" + curTimestamp + '\'' +
                ", userLang='" + userLang + '\'' +
                ", errorLang='" + errorLang + '\'' +
                ", query=" + query +
                '}';
    }
}
