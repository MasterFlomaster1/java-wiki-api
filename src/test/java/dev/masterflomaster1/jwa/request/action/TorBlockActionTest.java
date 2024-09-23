package dev.masterflomaster1.jwa.request.action;

import dev.masterflomaster1.jwa.BaseApiTest;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.internal.UrlComparator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TorBlockActionTest extends BaseApiTest {

    @Test
    @DisplayName("Check if the IP address 192.0.2.18 is blocked as a Tor exit node")
    void test() {
        var a = new WikiApiRequest.Builder()
                .action(new TorBlockAction.Builder()
                        .ip("192.0.2.18")
                        .build()
                )
                .build();

        assertTrue(UrlComparator.compareUrls(
                "https://en.wikipedia.org/w/api.php?action=torblock&format=json&ip=192.0.2.18&formatversion=2",
                a.getUrl()
        ));
    }

    @Test
    void getIp() {
        var a = new TorBlockAction.Builder()
                .ip("127.0.0.1")
                .build();

        assertEquals("127.0.0.1", a.getIp());
    }
}