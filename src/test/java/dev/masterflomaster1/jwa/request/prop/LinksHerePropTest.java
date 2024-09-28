package dev.masterflomaster1.jwa.request.prop;

import dev.masterflomaster1.jwa.BaseApiTest;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.common.Namespace;
import dev.masterflomaster1.jwa.common.Show;
import dev.masterflomaster1.jwa.internal.UrlComparator;
import dev.masterflomaster1.jwa.request.action.QueryAction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EnumSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class LinksHerePropTest extends BaseApiTest {

    @Test
    @DisplayName("Get a list of pages linking to the Main Page")
    void testExample1() {
        var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .prop(Set.of(
                                new LinksHereProp.Builder()
                                        .build()
                        ))
                        .titles(Set.of("Main Page"))
                        .build()
                )
                .build();

        assertTrue(UrlComparator.compareUrls(
                "https://en.wikipedia.org/w/api.php?action=query&format=json&prop=linkshere&titles=Main%20Page&formatversion=2",
                a.getUrl()
        ));
    }

    @Test
    void testBuilder() {
        var a = new LinksHereProp.Builder()
                .lhProp(EnumSet.of(LinksHereProp.LhProp.REDIRECT))
                .lhNamespace(EnumSet.of(Namespace.MEDIA))
                .lhShow(EnumSet.of(Show.Redirect.NOT_REDIRECT))
                .lhLimit(33)
                .lhContinue("test")
                .build();

        assertEquals(EnumSet.of(LinksHereProp.LhProp.REDIRECT), a.getLhProp());
        assertEquals(EnumSet.of(Namespace.MEDIA), a.getLhNamespace());
        assertEquals(EnumSet.of(Show.Redirect.NOT_REDIRECT), a.getLhShow());
        assertEquals(33, a.getLhLimit());
        assertEquals("test", a.getLhContinue());
    }

}