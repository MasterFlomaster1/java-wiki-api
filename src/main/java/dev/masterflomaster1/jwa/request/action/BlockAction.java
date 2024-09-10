package dev.masterflomaster1.jwa.request.action;

import dev.masterflomaster1.jwa.common.Namespace;
import dev.masterflomaster1.jwa.common.Tags;
import lombok.Getter;
import lombok.ToString;
import okhttp3.FormBody;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Block a user.
 *
 * @see <a href="https://www.mediawiki.org/wiki/API:Block">API:Block</a>
 */
@Getter
@ToString
@SuppressWarnings("SpellCheckingInspection")
public final class BlockAction extends AbstractAction implements IPost {

    private String user;
    private String expiry;
    private String reason;
    private boolean anonOnly;
    private boolean noCreate;
    private boolean autoBlock;
    private boolean noEmail;
    private boolean hideName;
    private boolean allowUserTalk;
    private boolean reBlock;
    private boolean watchUser;
    private String watchlistExpiry;
    private Set<Tags> tags;
    private boolean partial;
    private Set<String> pageRestrictions;
    private Set<Namespace> namespaceRestrictions;
    private String token;

    private BlockAction() {
        apiUrl.setAction("block");
    }

    @Override
    public FormBody getPostBody() {
        return new FormBody.Builder()
                .add("action", "block")
                .add("token", token)
                .build();
    }

    public static class Builder {

        private final BlockAction blockAction = new BlockAction();

        /**
         * User to block.
         * @param user user, by any of username, IP, Temporary user, IP range and user ID (e.g. "#12345")
         * @return {@code Builder}
         */
        public Builder user(String user) {
            blockAction.user = user;
            blockAction.apiUrl.putQuery("user", user);
            return this;
        }

        /**
         * Expiry time.
         * @param expiry May be relative (e.g. {@code 5 months} or {@code 2 weeks}) or absolute
         *              (e.g. {@code 2014-09-18T12:34:56Z}). If set to {@code infinite}, {@code indefinite},
         *              or {@code never}, the block will never expire. Default: never
         * @return {@code Builder}
         */
        public Builder expiry(String expiry) {
            blockAction.expiry = expiry;
            blockAction.apiUrl.putQuery("expiry", expiry);
            return this;
        }

        /**
         * Reason for block.
         * @param reason Default: {@code ""}
         * @return {@code Builder}
         */
        public Builder reason(String reason) {
            blockAction.reason = reason;
            blockAction.apiUrl.putQuery("reason", reason);
            return this;
        }

        /**
         * Block anonymous users only (i.e. disable anonymous edits for this IP address, including temporary account
         * edits).
         * @return {@code Builder}
         */
        public Builder anonOnly() {
            blockAction.anonOnly = true;
            blockAction.apiUrl.putQuery("anononly", "1");
            return this;
        }

        /**
         * Prevent account creation.
         * @return {@code Builder}
         */
        public Builder noCreate() {
            blockAction.noCreate = true;
            blockAction.apiUrl.putQuery("nocreate", "1");
            return this;
        }

        /**
         * Automatically block the last used IP address, and any subsequent IP addresses they try to login from.
         * @return {@code Builder}
         */
        public Builder autoBlock() {
            blockAction.autoBlock = true;
            blockAction.apiUrl.putQuery("autoblock", "1");
            return this;
        }

        /**
         * Prevent user from sending email through the wiki. (Requires the {@code blockemail} right).
         * @return {@code Builder}
         */
        public Builder noEmail() {
            blockAction.noEmail = true;
            blockAction.apiUrl.putQuery("noemail", 1);
            return this;
        }

        /**
         * Hide the username from the block log. (Requires the {@code hideuser} right).
         * @return {@code Builder}
         */
        public Builder hideName() {
            blockAction.hideName = true;
            blockAction.apiUrl.putQuery("hidename", "1");
            return this;
        }

        /**
         * Allow the user to edit their own talk page (depends on {@code $wgBlockAllowsUTEdit}).
         * @return {@code Builder}
         */
        public Builder allowUserTalk() {
            blockAction.allowUserTalk = true;
            blockAction.apiUrl.putQuery("allowusertalk", "1");
            return this;
        }

        /**
         * If the user is already blocked, overwrite the existing block.
         * @return {@code Builder}
         */
        public Builder reBlock() {
            blockAction.reBlock = true;
            blockAction.apiUrl.putQuery("reblock", "1");
            return this;
        }

        /**
         * Watch the user's or IP address's user and talk pages.
         * @return {@code Builder}
         */
        public Builder watchUser() {
            blockAction.watchUser = true;
            blockAction.apiUrl.putQuery("watchuser", "1");
            return this;
        }

        /**
         * Watchlist expiry timestamp. Omit this parameter entirely to leave the current expiry unchanged.
         * @return {@code Builder}
         */
        public Builder watchlistExpiry(String watchlistExpiry) {
            blockAction.watchlistExpiry = watchlistExpiry;
            blockAction.apiUrl.putQuery("watchlistexpiry", watchlistExpiry);
            return this;
        }

        /**
         * Change tags to apply to the entry in the block log.
         * @return {@code Builder}
         */
        public Builder tags(Set<Tags> tags) {
            blockAction.tags = tags;
            blockAction.apiUrl.putQuery("tags", tags.stream()
                    .map(Tags::getValue)
                    .collect(Collectors.joining("|")));
            return this;
        }

        /**
         * Block user from specific pages or namespaces rather than the entire site.
         * @return {@code Builder}
         */
        public Builder partial() {
            blockAction.partial = true;
            blockAction.apiUrl.putQuery("partial", "1");
            return this;
        }

        /**
         * List of titles to block the user from editing. Only applies when {@code partial} is set to true.
         * @return {@code Builder}
         */
        public Builder pageRestrictions(Set<String> pageRestrictions) {
            blockAction.pageRestrictions = pageRestrictions;
            blockAction.apiUrl.putQuery("pagerestrictions", String.join("|", pageRestrictions));
            return this;
        }

        /**
         * List of namespace IDs to block the user from editing. Only applies when {@code partial} is set to true.
         * @return {@code Builder}
         */
        public Builder namespaceRestrictions(Set<Namespace> namespaceRestrictions) {
            blockAction.namespaceRestrictions = namespaceRestrictions;
            blockAction.apiUrl.putQuery("namespacerestrictions", namespaceRestrictions.stream()
                    .map(Namespace::getValue)
                    .collect(Collectors.joining("|")));
            return this;
        }

        /**
         * A "csrf" token retrieved from
         * <a href="https://www.mediawiki.org/w/api.php?action=help&modules=query%2Btokens">action=query&meta=tokens</a>
         * This parameter is required.
         * @return {@code Builder}
         */
        public Builder token(String token) {
            blockAction.token = token;
            return this;
        }

        public BlockAction build() {
            if (blockAction.token == null)
                throw new IllegalArgumentException("Parameter 'token' is required");

            return blockAction;
        }

    }

}
