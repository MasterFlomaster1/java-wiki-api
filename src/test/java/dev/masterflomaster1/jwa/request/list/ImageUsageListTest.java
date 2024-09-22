package dev.masterflomaster1.jwa.request.list;

import dev.masterflomaster1.jwa.Response;
import dev.masterflomaster1.jwa.WikiApi;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.common.Dir;
import dev.masterflomaster1.jwa.common.FilterRedir;
import dev.masterflomaster1.jwa.common.Namespace;
import dev.masterflomaster1.jwa.request.action.QueryAction;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.EnumSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ImageUsageListTest {

    private static WikiApi api;

    @BeforeAll
    static void before() {
        api = new WikiApi();
    }

    @Test
    @DisplayName("Show pages using File:Albert Einstein Head.jpg")
    void testExample1() throws IOException {
        var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .list(Set.of(
                                new ImageUsageList.Builder()
                                        .iuTitle("File:Albert Einstein Head.jpg")
                                        .build()
                        ))
                        .build()
                )
                .build();

        Response r = api.execute(a);

        System.out.println(r.getQuery().getImageUsage());

        assertNotNull(r.getQuery().getImageUsage());
    }

    @Test
    void testBuilder() {
        var a = new ImageUsageList.Builder()
                .iuTitle("Demo")
                .iuPageId(2222)
                .iuContinue("test")
                .iuNamespace(EnumSet.of(Namespace.FILE))
                .iuDir(Dir.Order.DESCENDING)
                .iuFilterRedir(FilterRedir.ALL)
                .iuLimit(42)
                .iuRedirect()
                .build();

        assertEquals("Demo", a.getIuTitle());
        assertEquals(2222, a.getIuPageId());
        assertEquals("test", a.getIuContinue());
        assertEquals(EnumSet.of(Namespace.FILE), a.getIuNamespace());
        assertEquals(Dir.Order.DESCENDING, a.getIuDir());
        assertEquals(FilterRedir.ALL, a.getIuFilterRedir());
        assertEquals(42, a.getIuLimit());
        assertTrue(a.isIuRedirect());
    }

}