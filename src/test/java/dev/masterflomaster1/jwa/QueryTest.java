package dev.masterflomaster1.jwa;

import dev.masterflomaster1.jwa.model.Query;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class QueryTest {

    @Test
    void test() throws WikiApiException, IOException, InterruptedException {
        WikiApi api = new WikiApi();

        var a = new WikiApiRequest.Builder()
                .setAction(
                        new Query.Builder()
                                .build()
                )
                .build();

        System.out.println(a.getUrl());
        System.out.println(api.execute(a));
    }

}
