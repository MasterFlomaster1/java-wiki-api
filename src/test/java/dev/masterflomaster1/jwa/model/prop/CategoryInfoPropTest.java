package dev.masterflomaster1.jwa.model.prop;

import com.google.gson.Gson;
import dev.masterflomaster1.jwa.Response;
import dev.masterflomaster1.jwa.WikiApi;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.WikiApiSyntaxException;
import dev.masterflomaster1.jwa.model.action.QueryAction;
import dev.masterflomaster1.jwa.model.meta.SiteInfoMeta;
import dev.masterflomaster1.jwa.response.CategoryInfo;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CategoryInfoPropTest {

    private static WikiApi api;

    @BeforeAll
    static void before() {
        api = new WikiApi();
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

        Gson gson = new Gson();
        Response r = gson.fromJson(api.execute(a), Response.class);

        System.out.println(r);
    }

    @Test
    void getCiContinue() {
        var a = new CategoryInfoProp.Builder()
                .ciContinue("2")
                .build();

        assertEquals("2", a.getCiContinue());
    }
}