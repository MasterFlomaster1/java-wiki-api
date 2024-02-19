package dev.masterflomaster1.jwa.response;

import com.google.gson.annotations.SerializedName;

public final class Contributor {

    @SerializedName("userid")
    private Integer userId;

    @SerializedName("name")
    private String name;

    private Contributor() {

    }

    public Integer getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Contributor{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                '}';
    }
}
