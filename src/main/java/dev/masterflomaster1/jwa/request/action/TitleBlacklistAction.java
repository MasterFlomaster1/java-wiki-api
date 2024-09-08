package dev.masterflomaster1.jwa.request.action;

import lombok.Getter;
import lombok.ToString;

/**
 * Validate a page title, filename, or username against the TitleBlacklist.
 */
@Getter
@ToString
public final class TitleBlacklistAction extends AbstractAction {

    private String tbTitle;
    private TbAction tbAction;
    private boolean tbNoOverride;

    private TitleBlacklistAction() {
        apiUrl.setAction("titleblacklist");
    }

    public static class Builder {

        private final TitleBlacklistAction titleBlacklistAction = new TitleBlacklistAction();

        /**
         * The string to validate against the blacklist.
         * @return {@code Builder}
         */
        public Builder tbTitle(String tbTitle) {
            titleBlacklistAction.tbTitle = tbTitle;
            titleBlacklistAction.apiUrl.putQuery("tbtitle", tbTitle);
            return this;
        }

        /**
         * The action to be checked.
         * @return {@code Builder}
         */
        public Builder tbAction(TbAction tbAction) {
            titleBlacklistAction.tbAction = tbAction;
            titleBlacklistAction.apiUrl.putQuery("tbaction", tbAction.getValue());
            return this;
        }

        /**
         * Don't try to override the titleblacklist.
         * @return {@code Builder}
         */
        public Builder tbNoOverride() {
            titleBlacklistAction.tbNoOverride = true;
            titleBlacklistAction.apiUrl.putQuery("tbnooverride", "1");
            return this;
        }

        public TitleBlacklistAction build() {
            return titleBlacklistAction;
        }

    }

    @Getter
    public enum TbAction {

        CREATE ("create"),
        CREATE_PAGE ("createpage"),
        CREATE_TALK ("createtalk"),
        EDIT ("edit"),
        MOVE ("move"),
        NEW_ACCOUNT ("newaccount"),
        UPLOAD ("upload");
        private final String value;

        TbAction(String value) {
            this.value = value;
        }

    }

}
