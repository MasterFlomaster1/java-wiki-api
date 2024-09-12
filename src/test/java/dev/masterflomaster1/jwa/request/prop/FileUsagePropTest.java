package dev.masterflomaster1.jwa.request.prop;

import dev.masterflomaster1.jwa.Response;
import dev.masterflomaster1.jwa.WikiApi;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.common.Namespace;
import dev.masterflomaster1.jwa.request.action.QueryAction;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.EnumSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class FileUsagePropTest {

    private static WikiApi api;

    @BeforeAll
    static void before() {
        api = new WikiApi();
    }

    @Test
    @DisplayName("Get a list of pages using File:Example.jpg.")
    void testExample1() throws IOException {
        var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .prop(Set.of(
                                new FileUsageProp.Builder()
                                        .build()
                                )
                        )
                        .titles(Set.of("File:Example.jpg"))
                        .build()
                )
                .build();

        Response r = api.execute(a);
        assertNotNull(r.getQuery().getPages().get(0).getFileUsage());
    }

    @Test
    void testBuilder() {
        var a = new FileUsageProp.Builder()
                .fuProp(EnumSet.of(FileUsageProp.FuProp.TITLE))
                .fuNamespace(EnumSet.of(Namespace.TEMPLATE))
                .fuShow(EnumSet.of(FileUsageProp.FuShow.REDIRECT))
                .fuLimit(40)
                .fuContinue("test")
                .build();

        assertEquals(EnumSet.of(FileUsageProp.FuProp.TITLE), a.getFuProp());
        assertEquals(EnumSet.of(Namespace.TEMPLATE), a.getFuNamespace());
        assertEquals(EnumSet.of(FileUsageProp.FuShow.REDIRECT), a.getFuShow());
        assertEquals(40, a.getFuLimit());
        assertEquals("test", a.getFuContinue());
    }

}