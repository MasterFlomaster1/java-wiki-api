package dev.masterflomaster1.jwa.request.list;

import dev.masterflomaster1.jwa.BaseApiTest;
import dev.masterflomaster1.jwa.Response;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.common.FilterRedir;
import dev.masterflomaster1.jwa.common.Namespace;
import dev.masterflomaster1.jwa.internal.UrlComparator;
import dev.masterflomaster1.jwa.request.action.QueryAction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.EnumSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class RandomListTest extends BaseApiTest {

    @Test
    @DisplayName("Return two random pages from the main namespace")
    void testExample1() throws IOException {
        var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .list(Set.of(
                                new RandomList.Builder()
                                        .rnNamespace(EnumSet.of(Namespace.ARTICLE))
                                        .rnLimit(2)
                                        .build()
                        ))
                        .build()
                )
                .build();

        assertTrue(UrlComparator.compareUrls(
                "https://en.wikipedia.org/w/api.php?action=query&format=json&list=random&formatversion=2&rnnamespace=0&rnlimit=2",
                a.getUrl()
        ));
    }

    @Test
    void testBuilder() {
        var a = new RandomList.Builder()
                .rnNamespace(EnumSet.of(Namespace.FILE))
                .rnFilterRedir(FilterRedir.NON_REDIRECTS)
                .rnLimit(19)
                .rnContinue("cont")
                .build();

        assertEquals(EnumSet.of(Namespace.FILE), a.getRnNamespace());
        assertEquals(FilterRedir.NON_REDIRECTS, a.getRnFilterRedir());
        assertEquals(19, a.getRnLimit());
        assertEquals("cont", a.getRnContinue());
    }

}