package dev.masterflomaster1.jwa.response;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public final class ValidatePassword {

    @SerializedName("validity")
    private String validity;

    @SerializedName("validitymessages")
    private List<ValidityMessage> validityMessages;

    private ValidatePassword() { }
}
