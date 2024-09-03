package dev.masterflomaster1.jwa.response;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public final class User {

    @SerializedName("userid")
    private Integer userId;

    @SerializedName("name")
    private String name;

    @SerializedName("editcount")
    private Integer editCount;

    @SerializedName("groups")
    private List<String> groups;

    @SerializedName("gender")
    private String gender;

    private User() { }
}
