package dev.masterflomaster1.jwa.request.prop;

import dev.masterflomaster1.jwa.BaseApiTest;
import dev.masterflomaster1.jwa.Response;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.common.Dir;
import dev.masterflomaster1.jwa.request.action.QueryAction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ImagesPropTest extends BaseApiTest {

    @Test
    @DisplayName("Get a list of files used on the page Main Page.")
    void testExample1() throws IOException {
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

        Response r = api.execute(a);
        assertNotNull(r.getQuery().getPages().get(0).getImages());
    }

    @Test
    void testBuilder() {
        var a = new ImagesProp.Builder()
                .imLimit(50)
                .imContinue("15580374|Wikibooks-logo.svg")
                .imImages(Set.of("File:MediaWiki-2020-icon.svg"))
                .imDir(Dir.Order.DESCENDING)
                .build();

        assertEquals(50, a.getImLimit());
        assertEquals("15580374|Wikibooks-logo.svg", a.getImContinue());
        assertEquals(Set.of("File:MediaWiki-2020-icon.svg"), a.getImImages());
        assertEquals(Dir.Order.DESCENDING, a.getImDir());
    }

}