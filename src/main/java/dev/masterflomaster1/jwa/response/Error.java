package dev.masterflomaster1.jwa.response;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
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

    private Error() { }
}
