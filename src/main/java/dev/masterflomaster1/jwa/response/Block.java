package dev.masterflomaster1.jwa.response;

import com.google.gson.annotations.SerializedName;

public final class Block {

    @SerializedName("user")
    private String user;

    @SerializedName("userid")
    private Integer userId;

    @SerializedName("expiry")
    private String expiry;

    @SerializedName("id")
    private String id;

    @SerializedName("reason")
    private String reason;

    @SerializedName("nocreate")
    private String noCreate;

    @SerializedName("noemail")
    private String noEmail;

    private Block() {

    }

    public String getUser() {
        return user;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getExpiry() {
        return expiry;
    }

    public String getId() {
        return id;
    }

    public String getReason() {
        return reason;
    }

    public String getNoCreate() {
        return noCreate;
    }

    public String getNoEmail() {
        return noEmail;
    }

    @Override
    public String toString() {
        return "Block{" +
                "user='" + user + '\'' +
                ", userId=" + userId +
                ", expiry='" + expiry + '\'' +
                ", id='" + id + '\'' +
                ", reason='" + reason + '\'' +
                ", noCreate='" + noCreate + '\'' +
                ", noEmail='" + noEmail + '\'' +
                '}';
    }
}
