package dev.masterflomaster1.jwa.model;

import dev.masterflomaster1.jwa.WikiApi;
import dev.masterflomaster1.jwa.WikiApiException;
import dev.masterflomaster1.jwa.WikiApiRequest;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class TorBlockActionTest {


    @Test
    void test() throws IOException, InterruptedException, WikiApiException {
        WikiApi api = new WikiApi();

        var a = new WikiApiRequest.Builder()
                .action(
                        new TorBlockAction.Builder()
                                .ip("102.130.119.48")
                                .build()
                )
                .build();

        System.out.println(a.getUrl());
        System.out.println(api.execute(a));
    }

}