package dev.masterflomaster1.jwa.request.action;

import dev.masterflomaster1.jwa.Response;
import dev.masterflomaster1.jwa.WikiApi;
import dev.masterflomaster1.jwa.WikiApiRequest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.EnumSet;

import static dev.masterflomaster1.jwa.request.action.CompareAction.Prop.*;
import static org.junit.jupiter.api.Assertions.*;

class CompareActionTest {

    private static WikiApi api;

    @BeforeAll
    static void before() {
        api = new WikiApi();
    }

    @Test
    void testExample1() throws IOException {
        var a = new WikiApiRequest.Builder()
                .action(new CompareAction.Builder()
                        .fromRev(1207508716)
                        .toRev(1210047507)
                        .build()
                )
                .build();

        Response r = api.execute(a);

        System.out.println(r);
        assertNotNull(r.getCompare());
        System.out.println(r.getCompare());
    }

    @Test
    void testBuilder() {
        var a = new CompareAction.Builder()
                .fromTitle("test1")
                .fromId(1)
                .fromRev(1207508716)
                .fromPst()
                .toTitle("test2")
                .toId(2)
                .toRev(1210047507)
                .toRelative(CompareAction.ToRelative.CUR)
                .toPst()
                .prop(EnumSet.of(DIFF, IDS, TITLE))
                .slots(EnumSet.of(CompareAction.Slots.ALL_VALUES))
                .diffType(CompareAction.DiffType.TABLE)
                .build();

        assertEquals("test1", a.getFromTitle());
        assertEquals(1, a.getFromId());
        assertEquals(1207508716, a.getFromRev());
        assertTrue(a.isFromPst());
        assertEquals("test2", a.getToTitle());
        assertEquals(2, a.getToId());
        assertEquals(1210047507, a.getToRev());
        assertEquals(CompareAction.ToRelative.CUR, a.getToRelative());
        assertTrue(a.isToPst());
        assertEquals(EnumSet.of(DIFF, IDS, TITLE), a.getProp());
        assertEquals(EnumSet.of(CompareAction.Slots.ALL_VALUES), a.getSlots());
        assertEquals(CompareAction.DiffType.TABLE, a.getDiffType());
    }

}