package dev.masterflomaster1.jwa.response;

import com.google.gson.annotations.SerializedName;

public final class TorBlock {

    @SerializedName("result")
    private Boolean result;

    private TorBlock() {

    }

    public Boolean getResult() {
        return result;
    }

    @Override
    public String toString() {
        return "TorBlock{" +
                "result=" + result +
                '}';
    }
}
