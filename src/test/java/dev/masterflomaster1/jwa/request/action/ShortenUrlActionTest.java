package dev.masterflomaster1.jwa.request.action;

import dev.masterflomaster1.jwa.BaseApiTest;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.internal.UrlComparator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShortenUrlActionTest extends BaseApiTest {

    @Test
    @DisplayName("Get the short URL for https://en.wikipedia.org/wiki/Arctica")
    void testExample1() {
        var a = new WikiApiRequest.Builder()
                .action(new ShortenUrlAction.Builder()
                        .url("https://en.wikipedia.org/wiki/Arctica")
                        .build()
                )
                .build();

        assertTrue(UrlComparator.compareUrls(
                "https://en.wikipedia.org/w/api.php?action=shortenurl&format=json&url=https%3A%2F%2Fen.wikipedia.org%2Fwiki%2FArctica&formatversion=2",
                a.getUrl()
        ));
    }

    @Test
    @DisplayName("Get a QR code for https://en.wikipedia.org/wiki/Arctica")
    void testExample2() {
        var a = new WikiApiRequest.Builder()
                .action(new ShortenUrlAction.Builder()
                        .url("https://en.wikipedia.org/wiki/Arctica")
                        .qrCode()
                        .build()
                )
                .build();

        assertTrue(UrlComparator.compareUrls(
                "https://en.wikipedia.org/w/api.php?action=shortenurl&format=json&url=https%3A%2F%2Fen.wikipedia.org%2Fwiki%2FArctica&qrcode=1&formatversion=2",
                a.getUrl()
        ));
    }

    @Test
    void testBuilder() {
        var a = new ShortenUrlAction.Builder()
                .url("https://en.wikipedia.org/wiki/Arctica")
                .qrCode()
                .build();

        assertEquals("https://en.wikipedia.org/wiki/Arctica", a.getUrl());
        assertTrue(a.isQrCode());
    }

}