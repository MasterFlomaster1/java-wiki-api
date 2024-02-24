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

import static dev.masterflomaster1.jwa.request.meta.GlobalUserInfoMeta.GuiProp.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assumptions.assumeFalse;

class GlobalUserInfoMetaTest {

    private static WikiApi api;

    @BeforeAll
    static void before() {
        api = new WikiApi();
    }

    @Test
    @DisplayName("Get information about the current global user")
    void testExample1() throws WikiApiSyntaxException, IOException {
        var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .meta(Set.of(
                                new GlobalUserInfoMeta.Builder()
                                        .build()
                        ))
                        .build()
                )
                .build();

        Response r = api.execute(a);

        assumeFalse(r.getError() != null && r.getError().getCode().equals("invaliduser"), "Not logged in, skipping");
        assertNotNull(r.getQuery().getGlobalUserInfo());

    }

    @Test
    @DisplayName("Get information about global user Example")
    void testExample2() throws WikiApiSyntaxException, IOException {
        var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .meta(Set.of(
                                new GlobalUserInfoMeta.Builder()
                                        .guiUser("Example")
                                        .guiProp(Set.of(GROUPS, MERGED, UNATTACHED))
                                        .build()
                        ))
                        .build()
                )
                .build();

        Response r = api.execute(a);
        assertNotNull(r.getQuery().getGlobalUserInfo());
    }

    @Test
    void testBuilder() {
        var a = new GlobalUserInfoMeta.Builder()
                .guiUser("Example")
                .guiId(323)
                .guiProp(Set.of(GROUPS, MERGED, UNATTACHED))
                .build();

        assertEquals("Example", a.getGuiUser());
        assertEquals(323, a.getGuiId());
        assertEquals(Set.of(GROUPS, MERGED, UNATTACHED), a.getGuiProp());
    }

}