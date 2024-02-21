package dev.masterflomaster1.jwa.request.prop;

import dev.masterflomaster1.jwa.Response;
import dev.masterflomaster1.jwa.WikiApi;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.WikiApiSyntaxException;
import dev.masterflomaster1.jwa.request.action.QueryAction;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class RevisionsPropTest {

    private static WikiApi api;

    @BeforeAll
    static void before() {
        api = new WikiApi();
    }

    @Test
    @DisplayName("Get data with content for the last revision of titles API and Main Page.")
    void testExample1() throws WikiApiSyntaxException, IOException {
        var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .prop(Set.of(
                                new RevisionsProp.Builder()
                                        .rvProp(Set.of(
                                                RevisionsProp.RvProp.TIMESTAMP,
                                                RevisionsProp.RvProp.USER,
                                                RevisionsProp.RvProp.COMMENT,
                                                RevisionsProp.RvProp.CONTENT
                                        ))
                                        .build()
                                )
                        )
                        .titles(Set.of("Main Page", "API"))
                        .build()
                )
                .build();

        Response r = api.execute(a);

        assertNotNull(r.getQuery().getPages().get(0).getRevisions());
    }

    @Test
    @DisplayName("Get last 5 revisions of the Main Page.")
    void testExample2() throws WikiApiSyntaxException, IOException {
        var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .prop(Set.of(
                                new RevisionsProp.Builder()
                                        .rvProp(Set.of(
                                                RevisionsProp.RvProp.TIMESTAMP,
                                                RevisionsProp.RvProp.USER,
                                                RevisionsProp.RvProp.COMMENT
                                        ))
                                        .rvLimit(5)
                                        .build()
                                )
                        )
                        .titles(Set.of("Main Page"))
                        .build()
                )
                .build();

        Response r = api.execute(a);
        assertNotNull(r.getQuery().getPages().get(0).getRevisions());
    }

    @Test
    @DisplayName("Get first 5 revisions of the Main Page.")
    void testExample3() throws WikiApiSyntaxException, IOException {
        var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .prop(Set.of(
                                new RevisionsProp.Builder()
                                        .rvLimit(5)
                                        .build()
                                )
                        )
                        .titles(Set.of("Main Page"))
                        .build()
                )
                .build();

        Response r = api.execute(a);
    }

    @Test
    void testBuilder() {
        var a = new RevisionsProp.Builder()
                .rvProp(Set.of(RevisionsProp.RvProp.USER, RevisionsProp.RvProp.USER_ID))
                .rvLimit(5)
                .rvSection("section")
                .rvStart(LocalDateTime.of(2013, Month.AUGUST, 22, 2, 2, 2))
                .rvEnd(LocalDateTime.of(2013, Month.AUGUST, 22, 2, 2, 2))
                .rvDir(RevisionsProp.RvDir.OLDER)
                .rvUser("User123")
                .rvExcludeUser("User123")
                .rvTag("tag")
                .rvContinue("20060507062659|51945169")
                .build();

        assertEquals(Set.of(RevisionsProp.RvProp.USER, RevisionsProp.RvProp.USER_ID), a.getRvProp());
        assertEquals(5, a.getRvLimit());
        assertEquals("section", a.getRvSection());
        assertEquals(LocalDateTime.of(2013, Month.AUGUST, 22, 2, 2, 2), a.getRvStart());
        assertEquals(LocalDateTime.of(2013, Month.AUGUST, 22, 2, 2, 2), a.getRvEnd());
        assertEquals(RevisionsProp.RvDir.OLDER, a.getRvDir());
        assertEquals("User123", a.getRvUser());
        assertEquals("User123", a.getRvExcludeUser());
        assertEquals("tag", a.getRvTag());
        assertEquals("20060507062659|51945169", a.getRvContinue());
    }

}