package dev.masterflomaster1.jwa.request.action;

import dev.masterflomaster1.jwa.BaseApiTest;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.internal.UrlComparator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CheckTokenActionTest extends BaseApiTest {

    @Test
    @DisplayName("Test the validity of a csrf token")
    void testExample1() {
        var a = new WikiApiRequest.Builder()
                .action(new CheckTokenAction.Builder()
                        .type(CheckTokenAction.Type.CSRF)
                        .token("123ABC")
                        .build()
                )
                .build();

        assertTrue(UrlComparator.compareUrls(
                "https://en.wikipedia.org/w/api.php?action=checktoken&format=json&type=csrf&token=123ABC&formatversion=2",
                a.getUrl()
        ));
    }

    @Test
    void testBuilder() {
        var a = new CheckTokenAction.Builder()
                .type(CheckTokenAction.Type.CSRF)
                .token("123ABC")
                .maxTokenAge(1)
                .build();

        assertEquals(CheckTokenAction.Type.CSRF, a.getType());
        assertEquals("123ABC", a.getToken());
        assertEquals(1, a.getMaxTokenAge());
    }

}