package dev.masterflomaster1.jwa.response;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.Map;

@Getter
@ToString
@SuppressWarnings("SpellCheckingInspection")
public final class Query {

    @SerializedName("pages")           private List<Page> pages;
    @SerializedName("general")         private General general;
    @SerializedName("recentchanges")   private List<RecentChange> recentChanges;
    @SerializedName("users")           private List<User> users;
    @SerializedName("allcategories")   private List<CategoryInfo> allCategories;
    @SerializedName("tokens")          private Tokens tokens;
    @SerializedName("userinfo")        private UserInfo userInfo;
    @SerializedName("globaluserinfo")  private GlobalUserInfo globalUserInfo;
    @SerializedName("languageinfo")    private Map<String, LanguageInfo> languageInfo;
    @SerializedName("siteviews")       private Map<String, Integer> siteViews;
    @SerializedName("allfileusages")   private List<Map<String, String>> allFileUsages;
    @SerializedName("allimages")       private List<Map<String, String>> allImages;
    @SerializedName("categorymembers") private List<CategoryMember> categoryMembers;
    @SerializedName("random")          private List<BasePage> random;
    @SerializedName("tags")            private List<Tag> tags;
    @SerializedName("prefixsearch")    private List<DefaultPage> prefixSearch;
    @SerializedName("betafeatures")    private Map<String, BetaFeature> betafeatures;
    @SerializedName("projects")        private List<String> projects;
    @SerializedName("blocks")          private List<Blocks> blocks;
    @SerializedName("backlinks")       private List<DefaultPage> backlinks;
    @SerializedName("exturlusage")     private List<ExtUrlUsage> exturlusage;
    @SerializedName("alllinks")        private List<AllLinks> allLinks;
    @SerializedName("allpages")        private List<DefaultPage> allPages;
    @SerializedName("allusers")        private List<AllUsers> allUsers;
    @SerializedName("filearchive")     private List<FileArchive> fileArchive;
    @SerializedName("imageusage")      private List<DefaultPage> imageUsage;
    @SerializedName("protectedtitles") private List<ProtectedTitles> protectedtitles;

    private Query() { }
}
