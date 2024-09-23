package dev.masterflomaster1.jwa.request.list;

import dev.masterflomaster1.jwa.BaseApiTest;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.common.Dir;
import dev.masterflomaster1.jwa.common.Group;
import dev.masterflomaster1.jwa.common.Rights;
import dev.masterflomaster1.jwa.internal.UrlComparator;
import dev.masterflomaster1.jwa.request.action.QueryAction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EnumSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class AllUsersListTest extends BaseApiTest {

    @Test
    @DisplayName("List users starting at Y")
    void testExample1() {
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

        assertTrue(UrlComparator.compareUrls(
                "https://en.wikipedia.org/w/api.php?action=query&format=json&list=allusers&formatversion=2&aufrom=Y",
                a.getUrl()
        ));
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