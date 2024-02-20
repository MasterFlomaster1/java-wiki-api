package dev.masterflomaster1.jwa.model.prop;

import com.google.gson.Gson;
import dev.masterflomaster1.jwa.Response;
import dev.masterflomaster1.jwa.WikiApi;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.WikiApiSyntaxException;
import dev.masterflomaster1.jwa.common.Dir;
import dev.masterflomaster1.jwa.model.action.QueryAction;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ImagesPropTest {

    private static WikiApi api;
    private static Gson gson;

    @BeforeAll
    static void before() {
        api = new WikiApi();
        gson = new Gson();
    }

    @Test
    @DisplayName("Get a list of files used on the page Main Page.")
    void testExample1() throws WikiApiSyntaxException, IOException, InterruptedException {
        var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .prop(Set.of(
                                new ImagesProp.Builder()
                                        .build()
                                )
                        )
                        .titles(Set.of("Main Page"))
                        .build()
                )
                .build();

        Response r = gson.fromJson(api.execute(a), Response.class);
        assertNotNull(r.getQuery().getPages().get(0).getImages());
    }

    @Test
    void testBuild() {
        var a = new ImagesProp.Builder()
                .imLimit(50)
                .imContinue("15580374|Wikibooks-logo.svg")
                .imImages(Set.of("File:MediaWiki-2020-icon.svg"))
                .imDir(Dir.DESCENDING)
                .build();

        assertEquals(50, a.getImLimit());
        assertEquals("15580374|Wikibooks-logo.svg", a.getImContinue());
        assertEquals(Set.of("File:MediaWiki-2020-icon.svg"), a.getImImages());
        assertEquals(Dir.DESCENDING, a.getImDir());
    }

}