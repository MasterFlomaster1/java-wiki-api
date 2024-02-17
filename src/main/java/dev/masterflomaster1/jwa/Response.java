package dev.masterflomaster1.jwa;

import com.google.gson.annotations.SerializedName;
import dev.masterflomaster1.jwa.response.*;
import dev.masterflomaster1.jwa.response.Error;

public final class Response {

    @SerializedName("batchcomplete")
    private Boolean batchComplete;

    @SerializedName("continue")
    private Continue aContinue;

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

    @SerializedName("torBlock")
    private TorBlock torBlock;

    @SerializedName("centralauthtoken")
    private CentralAuthToken centralAuthToken;

    private Response() {

    }

    public Boolean isBatchComplete() {
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

    public TorBlock getTorBlock() {
        return torBlock;
    }

    public CentralAuthToken getCentralAuthToken() {
        return centralAuthToken;
    }

    @Override
    public String toString() {
        return "Response{" +
                "batchComplete=" + batchComplete +
                ", aContinue=" + aContinue +
                ", error=" + error +
                ", servedBy='" + servedBy + '\'' +
                ", curTimestamp='" + curTimestamp + '\'' +
                ", userLang='" + userLang + '\'' +
                ", errorLang='" + errorLang + '\'' +
                ", query=" + query +
                ", torBlock=" + torBlock +
                ", centralAuthToken=" + centralAuthToken +
                '}';
    }
}
