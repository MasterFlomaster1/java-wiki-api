package dev.masterflomaster1.jwa.request.prop;

import com.google.gson.Gson;
import dev.masterflomaster1.jwa.Response;
import dev.masterflomaster1.jwa.WikiApi;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.WikiApiSyntaxException;
import dev.masterflomaster1.jwa.request.action.QueryAction;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ExtLinksPropTest {

    private static WikiApi api;
    private static Gson gson;

    @BeforeAll
    static void before() {
        api = new WikiApi();
        gson = new Gson();
    }

    @Test
    @DisplayName("Get a list of external links on the page Main Page.")
    void testExample1() throws WikiApiSyntaxException, IOException, InterruptedException {
        var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .prop(Set.of(
                                        new ExtLinksProp.Builder()
                                                .build()
                                )
                        )
                        .titles(Set.of("Main Page"))
                        .build()
                )
                .build();

        Response r = gson.fromJson(api.execute(a), Response.class);
        assertNotNull(r.getQuery().getPages().get(0).getExtLinks());
    }

    @Test
    void testBuilder() {
        var a = new ExtLinksProp.Builder()
                .elLimit(30)
                .elContinue("460837609")
                .elProtocol(ExtLinksProp.ElProtocol.SSH)
                .elQuery("test")
                .build();

        assertEquals(30, a.getElLimit());
        assertEquals("460837609", a.getElContinue());
        assertEquals(ExtLinksProp.ElProtocol.SSH, a.getElProtocol());
        assertEquals("test", a.getElQuery());
    }

}