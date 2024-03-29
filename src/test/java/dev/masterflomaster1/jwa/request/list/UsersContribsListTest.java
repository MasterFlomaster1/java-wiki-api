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

class UsersContribsListTest {

    private static WikiApi api;

    @BeforeAll
    static void before() {
        api = new WikiApi();
    }

    @Test
    @DisplayName("Show contributions of user Example.")
    void testExample1() throws IOException {
        var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .list(Set.of(
                                new UsersContribsList.Builder()
                                        .ucUser(Set.of("Example"))
                                        .build()
                                )
                        )
                        .build()
                )
                .build();

        Response r = api.execute(a);
    }

    void testExample2() {

    }

    @Test
    void testBuilder() {
        var a = new UsersContribsList.Builder()
                .ucLimit(10)
                .ucStart(LocalDateTime.of(2023, Month.AUGUST, 8, 12, 35))
                .ucEnd(LocalDateTime.of(2023, Month.AUGUST, 8, 12, 35))
                .ucContinue("cont")
                .ucUser(Set.of("Example"))
                .ucUserIds(Set.of(333))
                .ucUserPrefix("pref")
                .ucIpRange("range")
                .ucDir(UsersContribsList.UcDir.NEWER)
                .ucNamespace(Set.of(Namespace.TALK))
                .ucProp(Set.of(UsersContribsList.UcProp.IDS))
                .ucShow(Set.of(UsersContribsList.UcShow.MINOR))
                .ucTag("tag")
                .build();

        assertEquals(10, a.getUcLimit());
        assertEquals(LocalDateTime.of(2023, Month.AUGUST, 8, 12, 35), a.getUcStart());
        assertEquals(LocalDateTime.of(2023, Month.AUGUST, 8, 12, 35), a.getUcEnd());
        assertEquals("cont", a.getUcContinue());
        assertEquals(Set.of("Example"), a.getUcUser());
        assertEquals(Set.of(333), a.getUcUserIds());
        assertEquals("range", a.getUcIpRange());
        assertEquals(UsersContribsList.UcDir.NEWER, a.getUcDir());
        assertEquals(Set.of(Namespace.TALK), a.getUcNamespace());
        assertEquals(Set.of(UsersContribsList.UcProp.IDS), a.getUcProp());
        assertEquals(Set.of(UsersContribsList.UcShow.MINOR), a.getUcShow());
        assertEquals("tag", a.getUcTag());
    }

}