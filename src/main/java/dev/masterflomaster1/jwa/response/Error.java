package dev.masterflomaster1.jwa.response;

import com.google.gson.annotations.SerializedName;

public class Error {

    @SerializedName("name")
    private String code;

    @SerializedName("info")
    private String info;

    @SerializedName("docref")
    private String docRef;

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

    @Override
    public String toString() {
        return "Error{" +
                "code='" + code + '\'' +
                ", info='" + info + '\'' +
                ", docRef='" + docRef + '\'' +
                '}';
    }
}
