package dev.masterflomaster1.jwa.request.meta;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.EnumSet;
import java.util.stream.Collectors;

/**
 * Show information about a global user.
 */
@Getter
@ToString
@EqualsAndHashCode(callSuper = false)
@SuppressWarnings("SpellCheckingInspection")
public final class GlobalUserInfoMeta extends AbstractMeta {

    private String guiUser;
    private int guiId;
    private EnumSet<GuiProp> guiProp;

    private GlobalUserInfoMeta() {
        name = "globaluserinfo";
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
        public Builder guiProp(EnumSet<GuiProp> guiProp) {
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

    @Getter
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

    }

}
