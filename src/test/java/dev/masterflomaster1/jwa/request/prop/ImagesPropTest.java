package dev.masterflomaster1.jwa.request.prop;

import dev.masterflomaster1.jwa.BaseApiTest;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.common.Dir;
import dev.masterflomaster1.jwa.internal.UrlComparator;
import dev.masterflomaster1.jwa.request.action.QueryAction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ImagesPropTest extends BaseApiTest {

    @Test
    @DisplayName("Get a list of files used on the page Main Page")
    void testExample1() {
        var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .prop(Set.of(
                                new ImagesProp.Builder()
                                        .build()
                        ))
                        .titles(Set.of("Main Page"))
                        .build()
                )
                .build();

        assertTrue(UrlComparator.compareUrls(
                "https://en.wikipedia.org/w/api.php?action=query&format=json&prop=images&titles=Main%20Page&formatversion=2",
                a.getUrl()
        ));
    }

    @Test
    void testBuilder() {
        var a = new ImagesProp.Builder()
                .imLimit(50)
                .imContinue("15580374|Wikibooks-logo.svg")
                .imImages(Set.of("File:MediaWiki-2020-icon.svg"))
                .imDir(Dir.Order.DESCENDING)
                .build();

        assertEquals(50, a.getImLimit());
        assertEquals("15580374|Wikibooks-logo.svg", a.getImContinue());
        assertEquals(Set.of("File:MediaWiki-2020-icon.svg"), a.getImImages());
        assertEquals(Dir.Order.DESCENDING, a.getImDir());
    }

}