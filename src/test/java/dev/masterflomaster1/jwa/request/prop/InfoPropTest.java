package dev.masterflomaster1.jwa.request.prop;

import dev.masterflomaster1.jwa.Response;
import dev.masterflomaster1.jwa.WikiApi;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.request.action.QueryAction;
import dev.masterflomaster1.jwa.response.Page;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class InfoPropTest {

    private static WikiApi api;

    @BeforeAll
    static void before() {
        api = new WikiApi();
    }

    @Test
    @DisplayName("Get information about the page Main Page.")
    void testExample1() throws IOException {
        var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .prop(Set.of(
                                        new InfoProp.Builder()
                                                .build()
                                )
                        )
                        .titles(Set.of("Main Page"))
                        .build()
                )
                .build();

        Response r = api.execute(a);
        Page p = r.getQuery().getPages().get(0);
        assertNotNull(p.getTouched());
        assertNotNull(p.getLastRevId());
        assertNotNull(p.getLength());
    }

    @Test
    void testBuilder() {
        var a = new InfoProp.Builder()
                .inProp(Set.of(InfoProp.InProp.URL, InfoProp.InProp.TALK_ID))
                .inContinue("test")
                .build();

        assertEquals(Set.of(InfoProp.InProp.URL, InfoProp.InProp.TALK_ID), a.getInProp());
        assertEquals("test", a.getInContinue());
    }

}