package dev.masterflomaster1.jwa.request.prop;

import dev.masterflomaster1.jwa.Response;
import dev.masterflomaster1.jwa.WikiApi;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.WikiApiSyntaxException;
import dev.masterflomaster1.jwa.request.action.QueryAction;
import dev.masterflomaster1.jwa.util.ISO639Language;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDateTime;
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
    void testExample1() throws WikiApiSyntaxException, IOException {
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
    void testExample2() throws WikiApiSyntaxException, IOException {
        var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .prop(Set.of(
                                new ImageInfoProp.Builder()
                                        .iiProp(Set.of(ImageInfoProp.IIProp.TIMESTAMP,
                                                ImageInfoProp.IIProp.USER,
                                                ImageInfoProp.IIProp.URL
                                        ))
                                        .iiLimit(50)
                                        .iiEnd(LocalDateTime.of(2007, 12, 31, 23, 59, 59))
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
    void testExample3() throws WikiApiSyntaxException, IOException {
        var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .prop(Set.of(
                                new ImageInfoProp.Builder()
                                        .iiProp(Set.of(ImageInfoProp.IIProp.TIMESTAMP,
                                                ImageInfoProp.IIProp.URL,
                                                ImageInfoProp.IIProp.EXTMETADATA
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
                .iiProp(Set.of(ImageInfoProp.IIProp.TIMESTAMP, ImageInfoProp.IIProp.USER_ID))
                .iiLimit(20)
                .iiStart(LocalDateTime.of(2007, 12, 31, 23, 59, 59))
                .iiEnd(LocalDateTime.of(2007, 12, 31, 23, 59, 59))
                .iiUrlWidth(50)
                .iiUrlHeight(50)
                .iiExtMetadataLanguage(ISO639Language.English)
                .iiExtMetadataMultiLang()
                .build();

        assertEquals(Set.of(ImageInfoProp.IIProp.TIMESTAMP, ImageInfoProp.IIProp.USER_ID), a.getIiProp());
        assertEquals(20, a.getIiLimit());
        assertEquals(LocalDateTime.of(2007, 12, 31, 23, 59, 59), a.getIiStart());
        assertEquals(LocalDateTime.of(2007, 12, 31, 23, 59, 59), a.getIiEnd());
        assertEquals(50, a.getIiUrlWidth());
        assertEquals(50, a.getIiUrlHeight());
        assertEquals(ISO639Language.English, a.getIiExtMetadataLanguage());
        assertTrue(a.isIiExtMetadataMultiLang());

    }

}