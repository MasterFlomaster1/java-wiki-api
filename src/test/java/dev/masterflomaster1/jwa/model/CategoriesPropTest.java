package dev.masterflomaster1.jwa.model;

import dev.masterflomaster1.jwa.WikiApi;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.WikiApiSyntaxException;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CategoriesPropTest {

    @Test
    void test() throws WikiApiSyntaxException, IOException, InterruptedException {
        WikiApi api = new WikiApi();
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

        System.out.println(a.getUrl());
        System.out.println(api.execute(a));
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