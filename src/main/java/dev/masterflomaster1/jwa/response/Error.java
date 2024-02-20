package dev.masterflomaster1.jwa.response;

import com.google.gson.annotations.SerializedName;

public final class Error {

    @SerializedName("code")
    private String code;

    @SerializedName("info")
    private String info;

    @SerializedName("docref")
    private String docRef;

    @SerializedName("parameter")
    private String parameter;

    @SerializedName("limit")
    private int limit;

    @SerializedName("lowlimit")
    private int lowLimit;

    @SerializedName("highlimit")
    private int highLimit;

    private Error() {

    }

    public String getCode() {
        return code;
    }

    public String getInfo() {
        return info;
    }

    public String getDocRef() {
        return docRef;
    }

    public String getParameter() {
        return parameter;
    }

    public int getLimit() {
        return limit;
    }

    public int getLowLimit() {
        return lowLimit;
    }

    public int getHighLimit() {
        return highLimit;
    }

    @Override
    public String toString() {
        return "Error{" +
                "code='" + code + '\'' +
                ", info='" + info + '\'' +
                ", docRef='" + docRef + '\'' +
                ", parameter='" + parameter + '\'' +
                ", limit=" + limit +
                ", lowLimit=" + lowLimit +
                ", highLimit=" + highLimit +
                '}';
    }
}
