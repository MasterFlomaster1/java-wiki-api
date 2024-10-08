package dev.masterflomaster1.jwa.request.list;

import dev.masterflomaster1.jwa.BaseApiTest;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.common.Dir;
import dev.masterflomaster1.jwa.common.Namespace;
import dev.masterflomaster1.jwa.internal.UrlComparator;
import dev.masterflomaster1.jwa.request.action.QueryAction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneOffset;
import java.util.EnumSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class RecentChangesListTest extends BaseApiTest {

    @Test
    @DisplayName("List recent changes")
    void testExample1() {
        var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .list(Set.of(
                                new RecentChangesList.Builder()
                                        .build()
                        ))
                        .build()
                )
                .build();

        assertTrue(UrlComparator.compareUrls(
                "https://en.wikipedia.org/w/api.php?action=query&format=json&list=recentchanges&formatversion=2",
                a.getUrl()
        ));
    }

    @Test
    void testBuilder() {
        var a = new RecentChangesList.Builder()
                .rcStart(LocalDateTime.of(2023, Month.AUGUST, 8, 12, 35).toInstant(ZoneOffset.UTC))
                .rcEnd(LocalDateTime.of(2023, Month.AUGUST, 8, 12, 35).toInstant(ZoneOffset.UTC))
                .rcDir(Dir.Time.OLDER)
                .rcNamespace(Namespace.TALK)
                .rcUser("User1")
                .rcExcludeUser("User1")
                .rcTag("edit")
                .rcProp(EnumSet.of(RecentChangesList.RcProp.USER, RecentChangesList.RcProp.TIMESTAMP))
                .rcShow(EnumSet.of(RecentChangesList.RcShow.BOT, RecentChangesList.RcShow.ANON))
                .rcLimit(50)
                .rcType(EnumSet.of(RecentChangesList.RcType.LOG))
                .rcTopOnly()
                .rcTitle("title")
                .rcContinue("20240219090350|1744507853")
                .rcGenerateRevisions()
                .build();

        assertEquals(LocalDateTime.of(2023, Month.AUGUST, 8, 12, 35).toInstant(ZoneOffset.UTC), a.getRcStart());
        assertEquals(LocalDateTime.of(2023, Month.AUGUST, 8, 12, 35).toInstant(ZoneOffset.UTC), a.getRcEnd());
        assertEquals(Dir.Time.OLDER, a.getRcDir());
        assertEquals(Namespace.TALK, a.getRcNamespace());
        assertEquals("User1", a.getRcUser());
        assertEquals("User1", a.getRcExcludeUser());
        assertEquals("edit", a.getRcTag());
        assertEquals(EnumSet.of(RecentChangesList.RcProp.USER, RecentChangesList.RcProp.TIMESTAMP), a.getRcProp());
        assertEquals(EnumSet.of(RecentChangesList.RcShow.BOT, RecentChangesList.RcShow.ANON), a.getRcShow());
        assertEquals(50, a.getRcLimit());
        assertEquals(EnumSet.of(RecentChangesList.RcType.LOG), a.getRcType());
        assertTrue(a.isRcTopOnly());
        assertEquals("title", a.getRcTitle());
        assertEquals("20240219090350|1744507853", a.getRcContinue());
        assertTrue(a.isRcGenerateRevisions());

    }

}