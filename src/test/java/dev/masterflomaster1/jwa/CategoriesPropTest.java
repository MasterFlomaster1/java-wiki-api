package dev.masterflomaster1.jwa;

import dev.masterflomaster1.jwa.model.CategoriesProp;
import dev.masterflomaster1.jwa.model.QueryAction;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Set;

public class CategoriesPropTest {

    @Test
    void test() throws WikiApiException, IOException, InterruptedException {
        WikiApi api = new WikiApi();

        var a = new WikiApiRequest.Builder()
                .action(
                        new QueryAction.Builder()
                                .prop(Set.of(new CategoriesProp()))
                                .build()
                )
                .build();

        System.out.println(a.getUrl());
        System.out.println(api.execute(a));
    }

}
