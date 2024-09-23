package dev.masterflomaster1.jwa.request.list;

import dev.masterflomaster1.jwa.BaseApiTest;
import dev.masterflomaster1.jwa.Response;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.common.Dir;
import dev.masterflomaster1.jwa.internal.UrlComparator;
import dev.masterflomaster1.jwa.request.action.QueryAction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.EnumSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class AllFileUsagesListTest extends BaseApiTest {

    @Test
    @DisplayName("List file titles, including missing ones, with page IDs they are from, starting at B")
    void testExample1() {
        var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .list(Set.of(
                                new AllFileUsagesList.Builder()
                                        .afFrom("B")
                                        .afProp(EnumSet.of(AllFileUsagesList.AfProp.IDS, AllFileUsagesList.AfProp.TITLE))
                                        .build()
                                )
                        )
                        .build()
                )
                .build();

        assertTrue(UrlComparator.compareUrls(
                "https://en.wikipedia.org/w/api.php?action=query&format=json&list=allfileusages&formatversion=2&affrom=B&afprop=ids%7Ctitle",
                a.getUrl()
        ));
    }

    @Test
    @DisplayName("List unique file titles.")
    void testExample2() throws IOException {
        var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .list(Set.of(
                                new AllFileUsagesList.Builder()
                                        .afFrom("B")
                                        .afUnique()
                                        .build()
                                )
                        )
                        .build()
                )
                .build();

        Response r = api.execute(a);
        assertNotNull(r.getQuery().getAllFileUsages());
    }

    @Test
    void testBuilder() {
        var a = new AllFileUsagesList.Builder()
                .afContinue("cont")
                .afFrom("B")
                .afTo("C")
                .afPrefix("D")
                .afUnique()
                .afProp(EnumSet.of(AllFileUsagesList.AfProp.IDS, AllFileUsagesList.AfProp.TITLE))
                .afLimit(20)
                .afDir(Dir.Order.DESCENDING)
                .build();

        assertEquals("cont", a.getAfContinue());
        assertEquals("B", a.getAfFrom());
        assertEquals("C", a.getAfTo());
        assertEquals("D", a.getAfPrefix());
        assertTrue(a.isAfUnique());
        assertEquals(EnumSet.of(AllFileUsagesList.AfProp.IDS, AllFileUsagesList.AfProp.TITLE), a.getAfProp());
        assertEquals(20, a.getAfLimit());
        assertEquals(Dir.Order.DESCENDING, a.getAfDir());
    }

}