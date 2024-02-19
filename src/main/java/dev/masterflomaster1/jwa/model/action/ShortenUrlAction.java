package dev.masterflomaster1.jwa.model.action;

import dev.masterflomaster1.jwa.WikiApiSyntaxException;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * Shorten a long URL into a shorter one.
 *
 * @see <a href="https://www.mediawiki.org/w/api.php?action=help&modules=shortenurl">https://www.mediawiki.org/</a>
 */
public class ShortenUrlAction extends AbstractAction {

    private String url;
    private boolean qrCode;

    private ShortenUrlAction() {
        urlPart = "?action=shortenurl";
    }

    public String getUrl() {
        return url;
    }

    public boolean isQrCode() {
        return qrCode;
    }

    public static class Builder {

        private final ShortenUrlAction shortenUrlAction = new ShortenUrlAction();

        /**
         * URL to be shortened. This parameter is required.
         * @return {@code Builder}
         */
        public Builder url(String url) {
            shortenUrlAction.url = url;
            shortenUrlAction.urlPart += "&url=" + URLEncoder.encode(url, StandardCharsets.UTF_8);
            return this;
        }

        /**
         * Get a QR code. The linked URL will only be shortened if it is very long.
         * @return {@code Builder}
         */
        public Builder qrCode() {
            shortenUrlAction.qrCode = true;
            shortenUrlAction.urlPart += "&qrcode=1";
            return this;
        }

        public ShortenUrlAction build() throws WikiApiSyntaxException {
            if (shortenUrlAction.url == null)
                throw new WikiApiSyntaxException("Parameter 'url' is required");

            return shortenUrlAction;
        }

    }

}
