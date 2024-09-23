package dev.masterflomaster1.jwa.request.prop;

import dev.masterflomaster1.jwa.BaseApiTest;
import dev.masterflomaster1.jwa.Response;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.request.action.QueryAction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PageViewsPropTest extends BaseApiTest {

    @Test
    @DisplayName("Show pageview statistics for the main page.")
    void testExample1() throws IOException {
        var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .prop(Set.of(
                                new PageViewsProp.Builder()
                                        .build()
                        ))
                        .titles(Set.of("Main_Page"))
                        .build()
                )
                .build();

        Response r = api.execute(a);
        assertEquals(60, r.getQuery().getPages().get(0).getPageViews().size());
    }

    @Test
    @DisplayName("Show pageview statistics for the main page. 20 values")
    void testExample2() throws IOException {
        var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .prop(Set.of(
                                new PageViewsProp.Builder()
                                        .pvIpDays(20)
                                        .build()
                        ))
                        .titles(Set.of("Main_Page"))
                        .build()
                )
                .build();

        Response r = api.execute(a);
        assertEquals(20, r.getQuery().getPages().get(0).getPageViews().size());
    }

    @Test
    void testBuilder() {
        var a = new PageViewsProp.Builder()
                .pvIpDays(50)
                .pvIpContinue("test")
                .build();

        assertEquals(50, a.getPvIpDays());
        assertEquals("test", a.getPvIpContinue());
    }

}