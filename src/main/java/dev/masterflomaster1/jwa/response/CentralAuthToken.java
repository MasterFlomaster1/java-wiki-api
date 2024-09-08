package dev.masterflomaster1.jwa.response;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public final class CentralAuthToken {

    @SerializedName("centralauthtoken")
    private String centralAuthToken;

    private CentralAuthToken() { }
}
