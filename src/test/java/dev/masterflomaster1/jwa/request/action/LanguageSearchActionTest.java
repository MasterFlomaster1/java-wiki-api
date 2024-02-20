package dev.masterflomaster1.jwa.request.action;

import dev.masterflomaster1.jwa.Response;
import dev.masterflomaster1.jwa.WikiApi;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.WikiApiSyntaxException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class LanguageSearchActionTest {

    private static WikiApi api;

    @BeforeAll
    static void before() {
        api = new WikiApi();
    }

    @Test
    @DisplayName("Search for 'Te'")
    void testExample1() throws WikiApiSyntaxException, IOException {
        var a = new WikiApiRequest.Builder()
                .action(new LanguageSearchAction.Builder()
                        .search("Te")
                        .build()
                )
                .build();

        Response r = api.execute(a);
        assertNotNull(r.getLanguageSearch());
    }

    @Test
    @DisplayName("Search for 'ഫി'")
    void testExample2() throws WikiApiSyntaxException, IOException {
        var a = new WikiApiRequest.Builder()
                .action(new LanguageSearchAction.Builder()
                        .search("ഫി")
                        .build()
                )
                .build();

        Response r = api.execute(a);
        assertNotNull(r.getLanguageSearch());
    }

    @Test
    @DisplayName("Search for 'ഫി', allowing one typo")
    void testExample3() throws WikiApiSyntaxException, IOException {
        var a = new WikiApiRequest.Builder()
                .action(new LanguageSearchAction.Builder()
                        .search("ഫി")
                        .typos(1)
                        .build()
                )
                .build();

        Response r = api.execute(a);
        assertNotNull(r.getLanguageSearch());
    }

    @Test
    void testBuilder() throws WikiApiSyntaxException {
        var a = new LanguageSearchAction.Builder()
                .search("Te")
                .typos(1)
                .build();

        assertEquals("Te", a.getSearch());
        assertEquals(1, a.getTypos());
    }

}