package dev.masterflomaster1.jwa.request.prop;

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
import java.time.ZoneOffset;
import java.util.EnumSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ImageInfoPropTest {

    private static WikiApi api;

    @BeforeAll
    static void before() {
        api = new WikiApi();
    }

    @Test
    @DisplayName("Fetch information about the current version of File:Albert Einstein Head.jpg.")
    void testExample1() throws IOException {
        var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .prop(Set.of(
                                new ImageInfoProp.Builder()
                                        .build()
                                )
                        )
                        .titles(Set.of("File:Albert Einstein Head.jpg"))
                        .build()
                )
                .build();

        Response r = api.execute(a);
        assertNotNull(r.getQuery().getPages().get(0).getImageInfo().get(0));
    }

    @Test
    @DisplayName("Fetch information about versions of File:Test.jpg from 2008 and later.")
    void testExample2() throws IOException {
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
                                )
                        )
                        .titles(Set.of("File:Test.jpg"))
                        .build()
                )
                .build();

        Response r = api.execute(a);
        assertNotNull(r.getQuery().getPages().get(0).getImageInfo().get(0));
    }

    @Test
    void testExample3() throws IOException {
        var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .prop(Set.of(
                                new ImageInfoProp.Builder()
                                        .iiProp(EnumSet.of(Prop.TIMESTAMP,
                                                Prop.URL,
                                                Prop.EXTMETADATA
                                        ))
                                        .iiLimit(1)
                                        .build()
                                )
                        )
                        .titles(Set.of("File:Albert Einstein Head.jpg"))
                        .build()
                )
                .build();

        Response r = api.execute(a);
        assertNotNull(r.getQuery().getPages().get(0).getImageInfo().get(0).getExtMetadata());
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