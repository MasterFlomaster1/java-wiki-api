package dev.masterflomaster1.jwa.request.prop;

import dev.masterflomaster1.jwa.BaseApiTest;
import dev.masterflomaster1.jwa.Response;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.common.Dir;
import dev.masterflomaster1.jwa.request.action.QueryAction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.EnumSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CategoriesPropTest extends BaseApiTest {

    @Test
    @DisplayName("Get a list of categories the page Albert Einstein belongs to")
    void testExample1() throws IOException {
        var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .prop(Set.of(
                                new CategoriesProp.Builder()
                                        .clLimit(10)
                                        .clDir(Dir.Order.ASCENDING)
                                        .build()
                                )
                        )
                        .titles(Set.of("Albert Einstein"))
                        .build()
                )
                .build();

        Response r = api.execute(a);

        System.out.println(r.getQuery().getPages().get(0).getCategories());

        assertNotNull(r.getQuery().getPages().get(0).getCategories());
    }

    @Test
    void testBuilder() {
        var a = new CategoriesProp.Builder()
                .clProp(EnumSet.of(CategoriesProp.ClProp.TIMESTAMP, CategoriesProp.ClProp.HIDDEN))
                .clShow(CategoriesProp.ClShow.UNHIDDEN)
                .clLimit(5)
                .clContinue("736|Academic_staff_of_the_University_of_Bern")
                .clCategories(Set.of("A", "B"))
                .clDir(Dir.Order.DESCENDING)
                .build();

        assertEquals(EnumSet.of(CategoriesProp.ClProp.TIMESTAMP, CategoriesProp.ClProp.HIDDEN), a.getClProp());
        assertEquals(CategoriesProp.ClShow.UNHIDDEN, a.getClShow());
        assertEquals(a.getClLimit(), 5);
        assertEquals(5, a.getClLimit());
        assertEquals("736|Academic_staff_of_the_University_of_Bern", a.getClContinue());
        assertEquals(Set.of("A", "B"), a.getClCategories());
        assertEquals(Dir.Order.DESCENDING, a.getClDir());
    }

}