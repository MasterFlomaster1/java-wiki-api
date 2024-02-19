package dev.masterflomaster1.jwa.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public final class Query {

    @SerializedName("pages")
    private List<Page> pages;

    @SerializedName("recentchanges")
    private List<RecentChange> recentChanges;

    public List<Page> getPages() {
        return pages;
    }

    public List<RecentChange> getRecentChanges() {
        return recentChanges;
    }

    private Query() {

    }

    @Override
    public String toString() {
        return "Query{" +
                "pages=" + pages +
                ", recentChanges=" + recentChanges +
                '}';
    }
}
