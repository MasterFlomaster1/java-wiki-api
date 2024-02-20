package dev.masterflomaster1.jwa.request.prop;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class VideoInfoPropTest {

    @Test
    void testBuilder() {
        var a = new VideoInfoProp.Builder()
                .viProp(Set.of(VideoInfoProp.ViProp.USER_ID))
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

        assertEquals(Set.of(VideoInfoProp.ViProp.USER_ID), a.getViProp());
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