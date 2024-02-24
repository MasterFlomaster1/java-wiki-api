package dev.masterflomaster1.jwa.request.prop;

import dev.masterflomaster1.jwa.Response;
import dev.masterflomaster1.jwa.WikiApi;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.WikiApiSyntaxException;
import dev.masterflomaster1.jwa.common.Prop;
import dev.masterflomaster1.jwa.request.action.QueryAction;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class VideoInfoPropTest {

    private static WikiApi api;

    @BeforeAll
    static void before() {
        api = new WikiApi();
    }

    @Test
    @DisplayName("Fetch information about File:Folgers.ogv")
    void testExample1() throws WikiApiSyntaxException, IOException {
        var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .prop(Set.of(
                                new VideoInfoProp.Builder()
                                        .viProp(Set.of(Prop.USER, Prop.TIMESTAMP, Prop.URL))
                                        .build()
                                )
                        )
                        .titles(Set.of("File:Folgers.ogv"))
                        .build()
                )
                .build();

        Response r = api.execute(a);
        assertNotNull(r.getQuery().getPages().get(0).getVideoInfo());
    }

    @Test
    void testBuilder() {
        var a = new VideoInfoProp.Builder()
                .viProp(Set.of(Prop.USER_ID))
                .viLimit(20)
                .viStart(LocalDateTime.parse("2007-12-31T23:59:59"))
                .viEnd(LocalDateTime.parse("2007-12-31T23:59:59"))
                .viUrlWidth(50)
                .viUrlHeight(50)
                .viMetadataVersion("1")
                .viExtMetadataLanguage("en")
                .viExtMetadataMultiLang()
                .viExtMetadataFilter(Set.of("test"))
                .viUrlParam("param")
                .viBadFileContextTitle("title")
                .viContinue("||")
                .viLocalOnly()
                .build();

        assertEquals(Set.of(Prop.USER_ID), a.getViProp());
        assertEquals(20, a.getViLimit());
        assertEquals(LocalDateTime.parse("2007-12-31T23:59:59"), a.getViStart());
        assertEquals(LocalDateTime.parse("2007-12-31T23:59:59"), a.getViEnd());
        assertEquals(50, a.getViUrlWidth());
        assertEquals(50, a.getViUrlHeight());
        assertEquals("1", a.getViMetadataVersion());
        assertEquals("en", a.getViExtMetadataLanguage());
        assertTrue(a.isViExtMetadataMultiLang());
        assertEquals(Set.of("test"), a.getViExtMetadataFilter());
        assertEquals("param", a.getViUrlParam());
        assertEquals("title", a.getViBadFileContextTitle());
        assertEquals("||", a.getViContinue());
        assertTrue(a.isViLocalOnly());

    }

}