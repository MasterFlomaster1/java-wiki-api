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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FileUsagePropTest extends BaseApiTest {

    @Test
    @DisplayName("Get a list of pages using File:Example.jpg")
    void testExample1() {
        var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .prop(Set.of(
                                new FileUsageProp.Builder()
                                        .build()
                        ))
                        .titles(Set.of("File:Example.jpg"))
                        .build()
                )
                .build();

        assertTrue(UrlComparator.compareUrls(
                "https://en.wikipedia.org/w/api.php?action=query&format=json&prop=fileusage&titles=File%3AExample.jpg&formatversion=2",
                a.getUrl()
        ));
    }

    @Test
    void testBuilder() {
        var a = new FileUsageProp.Builder()
                .fuProp(EnumSet.of(FileUsageProp.FuProp.TITLE))
                .fuNamespace(EnumSet.of(Namespace.TEMPLATE))
                .fuShow(EnumSet.of(Show.Redirect.REDIRECT))
                .fuLimit(40)
                .fuContinue("test")
                .build();

        assertEquals(EnumSet.of(FileUsageProp.FuProp.TITLE), a.getFuProp());
        assertEquals(EnumSet.of(Namespace.TEMPLATE), a.getFuNamespace());
        assertEquals(EnumSet.of(Show.Redirect.REDIRECT), a.getFuShow());
        assertEquals(40, a.getFuLimit());
        assertEquals("test", a.getFuContinue());
    }

}