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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CategoriesPropTest {

    private static WikiApi api;
    private static Gson gson;

    @BeforeAll
    static void before() {
        api = new WikiApi();
        gson = new Gson();
    }

    @Test
    @DisplayName("Get a list of categories the page Albert Einstein belongs to")
    void testExample1() throws WikiApiSyntaxException, IOException, InterruptedException {
        var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .prop(Set.of(
                                new CategoriesProp.Builder()
                                        .clLimit(10)
                                        .clDir(Dir.ASCENDING)
                                        .build()
                                )
                        )
                        .titles(Set.of("Albert Einstein"))
                        .build()
                )
                .build();

        Response r = gson.fromJson(api.execute(a), Response.class);
        assertNotNull(r.getQuery().getPages().get(0).getCategories());
    }

    @Test
    void testBuilder() {
        var a = new CategoriesProp.Builder()
                .clProp(Set.of(CategoriesProp.ClProp.TIMESTAMP, CategoriesProp.ClProp.HIDDEN))
                .clShow(CategoriesProp.ClShow.UNHIDDEN)
                .clLimit(5)
                .clDir(Dir.DESCENDING)
                .build();

        assertEquals(Set.of(CategoriesProp.ClProp.TIMESTAMP, CategoriesProp.ClProp.HIDDEN), a.getClProp());
        assertEquals(CategoriesProp.ClShow.UNHIDDEN, a.getClShow());
        assertEquals(a.getClLimit(), 5);
        assertEquals(5, a.getClLimit());
        assertEquals(Dir.DESCENDING, a.getClDir());
    }

}