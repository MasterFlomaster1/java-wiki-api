package dev.masterflomaster1.jwa.request.prop;

import com.google.gson.Gson;
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

import static org.junit.jupiter.api.Assertions.*;

class ContributorsPropTest {

    private static WikiApi api;
    private static Gson gson;

    @BeforeAll
    static void before() {
        api = new WikiApi();
        gson = new Gson();
    }

    @Test
    @DisplayName("Show contributors to the page Main Page.")
    void testExample1() throws WikiApiSyntaxException, IOException, InterruptedException {
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

        Response r = gson.fromJson(api.execute(a), Response.class);
        assertNotNull(r.getQuery().getPages().get(0).getContributors());
    }

    @Test
    void testBuilder() {
        var a = new ContributorsProp.Builder()
                .pcGroup(Set.of(ContributorsProp.PcGroup.ABUSE_FILTER))
                .pcExcludeGroup(Set.of(ContributorsProp.PcGroup.ABUSE_FILTER))
                .pcRights(Set.of(ContributorsProp.PcRights.EDIT))
                .pcExcludeRights(Set.of(ContributorsProp.PcRights.EDIT))
                .pcLimit(60)
                .pcContinue("15580374|1029")
                .build();

        assertEquals(Set.of(ContributorsProp.PcGroup.ABUSE_FILTER), a.getPcGroup());
        assertEquals(Set.of(ContributorsProp.PcGroup.ABUSE_FILTER), a.getPcExcludeGroup());
        assertEquals(Set.of(ContributorsProp.PcRights.EDIT), a.getPcRights());
        assertEquals(Set.of(ContributorsProp.PcRights.EDIT), a.getPcExcludeRights());
        assertEquals(60, a.getPcLimit());
        assertEquals("15580374|1029", a.getPcContinue());
    }

}