package dev.masterflomaster1.jwa.request.list;

import dev.masterflomaster1.jwa.Response;
import dev.masterflomaster1.jwa.WikiApi;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.request.action.QueryAction;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class UsersListTest {

    private static WikiApi api;

    @BeforeAll
    static void before() {
        api = new WikiApi();
    }

    @Test
    @DisplayName("Return information for user Example.")
    void testExample1() throws IOException {
        var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .list(Set.of(
                                new UsersList.Builder()
                                        .usProp(Set.of(
                                                UsersList.UsProp.GROUPS,
                                                UsersList.UsProp.EDIT_COUNT,
                                                UsersList.UsProp.GENDER
                                        ))
                                        .usUsers(Set.of("Example"))
                                        .build()
                                )
                        )
                        .build()
                )
                .build();

        Response r = api.execute(a);

        assertTrue(r.getBatchComplete());
        assertNotNull(r.getQuery().getUsers());
    }

    @Test
    void testBuilder() {
        var a = new UsersList.Builder()
                .usProp(Set.of(UsersList.UsProp.GROUPS))
                .usAttachedWiki("id")
                .usUsers(Set.of("Example"))
                .usUserIds(Set.of(2222))
                .build();

        assertEquals(Set.of(UsersList.UsProp.GROUPS), a.getUsProp());
        assertEquals("id", a.getUsAttachedWiki());
        assertEquals(Set.of("Example"), a.getUsUsers());
        assertEquals(Set.of(2222), a.getUsUserIds());
    }

}