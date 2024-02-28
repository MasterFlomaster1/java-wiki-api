package dev.masterflomaster1.jwa.request.list;

import dev.masterflomaster1.jwa.Response;
import dev.masterflomaster1.jwa.WikiApi;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.common.Prop;
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

class AllImagesListTest {

    private static WikiApi api;

    @BeforeAll
    static void before() {
        api = new WikiApi();
    }

    @Test
    @DisplayName("Show a list of files starting at the letter B.")
    void testExample1() throws IOException {
        var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .list(Set.of(
                                new AllImagesList.Builder()
                                        .aiFrom("B")
                                        .build()
                                )
                        )
                        .build()
                )
                .build();

        Response r = api.execute(a);
        assertNotNull(r.getQuery().getAllImages());
    }

    @Test
    @DisplayName("Show a list of recently uploaded files, similar to Special:NewFiles.")
    void testExample2() throws IOException {
        var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .list(Set.of(
                                new AllImagesList.Builder()
                                        .aiSort(AllImagesList.AiSort.TIMESTAMP)
                                        .aiDir(AllImagesList.AiDir.OLDER)
                                        .aiProp(Set.of(Prop.USER, Prop.TIMESTAMP, Prop.URL))
                                        .build()
                                )
                        )
                        .build()
                )
                .build();

        Response r = api.execute(a);
        assertNotNull(r.getQuery().getAllImages());
    }

    @Test
    void testBuilder() {
        var a = new AllImagesList.Builder()
                .aiSort(AllImagesList.AiSort.TIMESTAMP)
                .aiDir(AllImagesList.AiDir.OLDER)
                .aiFrom("B")
                .aiTo("C")
                .aiContinue("cont")
                .aiStart(LocalDateTime.of(2023, Month.AUGUST, 8, 12, 35))
                .aiEnd(LocalDateTime.of(2023, Month.AUGUST, 8, 12, 35))
                .aiProp(Set.of(Prop.USER, Prop.TIMESTAMP, Prop.URL))
                .aiPrefix("D")
                .aiMinSize(33L)
                .aiMaxSize(23323L)
                .aiSha1("sha1")
                .aiSha1Base36("base36")
                .aiUser("example")
                .aiFilterBots(AllImagesList.AiFilterBots.ALL)
                .aiLimit(50)
                .build();

        assertEquals(AllImagesList.AiSort.TIMESTAMP, a.getAiSort());
        assertEquals(AllImagesList.AiDir.OLDER, a.getAiDir());
        assertEquals("B", a.getAiFrom());
        assertEquals("C", a.getAiTo());
        assertEquals("cont", a.getAiContinue());
        assertEquals(LocalDateTime.of(2023, Month.AUGUST, 8, 12, 35), a.getAiStart());
        assertEquals(LocalDateTime.of(2023, Month.AUGUST, 8, 12, 35), a.getAiEnd());
        assertEquals("D", a.getAiPrefix());
        assertEquals(33L, a.getAiMinSize());
        assertEquals(23323L, a.getAiMaxSize());
        assertEquals("sha1", a.getAiSha1());
        assertEquals("base36", a.getAiSha1Base36());
        assertEquals("example", a.getAiUser());
        assertEquals(AllImagesList.AiFilterBots.ALL, a.getAiFilterBots());
        assertEquals(50, a.getAiLimit());
    }

}