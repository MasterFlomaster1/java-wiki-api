package dev.masterflomaster1.jwa.request.prop;

import dev.masterflomaster1.jwa.BaseApiTest;
import dev.masterflomaster1.jwa.Response;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.request.action.QueryAction;
import dev.masterflomaster1.jwa.response.Page;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CategoryInfoPropTest extends BaseApiTest {

    @Test
    void test() throws IOException {
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

        Response r = api.execute(a);

        for (Page p : r.getQuery().getPages()) {
            assertNotNull(p.getCategoryInfo());
        }
    }

    @Test
    void test3() throws IOException {
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

        Response r = api.execute(a);

        assertNotNull(r.getQuery().getPages().get(0).getCategoryInfo());
    }

    @Test
    @DisplayName("Trigger limit error")
    void triggerLimitError() throws IOException {
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

        Response r = api.execute(a);

        assertNotNull(r.getError());
        assertNotNull(r.getError().getDocRef());
        assertEquals("toomanyvalues", r.getError().getCode());
        assertEquals("titles", r.getError().getParameter());
        assertEquals(50, r.getError().getLimit());
        assertEquals(50, r.getError().getLowLimit());
        assertEquals(500, r.getError().getHighLimit());
        assertEquals("Too many values supplied for parameter \"titles\". The limit is 50.", r.getError().getInfo());

    }

    @Test
    void testBuilder() {
        var a = new CategoryInfoProp.Builder()
                .ciContinue("2")
                .build();

        assertEquals("2", a.getCiContinue());
    }
}