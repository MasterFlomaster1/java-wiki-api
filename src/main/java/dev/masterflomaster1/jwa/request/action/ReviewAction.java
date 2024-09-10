package dev.masterflomaster1.jwa.request.action;

import lombok.Getter;
import lombok.ToString;
import okhttp3.FormBody;

/**
 * Review a revision by approving or de-approving it.
 */
@Getter
@ToString
@SuppressWarnings("SpellCheckingInspection")
public final class ReviewAction extends AbstractAction implements IPost {

    private long revId;
    private String comment;
    private boolean unApprove;
    private String token;

    private ReviewAction() {
        apiUrl.setAction("review");
    }

    @Override
    public FormBody getPostBody() {
        return new FormBody.Builder()
                .add("token", token)
                .build();
    }

    public static class Builder {

        private final ReviewAction reviewAction = new ReviewAction();

        /**
         * The revision ID for which to set the flags.
         * @return {@code Builder}
         */
        public Builder revId(long revId) {
            reviewAction.revId = revId;
            reviewAction.apiUrl.putQuery("revid", revId);
            return this;
        }

        /**
         * Comment for the review.
         * @return {@code Builder}
         */
        public Builder comment(String comment) {
            reviewAction.comment = comment;
            reviewAction.apiUrl.putQuery("comment", comment);
            return this;
        }

        /**
         * If set, revision will be unapproved rather than approved.
         * @return {@code Builder}
         */
        public Builder unApprove() {
            reviewAction.unApprove = true;
            reviewAction.apiUrl.putQuery("unapprove", "1");
            return this;
        }

        /**
         * A "csrf" token retrieved from
         * <a href="https://www.mediawiki.org/w/api.php?action=help&modules=query%2Btokens">action=query&meta=tokens</a>
         * This parameter is required.
         * @return {@code Builder}
         */
        public Builder token(String token) {
            reviewAction.token = token;
            return this;
        }

        public ReviewAction build() {
            if (reviewAction.token == null)
                throw new IllegalArgumentException("Parameter 'token' is required");

            return reviewAction;
        }

    }

}
