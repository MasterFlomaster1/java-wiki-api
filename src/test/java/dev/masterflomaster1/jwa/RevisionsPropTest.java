package dev.masterflomaster1.jwa;

import dev.masterflomaster1.jwa.model.QueryAction;
import dev.masterflomaster1.jwa.model.Revisions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Set;

public class RevisionsPropTest {

    @Test
    void test() throws IOException, InterruptedException, WikiApiException {
        WikiApi api = new WikiApi();

        var a = new WikiApiRequest.Builder()
                .action(
                        new QueryAction.Builder()
                                .prop(Set.of(
                                        new Revisions.Builder()
                                                .setRvProp(Set.of(Revisions.RvProp.TIMESTAMP, Revisions.RvProp.USER))
                                                .setRvLimit(15)
                                                .build()
                                        )
                                )
                                .titles(Set.of("Java_(programming_language)"))
                                .build()
                )
                .build();

        System.out.println(a.getUrl());
        System.out.println(api.execute(a));
    }

}
