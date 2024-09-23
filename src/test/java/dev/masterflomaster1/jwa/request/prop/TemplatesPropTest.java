package dev.masterflomaster1.jwa.request.prop;

import dev.masterflomaster1.jwa.BaseApiTest;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.common.Dir;
import dev.masterflomaster1.jwa.common.Namespace;
import dev.masterflomaster1.jwa.internal.UrlComparator;
import dev.masterflomaster1.jwa.request.action.QueryAction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EnumSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TemplatesPropTest extends BaseApiTest {

    @Test
    @DisplayName("Get the templates used on the page Main Page")
    void testExample1() {
        var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .prop(Set.of(
                                new TemplatesProp.Builder()
                                        .build()
                        ))
                        .titles(Set.of("Main Page"))
                        .build()
                )
                .build();

        assertTrue(UrlComparator.compareUrls(
                "https://en.wikipedia.org/w/api.php?action=query&format=json&prop=templates&titles=Main%20Page&formatversion=2",
                a.getUrl()
        ));
    }

    @Test
    @DisplayName("Get pages in the User and Template namespaces that are transcluded on the page Main Page.")
    void testExample3() {
        var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .prop(Set.of(
                                new TemplatesProp.Builder()
                                        .tlNamespace(EnumSet.of(Namespace.USER, Namespace.TEMPLATE))
                                        .build()
                        ))
                        .titles(Set.of("Main Page"))
                        .build()
                )
                .build();

        assertTrue(UrlComparator.compareUrls(
                "https://en.wikipedia.org/w/api.php?action=query&format=json&prop=templates&titles=Main%20Page&formatversion=2&tlnamespace=2%7C10",
                a.getUrl()
        ));
    }

    @Test
    void testBuilder() {
        var a = new TemplatesProp.Builder()
                .tlNamespace(EnumSet.of(Namespace.USER, Namespace.TEMPLATE))
                .tlLimit(4)
                .tlContinue("15580374|10|Main_Page_interwikis")
                .tlTemplates(Set.of("Template:Flatlist"))
                .tlDir(Dir.Order.DESCENDING)
                .build();

        assertEquals(EnumSet.of(Namespace.USER, Namespace.TEMPLATE), a.getTlNamespace());
        assertEquals(4, a.getTlLimit());
        assertEquals("15580374|10|Main_Page_interwikis", a.getTlContinue());
        assertEquals(Set.of("Template:Flatlist"), a.getTlTemplates());
        assertEquals(Dir.Order.DESCENDING, a.getTlDir());
    }

}