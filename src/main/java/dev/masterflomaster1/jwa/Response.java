package dev.masterflomaster1.jwa;

import com.google.gson.annotations.SerializedName;
import dev.masterflomaster1.jwa.response.AntiSpoof;
import dev.masterflomaster1.jwa.response.Block;
import dev.masterflomaster1.jwa.response.CentralAuthToken;
import dev.masterflomaster1.jwa.response.CheckToken;
import dev.masterflomaster1.jwa.response.Compare;
import dev.masterflomaster1.jwa.response.Delete;
import dev.masterflomaster1.jwa.response.EmailUser;
import dev.masterflomaster1.jwa.response.Error;
import dev.masterflomaster1.jwa.response.Query;
import dev.masterflomaster1.jwa.response.ShortenUrl;
import dev.masterflomaster1.jwa.response.SpamBlacklist;
import dev.masterflomaster1.jwa.response.TitleBlacklist;
import dev.masterflomaster1.jwa.response.TorBlock;
import dev.masterflomaster1.jwa.response.ValidatePassword;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.Map;

@Getter
@ToString
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

    private Response() { }
}
