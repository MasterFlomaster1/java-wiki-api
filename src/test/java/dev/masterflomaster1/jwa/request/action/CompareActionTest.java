package dev.masterflomaster1.jwa.request.action;

import dev.masterflomaster1.jwa.BaseApiTest;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.internal.UrlComparator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EnumSet;

import static dev.masterflomaster1.jwa.request.action.CompareAction.Prop.*;
import static org.junit.jupiter.api.Assertions.*;

class CompareActionTest extends BaseApiTest {

    @Test
    @DisplayName("Create a diff between revision 1246320177 and 1242717618")
    void testExample1() {
        var a = new WikiApiRequest.Builder()
                .action(new CompareAction.Builder()
                        .fromRev(1246320177)
                        .toRev(1242717618)
                        .build()
                )
                .build();

        assertTrue(UrlComparator.compareUrls(
                "https://en.wikipedia.org/w/api.php?action=compare&format=json&fromrev=1246320177&torev=1242717618&formatversion=2",
                a.getUrl()
        ));
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