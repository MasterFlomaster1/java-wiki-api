package dev.masterflomaster1.jwa.request.prop;

import dev.masterflomaster1.jwa.BaseApiTest;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.common.Namespace;
import dev.masterflomaster1.jwa.internal.UrlComparator;
import dev.masterflomaster1.jwa.request.action.QueryAction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EnumSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class GlobalUsagePropTest extends BaseApiTest {

    @Test
    @DisplayName("Get usage of File:Example.jpg")
    void testExample1() {
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

        assertTrue(UrlComparator.compareUrls(
                "https://en.wikipedia.org/w/api.php?action=query&format=json&prop=globalusage&titles=File%3AExample.jpg&formatversion=2",
                a.getUrl()
        ));
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