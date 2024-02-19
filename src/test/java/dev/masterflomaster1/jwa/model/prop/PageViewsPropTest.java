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

import static org.junit.jupiter.api.Assertions.assertEquals;

class PageViewsPropTest {

    private static WikiApi api;
    private static Gson gson;

    @BeforeAll
    static void before() {
        api = new WikiApi();
        gson = new Gson();
    }

    @Test
    @DisplayName("Show pageview statistics for the main page.")
    void testExample1() throws WikiApiSyntaxException, IOException, InterruptedException {
        var a = new WikiApiRequest.Builder()
                .action(
                        new QueryAction.Builder()
                                .prop(Set.of(
                                        new PageViewsProp.Builder()
                                                .build()
                                ))
                                .titles(Set.of("Main_Page"))
                                .build()
                )
                .build();

        Response r = gson.fromJson(api.execute(a), Response.class);
        assertEquals(60, r.getQuery().getPages().get(0).getPageViews().size());
        System.out.println(r.getQuery().getPages().get(0).getPageViews());
    }

    @Test
    @DisplayName("Show pageview statistics for the main page. 20 values")
    void testExample2() throws WikiApiSyntaxException, IOException, InterruptedException {
        var a = new WikiApiRequest.Builder()
                .action(
                        new QueryAction.Builder()
                                .prop(Set.of(
                                        new PageViewsProp.Builder()
                                                .pvIpDays(20)
                                                .build()
                                ))
                                .titles(Set.of("Main_Page"))
                                .build()
                )
                .build();

        Response r = gson.fromJson(api.execute(a), Response.class);
        assertEquals(20, r.getQuery().getPages().get(0).getPageViews().size());
        System.out.println(r.getQuery().getPages().get(0).getPageViews());
    }

    @Test
    void getPvIpDays() {
        var a = new PageViewsProp.Builder()
                .pvIpDays(50)
                .build();

        assertEquals(50, a.getPvIpDays());
    }

    @Test
    void getPvIpContinue() {
        var a = new PageViewsProp.Builder()
                .pvIpContinue("test")
                .build();

        assertEquals("test", a.getPvIpContinue());
    }
}