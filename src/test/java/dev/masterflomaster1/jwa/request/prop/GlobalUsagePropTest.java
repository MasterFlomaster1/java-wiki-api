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

import static org.junit.jupiter.api.Assertions.*;

class GlobalUsagePropTest {

    private static WikiApi api;

    @BeforeAll
    static void before() {
        api = new WikiApi();
    }

    @Test
    @DisplayName("Get usage of File:Example.jpg")
    void testExample1() throws IOException {
        var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .prop(Set.of(
                                new GlobalUsageProp.Builder()
                                        .build()
                                )
                        )
                        .titles(Set.of("File:Example.jpg"))
                        .build()
                )
                .build();

        Response r = api.execute(a);

        assertNotNull(r.getQuery().getPages().get(0).getGlobalUsage());
    }

    @Test
    void testBuilder() {
        var a = new GlobalUsageProp.Builder()
                .guProp(EnumSet.of(GlobalUsageProp.GuProp.URL, GlobalUsageProp.GuProp.PAGE_ID))
                .guLimit(40)
                .guNamespace(EnumSet.of(Namespace.TEMPLATE, Namespace.FILE_TALK))
                .guContinue("Example.jpg|amwiki|10356")
                .guFilterLocal()
                .build();

        assertEquals(EnumSet.of(GlobalUsageProp.GuProp.URL, GlobalUsageProp.GuProp.PAGE_ID), a.getGuProp());
        assertEquals(40, a.getGuLimit());
        assertEquals(EnumSet.of(Namespace.TEMPLATE, Namespace.FILE_TALK), a.getGuNamespace());
        assertEquals("Example.jpg|amwiki|10356", a.getGuContinue());
        assertTrue(a.isGuFilterLocal());
    }

}