package dev.masterflomaster1.jwa.response;

import com.google.gson.annotations.SerializedName;

public final class CentralAuthToken {

    @SerializedName("centralauthtoken")
    private String centralAuthToken;

    private CentralAuthToken() {

    }

    public String getCentralAuthToken() {
        return centralAuthToken;
    }

    @Override
    public String toString() {
        return "CentralAuthToken{" +
                "centralAuthToken='" + centralAuthToken + '\'' +
                '}';
    }
}
