package dev.masterflomaster1.jwa.request.action;

/**
 * Validate a page title, filename, or username against the TitleBlacklist.
 */
public final class TitleBlacklistAction extends AbstractAction {

    private String tbTitle;
    private TbAction tbAction;
    private boolean tbNoOverride;

    private TitleBlacklistAction() {
        apiUrl.setAction("titleblacklist");
    }

    public String getTbTitle() {
        return tbTitle;
    }

    public TbAction getTbAction() {
        return tbAction;
    }

    public boolean isTbNoOverride() {
        return tbNoOverride;
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

        public String getValue() {
            return value;
        }

    }

}
