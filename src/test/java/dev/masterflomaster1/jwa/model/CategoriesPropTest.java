package dev.masterflomaster1.jwa.model;

import com.google.gson.Gson;
import dev.masterflomaster1.jwa.Response;
import dev.masterflomaster1.jwa.WikiApi;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.WikiApiSyntaxException;
import dev.masterflomaster1.jwa.model.action.QueryAction;
import dev.masterflomaster1.jwa.model.prop.CategoriesProp;
import dev.masterflomaster1.jwa.response.Category;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
                                        .clDir(CategoriesProp.ClDir.ASCENDING)
                                        .build()
                                )
                        )
                        .titles(Set.of("Albert Einstein"))
                        .build()
                )
                .build();

        Response r = gson.fromJson(api.execute(a), Response.class);

        for (Category c : r.getQuery().getPages().get(0).getCategories()) {
            System.out.println(c.getTitle());
        }
    }

    @Test
    void getClProp() {
        var a = new CategoriesProp.Builder()
                .clProp(Set.of(CategoriesProp.ClProp.TIMESTAMP, CategoriesProp.ClProp.HIDDEN))
                .build();

        assertEquals(a.getClProp(), Set.of(CategoriesProp.ClProp.TIMESTAMP, CategoriesProp.ClProp.HIDDEN));
    }

    @Test
    void getClShow() {
        var a = new CategoriesProp.Builder()
                .clShow(CategoriesProp.ClShow.UNHIDDEN)
                .build();

        assertEquals(a.getClShow(), CategoriesProp.ClShow.UNHIDDEN);
    }

    @Test
    void getClLimit() {
        var a = new CategoriesProp.Builder()
                .clLimit(5)
                .build();


        assertEquals(a.getClLimit(), 5);
    }

    @Test
    void getClDir() {
        var a = new CategoriesProp.Builder()
                .clDir(CategoriesProp.ClDir.DESCENDING)
                .build();

        assertEquals(a.getClDir(), CategoriesProp.ClDir.DESCENDING);
    }
}