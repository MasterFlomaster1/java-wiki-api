package dev.masterflomaster1.jwa.request.action;

import dev.masterflomaster1.jwa.Response;
import dev.masterflomaster1.jwa.WikiApi;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.WikiApiSyntaxException;
import dev.masterflomaster1.jwa.common.Namespace;
import dev.masterflomaster1.jwa.common.Tags;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeFalse;

class BlockActionTest {

    private static WikiApi api;

    @BeforeAll
    static void before() {
        api = new WikiApi();
    }

    @Test
    @DisplayName("Block IP address 192.0.2.5 for three days with a reason.")
    void testExample1() throws WikiApiSyntaxException, IOException {
        var a = new WikiApiRequest.Builder()
                .action(new BlockAction.Builder()
                        .user("192.0.2.5")
                        .expiry("3 days")
                        .reason("First strike")
                        .token(Shared.tokens().getCsrfToken())
                        .build()
                )
                .build();

        Response r = api.execute(a);

        assumeFalse(r.getError() != null && r.getError().getCode().equals("permissiondenied"), "Permission denied, skipping");
        assertNotNull(r.getBlock());
    }

    @Test
    @DisplayName("Block user Vandal indefinitely with a reason, and prevent new account creation and email sending.")
    void testExample2() throws WikiApiSyntaxException, IOException {
        var a = new WikiApiRequest.Builder()
                .action(new BlockAction.Builder()
                        .user("Vandal")
                        .expiry("never")
                        .reason("Vandalism")
                        .noCreate()
                        .autoBlock()
                        .noEmail()
                        .token(Shared.tokens().getCsrfToken())
                        .build()
                )
                .build();

        Response r = api.execute(a);

        assumeFalse(r.getError() != null && r.getError().getCode().equals("permissiondenied"), "Permission denied, skipping");
        assertNotNull(r.getBlock());

    }

    @Test
    void testBuilder() throws WikiApiSyntaxException {
        var a = new BlockAction.Builder()
                .user("Name")
                .expiry("2014-09-18T12:34:56Z")
                .reason("Vandalism")
                .anonOnly()
                .noCreate()
                .autoBlock()
                .noEmail()
                .hideName()
                .allowUserTalk()
                .reBlock()
                .watchUser()
                .watchlistExpiry("test")
                .tags(Set.of(Tags.CONVENIENT_DISCUSSIONS, Tags.REPEATING_CHARACTERS))
                .partial()
                .pageRestrictions(Set.of("Java_(programming_language)"))
                .namespaceRestrictions(Set.of(Namespace.TALK))
                .token("token")
                .build();

        assertEquals("Name", a.getUser());
        assertEquals("2014-09-18T12:34:56Z", a.getExpiry());
        assertEquals("Vandalism", a.getReason());
        assertTrue(a.isAnonOnly());
        assertTrue(a.isNoCreate());
        assertTrue(a.isAutoBlock());
        assertTrue(a.isNoEmail());
        assertTrue(a.isHideName());
        assertTrue(a.isAllowUserTalk());
        assertTrue(a.isReBlock());
        assertTrue(a.isWatchUser());
        assertEquals("test", a.getWatchlistExpiry());
        assertEquals(Set.of(Tags.CONVENIENT_DISCUSSIONS, Tags.REPEATING_CHARACTERS), a.getTags());
        assertTrue(a.isPartial());
        assertEquals(Set.of("Java_(programming_language)"), a.getPageRestrictions());
        assertEquals(Set.of(Namespace.TALK), a.getNamespaceRestrictions());
        assertEquals("token", a.getToken());
    }
}