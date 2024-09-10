package dev.masterflomaster1.jwa.response;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@SuppressWarnings("SpellCheckingInspection")
public final class Compare {

    @SerializedName("fromid")    private Integer fromId;
    @SerializedName("fromrevid") private Long fromRevId;

    private Compare() { }
}
