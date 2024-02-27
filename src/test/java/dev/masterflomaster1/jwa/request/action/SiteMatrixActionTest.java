package dev.masterflomaster1.jwa.request.action;

import dev.masterflomaster1.jwa.Response;
import dev.masterflomaster1.jwa.WikiApi;
import dev.masterflomaster1.jwa.WikiApiRequest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class SiteMatrixActionTest {

    private static WikiApi api;

    @BeforeAll
    static void before() {
        api = new WikiApi();
    }

    @Test
    @DisplayName("Show the site matrix")
    void testExample1() throws IOException {
        var a = new WikiApiRequest.Builder()
                .action(new SiteMatrixAction.Builder()
                        .build()
                )
                .build();

        Response r = api.execute(a);
        assertNotNull(r.getSiteMatrix());
    }

    @Test
    void testBuilder() {
        var a = new SiteMatrixAction.Builder()
                .smType(Set.of(SiteMatrixAction.SmType.LANGUAGE))
                .smState(Set.of(SiteMatrixAction.SmState.PRIVATE))
                .smLangProp(Set.of(SiteMatrixAction.SmLangProp.NAME))
                .smSiteProp(Set.of(SiteMatrixAction.SmSiteProp.DB_NAME))
                .smLimit(30)
                .smContinue("cont")
                .build();

        assertEquals(Set.of(SiteMatrixAction.SmType.LANGUAGE), a.getSmType());
        assertEquals(Set.of(SiteMatrixAction.SmState.PRIVATE), a.getSmState());
        assertEquals(Set.of(SiteMatrixAction.SmLangProp.NAME), a.getSmLangProp());
        assertEquals(Set.of(SiteMatrixAction.SmSiteProp.DB_NAME), a.getSmSiteProp());
        assertEquals(30, a.getSmLimit());
        assertEquals("cont", a.getSmContinue());
    }

}