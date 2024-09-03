package dev.masterflomaster1.jwa.request.action;

import dev.masterflomaster1.jwa.WikiApiSyntaxException;
import okhttp3.FormBody;

/**
 * Shorten a long URL into a shorter one.
 *
 * @see <a href="https://www.mediawiki.org/w/api.php?action=help&modules=shortenurl">https://www.mediawiki.org/</a>
 */
public final class ShortenUrlAction extends AbstractAction implements IPost {

    private String url;
    private boolean qrCode;

    private ShortenUrlAction() {
        apiUrl.setAction("shortenurl");
    }

    public String getUrl() {
        return url;
    }

    public boolean isQrCode() {
        return qrCode;
    }

    @Override
    public FormBody getPostBody() {
        return new FormBody.Builder()
//                .add("action", "shortenurl")
                .build();
    }

    public static class Builder {

        private final ShortenUrlAction shortenUrlAction = new ShortenUrlAction();

        /**
         * URL to be shortened. This parameter is required.
         * @return {@code Builder}
         */
        public Builder url(String url) {
            shortenUrlAction.url = url;
            shortenUrlAction.apiUrl.putQuery("url", url);
            return this;
        }

        /**
         * Get a QR code. The linked URL will only be shortened if it is very long.
         * @return {@code Builder}
         */
        public Builder qrCode() {
            shortenUrlAction.qrCode = true;
            shortenUrlAction.apiUrl.putQuery("qrcode", "1");
            return this;
        }

        public ShortenUrlAction build() throws WikiApiSyntaxException {
            if (shortenUrlAction.url == null)
                throw new WikiApiSyntaxException("Parameter 'url' is required");

            return shortenUrlAction;
        }

    }

}
