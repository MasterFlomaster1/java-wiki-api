package dev.masterflomaster1.jwa.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public final class AntiSpoof {

    @SerializedName("username")
    private String username;

    @SerializedName("normalized")
    private String normalized;

    @SerializedName("result")
    private String result;

    @SerializedName("users")
    private List<String> users;

    private AntiSpoof() {

    }

    public String getUsername() {
        return username;
    }

    public String getNormalized() {
        return normalized;
    }

    public String getResult() {
        return result;
    }

    public List<String> getUsers() {
        return users;
    }

    @Override
    public String toString() {
        return "AntiSpoof{" +
                "username='" + username + '\'' +
                ", normalized='" + normalized + '\'' +
                ", result='" + result + '\'' +
                ", users=" + users +
                '}';
    }
}
