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

class ProtectedTitlesListTest extends BaseApiTest {

    @Test
    @DisplayName("List protected titles")
    void testExample1() throws IOException {
        var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .list(Set.of(
                                new ProtectedTitlesList.Builder()
                                        .build()
                        ))
                        .build()
                )
                .build();

        Response r = api.execute(a);

        System.out.println(r.getQuery().getProtectedtitles());

        assertNotNull(r.getQuery().getProtectedtitles());
    }

    @Test
    void testBuilder() {
        var a = new ProtectedTitlesList.Builder()
                .ptNamespace(EnumSet.of(Namespace.ARTICLE))
                .ptLevel(EnumSet.of(ProtectedTitlesList.PtLevel.SYSOP))
                .ptLimit(32)
                .ptDir(Dir.Time.OLDER)
                .ptStart(LocalDateTime.of(2023, Month.AUGUST, 8, 12, 35).toInstant(ZoneOffset.UTC))
                .ptEnd(LocalDateTime.of(2023, Month.SEPTEMBER, 8, 12, 35).toInstant(ZoneOffset.UTC))
                .ptProp(EnumSet.of(ProtectedTitlesList.PtProp.COMMENT))
                .ptContinue("test")
                .build();

        assertEquals(EnumSet.of(Namespace.ARTICLE), a.getPtNamespace());
        assertEquals(EnumSet.of(ProtectedTitlesList.PtLevel.SYSOP), a.getPtLevel());
        assertEquals(32, a.getPtLimit());
        assertEquals(Dir.Time.OLDER, a.getPtDir());
        assertEquals(LocalDateTime.of(2023, Month.AUGUST, 8, 12, 35).toInstant(ZoneOffset.UTC), a.getPtStart());
        assertEquals(LocalDateTime.of(2023, Month.SEPTEMBER, 8, 12, 35).toInstant(ZoneOffset.UTC), a.getPtEnd());
        assertEquals(EnumSet.of(ProtectedTitlesList.PtProp.COMMENT), a.getPtProp());
        assertEquals("test", a.getPtContinue());
    }

}