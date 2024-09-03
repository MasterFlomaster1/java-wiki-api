package dev.masterflomaster1.jwa.response;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.Map;

@Getter
@ToString
public final class UserInfo {

    @SerializedName("id")
    private Integer id;

    @SerializedName("name")
    private String name;

    @SerializedName("messages")
    private Boolean messages;

    @SerializedName("groups")
    private List<String> groups;

    @SerializedName("groupmemberships")
    private List<String> groupMemberships;

    @SerializedName("implicitgroups")
    private List<String> implicitGroups;

    @SerializedName("rights")
    private List<String> rights;

    @SerializedName("changeablegroups")
    private Map<String, List<String>> changeableGroups;

    @SerializedName("email")
    private String email;

    @SerializedName("emailauthenticated")
    private String emailAuthenticated;

    @SerializedName("registrationdate")
    private String registrationDate;

    @SerializedName("unreadcount")
    private Integer unreadCount;

    @SerializedName("centralids")
    private Map<String, Integer> centralIds;

    @SerializedName("attachedlocal")
    private Map<String, Boolean> attachedLocal;

    @SerializedName("cancreateaccount")
    private Boolean canCreateAccount;

    private UserInfo() { }
}
