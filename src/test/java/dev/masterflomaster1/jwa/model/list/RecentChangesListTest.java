package dev.masterflomaster1.jwa.model.list;

import com.google.gson.Gson;
import dev.masterflomaster1.jwa.Response;
import dev.masterflomaster1.jwa.WikiApi;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.WikiApiSyntaxException;
import dev.masterflomaster1.jwa.common.Namespace;
import dev.masterflomaster1.jwa.model.action.QueryAction;
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
    private static Gson gson;

    @BeforeAll
    static void before() {
        api = new WikiApi();
        gson = new Gson();
    }

    @Test
    @DisplayName("List recent changes.")
    void testExample1() throws WikiApiSyntaxException, IOException, InterruptedException {
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

        Response r = gson.fromJson(api.execute(a), Response.class);

        assertTrue(r.isBatchComplete());
        assertNotNull(r.getQuery().getRecentChanges());
    }

    @Test
    void getRcStart() {
        var a = new RecentChangesList.Builder()
                .rcStart(LocalDateTime.of(2023, Month.AUGUST, 8, 12, 35))
                .build();

        assertEquals(LocalDateTime.of(2023, Month.AUGUST, 8, 12, 35), a.getRcStart());
    }

    @Test
    void getRcEnd() {
        var a = new RecentChangesList.Builder()
                .rcEnd(LocalDateTime.of(2023, Month.AUGUST, 8, 12, 35))
                .build();

        assertEquals(LocalDateTime.of(2023, Month.AUGUST, 8, 12, 35), a.getRcEnd());
    }

    @Test
    void getRcDir() {
        var a = new RecentChangesList.Builder()
                .rcDir(RecentChangesList.RcDir.OLDER)
                .build();

        assertEquals(RecentChangesList.RcDir.OLDER, a.getRcDir());
    }

    @Test
    void getRcNamespace() {
        var a = new RecentChangesList.Builder()
                .rcNamespace(Namespace.TALK)
                .build();

        assertEquals(Namespace.TALK, a.getRcNamespace());
    }

    @Test
    void getRcUser() {
        var a = new RecentChangesList.Builder()
                .rcUser("User1")
                .build();

        assertEquals("User1", a.getRcUser());
    }

    @Test
    void getRcExcludeUser() {
        var a = new RecentChangesList.Builder()
                .rcExcludeUser("User1")
                .build();

        assertEquals("User1", a.getRcExcludeUser());
    }

    @Test
    void getRcTag() {
        var a = new RecentChangesList.Builder()
                .rcTag("edit")
                .build();

        assertEquals("edit", a.getRcTag());
    }

    @Test
    void getRcProp() {
        var a = new RecentChangesList.Builder()
                .rcProp(Set.of(RecentChangesList.RcProp.USER, RecentChangesList.RcProp.TIMESTAMP))
                .build();

        assertEquals(Set.of(RecentChangesList.RcProp.USER, RecentChangesList.RcProp.TIMESTAMP), a.getRcProp());
    }

    @Test
    void getRcShow() {
        var a = new RecentChangesList.Builder()
                .rcShow(Set.of(RecentChangesList.RcShow.BOT, RecentChangesList.RcShow.ANON))
                .build();

        assertEquals(Set.of(RecentChangesList.RcShow.BOT, RecentChangesList.RcShow.ANON), a.getRcShow());
    }

    @Test
    void getRcLimit() {
        var a = new RecentChangesList.Builder()
                .rcLimit(50)
                .build();

        assertEquals(50, a.getRcLimit());
    }

    @Test
    void getRcType() {
        var a = new RecentChangesList.Builder()
                .rcType(Set.of(RecentChangesList.RcType.LOG))
                .build();

        assertEquals(Set.of(RecentChangesList.RcType.LOG), a.getRcType());
    }

    @Test
    void isRcTopOnly() {
        var a = new RecentChangesList.Builder()
                .rcTopOnly()
                .build();

        assertTrue(a.isRcTopOnly());
    }

    @Test
    void getRcTitle() {
        var a = new RecentChangesList.Builder()
                .rcTitle("title")
                .build();

        assertEquals("title", a.getRcTitle());
    }

    @Test
    void getRcContinue() {
        var a = new RecentChangesList.Builder()
                .rcContinue("20240219090350|1744507853")
                .build();

        assertEquals("20240219090350|1744507853", a.getRcContinue());
    }

    @Test
    void isRcGenerateRevisions() {
        var a = new RecentChangesList.Builder()
                .rcGenerateRevisions()
                .build();

        assertTrue(a.isRcGenerateRevisions());
    }
}