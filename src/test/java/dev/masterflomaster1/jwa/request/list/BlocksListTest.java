package dev.masterflomaster1.jwa.request.list;

import dev.masterflomaster1.jwa.BaseApiTest;
import dev.masterflomaster1.jwa.Response;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.common.Dir;
import dev.masterflomaster1.jwa.internal.UrlComparator;
import dev.masterflomaster1.jwa.request.action.QueryAction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.EnumSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class BlocksListTest extends BaseApiTest {

    @Test
    @DisplayName("List blocks.")
    void testExample1() {
        var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .list(Set.of(
                                new BlocksList.Builder()
                                        .build()
                        ))
                        .build()
                )
                .build();

        assertTrue(UrlComparator.compareUrls(
                "https://en.wikipedia.org/w/api.php?action=query&format=json&list=blocks&formatversion=2",
                a.getUrl()
        ));
    }

    @Test
    void shouldReturnRestrictionsObject() throws IOException {
        var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .list(Set.of(
                                new BlocksList.Builder()
                                        .bkUsers(Set.of("105.113.40.0/23"))
                                        .bkProp(EnumSet.of(BlocksList.BkProp.RESTRICTIONS))
                                        .build()
                        ))
                        .build()
                )
                .build();

        Response r = api.execute(a);

        System.out.println(r.getQuery().getBlocks());

        assertNotNull(r.getQuery().getBlocks().get(0).getRestrictions());
    }

    @Test
    void testBuilder() {
        var a = new BlocksList.Builder()
                .bkStart(LocalDateTime.of(2024, 1, 1, 2, 3).toInstant(ZoneOffset.UTC))
                .bkEnd(LocalDateTime.of(2024, 2, 1, 2, 3).toInstant(ZoneOffset.UTC))
                .bkDir(Dir.Time.OLDER)
                .bkIds(Set.of(101010))
                .bkUsers(Set.of("Demo"))
                .bkIp("1.1.1.1")
                .bkLimit(30)
                .bkProp(EnumSet.of(BlocksList.BkProp.BY, BlocksList.BkProp.BY_ID))
                .bkShow(EnumSet.of(BlocksList.BkShow.IP))
                .bkContinue("test")
                .build();

        assertEquals(LocalDateTime.of(2024, 1, 1, 2, 3).toInstant(ZoneOffset.UTC), a.getBkStart());
        assertEquals(LocalDateTime.of(2024, 2, 1, 2, 3).toInstant(ZoneOffset.UTC), a.getBkEnd());
        assertEquals(Dir.Time.OLDER, a.getBkDir());
        assertEquals(Set.of(101010), a.getBkIds());
        assertEquals(Set.of("Demo"), a.getBkUsers());
        assertEquals(30, a.getBkLimit());
        assertEquals(EnumSet.of(BlocksList.BkProp.BY, BlocksList.BkProp.BY_ID), a.getBkProp());
        assertEquals(EnumSet.of(BlocksList.BkShow.IP), a.getBkShow());
        assertEquals("test", a.getBkContinue());

    }

}