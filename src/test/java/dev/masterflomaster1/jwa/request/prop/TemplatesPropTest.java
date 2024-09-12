package dev.masterflomaster1.jwa.request.prop;

import dev.masterflomaster1.jwa.Response;
import dev.masterflomaster1.jwa.WikiApi;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.common.Dir;
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

class TemplatesPropTest {

    private static WikiApi api;

    @BeforeAll
    static void before() {
        api = new WikiApi();
    }

    @Test
    @DisplayName("Get the templates used on the page Main Page.")
    void testExample1() throws IOException {
        var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .prop(Set.of(
                                new TemplatesProp.Builder()
                                        .build()
                                )
                        )
                        .titles(Set.of("Main Page"))
                        .build()
                )
                .build();

        Response r = api.execute(a);
        assertNotNull(r.getQuery().getPages().get(0).getTemplates());
    }

    @Test
    @DisplayName("Get pages in the User and Template namespaces that are transcluded on the page Main Page.")
    void testExample3() throws IOException {
        var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .prop(Set.of(
                                new TemplatesProp.Builder()
                                        .tlNamespace(EnumSet.of(Namespace.USER, Namespace.TEMPLATE))
                                        .build()
                                )
                        )
                        .titles(Set.of("Main Page"))
                        .build()
                )
                .build();

        Response r = api.execute(a);
        assertNotNull(r.getQuery().getPages().get(0).getTemplates());
    }

    @Test
    void testBuilder() {
        var a = new TemplatesProp.Builder()
                .tlNamespace(EnumSet.of(Namespace.USER, Namespace.TEMPLATE))
                .tlLimit(4)
                .tlContinue("15580374|10|Main_Page_interwikis")
                .tlTemplates(Set.of("Template:Flatlist"))
                .tlDir(Dir.DESCENDING)
                .build();

        assertEquals(EnumSet.of(Namespace.USER, Namespace.TEMPLATE), a.getTlNamespace());
        assertEquals(4, a.getTlLimit());
        assertEquals("15580374|10|Main_Page_interwikis", a.getTlContinue());
        assertEquals(Set.of("Template:Flatlist"), a.getTlTemplates());
        assertEquals(Dir.DESCENDING, a.getTlDir());
    }

}