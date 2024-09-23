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

class ImageInfoPropTest extends BaseApiTest {

    @Test
    @DisplayName("Fetch information about the current version of File:Albert Einstein Head.jpg")
    void testExample1() {
        var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .prop(Set.of(
                                new ImageInfoProp.Builder()
                                        .build()
                        ))
                        .titles(Set.of("File:Albert Einstein Head.jpg"))
                        .build()
                )
                .build();

        assertTrue(UrlComparator.compareUrls(
                "https://en.wikipedia.org/w/api.php?action=query&format=json&prop=imageinfo&titles=File%3AAlbert%20Einstein%20Head.jpg&formatversion=2",
                a.getUrl()
        ));
    }

    @Test
    @DisplayName("Fetch information about versions of File:Test.jpg from 2008 and later")
    void testExample2() {
        var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .prop(Set.of(
                                new ImageInfoProp.Builder()
                                        .iiProp(EnumSet.of(Prop.TIMESTAMP,
                                                Prop.USER,
                                                Prop.URL
                                        ))
                                        .iiLimit(50)
                                        .iiEnd(LocalDateTime.of(2007, 12, 31, 23, 59, 59).toInstant(ZoneOffset.UTC))
                                        .build()
                        ))
                        .titles(Set.of("File:Test.jpg"))
                        .build()
                )
                .build();

        assertTrue(UrlComparator.compareUrls(
                "https://en.wikipedia.org/w/api.php?action=query&format=json&prop=imageinfo&titles=File%3ATest.jpg&formatversion=2&iiprop=timestamp%7Cuser%7Curl&iilimit=50&iiend=2007-12-31T23%3A59%3A59Z",
                a.getUrl()
        ));
    }

    @Test
    void testBuilder() {
        var a = new ImageInfoProp.Builder()
                .iiProp(EnumSet.of(Prop.TIMESTAMP, Prop.USER_ID))
                .iiLimit(20)
                .iiStart(LocalDateTime.of(2007, 12, 31, 23, 59, 59).toInstant(ZoneOffset.UTC))
                .iiEnd(LocalDateTime.of(2007, 12, 31, 23, 59, 59).toInstant(ZoneOffset.UTC))
                .iiUrlWidth(50)
                .iiUrlHeight(50)
                .iiExtMetadataLanguage("en")
                .iiExtMetadataMultiLang()
                .build();

        assertEquals(EnumSet.of(Prop.TIMESTAMP, Prop.USER_ID), a.getIiProp());
        assertEquals(20, a.getIiLimit());
        assertEquals(LocalDateTime.of(2007, 12, 31, 23, 59, 59).toInstant(ZoneOffset.UTC), a.getIiStart());
        assertEquals(LocalDateTime.of(2007, 12, 31, 23, 59, 59).toInstant(ZoneOffset.UTC), a.getIiEnd());
        assertEquals(50, a.getIiUrlWidth());
        assertEquals(50, a.getIiUrlHeight());
        assertEquals("en", a.getIiExtMetadataLanguage());
        assertTrue(a.isIiExtMetadataMultiLang());

    }

}