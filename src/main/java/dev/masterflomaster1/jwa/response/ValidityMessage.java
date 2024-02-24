package dev.masterflomaster1.jwa.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ValidityMessage {

    @SerializedName("message")
    private String message;

    @SerializedName("params")
    private List<Integer> params;

    @SerializedName("code")
    private String code;

    @SerializedName("type")
    private String type;

    private ValidityMessage() {

    }

    public String getMessage() {
        return message;
    }

    public List<Integer> getParams() {
        return params;
    }

    public String getCode() {
        return code;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "ValidityMessage{" +
                "message='" + message + '\'' +
                ", params=" + params +
                ", code='" + code + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
