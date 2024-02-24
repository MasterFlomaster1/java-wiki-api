package dev.masterflomaster1.jwa.request.meta;

import dev.masterflomaster1.jwa.Response;
import dev.masterflomaster1.jwa.WikiApi;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.WikiApiSyntaxException;
import dev.masterflomaster1.jwa.request.action.QueryAction;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Set;

import static dev.masterflomaster1.jwa.request.meta.UserInfoMeta.UiProp.*;
import static org.junit.jupiter.api.Assertions.*;

class UserInfoMetaTest {

    private static WikiApi api;

    @BeforeAll
    static void before() {
        api = new WikiApi();
    }

    @Test
    @DisplayName("Get information about the current user.")
    void testExample1() throws WikiApiSyntaxException, IOException {
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
    void testExample2() throws WikiApiSyntaxException, IOException {
        var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .meta(Set.of(
                                new UserInfoMeta.Builder()
                                        .uiProp(Set.of(BLOCK_INFO, GROUPS, RIGHTS, HAS_MSG))
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
                .uiProp(Set.of(BLOCK_INFO, UserInfoMeta.UiProp.GROUPS))
                .uiAttachedWiki("test")
                .build();

        assertEquals(Set.of(BLOCK_INFO, UserInfoMeta.UiProp.GROUPS), a.getUiProp());
        assertEquals("test", a.getUiAttachedWiki());
    }

}