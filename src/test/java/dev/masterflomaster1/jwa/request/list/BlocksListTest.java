package dev.masterflomaster1.jwa.request.list;

import dev.masterflomaster1.jwa.Response;
import dev.masterflomaster1.jwa.WikiApi;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.common.Dir;
import dev.masterflomaster1.jwa.request.action.QueryAction;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.EnumSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class BlocksListTest {

    private static WikiApi api;

    @BeforeAll
    static void before() {
        api = new WikiApi();
    }

    @Test
    @DisplayName("List blocks.")
    void testExample1() throws IOException {
        var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .list(Set.of(
                                new BlocksList.Builder()
                                        .build()
                        ))
                        .build()
                )
                .build();

        Response r = api.execute(a);

        System.out.println(r.getQuery().getBlocks());

        assertNotNull(r.getQuery().getBlocks());
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
                .bkContinue("test")
                .build();

        assertEquals(LocalDateTime.of(2024, 1, 1, 2, 3).toInstant(ZoneOffset.UTC), a.getBkStart());
        assertEquals(LocalDateTime.of(2024, 2, 1, 2, 3).toInstant(ZoneOffset.UTC), a.getBkEnd());
        assertEquals(Dir.Time.OLDER, a.getBkDir());
        assertEquals(Set.of(101010), a.getBkIds());
        assertEquals(Set.of("Demo"), a.getBkUsers());
        assertEquals(30, a.getBkLimit());
        assertEquals(EnumSet.of(BlocksList.BkProp.BY, BlocksList.BkProp.BY_ID), a.getBkProp());
        assertEquals("test", a.getBkContinue());

    }

}