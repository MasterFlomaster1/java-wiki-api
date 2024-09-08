package dev.masterflomaster1.jwa.response;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.Map;

@Getter
@ToString
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

    private GlobalUserInfo() { }
}
