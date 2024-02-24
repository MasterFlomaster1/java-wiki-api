package dev.masterflomaster1.jwa.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

public final class GlobalUserInfo {

    @SerializedName("home")
    private String home;

    @SerializedName("id")
    private Integer id;

    @SerializedName("registration")
    private String registration;

    @SerializedName("name")
    private String name;

    @SerializedName("groups")
    private List<String> groups;

    @SerializedName("rights")
    private List<String> rights;

    @SerializedName("merged")
    private List<Map<String, Object>> merged;

    @SerializedName("editcount")
    private Integer editCount;

    private GlobalUserInfo() {

    }

    public String getHome() {
        return home;
    }

    public Integer getId() {
        return id;
    }

    public String getRegistration() {
        return registration;
    }

    public String getName() {
        return name;
    }

    public List<String> getGroups() {
        return groups;
    }

    public List<String> getRights() {
        return rights;
    }

    public List<Map<String, Object>> getMerged() {
        return merged;
    }

    public Integer getEditCount() {
        return editCount;
    }

    @Override
    public String toString() {
        return "GlobalUserInfo{" +
                "home='" + home + '\'' +
                ", id=" + id +
                ", registration='" + registration + '\'' +
                ", name='" + name + '\'' +
                ", groups=" + groups +
                ", rights=" + rights +
                ", merged=" + merged +
                ", editCount=" + editCount +
                '}';
    }
}
