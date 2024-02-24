package dev.masterflomaster1.jwa.response;

import com.google.gson.annotations.SerializedName;

public final class Tokens {

    @SerializedName("createaccounttoken")
    private String createAccountToken;

    @SerializedName("csrftoken")
    private String csrfToken;

    @SerializedName("deleteglobalaccounttoken")
    private String deleteGlobalAccountToken;

    @SerializedName("logintoken")
    private String loginToken;

    @SerializedName("patroltoken")
    private String patrolToken;

    @SerializedName("rollbacktoken")
    private String rollbackToken;

    @SerializedName("setglobalaccountstatustoken")
    private String setGlobalAccountStatusToken;

    @SerializedName("userrightstoken")
    private String userRightsToken;

    @SerializedName("watchtoken")
    private String watchToken;

    private Tokens() {

    }

    public String getCreateAccountToken() {
        return createAccountToken;
    }

    public String getCsrfToken() {
        return csrfToken;
    }

    public String getDeleteGlobalAccountToken() {
        return deleteGlobalAccountToken;
    }

    public String getLoginToken() {
        return loginToken;
    }

    public String getPatrolToken() {
        return patrolToken;
    }

    public String getRollbackToken() {
        return rollbackToken;
    }

    public String getSetGlobalAccountStatusToken() {
        return setGlobalAccountStatusToken;
    }

    public String getUserRightsToken() {
        return userRightsToken;
    }

    public String getWatchToken() {
        return watchToken;
    }

    @Override
    public String toString() {
        return "Tokens{" +
                "createAccountToken='" + createAccountToken + '\'' +
                ", csrfToken='" + csrfToken + '\'' +
                ", deleteGlobalAccountToken='" + deleteGlobalAccountToken + '\'' +
                ", loginToken='" + loginToken + '\'' +
                ", patrolToken='" + patrolToken + '\'' +
                ", rollbackToken='" + rollbackToken + '\'' +
                ", setGlobalAccountStatusToken='" + setGlobalAccountStatusToken + '\'' +
                ", userRightsToken='" + userRightsToken + '\'' +
                ", watchToken='" + watchToken + '\'' +
                '}';
    }
}
