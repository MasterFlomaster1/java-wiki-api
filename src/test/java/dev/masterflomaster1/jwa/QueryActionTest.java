package dev.masterflomaster1.jwa;

import com.google.gson.Gson;
import dev.masterflomaster1.jwa.model.ImageInfoProp;
import dev.masterflomaster1.jwa.model.QueryAction;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Set;

public class QueryActionTest {

    @Test
    void test() throws WikiApiException, IOException, InterruptedException {
        WikiApi api = new WikiApi();

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
    void test2() throws WikiApiException, IOException, InterruptedException {
        WikiApi api = new WikiApi();

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

}
