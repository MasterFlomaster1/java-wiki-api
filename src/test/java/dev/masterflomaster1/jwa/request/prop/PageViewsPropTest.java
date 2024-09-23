package dev.masterflomaster1.jwa.request.prop;

import dev.masterflomaster1.jwa.BaseApiTest;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.internal.UrlComparator;
import dev.masterflomaster1.jwa.request.action.QueryAction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PageViewsPropTest extends BaseApiTest {

    @Test
    @DisplayName("Show pageview statistics for the main page")
    void testExample1() {
        var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .prop(Set.of(
                                new PageViewsProp.Builder()
                                        .build()
                        ))
                        .titles(Set.of("Main_Page"))
                        .build()
                )
                .build();

        assertTrue(UrlComparator.compareUrls(
                "https://en.wikipedia.org/w/api.php?action=query&format=json&prop=pageviews&titles=Main_Page&formatversion=2",
                a.getUrl()
        ));
    }

    @Test
    void testBuilder() {
        var a = new PageViewsProp.Builder()
                .pvIpDays(50)
                .pvIpContinue("test")
                .build();

        assertEquals(50, a.getPvIpDays());
        assertEquals("test", a.getPvIpContinue());
    }

}