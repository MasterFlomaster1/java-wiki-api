package dev.masterflomaster1.jwa.model.prop;

import com.google.gson.Gson;
import dev.masterflomaster1.jwa.Response;
import dev.masterflomaster1.jwa.WikiApi;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.WikiApiSyntaxException;
import dev.masterflomaster1.jwa.common.Dir;
import dev.masterflomaster1.jwa.common.Namespace;
import dev.masterflomaster1.jwa.model.action.QueryAction;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class TemplatesPropTest {

    private static WikiApi api;
    private static Gson gson;

    @BeforeAll
    static void before() {
        api = new WikiApi();
        gson = new Gson();
    }

    @Test
    @DisplayName("Get the templates used on the page Main Page.")
    void testExample1() throws WikiApiSyntaxException, IOException, InterruptedException {
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

        Response r = gson.fromJson(api.execute(a), Response.class);
        assertNotNull(r.getQuery().getPages().get(0).getTemplates());
    }

    void testExample2() {

    }

    @Test
    @DisplayName("Get pages in the User and Template namespaces that are transcluded on the page Main Page.")
    void testExample3() throws WikiApiSyntaxException, IOException, InterruptedException {
        var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .prop(Set.of(
                                        new TemplatesProp.Builder()
                                                .tlNamespace(Set.of(Namespace.USER, Namespace.TEMPLATE))
                                                .build()
                                )
                        )
                        .titles(Set.of("Main Page"))
                        .build()
                )
                .build();

        Response r = gson.fromJson(api.execute(a), Response.class);
        assertNotNull(r.getQuery().getPages().get(0).getTemplates());
    }

    @Test
    void getTlNamespace() {
        var a = new TemplatesProp.Builder()
                .tlNamespace(Set.of(Namespace.USER, Namespace.TEMPLATE))
                .build();

        assertEquals(Set.of(Namespace.USER, Namespace.TEMPLATE), a.getTlNamespace());
    }

    @Test
    void getTlLimit() {
        var a = new TemplatesProp.Builder()
                .tlLimit(4)
                .build();

        assertEquals(4, a.getTlLimit());
    }

    @Test
    void getTlContinue() {
        var a = new TemplatesProp.Builder()
                .tlContinue("15580374|10|Main_Page_interwikis")
                .build();

        assertEquals("15580374|10|Main_Page_interwikis", a.getTlContinue());
    }

    @Test
    void getTlTemplates() {
        var a = new TemplatesProp.Builder()
                .tlTemplates(Set.of("Template:Flatlist"))
                .build();

        assertEquals(Set.of("Template:Flatlist"), a.getTlTemplates());
    }

    @Test
    void getTlDir() {
        var a = new TemplatesProp.Builder()
                .tlDir(Dir.DESCENDING)
                .build();

        assertEquals(Dir.DESCENDING, a.getTlDir());
    }
}