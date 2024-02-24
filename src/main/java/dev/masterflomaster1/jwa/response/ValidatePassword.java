package dev.masterflomaster1.jwa.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public final class ValidatePassword {

    @SerializedName("validity")
    private String validity;

    @SerializedName("validitymessages")
    private List<ValidityMessage> validityMessages;

    private ValidatePassword() {

    }

    public String getValidity() {
        return validity;
    }

    public List<ValidityMessage> getValidityMessages() {
        return validityMessages;
    }

    @Override
    public String toString() {
        return "ValidatePassword{" +
                "validity='" + validity + '\'' +
                ", validityMessages=" + validityMessages +
                '}';
    }
}
