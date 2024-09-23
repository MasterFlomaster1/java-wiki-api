package dev.masterflomaster1.jwa.request.action;

import dev.masterflomaster1.jwa.BaseApiTest;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.internal.UrlComparator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LanguageSearchActionTest extends BaseApiTest {

    @Test
    @DisplayName("Search for 'Te'")
    void testExample1() {
        var a = new WikiApiRequest.Builder()
                .action(new LanguageSearchAction.Builder()
                        .search("Te")
                        .build()
                )
                .build();

        assertTrue(UrlComparator.compareUrls(
                "https://en.wikipedia.org/w/api.php?action=languagesearch&format=json&search=Te&formatversion=2",
                a.getUrl()
        ));
    }

    @Test
    @DisplayName("Search for 'ഫി'")
    void testExample2() {
        var a = new WikiApiRequest.Builder()
                .action(new LanguageSearchAction.Builder()
                        .search("ഫി")
                        .build()
                )
                .build();

        assertTrue(UrlComparator.compareUrls(
                "https://en.wikipedia.org/w/api.php?action=languagesearch&format=json&search=%E0%B4%AB%E0%B4%BF&formatversion=2",
                a.getUrl()
        ));
    }

    @Test
    @DisplayName("Search for 'ഫി', allowing one typo")
    void testExample3() {
        var a = new WikiApiRequest.Builder()
                .action(new LanguageSearchAction.Builder()
                        .search("ഫി")
                        .typos(1)
                        .build()
                )
                .build();

        assertTrue(UrlComparator.compareUrls(
                "https://en.wikipedia.org/w/api.php?action=languagesearch&format=json&search=%E0%B4%AB%E0%B4%BF&typos=1&formatversion=2",
                a.getUrl()
        ));
    }

    @Test
    void testBuilder() {
        var a = new LanguageSearchAction.Builder()
                .search("Te")
                .typos(1)
                .build();

        assertEquals("Te", a.getSearch());
        assertEquals(1, a.getTypos());
    }

}