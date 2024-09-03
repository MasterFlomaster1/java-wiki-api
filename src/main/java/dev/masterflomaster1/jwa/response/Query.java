package dev.masterflomaster1.jwa.response;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.Map;

@Getter
@ToString
public final class Query {

    @SerializedName("pages")
    private List<Page> pages;

    @SerializedName("general")
    private General general;

    @SerializedName("recentchanges")
    private List<RecentChange> recentChanges;

    @SerializedName("users")
    private List<User> users;

    @SerializedName("allcategories")
    private List<CategoryInfo> allCategories;

    @SerializedName("tokens")
    private Tokens tokens;

    @SerializedName("userinfo")
    private UserInfo userInfo;

    @SerializedName("globaluserinfo")
    private GlobalUserInfo globalUserInfo;

    @SerializedName("languageinfo")
    private Map<String, LanguageInfo> languageInfo;

    @SerializedName("siteviews")
    private Map<String, Integer> siteViews;

    @SerializedName("allfileusages")
    private List<Map<String, String>> allFileUsages;

    @SerializedName("allimages")
    private List<Map<String, String>> allImages;

    private Query() { }
}
