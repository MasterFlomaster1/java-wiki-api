package dev.masterflomaster1.jwa.request.meta;

import dev.masterflomaster1.jwa.BaseApiTest;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.internal.UrlComparator;
import dev.masterflomaster1.jwa.request.action.QueryAction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EnumSet;
import java.util.Set;

import static dev.masterflomaster1.jwa.request.meta.UserInfoMeta.UiProp.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UserInfoMetaTest extends BaseApiTest {

    @Test
    @DisplayName("Get information about the current user")
    void testExample1() {
        var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .meta(Set.of(
                                new UserInfoMeta.Builder()
                                        .build()
                        ))
                        .build()
                )
                .build();

        assertTrue(UrlComparator.compareUrls(
                "https://en.wikipedia.org/w/api.php?action=query&format=json&meta=userinfo&formatversion=2",
                a.getUrl()
        ));
    }

    @Test
    @DisplayName("Get additional information about the current user")
    void testExample2() {
        var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .meta(Set.of(
                                new UserInfoMeta.Builder()
                                        .uiProp(EnumSet.of(BLOCK_INFO, GROUPS, RIGHTS, HAS_MSG))
                                        .build()
                        ))
                        .build()
                )
                .build();

        assertTrue(UrlComparator.compareUrls(
                "https://en.wikipedia.org/w/api.php?action=query&format=json&meta=userinfo&formatversion=2&uiprop=blockinfo%7Cgroups%7Crights%7Chasmsg",
                a.getUrl()
        ));
    }

    @Test
    void testBuilder() {
        var a = new UserInfoMeta.Builder()
                .uiProp(EnumSet.of(BLOCK_INFO, UserInfoMeta.UiProp.GROUPS))
                .uiAttachedWiki("test")
                .build();

        assertEquals(EnumSet.of(BLOCK_INFO, UserInfoMeta.UiProp.GROUPS), a.getUiProp());
        assertEquals("test", a.getUiAttachedWiki());
    }

}