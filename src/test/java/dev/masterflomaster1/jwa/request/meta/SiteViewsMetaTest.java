package dev.masterflomaster1.jwa.request.meta;

import dev.masterflomaster1.jwa.BaseApiTest;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.internal.UrlComparator;
import dev.masterflomaster1.jwa.request.action.QueryAction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SiteViewsMetaTest extends BaseApiTest {

    @Test
    @DisplayName("Show sitewide pageview totals")
    void testExample1() {
        var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .meta(Set.of(
                                new SiteViewsMeta.Builder()
                                        .build()
                        ))
                        .build()
                )
                .build();

        assertTrue(UrlComparator.compareUrls(
                "https://en.wikipedia.org/w/api.php?action=query&format=json&meta=siteviews&formatversion=2",
                a.getUrl()
        ));
    }

    @Test
    @DisplayName("Show sitewide unique visitor totals")
    void testExample2() {
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

        assertTrue(UrlComparator.compareUrls(
                "https://en.wikipedia.org/w/api.php?action=query&format=json&meta=siteviews&formatversion=2&pvismetric=uniques",
                a.getUrl()
        ));
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