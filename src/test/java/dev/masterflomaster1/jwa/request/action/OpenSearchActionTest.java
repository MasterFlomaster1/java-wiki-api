package dev.masterflomaster1.jwa.request.action;

import dev.masterflomaster1.jwa.BaseApiTest;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.common.Namespace;
import dev.masterflomaster1.jwa.internal.UrlComparator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EnumSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class OpenSearchActionTest extends BaseApiTest {

    /**
     * NOTE: OpenSearchAction response not implemented yet
     */
    @Test
    @DisplayName("Find pages beginning with Te")
    void testExample1() {
        var a = new WikiApiRequest.Builder()
                .action(new OpenSearchAction.Builder()
                        .search("Te")
                        .build()
                )
                .build();

        assertTrue(UrlComparator.compareUrls(
                "https://en.wikipedia.org/w/api.php?action=opensearch&format=json&search=Te&formatversion=2",
                a.getUrl()
        ));
    }

    @Test
    void testBuilder() {
        var a = new OpenSearchAction.Builder()
                .search("Te")
                .namespace(EnumSet.of(Namespace.FILE))
                .limit(5)
                .profile(OpenSearchAction.Profile.CLASSIC)
                .redirects(OpenSearchAction.Redirects.RESOLVE)
                .format(OpenSearchAction.Format.JSON)
                .warningsAsError()
                .build();

        assertEquals("Te", a.getSearch());
        assertEquals(EnumSet.of(Namespace.FILE), a.getNamespace());
        assertEquals(5, a.getLimit());
        assertEquals(OpenSearchAction.Profile.CLASSIC, a.getProfile());
        assertEquals(OpenSearchAction.Redirects.RESOLVE, a.getRedirects());
        assertEquals(OpenSearchAction.Format.JSON, a.getFormat());
        assertTrue(a.isWarningsAsError());
    }

}