package dev.masterflomaster1.jwa.request.action;

import dev.masterflomaster1.jwa.Response;
import dev.masterflomaster1.jwa.WikiApi;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.common.Namespace;
import org.junit.Ignore;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class OpenSearchActionTest {

    private static WikiApi api;

    @BeforeAll
    static void before() {
        api = new WikiApi();
    }

    @Test
    @Ignore
    @Disabled("OpenSearchAction response not implemented yet")
    @DisplayName("Find pages beginning with Te.")
    void testExample1() throws IOException {
        var a = new WikiApiRequest.Builder()
                .action(new OpenSearchAction.Builder()
                        .search("Te")
                        .build()
                )
                .build();

        Response r = api.execute(a);
        System.out.println(r);
    }

    @Test
    void testBuilder() {
        var a = new OpenSearchAction.Builder()
                .search("Te")
                .namespace(Set.of(Namespace.FILE))
                .limit(5)
                .profile(OpenSearchAction.Profile.CLASSIC)
                .redirects(OpenSearchAction.Redirects.RESOLVE)
                .format(OpenSearchAction.Format.JSON)
                .warningsAsError()
                .build();

        assertEquals("Te", a.getSearch());
        assertEquals(Set.of(Namespace.FILE), a.getNamespace());
        assertEquals(5, a.getLimit());
        assertEquals(OpenSearchAction.Profile.CLASSIC, a.getProfile());
        assertEquals(OpenSearchAction.Redirects.RESOLVE, a.getRedirects());
        assertEquals(OpenSearchAction.Format.JSON, a.getFormat());
        assertTrue(a.isWarningsAsError());
    }

}