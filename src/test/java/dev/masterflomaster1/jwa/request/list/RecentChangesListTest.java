package dev.masterflomaster1.jwa.request.list;

import dev.masterflomaster1.jwa.Response;
import dev.masterflomaster1.jwa.WikiApi;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.common.Namespace;
import dev.masterflomaster1.jwa.request.action.QueryAction;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class RecentChangesListTest {

    private static WikiApi api;

    @BeforeAll
    static void before() {
        api = new WikiApi();
    }

    @Test
    @DisplayName("List recent changes.")
    void testExample1() throws IOException {
        var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .list(Set.of(
                                new RecentChangesList.Builder()
                                        .build()
                                )
                        )
                        .build()
                )
                .build();

        Response r = api.execute(a);

        assertTrue(r.isBatchComplete());
        assertNotNull(r.getQuery().getRecentChanges());
    }

    @Test
    void testBuilder() {
        var a = new RecentChangesList.Builder()
                .rcStart(LocalDateTime.of(2023, Month.AUGUST, 8, 12, 35))
                .rcEnd(LocalDateTime.of(2023, Month.AUGUST, 8, 12, 35))
                .rcDir(RecentChangesList.RcDir.OLDER)
                .rcNamespace(Namespace.TALK)
                .rcUser("User1")
                .rcExcludeUser("User1")
                .rcTag("edit")
                .rcProp(Set.of(RecentChangesList.RcProp.USER, RecentChangesList.RcProp.TIMESTAMP))
                .rcShow(Set.of(RecentChangesList.RcShow.BOT, RecentChangesList.RcShow.ANON))
                .rcLimit(50)
                .rcType(Set.of(RecentChangesList.RcType.LOG))
                .rcTopOnly()
                .rcTitle("title")
                .rcContinue("20240219090350|1744507853")
                .rcGenerateRevisions()
                .build();

        assertEquals(LocalDateTime.of(2023, Month.AUGUST, 8, 12, 35), a.getRcStart());
        assertEquals(LocalDateTime.of(2023, Month.AUGUST, 8, 12, 35), a.getRcEnd());
        assertEquals(RecentChangesList.RcDir.OLDER, a.getRcDir());
        assertEquals(Namespace.TALK, a.getRcNamespace());
        assertEquals("User1", a.getRcUser());
        assertEquals("User1", a.getRcExcludeUser());
        assertEquals("edit", a.getRcTag());
        assertEquals(Set.of(RecentChangesList.RcProp.USER, RecentChangesList.RcProp.TIMESTAMP), a.getRcProp());
        assertEquals(Set.of(RecentChangesList.RcShow.BOT, RecentChangesList.RcShow.ANON), a.getRcShow());
        assertEquals(50, a.getRcLimit());
        assertEquals(Set.of(RecentChangesList.RcType.LOG), a.getRcType());
        assertTrue(a.isRcTopOnly());
        assertEquals("title", a.getRcTitle());
        assertEquals("20240219090350|1744507853", a.getRcContinue());
        assertTrue(a.isRcGenerateRevisions());

    }

}