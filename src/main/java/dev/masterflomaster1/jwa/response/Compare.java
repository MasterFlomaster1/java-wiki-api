package dev.masterflomaster1.jwa.response;

import com.google.gson.annotations.SerializedName;

public final class Compare {

    @SerializedName("fromid")
    private Integer fromId;

    @SerializedName("fromrevid")
    private Long fromRevId;

    private Compare() {

    }

    @Override
    public String toString() {
        return "Compare{" +
                "fromId=" + fromId +
                ", fromRevId=" + fromRevId +
                '}';
    }
}
