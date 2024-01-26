package dev.masterflomaster1.jwa;

import dev.masterflomaster1.jwa.model.Prop;
import dev.masterflomaster1.jwa.model.action.Query;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class RevisionsTest {

    @Test
    void test() throws IOException, InterruptedException {
        WikiApi api = new WikiApi();

        var a = new WikiApiRequest.Builder()
                .setAction(
                        new Query.Builder()
                                .addProp(Prop.REVISIONS)
                                .build()
                )
                .build();

        System.out.println(api.execute(a));
    }

}
