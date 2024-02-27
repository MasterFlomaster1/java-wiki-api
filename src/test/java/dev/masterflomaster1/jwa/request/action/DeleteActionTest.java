package dev.masterflomaster1.jwa.request.action;

import dev.masterflomaster1.jwa.Response;
import dev.masterflomaster1.jwa.WikiApi;
import dev.masterflomaster1.jwa.WikiApiRequest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeFalse;

class DeleteActionTest {

    private static WikiApi api;

    @BeforeAll
    static void before() {
        api = new WikiApi();
    }

    @Test
    @DisplayName("Delete Main Page.")
    void testExample1() throws IOException {
        var a = new WikiApiRequest.Builder()
                .action(new DeleteAction.Builder()
                        .title("Main Page")
                        .token(Shared.tokens().getCsrfToken())
                        .build()
                )
                .build();

        Response r = api.execute(a);

        assumeFalse(r.getError() != null && r.getError().getCode().equals("permissiondenied"), "Permission denied, skipping");
        assertNotNull(r.getDelete());
    }

    @Test
    @DisplayName("Delete Main Page with the reason Preparing for move.")
    void testExample2() throws IOException {
        var a = new WikiApiRequest.Builder()
                .action(new DeleteAction.Builder()
                        .title("Main Page")
                        .reason("Preparing for move")
                        .token(Shared.tokens().getCsrfToken())
                        .build()
                )
                .build();

        Response r = api.execute(a);

        assumeFalse(r.getError() != null && r.getError().getCode().equals("permissiondenied"), "Permission denied, skipping");
        assertNotNull(r.getDelete());
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