package dev.masterflomaster1.jwa.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

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

    private UserInfo() {

    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Boolean getMessages() {
        return messages;
    }

    public List<String> getGroups() {
        return groups;
    }

    public List<String> getGroupMemberships() {
        return groupMemberships;
    }

    public List<String> getImplicitGroups() {
        return implicitGroups;
    }

    public List<String> getRights() {
        return rights;
    }

    public Map<String, List<String>> getChangeableGroups() {
        return changeableGroups;
    }

    public String getEmail() {
        return email;
    }

    public String getEmailAuthenticated() {
        return emailAuthenticated;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public Integer getUnreadCount() {
        return unreadCount;
    }

    public Map<String, Integer> getCentralIds() {
        return centralIds;
    }

    public Map<String, Boolean> getAttachedLocal() {
        return attachedLocal;
    }

    public Boolean getCanCreateAccount() {
        return canCreateAccount;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", messages=" + messages +
                ", groups=" + groups +
                ", groupMemberships=" + groupMemberships +
                ", implicitGroups=" + implicitGroups +
                ", rights=" + rights +
                ", changeableGroups=" + changeableGroups +
                ", email='" + email + '\'' +
                ", emailAuthenticated='" + emailAuthenticated + '\'' +
                ", registrationDate='" + registrationDate + '\'' +
                ", unreadCount=" + unreadCount +
                ", centralIds=" + centralIds +
                ", attachedLocal=" + attachedLocal +
                ", canCreateAccount=" + canCreateAccount +
                '}';
    }
}
