package dev.masterflomaster1.jwa.request.meta;

import dev.masterflomaster1.jwa.Response;
import dev.masterflomaster1.jwa.WikiApi;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.request.action.QueryAction;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class SiteViewsMetaTest {

    private static WikiApi api;

    @BeforeAll
    static void before() {
        api = new WikiApi();
    }

    @Test
    @DisplayName("Show sitewide pageview totals.")
    void testExample1() throws IOException {
        var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .meta(Set.of(
                                new SiteViewsMeta.Builder()
                                        .build()
                        ))
                        .build()
                )
                .build();

        Response r = api.execute(a);
        assertNotNull(r.getQuery().getSiteViews());
    }

    @Test
    @DisplayName("Show sitewide unique visitor totals.")
    void testExample2() throws IOException {
        var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .meta(Set.of(
                                new SiteViewsMeta.Builder()
                                        .pvIsMetric(SiteViewsMeta.PvIsMetric.UNIQUES)
                                        .build()
                        ))
                        .build()
                )
                .build();

        Response r = api.execute(a);
        assertNotNull(r.getQuery().getSiteViews());
    }

    @Test
    void testBuilder() {
        var a = new SiteViewsMeta.Builder()
                .pvIsMetric(SiteViewsMeta.PvIsMetric.UNIQUES)
                .pvIsDays(4)
                .build();

        assertEquals(SiteViewsMeta.PvIsMetric.UNIQUES, a.getPvIsMetric());
        assertEquals(4, a.getPvIsDays());
    }

}