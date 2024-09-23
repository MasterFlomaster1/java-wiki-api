package dev.masterflomaster1.jwa.request.list;

import dev.masterflomaster1.jwa.BaseApiTest;
import dev.masterflomaster1.jwa.Response;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.common.Dir;
import dev.masterflomaster1.jwa.common.Namespace;
import dev.masterflomaster1.jwa.request.action.QueryAction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneOffset;
import java.util.EnumSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("SpellCheckingInspection")
class UsersContribsListTest extends BaseApiTest {

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

    @Test
    void testBuilder() {
        var a = new UsersContribsList.Builder()
                .ucLimit(10)
                .ucStart(LocalDateTime.of(2023, Month.AUGUST, 8, 12, 35).toInstant(ZoneOffset.UTC))
                .ucEnd(LocalDateTime.of(2023, Month.AUGUST, 8, 12, 35).toInstant(ZoneOffset.UTC))
                .ucContinue("cont")
                .ucUser(Set.of("Example"))
                .ucUserIds(Set.of(333))
                .ucUserPrefix("pref")
                .ucIpRange("range")
                .ucDir(Dir.Time.NEWER)
                .ucNamespace(EnumSet.of(Namespace.TALK))
                .ucProp(EnumSet.of(UsersContribsList.UcProp.IDS))
                .ucShow(EnumSet.of(UsersContribsList.UcShow.MINOR))
                .ucTag("tag")
                .build();

        assertEquals(10, a.getUcLimit());
        assertEquals(LocalDateTime.of(2023, Month.AUGUST, 8, 12, 35).toInstant(ZoneOffset.UTC), a.getUcStart());
        assertEquals(LocalDateTime.of(2023, Month.AUGUST, 8, 12, 35).toInstant(ZoneOffset.UTC), a.getUcEnd());
        assertEquals("cont", a.getUcContinue());
        assertEquals(Set.of("Example"), a.getUcUser());
        assertEquals(Set.of(333), a.getUcUserIds());
        assertEquals("range", a.getUcIpRange());
        assertEquals(Dir.Time.NEWER, a.getUcDir());
        assertEquals(EnumSet.of(Namespace.TALK), a.getUcNamespace());
        assertEquals(EnumSet.of(UsersContribsList.UcProp.IDS), a.getUcProp());
        assertEquals(EnumSet.of(UsersContribsList.UcShow.MINOR), a.getUcShow());
        assertEquals("tag", a.getUcTag());
    }

}