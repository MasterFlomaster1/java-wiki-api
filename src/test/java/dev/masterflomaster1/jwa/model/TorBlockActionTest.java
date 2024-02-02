package dev.masterflomaster1.jwa.model;

import dev.masterflomaster1.jwa.WikiApi;
import dev.masterflomaster1.jwa.WikiApiSyntaxException;
import dev.masterflomaster1.jwa.WikiApiRequest;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class TorBlockActionTest {

    private static WikiApi api;

    @BeforeAll
    static void before() {
        api = new WikiApi();
    }


    @Test
    void test() throws IOException, InterruptedException, WikiApiSyntaxException {
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

    @Test
    void test2() throws WikiApiSyntaxException {
        var a = new TorBlockAction.Builder()
                .ip("102.130.119.48")
                .build();

        Assertions.assertEquals("102.130.119.48", a.getIp());
    }

}