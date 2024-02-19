package dev.masterflomaster1.jwa.model.prop;

import com.google.gson.Gson;
import dev.masterflomaster1.jwa.Response;
import dev.masterflomaster1.jwa.WikiApi;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.WikiApiSyntaxException;
import dev.masterflomaster1.jwa.model.action.QueryAction;
import dev.masterflomaster1.jwa.response.CategoryInfo;
import dev.masterflomaster1.jwa.response.Page;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CategoryInfoPropTest {

    private static WikiApi api;
    private static Gson gson;

    @BeforeAll
    static void before() {
        api = new WikiApi();
        gson = new Gson();
    }

    @Test
    void test() throws WikiApiSyntaxException, IOException, InterruptedException {
        var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .prop(Set.of(
                                new CategoryInfoProp.Builder()
                                        .build()
                                )
                        )
                        .titles(Set.of(
                                "Category:Java (programming language) libraries",
                                "Category:Java specification requests",
                                "Category:Java platform games",
                                "Category:Java APIs",
                                "Category:Jakarta Server Faces",
                                "Category:Java API for XML",
                                "Category:Java (programming language) software",
                                "Category:Instant messaging clients programmed in Java",
                                "Category:Java (programming language)",
                                "Category:J2ME games",
                                "Category:JDK components"
                                )
                        )
                        .build()
                )
                .build();

        Response r = gson.fromJson(api.execute(a), Response.class);

        for (Page p : r.getQuery().getPages()) {
            System.out.println("Title: " + p.getTitle());
            display(p.getCategoryInfo());
            System.out.println();
        }
    }

    @Test
    void test3() throws WikiApiSyntaxException, IOException, InterruptedException {
        var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .prop(Set.of(
                                new CategoryInfoProp.Builder()
                                        .build()
                                )
                        )
                        .titles(Set.of("Category:Management cybernetics"))
                        .build()
                )
                .build();

        Response r = gson.fromJson(api.execute(a), Response.class);

        assertNotNull(r.getQuery().getPages().get(0).getCategoryInfo());
        display(r.getQuery().getPages().get(0).getCategoryInfo());
    }

    @Test
    @DisplayName("Trigger limit error")
    void triggerLimitError() throws WikiApiSyntaxException, IOException, InterruptedException {
        var cats = Set.of(
                "Category:Business architecture",
                "Category:Business intelligence",
                "Category:Analytics",
                "Category:Analytics companies",
                "Category:Business intelligence companies",
                "Category:Automotive intelligence companies",
                "Category:Market research companies",
                "Category:Types of analytics",
                "Category:Business analytics",
                "Category:Marketing analytics",
                "Category:Retail analytics",
                "Category:Web analytics",
                "Category:Free web analytics software",
                "Category:Web log analysis software",
                "Category:Business analysis",
                "Category:Applied data mining",
                "Category:Data warehousing",
                "Category:Data warehousing products",
                "Category:Extract, transform, load tools",
                "Category:Market intelligence",
                "Category:Competitive intelligence",
                "Category:Product intelligence",
                "Category:Business intelligence organizations",
                "Category:Business intelligence software",
                "Category:Strategic management",
                "Category:Strategic alliances",
                "Category:Crossover fiction",
                "Category:Franchising",
                "Category:Joint ventures",
                "Category:Professional wrestling joint shows",
                "Category:Business models",
                "Category:Communications management",
                "Category:Strategy consulting",
                "Category:Auctions",
                "Category:Bamboo network",
                "Category:Cooperative economics",
                "Category:Enterprise modelling",
                "Category:Gacha games",
                "Category:Holding companies",
                "Category:Multi-level marketing",
                "Category:No frills",
                "Category:Revenue models",
                "Category:Service-oriented (business computing)",
                "Category:Software distribution",
                "Category:Sustainable business",
                "Category:Corporate development",
                "Category:Management frameworks",
                "Category:Marketing strategy",
                "Category:Business opportunities",
                "Category:Organizational performance management",
                "Category:JDK components"
        );

        var a = new WikiApiRequest.Builder()
                .action(new QueryAction.Builder()
                        .prop(Set.of(
                                        new CategoryInfoProp.Builder()
                                                .build()
                                )
                        )
                        .titles(cats)
                        .build()
                )
                .build();

        Response r = gson.fromJson(api.execute(a), Response.class);

        assertNotNull(r.getError());
        assertNotNull(r.getError().getDocRef());
        assertEquals("toomanyvalues", r.getError().getCode());
        assertEquals("titles", r.getError().getParameter());
        assertEquals(50, r.getError().getLimit());
        assertEquals(50, r.getError().getLowLimit());
        assertEquals(500, r.getError().getHighLimit());
        assertEquals("Too many values supplied for parameter \"titles\". The limit is 50.", r.getError().getInfo());

    }

    private void display(CategoryInfo c) {
        System.out.println("size: " + c.getSize());
        System.out.println("pages: " + c.getPages());
        System.out.println("files: " + c.getFiles());
        System.out.println("subCats: " + c.getSubCats());
        System.out.println("hidden: " + c.isHidden());
    }

    @Test
    void getCiContinue() {
        var a = new CategoryInfoProp.Builder()
                .ciContinue("2")
                .build();

        assertEquals("2", a.getCiContinue());
    }
}