package dev.masterflomaster1.jwa;

import dev.masterflomaster1.jwa.model.QueryAction;
import dev.masterflomaster1.jwa.model.RevisionsProp;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Set;

public class RevisionsPropTest {

    @Test
    void test() throws IOException, InterruptedException, WikiApiSyntaxException {
        WikiApi api = new WikiApi();

        var a = new WikiApiRequest.Builder()
                .action(
                        new QueryAction.Builder()
                                .prop(Set.of(
                                        new RevisionsProp.Builder()
                                                .rvProp(Set.of(RevisionsProp.RvProp.TIMESTAMP, RevisionsProp.RvProp.USER))
                                                .rvLimit(15)
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
