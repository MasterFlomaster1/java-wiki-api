package dev.masterflomaster1.jwa.model.meta;

import com.google.gson.Gson;
import dev.masterflomaster1.jwa.Response;
import dev.masterflomaster1.jwa.WikiApi;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.WikiApiSyntaxException;
import dev.masterflomaster1.jwa.model.action.QueryAction;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class SiteInfoMetaTest {

    private static WikiApi api;
    private static Gson gson;

    @BeforeAll
    static void before() {
        api = new WikiApi();
        gson = new Gson();
    }

    @Test
    @DisplayName("Fetch site information.")
    void testExample1() throws WikiApiSyntaxException, IOException, InterruptedException {
        var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .meta(Set.of(
                                new SiteInfoMeta.Builder()
                                        .siProp(Set.of(
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

        Response r = gson.fromJson(api.execute(a), Response.class);

        assertNotNull(r.getQuery().getGeneral());
    }

    @Test
    void testBuild() {
        var a = new SiteInfoMeta.Builder()
                .siProp(Set.of(SiteInfoMeta.SiProp.NAMESPACES))
                .siShowAllDb()
                .siNumberInGroup()
                .build();

        assertEquals(Set.of(SiteInfoMeta.SiProp.NAMESPACES), a.getSiProp());
        assertTrue(a.isSiShowAllDb());
        assertTrue(a.isSiNumberInGroup());
    }

}