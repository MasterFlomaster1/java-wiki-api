package dev.masterflomaster1.jwa.request.action;

import dev.masterflomaster1.jwa.BaseApiTest;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.common.Generator;
import dev.masterflomaster1.jwa.internal.UrlComparator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeFalse;

class WatchActionTest extends BaseApiTest {

    @Test
    @DisplayName("Watch the page Main Page")
    void testExample1() {
        var a = new WikiApiRequest.Builder()
                .action(new WatchAction.Builder()
                        .titles(Set.of("Main Page"))
                        .token("+\\")
                        .build()
                )
                .build();

        assertTrue(UrlComparator.compareUrls(
                "https://en.wikipedia.org/w/api.php?action=watch&format=json&titles=Main%20Page&token=%2B%5C&formatversion=2",
                a.getUrl()
        ));
    }

    @Test
    @DisplayName("Watch the pages Main Page, Foo, and Bar for one month")
    void testExample2() {
        var a = new WikiApiRequest.Builder()
                .action(new WatchAction.Builder()
                        .expiry("1 month")
                        .titles(Set.of("Main Page", "Foo", "Bar"))
                        .token("+\\")
                        .build()
                )
                .build();

        assertTrue(UrlComparator.compareUrls(
                "https://en.wikipedia.org/w/api.php?action=watch&format=json&expiry=1%20month&titles=Main%20Page%7CFoo%7CBar&token=%2B%5C&formatversion=2",
                a.getUrl()
        ));
    }

    @Test
    @DisplayName("Unwatch the page Main Page.")
    void testExample3() {
        var a = new WikiApiRequest.Builder()
                .action(new WatchAction.Builder()
                        .unwatch()
                        .titles(Set.of("Main Page"))
                        .token("+\\")
                        .build()
                )
                .build();

        assertTrue(UrlComparator.compareUrls(
                "https://en.wikipedia.org/w/api.php?action=watch&format=json&unwatch=1&titles=Main%20Page&token=%2B%5C&formatversion=2",
                a.getUrl()
        ));
    }

    @Test
    void testBuilder() {
        var a = new WatchAction.Builder()
                .expiry("1 month")
                .unwatch()
                .continue_("cont")
                .titles(Set.of("Main Page"))
                .pageIds(Set.of(12))
                .revIds(Set.of(24L))
                .generator(Generator.ALL_PAGES)
                .redirects()
                .convertTitles()
                .token("token")
                .build();

        assertEquals("1 month", a.getExpiry());
        assertTrue(a.isUnwatch());
        assertEquals("cont", a.getContinue_());
        assertEquals(Set.of("Main Page"), a.getTitles());
        assertEquals(Set.of(12), a.getPageIds());
        assertEquals(Set.of(24L), a.getRevIds());
        assertEquals(Generator.ALL_PAGES, a.getGenerator());
        assertTrue(a.isRedirects());
        assertTrue(a.isConvertTitles());
        assertEquals("token", a.getToken());

    }

}