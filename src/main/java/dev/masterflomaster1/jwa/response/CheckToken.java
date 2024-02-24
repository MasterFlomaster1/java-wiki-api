package dev.masterflomaster1.jwa.response;

import com.google.gson.annotations.SerializedName;

public final class CheckToken {

    @SerializedName("result")
    private String result;

    private CheckToken() {

    }

    public String getResult() {
        return result;
    }

    @Override
    public String toString() {
        return "CheckToken{" +
                "result='" + result + '\'' +
                '}';
    }
}
