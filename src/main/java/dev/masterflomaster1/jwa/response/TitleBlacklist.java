package dev.masterflomaster1.jwa.response;

import com.google.gson.annotations.SerializedName;

public final class TitleBlacklist {

    @SerializedName("result")
    private String result;

    private TitleBlacklist() {

    }

    public String getResult() {
        return result;
    }

    @Override
    public String toString() {
        return "TitleBlacklist{" +
                "result='" + result + '\'' +
                '}';
    }
}
