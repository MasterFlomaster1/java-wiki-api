package dev.masterflomaster1.jwa.response;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public final class AntiSpoof {

    @SerializedName("username")   private String username;
    @SerializedName("normalized") private String normalized;
    @SerializedName("result")     private String result;
    @SerializedName("users")      private List<String> users;

    private AntiSpoof() { }
}
