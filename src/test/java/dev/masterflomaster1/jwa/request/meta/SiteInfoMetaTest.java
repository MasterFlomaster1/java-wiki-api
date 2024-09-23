package dev.masterflomaster1.jwa.request.meta;

import dev.masterflomaster1.jwa.BaseApiTest;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.internal.UrlComparator;
import dev.masterflomaster1.jwa.request.action.QueryAction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EnumSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class SiteInfoMetaTest extends BaseApiTest {

    @Test
    @DisplayName("Fetch site information")
    void testExample1() {
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
                        ))
                        .build()
                )
                .build();

        assertTrue(UrlComparator.compareUrls(
                "https://en.wikipedia.org/w/api.php?action=query&format=json&meta=siteinfo&formatversion=2&siprop=general%7Cnamespaces%7Cnamespacealiases%7Cstatistics",
                a.getUrl()
        ));
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