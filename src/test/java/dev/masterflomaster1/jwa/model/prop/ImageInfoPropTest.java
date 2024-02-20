package dev.masterflomaster1.jwa.model.prop;

import com.google.gson.Gson;
import dev.masterflomaster1.jwa.Response;
import dev.masterflomaster1.jwa.WikiApi;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.WikiApiSyntaxException;
import dev.masterflomaster1.jwa.model.action.QueryAction;
import dev.masterflomaster1.jwa.util.ISO639Language;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ImageInfoPropTest {

    private static WikiApi api;
    private static Gson gson;

    @BeforeAll
    static void before() {
        api = new WikiApi();
        gson = new Gson();
    }

    @Test
    @DisplayName("Fetch information about the current version of File:Albert Einstein Head.jpg.")
    void testExample1() throws WikiApiSyntaxException, IOException, InterruptedException {
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

        Response r = gson.fromJson(api.execute(a), Response.class);
        assertNotNull(r.getQuery().getPages().get(0).getImageInfo().get(0));
    }

    @Test
    @DisplayName("Fetch information about versions of File:Test.jpg from 2008 and later.")
    void testExample2() throws WikiApiSyntaxException, IOException, InterruptedException {
        var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .prop(Set.of(
                                new ImageInfoProp.Builder()
                                        .iiProp(Set.of(ImageInfoProp.IIProp.TIMESTAMP,
                                                ImageInfoProp.IIProp.USER,
                                                ImageInfoProp.IIProp.URL
                                        ))
                                        .iiLimit(50)
                                        .iiEnd("2007-12-31T23:59:59Z")
                                        .build()
                                )
                        )
                        .titles(Set.of("File:Test.jpg"))
                        .build()
                )
                .build();

        Response r = gson.fromJson(api.execute(a), Response.class);
        assertNotNull(r.getQuery().getPages().get(0).getImageInfo().get(0));
    }

    @Test
    void testExample3() throws WikiApiSyntaxException, IOException, InterruptedException {
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

        Response r = gson.fromJson(api.execute(a), Response.class);
        assertNotNull(r.getQuery().getPages().get(0).getImageInfo().get(0).getExtMetadata());
    }

    @Test
    void testBuilder() {
        var a = new ImageInfoProp.Builder()
                .iiProp(Set.of(ImageInfoProp.IIProp.TIMESTAMP, ImageInfoProp.IIProp.USER_ID))
                .iiLimit(20)
                .iiStart("2007-12-31T23:59:59Z")
                .iiEnd("2007-12-31T23:59:59Z")
                .iiUrlWidth(50)
                .iiUrlHeight(50)
                .iiExtMetadataLanguage(ISO639Language.English)
                .iiExtMetadataMultiLang()
                .build();

        assertEquals(Set.of(ImageInfoProp.IIProp.TIMESTAMP, ImageInfoProp.IIProp.USER_ID), a.getIiProp());
        assertEquals(20, a.getIiLimit());
        assertEquals("2007-12-31T23:59:59Z", a.getIiStart());
        assertEquals("2007-12-31T23:59:59Z", a.getIiEnd());
        assertEquals(50, a.getIiUrlWidth());
        assertEquals(50, a.getIiUrlHeight());
        assertEquals(ISO639Language.English, a.getIiExtMetadataLanguage());
        assertTrue(a.isIiExtMetadataMultiLang());

    }

}