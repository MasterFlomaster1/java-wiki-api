package dev.masterflomaster1.jwa.request.list;

import dev.masterflomaster1.jwa.Response;
import dev.masterflomaster1.jwa.WikiApi;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.common.Dir;
import dev.masterflomaster1.jwa.common.Group;
import dev.masterflomaster1.jwa.common.Rights;
import dev.masterflomaster1.jwa.request.action.QueryAction;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.EnumSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class AllUsersListTest {

    private static WikiApi api;

    @BeforeAll
    static void before() {
        api = new WikiApi();
    }

    @Test
    @DisplayName("List users starting at Y")
    void testExample1() throws IOException {
        var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .list(Set.of(
                                new AllUsersList.Builder()
                                        .auFrom("Y")
                                        .build()
                        ))
                        .build()
                )
                .build();

        Response r = api.execute(a);

        System.out.println(r.getQuery().getAllUsers());

        assertNotNull(r.getQuery().getAllUsers());
    }

    @Test
    void testBuilder() {
        var a = new AllUsersList.Builder()
                .auFrom("Y")
                .auTo("Z")
                .auPrefix("demo")
                .auDir(Dir.Order.ASCENDING)
                .auGroup(EnumSet.of(Group.REVIEWER))
                .auExcludeGroup(EnumSet.of(Group.CONFIRMED))
                .auRights(EnumSet.of(Rights.FLOW_HIDE))
                .auProp(EnumSet.of(AllUsersList.AuProp.GROUPS))
                .auLimit(23)
                .auWithEditsOnly()
                .auActiveUsers()
                .auAttachedWiki()
                .build();

        assertEquals("Y", a.getAuFrom());
        assertEquals("Z", a.getAuTo());
        assertEquals("demo", a.getAuPrefix());
        assertEquals(Dir.Order.ASCENDING, a.getAuDir());
        assertEquals(EnumSet.of(Group.REVIEWER), a.getAuGroup());
        assertEquals(EnumSet.of(Group.CONFIRMED), a.getAuExcludeGroup());
        assertEquals(EnumSet.of(Rights.FLOW_HIDE), a.getAuRights());
        assertEquals(EnumSet.of(AllUsersList.AuProp.GROUPS), a.getAuProp());
        assertEquals(23, a.getAuLimit());
        assertTrue(a.isAuWithEditsOnly());
        assertTrue(a.isAuActiveUsers());
        assertTrue(a.isAuAttachedWiki());
    }

}