package dev.masterflomaster1.jwa.request.list;

import dev.masterflomaster1.jwa.Response;
import dev.masterflomaster1.jwa.WikiApi;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.common.Dir;
import dev.masterflomaster1.jwa.request.action.QueryAction;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class AllCategoriesListTest {

    private static WikiApi api;

    @BeforeAll
    static void before() {
        api = new WikiApi();
    }

    @Test
    @DisplayName("List categories with information on the number of pages in each.")
    void testExample1() throws IOException {
        var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .list(Set.of(
                                new AllCategoriesList.Builder()
                                        .acProp(Set.of(AllCategoriesList.AcProp.SIZE))
                                        .build()
                                )
                        )
                        .build()
                )
                .build();

        Response r = api.execute(a);
        assertNotNull(r.getQuery().getAllCategories());
    }

    @Test
    void testBuilder() {
        var a = new AllCategoriesList.Builder()
                .acFrom("Java APIs")
                .acContinue("Java_compilers")
                .acTo("Java Platform")
                .acPrefix("Java")
                .acDir(Dir.DESCENDING)
                .acMin(2)
                .acMax(10)
                .acLimit(20)
                .acProp(Set.of(AllCategoriesList.AcProp.HIDDEN))
                .build();

        assertEquals("Java APIs", a.getAcFrom());
        assertEquals("Java_compilers", a.getAcContinue());
        assertEquals("Java Platform", a.getAcTo());
        assertEquals("Java", a.getAcPrefix());
        assertEquals(Dir.DESCENDING, a.getAcDir());
        assertEquals(2, a.getAcMin());
        assertEquals(10, a.getAcMax());
        assertEquals(20, a.getAcLimit());
        assertEquals(Set.of(AllCategoriesList.AcProp.HIDDEN), a.getAcProp());
    }

}