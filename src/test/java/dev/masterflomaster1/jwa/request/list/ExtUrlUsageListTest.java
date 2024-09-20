package dev.masterflomaster1.jwa.request.list;

import dev.masterflomaster1.jwa.Response;
import dev.masterflomaster1.jwa.WikiApi;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.common.Namespace;
import dev.masterflomaster1.jwa.common.Protocol;
import dev.masterflomaster1.jwa.request.action.QueryAction;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.EnumSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ExtUrlUsageListTest {

    private static WikiApi api;

    @BeforeAll
    static void before() {
        api = new WikiApi();
    }

    @Test
    @DisplayName("how pages linking to https://www.mediawiki.org")
    void testExample1() throws IOException {
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

        Response r = api.execute(a);

        System.out.println(r.getQuery().getExturlusage());

        assertNotNull(r.getQuery().getExturlusage());
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