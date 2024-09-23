package dev.masterflomaster1.jwa.request.list;

import dev.masterflomaster1.jwa.BaseApiTest;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.common.Namespace;
import dev.masterflomaster1.jwa.common.Protocol;
import dev.masterflomaster1.jwa.internal.UrlComparator;
import dev.masterflomaster1.jwa.request.action.QueryAction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EnumSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ExtUrlUsageListTest extends BaseApiTest {

    @Test
    @DisplayName("Show pages linking to https://www.mediawiki.org")
    void testExample1() {
        var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .list(Set.of(
                                new ExtUrlUsageList.Builder()
                                        .euQuery("www.mediawiki.org")
                                        .build()
                        ))
                        .build()
                )
                .build();

        assertTrue(UrlComparator.compareUrls(
                "https://en.wikipedia.org/w/api.php?action=query&format=json&list=exturlusage&formatversion=2&euquery=www.mediawiki.org",
                a.getUrl()
        ));
    }

    @Test
    void testBuilder() {
        var a = new ExtUrlUsageList.Builder()
                .euProp(EnumSet.of(ExtUrlUsageList.EuProp.TITLE))
                .euContinue("test")
                .euProtocol(Protocol.GEO)
                .euQuery("demo")
                .euNamespace(EnumSet.of(Namespace.FILE))
                .euLimit(23)
                .build();

        assertEquals(EnumSet.of(ExtUrlUsageList.EuProp.TITLE), a.getEuProp());
        assertEquals("test", a.getEuContinue());
        assertEquals(Protocol.GEO, a.getEuProtocol());
        assertEquals("demo", a.getEuQuery());
        assertEquals(EnumSet.of(Namespace.FILE), a.getEuNamespace());
        assertEquals(23, a.getEuLimit());

    }

}