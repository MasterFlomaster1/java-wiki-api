package dev.masterflomaster1.jwa.request.prop;

import dev.masterflomaster1.jwa.Response;
import dev.masterflomaster1.jwa.WikiApi;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.request.action.QueryAction;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.EnumSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ContributorsPropTest {

    private static WikiApi api;

    @BeforeAll
    static void before() {
        api = new WikiApi();
    }

    @Test
    @DisplayName("Show contributors to the page Main Page.")
    void testExample1() throws IOException {
        var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .prop(Set.of(
                                new ContributorsProp.Builder()
                                        .build()
                                )
                        )
                        .titles(Set.of("Main Page"))
                        .build()
                )
                .build();

        Response r = api.execute(a);
        assertNotNull(r.getQuery().getPages().get(0).getContributors());
    }

    @Test
    void testBuilder() {
        var a = new ContributorsProp.Builder()
                .pcGroup(EnumSet.of(ContributorsProp.PcGroup.ABUSE_FILTER))
                .pcExcludeGroup(EnumSet.of(ContributorsProp.PcGroup.ABUSE_FILTER))
                .pcRights(EnumSet.of(ContributorsProp.PcRights.EDIT))
                .pcExcludeRights(EnumSet.of(ContributorsProp.PcRights.EDIT))
                .pcLimit(60)
                .pcContinue("15580374|1029")
                .build();

        assertEquals(EnumSet.of(ContributorsProp.PcGroup.ABUSE_FILTER), a.getPcGroup());
        assertEquals(EnumSet.of(ContributorsProp.PcGroup.ABUSE_FILTER), a.getPcExcludeGroup());
        assertEquals(EnumSet.of(ContributorsProp.PcRights.EDIT), a.getPcRights());
        assertEquals(EnumSet.of(ContributorsProp.PcRights.EDIT), a.getPcExcludeRights());
        assertEquals(60, a.getPcLimit());
        assertEquals("15580374|1029", a.getPcContinue());
    }

}