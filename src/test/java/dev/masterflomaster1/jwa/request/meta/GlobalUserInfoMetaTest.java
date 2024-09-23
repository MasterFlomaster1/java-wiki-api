package dev.masterflomaster1.jwa.request.meta;

import dev.masterflomaster1.jwa.BaseApiTest;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.internal.UrlComparator;
import dev.masterflomaster1.jwa.request.action.QueryAction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EnumSet;
import java.util.Set;

import static dev.masterflomaster1.jwa.request.meta.GlobalUserInfoMeta.GuiProp.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeFalse;

class GlobalUserInfoMetaTest extends BaseApiTest {

    @Test
    @DisplayName("Get information about the current global user")
    void testExample1() {
        var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .meta(Set.of(
                                new GlobalUserInfoMeta.Builder()
                                        .build()
                        ))
                        .build()
                )
                .build();

        assertTrue(UrlComparator.compareUrls(
                "https://en.wikipedia.org/w/api.php?action=query&format=json&meta=globaluserinfo&formatversion=2",
                a.getUrl()
        ));

    }

    @Test
    @DisplayName("Get information about global user Example")
    void testExample2() {
        var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .meta(Set.of(
                                new GlobalUserInfoMeta.Builder()
                                        .guiUser("Example")
                                        .guiProp(EnumSet.of(GROUPS, MERGED, UNATTACHED))
                                        .build()
                        ))
                        .build()
                )
                .build();

        assertTrue(UrlComparator.compareUrls(
                "https://en.wikipedia.org/w/api.php?action=query&format=json&meta=globaluserinfo&formatversion=2&guiuser=Example&guiprop=groups%7Cmerged%7Cunattached",
                a.getUrl()
        ));
    }

    @Test
    void testBuilder() {
        var a = new GlobalUserInfoMeta.Builder()
                .guiUser("Example")
                .guiId(323)
                .guiProp(EnumSet.of(GROUPS, MERGED, UNATTACHED))
                .build();

        assertEquals("Example", a.getGuiUser());
        assertEquals(323, a.getGuiId());
        assertEquals(EnumSet.of(GROUPS, MERGED, UNATTACHED), a.getGuiProp());
    }

}