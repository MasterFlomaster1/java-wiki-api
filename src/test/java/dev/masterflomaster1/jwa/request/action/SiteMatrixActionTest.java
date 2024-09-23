package dev.masterflomaster1.jwa.request.action;

import dev.masterflomaster1.jwa.BaseApiTest;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.internal.UrlComparator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EnumSet;

import static org.junit.jupiter.api.Assertions.*;

class SiteMatrixActionTest extends BaseApiTest {

    @Test
    @DisplayName("Show the site matrix")
    void testExample1() {
        var a = new WikiApiRequest.Builder()
                .action(new SiteMatrixAction.Builder()
                        .build()
                )
                .build();

        assertTrue(UrlComparator.compareUrls(
                "https://en.wikipedia.org/w/api.php?action=sitematrix&format=json&formatversion=2",
                a.getUrl()
        ));
    }

    @Test
    void testBuilder() {
        var a = new SiteMatrixAction.Builder()
                .smType(EnumSet.of(SiteMatrixAction.SmType.LANGUAGE))
                .smState(EnumSet.of(SiteMatrixAction.SmState.PRIVATE))
                .smLangProp(EnumSet.of(SiteMatrixAction.SmLangProp.NAME))
                .smSiteProp(EnumSet.of(SiteMatrixAction.SmSiteProp.DB_NAME))
                .smLimit(30)
                .smContinue("cont")
                .build();

        assertEquals(EnumSet.of(SiteMatrixAction.SmType.LANGUAGE), a.getSmType());
        assertEquals(EnumSet.of(SiteMatrixAction.SmState.PRIVATE), a.getSmState());
        assertEquals(EnumSet.of(SiteMatrixAction.SmLangProp.NAME), a.getSmLangProp());
        assertEquals(EnumSet.of(SiteMatrixAction.SmSiteProp.DB_NAME), a.getSmSiteProp());
        assertEquals(30, a.getSmLimit());
        assertEquals("cont", a.getSmContinue());
    }

}