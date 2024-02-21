package dev.masterflomaster1.jwa.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

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
                '}';
    }
}
