package dev.masterflomaster1.jwa.request.list;

import dev.masterflomaster1.jwa.BaseApiTest;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.internal.UrlComparator;
import dev.masterflomaster1.jwa.request.action.QueryAction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EnumSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class UsersListTest extends BaseApiTest {

    @Test
    @DisplayName("Return information for user Example")
    void testExample1() {
        var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .list(Set.of(
                                new UsersList.Builder()
                                        .usProp(EnumSet.of(
                                                UsersList.UsProp.GROUPS,
                                                UsersList.UsProp.EDIT_COUNT,
                                                UsersList.UsProp.GENDER
                                        ))
                                        .usUsers(Set.of("Example"))
                                        .build()
                        ))
                        .build()
                )
                .build();

        assertTrue(UrlComparator.compareUrls(
                "https://en.wikipedia.org/w/api.php?action=query&format=json&list=users&formatversion=2&usprop=groups%7Ceditcount%7Cgender&ususers=Example",
                a.getUrl()
        ));
    }

    @Test
    void testBuilder() {
        var a = new UsersList.Builder()
                .usProp(EnumSet.of(UsersList.UsProp.GROUPS))
                .usAttachedWiki("id")
                .usUsers(Set.of("Example"))
                .usUserIds(Set.of(2222))
                .build();

        assertEquals(EnumSet.of(UsersList.UsProp.GROUPS), a.getUsProp());
        assertEquals("id", a.getUsAttachedWiki());
        assertEquals(Set.of("Example"), a.getUsUsers());
        assertEquals(Set.of(2222), a.getUsUserIds());
    }

}