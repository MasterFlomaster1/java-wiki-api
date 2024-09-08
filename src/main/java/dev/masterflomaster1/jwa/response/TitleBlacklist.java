package dev.masterflomaster1.jwa.response;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public final class TitleBlacklist {

    @SerializedName("result")
    private String result;

    private TitleBlacklist() { }
}
