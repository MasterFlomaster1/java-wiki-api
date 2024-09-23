package dev.masterflomaster1.jwa.request.action;

import dev.masterflomaster1.jwa.BaseApiTest;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.internal.UrlComparator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeFalse;

class DeleteActionTest extends BaseApiTest {

    @Test
    @DisplayName("Delete Main Page")
    void testExample1() {
        var a = new WikiApiRequest.Builder()
                .action(new DeleteAction.Builder()
                        .title("Main Page")
                        .token("+\\")
                        .build()
                )
                .build();

        assertTrue(UrlComparator.compareUrls(
                "https://en.wikipedia.org/w/api.php?action=delete&format=json&title=Main%20Page&token=%2B%5C&formatversion=2",
                a.getUrl()
        ));
    }

    @Test
    @DisplayName("Delete Main Page with the reason Preparing for move")
    void testExample2() {
        var a = new WikiApiRequest.Builder()
                .action(new DeleteAction.Builder()
                        .title("Main Page")
                        .reason("Preparing for move")
                        .token("+\\")
                        .build()
                )
                .build();

        assertTrue(UrlComparator.compareUrls(
                "https://en.wikipedia.org/w/api.php?action=delete&format=json&title=Main%20Page&reason=Preparing%20for%20move&token=%2B%5C&formatversion=2",
                a.getUrl()
        ));
    }

    @Test
    void testBuilder() {
        var a = new DeleteAction.Builder()
                .title("Main Page")
                .pageId(23)
                .reason("Preparing for move")
                .deleteTalk()
                .watchlist(DeleteAction.Watchlist.NO_CHANGE)
                .watchlistExpiry("000")
                .oldImage("image")
                .token("test")
                .build();

        assertEquals("Main Page", a.getTitle());
        assertEquals(23, a.getPageId());
        assertEquals("Preparing for move", a.getReason());
        assertTrue(a.isDeleteTalk());
        assertEquals(DeleteAction.Watchlist.NO_CHANGE, a.getWatchlist());
        assertEquals("000", a.getWatchlistExpiry());
        assertEquals("image", a.getOldImage());
        assertEquals("test", a.getToken());
    }

}