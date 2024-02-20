package dev.masterflomaster1.jwa.model.prop;

import com.google.gson.Gson;
import dev.masterflomaster1.jwa.Response;
import dev.masterflomaster1.jwa.WikiApi;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.WikiApiSyntaxException;
import dev.masterflomaster1.jwa.common.Namespace;
import dev.masterflomaster1.jwa.model.action.QueryAction;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class GlobalUsagePropTest {

    private static WikiApi api;
    private static Gson gson;

    @BeforeAll
    static void before() {
        api = new WikiApi();
        gson = new Gson();
    }

    @Test
    @DisplayName("Get usage of File:Example.jpg")
    void testExample1() throws WikiApiSyntaxException, IOException, InterruptedException {
        var a = new WikiApiRequest.Builder()
                .action(
                        new QueryAction.Builder()
                                .prop(Set.of(
                                        new GlobalUsageProp.Builder()
                                                .build()
                                        )
                                )
                                .titles(Set.of("File:Example.jpg"))
                                .build()
                )
                .build();

        Response r = gson.fromJson(api.execute(a), Response.class);

        assertNotNull(r.getQuery().getPages().get(0).getGlobalUsage());
    }

    @Test
    void testBuilder() {
        var a = new GlobalUsageProp.Builder()
                .guProp(Set.of(GlobalUsageProp.GuProp.URL, GlobalUsageProp.GuProp.PAGE_ID))
                .guLimit(40)
                .guNamespace(Set.of(Namespace.TEMPLATE, Namespace.FILE_TALK))
                .guContinue("Example.jpg|amwiki|10356")
                .guFilterLocal()
                .build();

        assertEquals(Set.of(GlobalUsageProp.GuProp.URL, GlobalUsageProp.GuProp.PAGE_ID), a.getGuProp());
        assertEquals(40, a.getGuLimit());
        assertEquals(Set.of(Namespace.TEMPLATE, Namespace.FILE_TALK), a.getGuNamespace());
        assertEquals("Example.jpg|amwiki|10356", a.getGuContinue());
        assertTrue(a.isGuFilterLocal());
    }

}