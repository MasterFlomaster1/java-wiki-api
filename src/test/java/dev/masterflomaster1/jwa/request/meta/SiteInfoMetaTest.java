package dev.masterflomaster1.jwa.request.meta;

import dev.masterflomaster1.jwa.Response;
import dev.masterflomaster1.jwa.WikiApi;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.request.action.QueryAction;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.EnumSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class SiteInfoMetaTest {

    private static WikiApi api;

    @BeforeAll
    static void before() {
        api = new WikiApi();
    }

    @Test
    @DisplayName("Fetch site information.")
    void testExample1() throws IOException {
        var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .meta(Set.of(
                                new SiteInfoMeta.Builder()
                                        .siProp(EnumSet.of(
                                                SiteInfoMeta.SiProp.GENERAL,
                                                SiteInfoMeta.SiProp.NAMESPACES,
                                                SiteInfoMeta.SiProp.NAMESPACE_ALIASES,
                                                SiteInfoMeta.SiProp.STATISTICS
                                        ))
                                        .build()
                                )
                        )
                        .build()
                )
                .build();

        Response r = api.execute(a);

        assertNotNull(r.getQuery().getGeneral());
    }

    @Test
    void testBuilder() {
        var a = new SiteInfoMeta.Builder()
                .siProp(EnumSet.of(SiteInfoMeta.SiProp.NAMESPACES))
                .siShowAllDb()
                .siNumberInGroup()
                .build();

        assertEquals(EnumSet.of(SiteInfoMeta.SiProp.NAMESPACES), a.getSiProp());
        assertTrue(a.isSiShowAllDb());
        assertTrue(a.isSiNumberInGroup());
    }

}