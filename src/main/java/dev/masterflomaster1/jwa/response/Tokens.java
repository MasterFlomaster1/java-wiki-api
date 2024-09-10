package dev.masterflomaster1.jwa.response;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@SuppressWarnings("SpellCheckingInspection")
public final class Tokens {

    @SerializedName("createaccounttoken")          private String createAccountToken;
    @SerializedName("csrftoken")                   private String csrfToken;
    @SerializedName("deleteglobalaccounttoken")    private String deleteGlobalAccountToken;
    @SerializedName("logintoken")                  private String loginToken;
    @SerializedName("patroltoken")                 private String patrolToken;
    @SerializedName("rollbacktoken")               private String rollbackToken;
    @SerializedName("setglobalaccountstatustoken") private String setGlobalAccountStatusToken;
    @SerializedName("userrightstoken")             private String userRightsToken;
    @SerializedName("watchtoken")                  private String watchToken;

    private Tokens() { }
}
