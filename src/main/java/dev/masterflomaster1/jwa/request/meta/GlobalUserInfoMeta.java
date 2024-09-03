package dev.masterflomaster1.jwa.request.meta;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Show information about a global user.
 */
public final class GlobalUserInfoMeta extends AbstractMeta {

    private String guiUser;
    private int guiId;
    private Set<GuiProp> guiProp;

    private GlobalUserInfoMeta() {
        name = "globaluserinfo";
    }

    public String getGuiUser() {
        return guiUser;
    }

    public int getGuiId() {
        return guiId;
    }

    public Set<GuiProp> getGuiProp() {
        return guiProp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GlobalUserInfoMeta that = (GlobalUserInfoMeta) o;

        if (guiId != that.guiId) return false;
        if (!Objects.equals(guiUser, that.guiUser)) return false;
        return Objects.equals(guiProp, that.guiProp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(guiUser, guiId, guiProp);
    }

    public static class Builder {

        private final GlobalUserInfoMeta globalUserInfoMeta = new GlobalUserInfoMeta();

        /**
         * User to get information about. If {@code guiuser} and {@code guiid} both are omitted, it defaults to the
         * current user.
         * @return {@code Builder}
         */
        public Builder guiUser(String guiUser) {
            globalUserInfoMeta.guiUser = guiUser;
            globalUserInfoMeta.apiUrl.putQuery("guiuser", guiUser);
            return this;
        }

        /**
         * Global user ID to get information about. If {@code guiuser} and {@code guiid} both are omitted, it defaults to the
         * current user.
         * @return {@code Builder}
         */
        public Builder guiId(int guiId) {
            globalUserInfoMeta.guiId = guiId;
            globalUserInfoMeta.apiUrl.putQuery("guiid", guiId);
            return this;
        }

        /**
         * Which properties to get.
         * @return {@code Builder}
         */
        public Builder guiProp(Set<GuiProp> guiProp) {
            globalUserInfoMeta.guiProp = guiProp;
            globalUserInfoMeta.apiUrl.putQuery("guiprop", guiProp.stream()
                    .map(GuiProp::getValue)
                    .collect(Collectors.joining("|")));
            return this;
        }

        public GlobalUserInfoMeta build() {
            return globalUserInfoMeta;
        }

    }

    public enum GuiProp {

        /**
         * Get a list of global groups this user belongs to.
         */
        GROUPS ("groups"),

        /**
         * Get a list of global rights this user has.
         */
        RIGHTS ("rights"),

        /**
         * Get a list of merged accounts.
         */
        MERGED ("merged"),

        /**
         * Get a list of unattached accounts.
         */
        UNATTACHED ("unattached"),

        /**
         * Get the user's global edit count.
         */
        EDIT_COUNT ("editcount");

        final String value;

        GuiProp(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

    }

}
