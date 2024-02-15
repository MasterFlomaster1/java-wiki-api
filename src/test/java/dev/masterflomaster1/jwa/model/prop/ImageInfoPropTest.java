package dev.masterflomaster1.jwa.model.prop;

import com.google.gson.Gson;
import dev.masterflomaster1.jwa.Response;
import dev.masterflomaster1.jwa.WikiApi;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.WikiApiSyntaxException;
import dev.masterflomaster1.jwa.model.action.QueryAction;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Set;

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
                .action(
                        new QueryAction.Builder()
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

        System.out.println(r.getQuery().getPages().get(0).getImageInfo().get(0));
        System.out.println("Timestamp: " + r.getQuery().getPages().get(0).getImageInfo().get(0).getTimestamp());
        System.out.println("User: " + r.getQuery().getPages().get(0).getImageInfo().get(0).getUser());
    }

    @Test
    @DisplayName("Fetch information about versions of File:Test.jpg from 2008 and later.")
    void testExample2() throws WikiApiSyntaxException, IOException, InterruptedException {
        var a = new WikiApiRequest.Builder()
                .action(
                        new QueryAction.Builder()
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
        System.out.println(a.getUrl());
        System.out.println(r);

        r.getQuery().getPages().get(0).getImageInfo().forEach(e -> {
            System.out.printf("%s on %s: %s\n", e.getUser(), e.getTimestamp(), e.getUrl());
        });
    }

    @Test
    void getIiProp() {
    }

    @Test
    void getIiLimit() {
    }

    @Test
    void getIiStart() {
    }

    @Test
    void getIiEnd() {
    }

    @Test
    void getIiUrlWidth() {
    }

    @Test
    void getIiUrlHeight() {
    }

    @Test
    void getIiExtMetadataLanguage() {
    }

    @Test
    void isIiExtMetadataMultiLang() {
    }
}