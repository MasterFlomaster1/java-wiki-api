package dev.masterflomaster1.jwa.response;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import dev.masterflomaster1.jwa.common.Namespace;
import dev.masterflomaster1.jwa.internal.json.NamespaceDeserializer;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.Map;

@Getter
@ToString
@SuppressWarnings("SpellCheckingInspection")
public final class Page {

    @SerializedName("pageid")               private Integer pageId;

    @SerializedName("ns")
    @JsonAdapter(NamespaceDeserializer.class)
    private Namespace ns;

    @SerializedName("missing")              private Boolean missing;
    @SerializedName("title")                private String title;
    @SerializedName("isreviewed")           private Boolean isReviewed;
    @SerializedName("anoncontributors")     private Integer anonContributors;
    @SerializedName("contentmodel")         private String contentModel;
    @SerializedName("pagelanguage")         private String pageLanguage;
    @SerializedName("pagelanguagehtmlcode") private String pageLanguageHtmlCode;
    @SerializedName("pagelanguagedir")      private String pageLanguageDir;
    @SerializedName("touched")              private String touched;
    @SerializedName("lastrevid")            private Long lastRevId;
    @SerializedName("length")               private Integer length;
    @SerializedName("categoryinfo")         private CategoryInfo categoryInfo;
    @SerializedName("categories")           private List<Category> categories;
    @SerializedName("revisions")            private List<Revision> revisions;
    @SerializedName("imageinfo")            private List<ImageInfo> imageInfo;
    @SerializedName("templates")            private List<Template> templates;
    @SerializedName("pageviews")            private Map<String, Integer> pageViews;
    @SerializedName("contributors")         private List<Contributor> contributors;
    @SerializedName("extlinks")             private List<Map<String, String>> extLinks;
    @SerializedName("globalusage")          private List<Map<String, String>> globalUsage;
    @SerializedName("images")               private List<Map<String, String>> images;
    @SerializedName("redirects")            private List<Redirect> redirects;
    @SerializedName("videoinfo")            private List<VideoInfo> videoInfo;
    @SerializedName("fileusage")            private List<FileUsage> fileUsage;
    @SerializedName("links")                private List<Links> links;
    @SerializedName("linkshere")            private List<LinksHere> linksHere;

    private Page() { }
}
