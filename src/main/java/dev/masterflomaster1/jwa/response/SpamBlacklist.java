package dev.masterflomaster1.jwa.response;

import com.google.gson.annotations.SerializedName;

public final class SpamBlacklist {

    @SerializedName("result")
    private String result;

    private SpamBlacklist() {

    }

    public String getResult() {
        return result;
    }

    @Override
    public String toString() {
        return "SpamBlacklist{" +
                "result='" + result + '\'' +
                '}';
    }
}
