package dev.masterflomaster1.jwa.request.action;

import dev.masterflomaster1.jwa.Response;
import dev.masterflomaster1.jwa.WikiApi;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.common.Generator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeFalse;

class WatchActionTest {

    private static WikiApi api;

    @BeforeAll
    static void before() {
        api = new WikiApi();
    }

    @Test
    @DisplayName("Watch the page Main Page.")
    void testExample1() throws IOException {
        var a = new WikiApiRequest.Builder()
                .action(new WatchAction.Builder()
                        .titles(Set.of("Main Page"))
                        .token(Shared.tokens().getWatchToken())
                        .build()
                )
                .build();

        Response r = api.execute(a);
        assumeFalse(r.getError() != null && r.getError().getCode().equals("notloggedin"), "Not logged in, skipping");
        assertNotNull(r.getWatch());
    }

    @Test
    @DisplayName("Watch the pages Main Page, Foo, and Bar for one month.")
    void testExample2() throws IOException {
        var a = new WikiApiRequest.Builder()
                .action(new WatchAction.Builder()
                        .expiry("1 month")
                        .titles(Set.of("Main Page", "Foo", "Bar"))
                        .token(Shared.tokens().getWatchToken())
                        .build()
                )
                .build();

        Response r = api.execute(a);
        assumeFalse(r.getError() != null && r.getError().getCode().equals("notloggedin"), "Not logged in, skipping");
        assertNotNull(r.getWatch());
    }

    @Test
    @DisplayName("Unwatch the page Main Page.")
    void testExample3() throws IOException {
        var a = new WikiApiRequest.Builder()
                .action(new WatchAction.Builder()
                        .unwatch()
                        .titles(Set.of("Main Page"))
                        .token(Shared.tokens().getWatchToken())
                        .build()
                )
                .build();

        Response r = api.execute(a);
        assumeFalse(r.getError() != null && r.getError().getCode().equals("notloggedin"), "Not logged in, skipping");
        assertNotNull(r.getWatch());
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