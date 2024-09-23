package dev.masterflomaster1.jwa.request.action;

import dev.masterflomaster1.jwa.BaseApiTest;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.common.Namespace;
import dev.masterflomaster1.jwa.common.Tags;
import dev.masterflomaster1.jwa.internal.UrlComparator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EnumSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeFalse;

class BlockActionTest extends BaseApiTest {

    @Test
    @DisplayName("Block IP address 192.0.2.5 for three days with a reason")
    void testExample1() {
        var a = new WikiApiRequest.Builder()
                .action(new BlockAction.Builder()
                        .user("192.0.2.5")
                        .expiry("3 days")
                        .reason("First strike")
                        .token("+\\")
                        .build()
                )
                .build();

        assertTrue(UrlComparator.compareUrls(
                "https://en.wikipedia.org/w/api.php?action=block&format=json&user=192.0.2.5&expiry=3%20days&reason=First%20strike&token=%2B%5C&formatversion=2",
                a.getUrl()
        ));
    }

    @Test
    @DisplayName("Block user Vandal indefinitely with a reason, and prevent new account creation and email sending")
    void testExample2() {
        var a = new WikiApiRequest.Builder()
                .action(new BlockAction.Builder()
                        .user("Vandal")
                        .expiry("never")
                        .reason("Vandalism")
                        .noCreate()
                        .autoBlock()
                        .noEmail()
                        .token("+\\")
                        .build()
                )
                .build();

        assertTrue(UrlComparator.compareUrls(
                "https://en.wikipedia.org/w/api.php?action=block&format=json&user=Vandal&expiry=never&reason=Vandalism&nocreate=1&autoblock=1&noemail=1&token=%2B%5C&formatversion=2",
                a.getUrl()
        ));

    }

    @Test
    void testBuilder() {
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
                .tags(EnumSet.of(Tags.CONVENIENT_DISCUSSIONS, Tags.REPEATING_CHARACTERS))
                .partial()
                .pageRestrictions(Set.of("Java_(programming_language)"))
                .namespaceRestrictions(EnumSet.of(Namespace.TALK))
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