package dev.masterflomaster1.jwa.request.action;

import dev.masterflomaster1.jwa.BaseApiTest;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.internal.UrlComparator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class SpamBlacklistActionTest extends BaseApiTest {

    @Test
    @DisplayName("Check two URLs against the block list")
    void testExample1() {
        var a = new WikiApiRequest.Builder()
                .action(new SpamBlacklistAction.Builder()
                        .url(Set.of("http://www.example.com/", "http://www.example.org/"))
                        .build()
                )
                .build();

        assertTrue(UrlComparator.compareUrls(
                "https://en.wikipedia.org/w/api.php?action=spamblacklist&format=json&url=http%3A%2F%2Fwww.example.com%2F%7Chttp%3A%2F%2Fwww.example.org%2F&formatversion=2",
                a.getUrl()
        ));
    }

    @Test
    void testBuilder() {
        var a = new SpamBlacklistAction.Builder()
                .url(Set.of("https://www.example.com/", "https://www.example.org/"))
                .build();

        assertEquals(Set.of("https://www.example.com/", "https://www.example.org/"), a.getUrl());
    }

}