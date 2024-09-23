package dev.masterflomaster1.jwa.request.action;

import dev.masterflomaster1.jwa.BaseApiTest;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.internal.UrlComparator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeFalse;

class ThankActionTest extends BaseApiTest {

    @Test
    @DisplayName("Send thanks for revision ID 456, with the source being a diff page")
    void testExample1() {
        var a = new WikiApiRequest.Builder()
                .action(new ThankAction.Builder()
                        .rev(456)
                        .token("+\\")
                        .source("diff")
                        .build()
                )
                .build();

        assertTrue(UrlComparator.compareUrls(
                "https://en.wikipedia.org/w/api.php?action=thank&format=json&rev=456&token=%2B%5C&source=diff&formatversion=2",
                a.getUrl()
        ));
    }

    @Test
    void testBuilder() {
        var a = new ThankAction.Builder()
                .rev(456)
                .log(456)
                .token("test12345")
                .source("diff")
                .build();

        assertEquals(456, a.getRev());
        assertEquals(456, a.getLog());
        assertEquals("test12345", a.getToken());
        assertEquals("diff", a.getSource());
    }

}