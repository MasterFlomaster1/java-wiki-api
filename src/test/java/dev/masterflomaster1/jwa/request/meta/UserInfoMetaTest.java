package dev.masterflomaster1.jwa.request.meta;

import dev.masterflomaster1.jwa.BaseApiTest;
import dev.masterflomaster1.jwa.Response;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.request.action.QueryAction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.EnumSet;
import java.util.Set;

import static dev.masterflomaster1.jwa.request.meta.UserInfoMeta.UiProp.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class UserInfoMetaTest extends BaseApiTest {

    @Test
    @DisplayName("Get information about the current user.")
    void testExample1() throws IOException {
        var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .meta(Set.of(
                                new UserInfoMeta.Builder()
                                        .build()
                        ))
                        .build()
                )
                .build();

        Response r = api.execute(a);
        assertNotNull(r.getQuery().getUserInfo());
    }

    @Test
    @DisplayName("Get additional information about the current user.")
    void testExample2() throws IOException {
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

        Response r = api.execute(a);
        assertNotNull(r.getQuery().getUserInfo());
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