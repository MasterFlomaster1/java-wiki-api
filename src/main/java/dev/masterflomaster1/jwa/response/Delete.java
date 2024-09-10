package dev.masterflomaster1.jwa.response;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@SuppressWarnings("SpellCheckingInspection")
public final class Delete {

    @SerializedName("title")  private String title;
    @SerializedName("reason") private String reason;
    @SerializedName("logid")  private int logId;

    private Delete() { }
}
