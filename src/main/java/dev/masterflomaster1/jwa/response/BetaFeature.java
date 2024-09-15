package dev.masterflomaster1.jwa.response;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public final class BetaFeature {

    @SerializedName("name")  private String name;
    @SerializedName("count") private int count;

    private BetaFeature() { }

}
