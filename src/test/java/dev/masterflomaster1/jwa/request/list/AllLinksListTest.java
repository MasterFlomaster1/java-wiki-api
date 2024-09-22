package dev.masterflomaster1.jwa.request.list;

import dev.masterflomaster1.jwa.Response;
import dev.masterflomaster1.jwa.WikiApi;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.common.Dir;
import dev.masterflomaster1.jwa.common.Namespace;
import dev.masterflomaster1.jwa.request.action.QueryAction;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.EnumSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class AllLinksListTest {

    private static WikiApi api;

    @BeforeAll
    static void before() {
        api = new WikiApi();
    }

    @Test
    @DisplayName("List linked titles, including missing ones, with page IDs they are from, starting at B")
    void testExample1() throws IOException {
        var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .list(Set.of(
                                new AllLinksList.Builder()
                                        .alFrom("B")
                                        .alProp(EnumSet.of(AllLinksList.AlProp.IDS, AllLinksList.AlProp.TITLE))
                                        .build()
                        ))
                        .build()
                )
                .build();

        Response r = api.execute(a);

        System.out.println(r.getQuery().getAllLinks());

        assertNotNull(r.getQuery().getAllLinks());
    }

    @Test
    void testBuilder() {
        var a = new AllLinksList.Builder()
                .alContinue("test")
                .alFrom("A")
                .alTo("B")
                .prefix("CD")
                .alUnique()
                .alProp(EnumSet.of(AllLinksList.AlProp.IDS))
                .alNamespace(EnumSet.of(Namespace.ARTICLE))
                .alLimit(24)
                .alDir(Dir.Order.ASCENDING)
                .build();

        assertEquals("test", a.getAlContinue());
        assertEquals("A", a.getAlFrom());
        assertEquals("B", a.getAlTo());
        assertEquals("CD", a.getPrefix());
        assertTrue(a.isAlUnique());
        assertEquals(EnumSet.of(AllLinksList.AlProp.IDS), a.getAlProp());
        assertEquals(EnumSet.of(Namespace.ARTICLE), a.getAlNamespace());
        assertEquals(24, a.getAlLimit());
        assertEquals(Dir.Order.ASCENDING, a.getAlDir());
    }

}