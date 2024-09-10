package dev.masterflomaster1.jwa.response;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@SuppressWarnings("SpellCheckingInspection")
public final class Block {

    @SerializedName("user")     private String user;
    @SerializedName("userid")   private Integer userId;
    @SerializedName("expiry")   private String expiry;
    @SerializedName("id")       private String id;
    @SerializedName("reason")   private String reason;
    @SerializedName("nocreate") private String noCreate;
    @SerializedName("noemail")  private String noEmail;

    private Block() { }
}
