package dev.masterflomaster1.jwa.request.prop;

import dev.masterflomaster1.jwa.BaseApiTest;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.common.Prop;
import dev.masterflomaster1.jwa.internal.UrlComparator;
import dev.masterflomaster1.jwa.request.action.QueryAction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.EnumSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class VideoInfoPropTest extends BaseApiTest {

    @Test
    @DisplayName("Fetch information about File:Folgers.ogv")
    void testExample1() {
        var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .prop(Set.of(
                                new VideoInfoProp.Builder()
                                        .viProp(EnumSet.of(Prop.CANONICAL_TITLE))
                                        .build()
                        ))
                        .titles(Set.of("File:Folgers.ogv"))
                        .build()
                )
                .build();

        assertTrue(UrlComparator.compareUrls(
                "https://en.wikipedia.org/w/api.php?action=query&format=json&prop=videoinfo&titles=File%3AFolgers.ogv&formatversion=2&viprop=canonicaltitle",
                a.getUrl()
        ));
    }

    @Test
    void testBuilder() {
        var a = new VideoInfoProp.Builder()
                .viProp(EnumSet.of(Prop.USER_ID))
                .viLimit(20)
                .viStart(LocalDateTime.parse("2007-12-31T23:59:59").toInstant(ZoneOffset.UTC))
                .viEnd(LocalDateTime.parse("2007-12-31T23:59:59").toInstant(ZoneOffset.UTC))
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

        assertEquals(EnumSet.of(Prop.USER_ID), a.getViProp());
        assertEquals(20, a.getViLimit());
        assertEquals(LocalDateTime.parse("2007-12-31T23:59:59").toInstant(ZoneOffset.UTC), a.getViStart());
        assertEquals(LocalDateTime.parse("2007-12-31T23:59:59").toInstant(ZoneOffset.UTC), a.getViEnd());
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