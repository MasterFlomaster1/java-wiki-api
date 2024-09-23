package dev.masterflomaster1.jwa.request.list;

import dev.masterflomaster1.jwa.BaseApiTest;
import dev.masterflomaster1.jwa.Response;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.common.Dir;
import dev.masterflomaster1.jwa.common.FilterRedir;
import dev.masterflomaster1.jwa.common.Namespace;
import dev.masterflomaster1.jwa.request.action.QueryAction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.EnumSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class BacklinksListTest extends BaseApiTest {

    @Test
    @DisplayName("Show links to Main Page")
    void testExample1() throws IOException {
        var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .list(Set.of(
                                new BacklinksList.Builder()
                                        .blTitle("Main Page")
                                        .build()
                        ))
                        .build()
                )
                .build();

        Response r = api.execute(a);

        assertNotNull(r.getQuery().getBacklinks());
    }

    @Test
    void testBuilder() {
        var a = new BacklinksList.Builder()
                .blTitle("Main Page")
                .blPageId(12345)
                .blContinue("demo")
                .blNamespace(EnumSet.of(Namespace.ARTICLE))
                .blDir(Dir.Order.DESCENDING)
                .blFilterRedir(FilterRedir.REDIRECTS)
                .blLimit(30)
                .blRedirect()
                .build();

        assertEquals("Main Page", a.getBlTitle());
        assertEquals(12345, a.getBlPageId());
        assertEquals("demo", a.getBlContinue());
        assertEquals(EnumSet.of(Namespace.ARTICLE), a.getBlNamespace());
        assertEquals(Dir.Order.DESCENDING, a.getBlDir());
        assertEquals(FilterRedir.REDIRECTS, a.getBlFilterRedir());
        assertEquals(30, a.getBlLimit());
        assertTrue(a.isBlRedirect());
    }

}