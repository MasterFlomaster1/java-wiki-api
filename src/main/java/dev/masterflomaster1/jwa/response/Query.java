package dev.masterflomaster1.jwa.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public final class Query {

    @SerializedName("pages")
    private List<Page> pages;

    public List<Page> getPages() {
        return pages;
    }

    private Query() {

    }

    @Override
    public String toString() {
        return "Query{" +
                "pages=" + pages +
                '}';
    }
}
