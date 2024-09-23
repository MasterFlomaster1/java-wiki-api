package dev.masterflomaster1.jwa.request.prop;

import dev.masterflomaster1.jwa.BaseApiTest;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.common.Dir;
import dev.masterflomaster1.jwa.internal.UrlComparator;
import dev.masterflomaster1.jwa.request.action.QueryAction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneOffset;
import java.util.EnumSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RevisionsPropTest extends BaseApiTest {

    @Test
    @DisplayName("Get data with content for the last revision of titles API and Main Page")
    void testExample1() {
        var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .prop(Set.of(
                                new RevisionsProp.Builder()
                                        .rvProp(EnumSet.of(
                                                RevisionsProp.RvProp.TIMESTAMP,
                                                RevisionsProp.RvProp.USER,
                                                RevisionsProp.RvProp.COMMENT,
                                                RevisionsProp.RvProp.CONTENT
                                        ))
                                        .rvSlots(EnumSet.of(RevisionsProp.RvSlots.ALL_VALUES))
                                        .build()
                        ))
                        .titles(Set.of("Main Page", "API"))
                        .build()
                )
                .build();

        assertTrue(UrlComparator.compareUrls(
                "https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=API%7CMain%20Page&formatversion=2&rvprop=timestamp%7Cuser%7Ccomment%7Ccontent&rvslots=*",
                a.getUrl()
        ));
    }

    @Test
    @DisplayName("Get last 5 revisions of the Main Page")
    void testExample2() {
        var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .prop(Set.of(
                                new RevisionsProp.Builder()
                                        .rvProp(EnumSet.of(
                                                RevisionsProp.RvProp.TIMESTAMP,
                                                RevisionsProp.RvProp.USER,
                                                RevisionsProp.RvProp.COMMENT
                                        ))
                                        .rvLimit(5)
                                        .build()
                        ))
                        .titles(Set.of("Main Page"))
                        .build()
                )
                .build();

        assertTrue(UrlComparator.compareUrls(
                "https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=Main%20Page&formatversion=2&rvprop=timestamp%7Cuser%7Ccomment&rvlimit=5",
                a.getUrl()
        ));
    }

    @Test
    @DisplayName("Get first 5 revisions of the Main Page")
    void testExample3() {
        var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .prop(Set.of(
                                new RevisionsProp.Builder()
                                        .rvProp(EnumSet.of(
                                                RevisionsProp.RvProp.TIMESTAMP,
                                                RevisionsProp.RvProp.USER,
                                                RevisionsProp.RvProp.COMMENT
                                        ))
                                        .rvLimit(5)
                                        .rvDir(Dir.Time.NEWER)
                                        .build()
                        ))
                        .titles(Set.of("Main Page"))
                        .build()
                )
                .build();

        assertTrue(UrlComparator.compareUrls(
                "https://en.wikipedia.org/w/api.php?action=query&format=json&prop=revisions&titles=Main%20Page&formatversion=2&rvprop=timestamp%7Cuser%7Ccomment&rvlimit=5&rvdir=newer",
                a.getUrl()
        ));
    }

    @Test
    void testBuilder() {
        var a = new RevisionsProp.Builder()
                .rvProp(EnumSet.of(RevisionsProp.RvProp.USER, RevisionsProp.RvProp.USER_ID))
                .rvSlots(EnumSet.of(RevisionsProp.RvSlots.ALL_VALUES))
                .rvLimit(5)
                .rvSection("section")
                .rvStart(LocalDateTime.of(2013, Month.AUGUST, 22, 2, 2, 2).toInstant(ZoneOffset.UTC))
                .rvEnd(LocalDateTime.of(2013, Month.AUGUST, 22, 2, 2, 2).toInstant(ZoneOffset.UTC))
                .rvDir(Dir.Time.OLDER)
                .rvUser("User123")
                .rvExcludeUser("User123")
                .rvTag("tag")
                .rvContinue("20060507062659|51945169")
                .build();

        assertEquals(EnumSet.of(RevisionsProp.RvProp.USER, RevisionsProp.RvProp.USER_ID), a.getRvProp());
        assertEquals(EnumSet.of(RevisionsProp.RvSlots.ALL_VALUES), a.getRvSlots());
        assertEquals(5, a.getRvLimit());
        assertEquals("section", a.getRvSection());
        assertEquals(LocalDateTime.of(2013, Month.AUGUST, 22, 2, 2, 2).toInstant(ZoneOffset.UTC), a.getRvStart());
        assertEquals(LocalDateTime.of(2013, Month.AUGUST, 22, 2, 2, 2).toInstant(ZoneOffset.UTC), a.getRvEnd());
        assertEquals(Dir.Time.OLDER, a.getRvDir());
        assertEquals("User123", a.getRvUser());
        assertEquals("User123", a.getRvExcludeUser());
        assertEquals("tag", a.getRvTag());
        assertEquals("20060507062659|51945169", a.getRvContinue());
    }

}