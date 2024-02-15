package dev.masterflomaster1.jwa.response;

import com.google.gson.annotations.SerializedName;

public final class Continue {

    @SerializedName("continue")
    private String aContinue;

    @SerializedName("rvcontinue")
    private String rvContinue;

    @SerializedName("iistart")
    private String iiStart;

    private Continue() {

    }

    public String getContinue() {
        return aContinue;
    }

    public String getRvContinue() {
        return rvContinue;
    }

    public String getIiStart() {
        return iiStart;
    }

    @Override
    public String toString() {
        return "Continue{" +
                "aContinue='" + aContinue + '\'' +
                ", rvContinue='" + rvContinue + '\'' +
                ", iiStart='" + iiStart + '\'' +
                '}';
    }
}
