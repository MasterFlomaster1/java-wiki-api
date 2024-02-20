package dev.masterflomaster1.jwa.model.list;

import com.google.gson.Gson;
import dev.masterflomaster1.jwa.Response;
import dev.masterflomaster1.jwa.WikiApi;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.WikiApiSyntaxException;
import dev.masterflomaster1.jwa.model.action.QueryAction;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class UsersListTest {

    private static WikiApi api;
    private static Gson gson;

    @BeforeAll
    static void before() {
        api = new WikiApi();
        gson = new Gson();
    }

    @Test
    @DisplayName("Return information for user Example.")
    void testExample1() throws WikiApiSyntaxException, IOException, InterruptedException {
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

        Response r = gson.fromJson(api.execute(a), Response.class);

        assertTrue(r.isBatchComplete());
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