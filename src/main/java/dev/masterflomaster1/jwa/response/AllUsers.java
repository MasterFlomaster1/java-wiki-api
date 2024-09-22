package dev.masterflomaster1.jwa.response;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import dev.masterflomaster1.jwa.internal.json.TimestampDeserializer;
import lombok.Getter;
import lombok.ToString;

import java.time.Instant;
import java.util.List;
import java.util.Map;

@Getter
@ToString
@SuppressWarnings("SpellCheckingInspection")
public final class AllUsers {

    @SerializedName("registration")
    @JsonAdapter(TimestampDeserializer.class)
    private Instant registration;

    @SerializedName("userid")         private Integer userId;
    @SerializedName("name")           private String name;
    @SerializedName("centralids")     private Map<String, Integer> centralIds;
    @SerializedName("attachedlocal")  private Map<String, Boolean> attachedLocal;
    @SerializedName("editcount")      private Integer editCount;
    @SerializedName("groups")         private List<String> groups;
    @SerializedName("implicitgroups") private List<String> implicitGroups;
    @SerializedName("rights")         private List<String> rights;

    private AllUsers() { }

}
