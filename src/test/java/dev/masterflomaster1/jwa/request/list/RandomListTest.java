package dev.masterflomaster1.jwa.request.list;

import dev.masterflomaster1.jwa.Response;
import dev.masterflomaster1.jwa.WikiApi;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.common.FilterRedir;
import dev.masterflomaster1.jwa.common.Namespace;
import dev.masterflomaster1.jwa.request.action.QueryAction;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.EnumSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class RandomListTest {

    private static WikiApi api;

    @BeforeAll
    static void before() {
        api = new WikiApi();
    }

    @Test
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

        Response r = api.execute(a);

        assertNotNull(r.getQuery().getRandom());
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