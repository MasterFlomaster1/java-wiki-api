package dev.masterflomaster1.jwa.model.prop;

import com.google.gson.Gson;
import dev.masterflomaster1.jwa.Response;
import dev.masterflomaster1.jwa.WikiApi;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.WikiApiSyntaxException;
import dev.masterflomaster1.jwa.model.action.QueryAction;
import dev.masterflomaster1.jwa.response.Page;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class InfoPropTest {

    private static WikiApi api;
    private static Gson gson;

    @BeforeAll
    static void before() {
        api = new WikiApi();
        gson = new Gson();
    }

    @Test
    @DisplayName("Get information about the page Main Page.")
    void testExample1() throws WikiApiSyntaxException, IOException, InterruptedException {
        var a = new WikiApiRequest.Builder()
                .action(
                        new QueryAction.Builder()
                                .prop(Set.of(
                                        new InfoProp.Builder()
                                                .build()
                                        )
                                )
                                .titles(Set.of("Main Page"))
                                .build()
                )
                .build();

        Response r = gson.fromJson(api.execute(a), Response.class);

        Page p = r.getQuery().getPages().get(0);
        System.out.println(p.getTouched());
        System.out.println(p.getLastRevId());
        System.out.println(p.getLength());

        assertNotNull(p.getTouched());
        assertNotNull(p.getLastRevId());
        assertNotNull(p.getLength());
    }

    @Test
    void testBuilder() {
        var a = new InfoProp.Builder()
                .inProp(Set.of(InfoProp.InProp.URL, InfoProp.InProp.TALK_ID))
                .build();

        assertEquals(Set.of(InfoProp.InProp.URL, InfoProp.InProp.TALK_ID), a.getInProp());
    }

}