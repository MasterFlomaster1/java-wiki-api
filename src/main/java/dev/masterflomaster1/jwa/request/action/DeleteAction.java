package dev.masterflomaster1.jwa.request.action;

import dev.masterflomaster1.jwa.WikiApiSyntaxException;
import okhttp3.FormBody;

/**
 * Delete a page.
 *
 * @see <a href="https://www.mediawiki.org/wiki/Special:MyLanguage/API:Delete">API:Delete</a>
 */
public class DeleteAction extends AbstractAction implements IPost {

    private String title;
    private int pageId;
    private String reason;
    private boolean deleteTalk;
    private Watchlist watchlist;
    private String watchlistExpiry;
    private String oldImage;
    private String token;

    private DeleteAction() {
        apiUrl.setAction("delete");
    }

    public String getTitle() {
        return title;
    }

    public int getPageId() {
        return pageId;
    }

    public String getReason() {
        return reason;
    }

    public boolean isDeleteTalk() {
        return deleteTalk;
    }

    public Watchlist getWatchlist() {
        return watchlist;
    }

    public String getWatchlistExpiry() {
        return watchlistExpiry;
    }

    public String getOldImage() {
        return oldImage;
    }

    public String getToken() {
        return token;
    }

    @Override
    public FormBody getPostBody() {
        return new FormBody.Builder()
                .add("token", token)
                .build();
    }

    public static class Builder {

        private final DeleteAction deleteAction = new DeleteAction();

        /**
         * Title of the page to delete. Cannot be used together with {@code pageid}.
         * @return {@code Builder}
         */
        public Builder title(String title) {
            deleteAction.title = title;
            deleteAction.apiUrl.putQuery("title", title);
            return this;
        }

        /**
         * Page ID of the page to delete. Cannot be used together with {@code title}.
         * @return {@code Builder}
         */
        public Builder pageId(int pageId) {
            deleteAction.pageId = pageId;
            deleteAction.apiUrl.putQuery("pageid", pageId);
            return this;
        }

        /**
         * Reason for the deletion. If not set, an automatically generated reason will be used.
         * @return {@code Builder}
         */
        public Builder reason(String reason) {
            deleteAction.reason = reason;
            deleteAction.apiUrl.putQuery("reason", reason);
            return this;
        }

        /**
         * Delete the talk page, if it exists.
         * @return {@code Builder}
         */
        public Builder deleteTalk() {
            deleteAction.deleteTalk = true;
            deleteAction.apiUrl.putQuery("deletetalk", "1");
            return this;
        }

        /**
         * Unconditionally add or remove the page from the current user's watchlist, use preferences
         * (ignored for bot users) or do not change watch.
         * @return {@code Builder}
         */
        public Builder watchlist(Watchlist watchlist) {
            deleteAction.watchlist = watchlist;
            deleteAction.apiUrl.putQuery("watchlist", watchlist.getValue());
            return this;
        }

        /**
         * Watchlist expiry timestamp. Omit this parameter entirely to leave the current expiry unchanged.
         * @return {@code Builder}
         */
        public Builder watchlistExpiry(String watchlistExpiry) {
            deleteAction.watchlistExpiry = watchlistExpiry;
            deleteAction.apiUrl.putQuery("watchlistexpiry", watchlistExpiry);
            return this;
        }

        /**
         * The name of the old image to delete as provided by {@code action=query&prop=imageinfo&iiprop=archivename}.
         * @return {@code Builder}
         */
        public Builder oldImage(String oldImage) {
            deleteAction.oldImage = oldImage;
            deleteAction.apiUrl.putQuery("oldimage", oldImage);
            return this;
        }

        /**
         * A "csrf" token retrieved from
         * <a href="https://www.mediawiki.org/w/api.php?action=help&modules=query%2Btokens">action=query&meta=tokens</a>
         * This parameter is required.
         * @return {@code Builder}
         */
        public Builder token(String token) {
            deleteAction.token = token;
            return this;
        }

        public DeleteAction build() {
            if (deleteAction.token == null)
                throw new WikiApiSyntaxException("Parameter 'token' is required");

            return deleteAction;
        }

    }

    public enum Watchlist {

        NO_CHANGE ("nochange"),
        PREFERENCES ("preferences"),
        UNWATCH ("unwatch"),
        WATCH ("watch");

        private final String value;

        Watchlist(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

    }

}
