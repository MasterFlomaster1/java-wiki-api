package dev.masterflomaster1.jwa.response;

import com.google.gson.annotations.SerializedName;

public final class Delete {

    @SerializedName("title")
    private String title;

    @SerializedName("reason")
    private String reason;

    @SerializedName("logid")
    private int logId;

    private Delete() {
    }

    public String getTitle() {
        return title;
    }

    public String getReason() {
        return reason;
    }

    public int getLogId() {
        return logId;
    }

    @Override
    public String toString() {
        return "Delete{" +
                "title='" + title + '\'' +
                ", reason='" + reason + '\'' +
                ", logId=" + logId +
                '}';
    }
}
