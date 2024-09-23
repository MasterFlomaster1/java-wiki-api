package dev.masterflomaster1.jwa.request.action;

import dev.masterflomaster1.jwa.BaseApiTest;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.internal.UrlComparator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AntiSpoofActionTest extends BaseApiTest {

    @Test
    @DisplayName("Check username 'Foo' against AntiSpoof")
    void testExample1() {
        var a = new WikiApiRequest.Builder()
                .action(new AntiSpoofAction.Builder()
                        .username("Foo")
                        .build()
                )
                .build();

        assertTrue(UrlComparator.compareUrls(
                "https://en.wikipedia.org/w/api.php?action=antispoof&format=json&username=Foo&formatversion=2",
                a.getUrl()
        ));
    }

    @Test
    void testBuilder() {
        var a = new AntiSpoofAction.Builder()
                .username("test")
                .build();

        assertEquals("test", a.getUsername());
    }

}