package dev.masterflomaster1.jwa;

import dev.masterflomaster1.jwa.model.Prop;
import dev.masterflomaster1.jwa.model.action.Query;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class JTest {

    @Test
    void test() throws IOException, InterruptedException {
        WikiApi api = new WikiApi();

        WikiApiRequest request = new WikiApiRequest.Builder()
                .setAction(
                        new Query()
                )
                .build();

        String reply = api.execute(request);

        System.out.println(reply);
    }



}
