package dev.masterflomaster1.jwa.request.list;

import dev.masterflomaster1.jwa.BaseApiTest;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.common.Dir;
import dev.masterflomaster1.jwa.internal.UrlComparator;
import dev.masterflomaster1.jwa.request.action.QueryAction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EnumSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AllCategoriesListTest extends BaseApiTest {

    @Test
    @DisplayName("List categories with information on the number of pages in each")
    void testExample1() {
        var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .list(Set.of(
                                new AllCategoriesList.Builder()
                                        .acProp(EnumSet.of(AllCategoriesList.AcProp.SIZE))
                                        .build()
                        ))
                        .build()
                )
                .build();

        assertTrue(UrlComparator.compareUrls(
                "https://en.wikipedia.org/w/api.php?action=query&format=json&list=allcategories&formatversion=2&acprop=size",
                a.getUrl()
        ));
    }

    @Test
    void testBuilder() {
        var a = new AllCategoriesList.Builder()
                .acFrom("Java APIs")
                .acContinue("Java_compilers")
                .acTo("Java Platform")
                .acPrefix("Java")
                .acDir(Dir.Order.DESCENDING)
                .acMin(2)
                .acMax(10)
                .acLimit(20)
                .acProp(EnumSet.of(AllCategoriesList.AcProp.HIDDEN))
                .build();

        assertEquals("Java APIs", a.getAcFrom());
        assertEquals("Java_compilers", a.getAcContinue());
        assertEquals("Java Platform", a.getAcTo());
        assertEquals("Java", a.getAcPrefix());
        assertEquals(Dir.Order.DESCENDING, a.getAcDir());
        assertEquals(2, a.getAcMin());
        assertEquals(10, a.getAcMax());
        assertEquals(20, a.getAcLimit());
        assertEquals(EnumSet.of(AllCategoriesList.AcProp.HIDDEN), a.getAcProp());
    }

}