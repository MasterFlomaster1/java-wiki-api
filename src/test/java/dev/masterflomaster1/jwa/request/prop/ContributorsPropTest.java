package dev.masterflomaster1.jwa.request.prop;

import dev.masterflomaster1.jwa.BaseApiTest;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.common.Group;
import dev.masterflomaster1.jwa.common.Rights;
import dev.masterflomaster1.jwa.internal.UrlComparator;
import dev.masterflomaster1.jwa.request.action.QueryAction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EnumSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ContributorsPropTest extends BaseApiTest {

    @Test
    @DisplayName("Show contributors to the page Main Page")
    void testExample1() {
        var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .prop(Set.of(
                                new ContributorsProp.Builder()
                                        .build()
                        ))
                        .titles(Set.of("Main Page"))
                        .build()
                )
                .build();

        assertTrue(UrlComparator.compareUrls(
                "https://en.wikipedia.org/w/api.php?action=query&format=json&prop=contributors&titles=Main%20Page&formatversion=2",
                a.getUrl()
        ));
    }

    @Test
    void testBuilder() {
        var a = new ContributorsProp.Builder()
                .pcGroup(EnumSet.of(Group.ABUSE_FILTER))
                .pcExcludeGroup(EnumSet.of(Group.ABUSE_FILTER))
                .pcRights(EnumSet.of(Rights.EDIT))
                .pcExcludeRights(EnumSet.of(Rights.EDIT))
                .pcLimit(60)
                .pcContinue("15580374|1029")
                .build();

        assertEquals(EnumSet.of(Group.ABUSE_FILTER), a.getPcGroup());
        assertEquals(EnumSet.of(Group.ABUSE_FILTER), a.getPcExcludeGroup());
        assertEquals(EnumSet.of(Rights.EDIT), a.getPcRights());
        assertEquals(EnumSet.of(Rights.EDIT), a.getPcExcludeRights());
        assertEquals(60, a.getPcLimit());
        assertEquals("15580374|1029", a.getPcContinue());
    }

}