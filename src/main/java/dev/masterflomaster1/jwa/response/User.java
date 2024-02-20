package dev.masterflomaster1.jwa.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public final class User {

    @SerializedName("userid")
    private Integer userId;

    @SerializedName("name")
    private String name;

    @SerializedName("editcount")
    private Integer editCount;

    private List<String> groups;

    @SerializedName("gender")
    private String gender;

    private User() {

    }

    public Integer getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public Integer getEditCount() {
        return editCount;
    }

    public List<String> getGroups() {
        return groups;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", editCount=" + editCount +
                ", groups=" + groups +
                ", gender='" + gender + '\'' +
                '}';
    }
}
