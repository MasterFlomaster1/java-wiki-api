package dev.masterflomaster1.jwa;

import com.google.gson.annotations.SerializedName;
import dev.masterflomaster1.jwa.response.Error;
import dev.masterflomaster1.jwa.response.*;

import java.util.List;
import java.util.Map;

public final class Response {

    @SerializedName("batchcomplete")
    private Boolean batchComplete;

    @SerializedName("continue")
    private Map<String, String> aContinue;

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

    @SerializedName("torblock")
    private TorBlock torBlock;

    @SerializedName("centralauthtoken")
    private CentralAuthToken centralAuthToken;

    @SerializedName("shortenurl")
    private ShortenUrl shortenUrl;

    @SerializedName("languagesearch")
    private Map<String, String> languageSearch;

    @SerializedName("requestid")
    private String requestId;

    @SerializedName("validatepassword")
    private ValidatePassword validatePassword;

    @SerializedName("block")
    private Block block;

    @SerializedName("checktoken")
    private CheckToken checkToken;

    @SerializedName("antispoof")
    private AntiSpoof antiSpoof;

    @SerializedName("compare")
    private Compare compare;

    @SerializedName("delete")
    private Delete delete;

    @SerializedName("emailuser")
    private EmailUser emailUser;

    @SerializedName("sitematrix")
    private Map<String, Object> siteMatrix;

    @SerializedName("spamblacklist")
    private SpamBlacklist spamBlacklist;

    @SerializedName("titleblacklist")
    private TitleBlacklist titleBlacklist;

    @SerializedName("watch")
    private List<Map<String, Object>> watch;

    @SerializedName("parse")
    private Map<String, Object> parse;

    @SerializedName("usercontribs")
    private List<Map<String, Object>> userContribs;

    private Response() {

    }

    public Boolean isBatchComplete() {
        return batchComplete;
    }

    public Map<String, String> getContinue() {
        return aContinue;
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

    public ShortenUrl getShortenUrl() {
        return shortenUrl;
    }

    public Map<String, String> getLanguageSearch() {
        return languageSearch;
    }

    public String getRequestId() {
        return requestId;
    }

    public ValidatePassword getValidatePassword() {
        return validatePassword;
    }

    public Block getBlock() {
        return block;
    }

    public CheckToken getCheckToken() {
        return checkToken;
    }

    public AntiSpoof getAntiSpoof() {
        return antiSpoof;
    }

    public Compare getCompare() {
        return compare;
    }

    public Delete getDelete() {
        return delete;
    }

    public EmailUser getEmailUser() {
        return emailUser;
    }

    public Map<String, Object> getSiteMatrix() {
        return siteMatrix;
    }

    public SpamBlacklist getSpamBlacklist() {
        return spamBlacklist;
    }

    public TitleBlacklist getTitleBlacklist() {
        return titleBlacklist;
    }

    public List<Map<String, Object>> getWatch() {
        return watch;
    }

    public Map<String, Object> getParse() {
        return parse;
    }

    public List<Map<String, Object>> getUserContribs() {
        return userContribs;
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
                ", shortenUrl=" + shortenUrl +
                ", languageSearch=" + languageSearch +
                ", requestId='" + requestId + '\'' +
                ", validatePassword=" + validatePassword +
                ", block=" + block +
                ", checkToken=" + checkToken +
                ", antiSpoof=" + antiSpoof +
                ", compare=" + compare +
                ", delete=" + delete +
                ", emailUser=" + emailUser +
                ", siteMatrix=" + siteMatrix +
                ", spamBlacklist=" + spamBlacklist +
                ", titleBlacklist=" + titleBlacklist +
                ", watch=" + watch +
                ", parse=" + parse +
                ", userContribs=" + userContribs +
                '}';
    }
}
