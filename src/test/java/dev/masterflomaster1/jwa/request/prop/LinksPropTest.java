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

import static org.junit.jupiter.api.Assertions.*;

class LinksPropTest extends BaseApiTest {

    @Test
    @DisplayName("Get links from the page Main Page")
    void testExample1() {
        var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .prop(Set.of(
                                new LinksProp.Builder()
                                        .build()
                        ))
                        .titles(Set.of("Main Page"))
                        .build()
                )
                .build();

        assertTrue(UrlComparator.compareUrls(
                "https://en.wikipedia.org/w/api.php?action=query&format=json&prop=links&titles=Main%20Page&formatversion=2",
                a.getUrl()
        ));
    }

    @Test
    @DisplayName("Get links from the page Main Page in the User and Template namespaces")
    void testExample2() {
        var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .prop(Set.of(
                                new LinksProp.Builder()
                                        .plNamespace(EnumSet.of(Namespace.USER, Namespace.TEMPLATE))
                                        .build()
                        ))
                        .titles(Set.of("Main Page"))
                        .build()
                )
                .build();

        assertTrue(UrlComparator.compareUrls(
                "https://en.wikipedia.org/w/api.php?action=query&format=json&prop=links&titles=Main%20Page&formatversion=2&plnamespace=2%7C10",
                a.getUrl()
        ));
    }

    @Test
    void testBuilder() {
        var a = new LinksProp.Builder()
                .plNamespace(EnumSet.of(Namespace.USER, Namespace.TEMPLATE))
                .plLimit(23)
                .plContinue("test")
                .plTitles(Set.of("A", "B", "C"))
                .plDir(Dir.Order.DESCENDING)
                .build();

        assertEquals(EnumSet.of(Namespace.USER, Namespace.TEMPLATE), a.getPlNamespace());
        assertEquals(23, a.getPlLimit());
        assertEquals("test", a.getPlContinue());
        assertEquals(Set.of("A", "B", "C"), a.getPlTitles());
        assertEquals(Dir.Order.DESCENDING, a.getPlDir());
    }

}