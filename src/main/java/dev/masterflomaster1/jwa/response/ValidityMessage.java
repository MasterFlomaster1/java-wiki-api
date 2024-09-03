package dev.masterflomaster1.jwa.response;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public final class ValidityMessage {

    @SerializedName("message")
    private String message;

    @SerializedName("params")
    private List<Integer> params;

    @SerializedName("code")
    private String code;

    @SerializedName("type")
    private String type;

    private ValidityMessage() { }
}
