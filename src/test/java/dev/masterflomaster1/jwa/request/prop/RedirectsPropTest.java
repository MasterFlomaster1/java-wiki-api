package dev.masterflomaster1.jwa.request.prop;

import dev.masterflomaster1.jwa.Response;
import dev.masterflomaster1.jwa.WikiApi;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.common.Namespace;
import dev.masterflomaster1.jwa.request.action.QueryAction;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.EnumSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class RedirectsPropTest {

    private static WikiApi api;

    @BeforeAll
    static void before() {
        api = new WikiApi();
    }

    @Test
    @DisplayName("Get a list of redirects to the Main Page.")
    void testExample1() throws IOException {
        var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .prop(Set.of(
                                new RedirectsProp.Builder()
                                        .build()
                                )
                        )
                        .titles(Set.of("Main Page"))
                        .build()
                )
                .build();

        Response r = api.execute(a);
        assertNotNull(r.getQuery().getPages().get(0).getRedirects());
    }

    @Test
    void testBuilder() {
        var a = new RedirectsProp.Builder()
                .rdProp(EnumSet.of(RedirectsProp.RdProp.PAGE_ID))
                .rdNamespace(EnumSet.of(Namespace.FILE))
                .rdShow(RedirectsProp.RdShow.NOT_FRAGMENT)
                .rdLimit(260)
                .rdContinue("4503755")
                .build();

        assertEquals(EnumSet.of(RedirectsProp.RdProp.PAGE_ID), a.getRdProp());
        assertEquals(EnumSet.of(Namespace.FILE), a.getRdNamespace());
        assertEquals(RedirectsProp.RdShow.NOT_FRAGMENT, a.getRdShow());
        assertEquals(260, a.getRdLimit());
        assertEquals("4503755", a.getRdContinue());
    }

}