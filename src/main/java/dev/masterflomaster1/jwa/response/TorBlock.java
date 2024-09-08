package dev.masterflomaster1.jwa.response;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public final class TorBlock {

    @SerializedName("result")
    private Boolean result;

    private TorBlock() { }
}
