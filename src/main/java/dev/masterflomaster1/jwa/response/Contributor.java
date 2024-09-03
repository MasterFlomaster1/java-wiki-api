package dev.masterflomaster1.jwa.response;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public final class Contributor {

    @SerializedName("userid")
    private Integer userId;

    @SerializedName("name")
    private String name;

    private Contributor() { }
}
