package dev.masterflomaster1.jwa.request.list;

import dev.masterflomaster1.jwa.BaseApiTest;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.common.Dir;
import dev.masterflomaster1.jwa.common.FilterRedir;
import dev.masterflomaster1.jwa.common.Namespace;
import dev.masterflomaster1.jwa.internal.UrlComparator;
import dev.masterflomaster1.jwa.request.action.QueryAction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EnumSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class AllPagesListTest extends BaseApiTest {

    @Test
    @DisplayName("Show a list of pages starting at the letter B")
    void testExample1() {
        var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .list(Set.of(
                                new AllPagesList.Builder()
                                        .apFrom("B")
                                        .build()
                        ))
                        .build()
                )
                .build();

        assertTrue(UrlComparator.compareUrls(
                "https://en.wikipedia.org/w/api.php?action=query&format=json&list=allpages&formatversion=2&apfrom=B",
                a.getUrl()
        ));
    }

    @Test
    void testBuilder() {
        var a = new AllPagesList.Builder()
                .apFrom("A")
                .apContinue("test")
                .apTo("B")
                .apPrefix("pref")
                .apNamespace(Namespace.FILE)
                .apFilterRedir(FilterRedir.ALL)
                .apFilterLangLinks(AllPagesList.ApFilterLangLinks.WITH_LANG_LINKS)
                .apMinSize(10)
                .apMaxSize(20)
                .apPrType(EnumSet.of(AllPagesList.ApPrType.MOVE))
                .apPrLevel(EnumSet.of(AllPagesList.ApPrLevel.SYSOP))
                .apPrFilterCascade(AllPagesList.ApPrFilterCascade.NON_CASCADING)
                .apPrExpiry(AllPagesList.ApPrExpiry.ALL)
                .apLimit(40)
                .apDir(Dir.Order.DESCENDING)
                .build();

        assertEquals("A", a.getApFrom());
        assertEquals("test", a.getApContinue());
        assertEquals("B", a.getApTo());
        assertEquals("pref", a.getApPrefix());
        assertEquals(Namespace.FILE, a.getApNamespace());
        assertEquals(FilterRedir.ALL, a.getApFilterRedir());
        assertEquals(AllPagesList.ApFilterLangLinks.WITH_LANG_LINKS, a.getApFilterLangLinks());
        assertEquals(10, a.getApMinSize());
        assertEquals(20, a.getApMaxSize());
        assertEquals(EnumSet.of(AllPagesList.ApPrType.MOVE), a.getApPrType());
        assertEquals(EnumSet.of(AllPagesList.ApPrLevel.SYSOP), a.getApPrLevel());
        assertEquals(AllPagesList.ApPrFilterCascade.NON_CASCADING, a.getApPrFilterCascade());
        assertEquals(AllPagesList.ApPrExpiry.ALL, a.getApPrExpiry());
        assertEquals(40, a.getApLimit());
        assertEquals(Dir.Order.DESCENDING, a.getApDir());
    }

}