package dev.masterflomaster1.jwa;

import dev.masterflomaster1.jwa.model.action.Query;
import dev.masterflomaster1.jwa.model.prop.Revisions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Set;

public class RevisionsTest {

    @Test
    void test() throws IOException, InterruptedException {
        WikiApi api = new WikiApi();

        var a = new WikiApiRequest.Builder()
                .setAction(
                        new Query.Builder()
                                .addProp(
                                        new Revisions.Builder()
                                                .setRvProp(Set.of(Revisions.RvProp.TIMESTAMP, Revisions.RvProp.USER))
                                                .setRvLimit(15)
                                                .build()
                                )
                                .setTitles(Set.of("Java_(programming_language)"))
                                .build()
                )
                .build();

        System.out.println(a.getUrl());
        System.out.println(api.execute(a));
    }

}
