package dev.masterflomaster1.jwa.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

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

    public List<Page> getPages() {
        return pages;
    }

    public List<RecentChange> getRecentChanges() {
        return recentChanges;
    }

    public List<User> getUsers() {
        return users;
    }

    public General getGeneral() {
        return general;
    }

    public List<CategoryInfo> getAllCategories() {
        return allCategories;
    }

    public Tokens getTokens() {
        return tokens;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public GlobalUserInfo getGlobalUserInfo() {
        return globalUserInfo;
    }

    public Map<String, LanguageInfo> getLanguageInfo() {
        return languageInfo;
    }

    public Map<String, Integer> getSiteViews() {
        return siteViews;
    }

    public List<Map<String, String>> getAllFileUsages() {
        return allFileUsages;
    }

    public List<Map<String, String>> getAllImages() {
        return allImages;
    }

    private Query() {

    }

    @Override
    public String toString() {
        return "Query{" +
                "pages=" + pages +
                ", general=" + general +
                ", recentChanges=" + recentChanges +
                ", users=" + users +
                ", allCategories=" + allCategories +
                ", tokens=" + tokens +
                ", userInfo=" + userInfo +
                ", globalUserInfo=" + globalUserInfo +
                ", languageInfo=" + languageInfo +
                ", siteViews=" + siteViews +
                ", allFileUsages=" + allFileUsages +
                ", allImages=" + allImages +
                '}';
    }
}
