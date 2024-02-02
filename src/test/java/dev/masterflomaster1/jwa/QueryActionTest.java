package dev.masterflomaster1.jwa;

import com.google.gson.Gson;
import dev.masterflomaster1.jwa.model.QueryAction;
import dev.masterflomaster1.jwa.model.RevisionsProp;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Set;

public class QueryActionTest {

    private static WikiApi api;

    @BeforeAll
    static void before() {
        api = new WikiApi();
    }

    @Test
    void test() throws WikiApiSyntaxException, IOException, InterruptedException {
        var a = new WikiApiRequest.Builder()
                .action(
                        new QueryAction.Builder()
                                .build()
                )
                .build();

        System.out.println(a.getUrl());
        System.out.println(api.execute(a));
    }

    @Test
    void test2() throws WikiApiSyntaxException, IOException, InterruptedException {
        var a = new WikiApiRequest.Builder()
                .action(
                        new QueryAction.Builder()
                                .titles(Set.of("Java_(programming_language)"))
                                .build()
                )
                .curTimestamp()
                .servedBy()
                .responseLangInfo()
                .build();

        Gson gson = new Gson();
        Response r = gson.fromJson(api.execute(a), Response.class);

        System.out.println(r);
    }

    @Test
    void test3() throws WikiApiSyntaxException {
        var a = new RevisionsProp.Builder()
                .rvLimit(10)
                .rvProp(Set.of(RevisionsProp.RvProp.USER, RevisionsProp.RvProp.SIZE))
                .build();

        var b = new RevisionsProp.Builder()
                .rvLimit(10)
                .rvProp(Set.of(RevisionsProp.RvProp.USER, RevisionsProp.RvProp.SHA1))
                .build();

        System.out.println(a.hashCode());
        System.out.println(b.hashCode());
    }

}
