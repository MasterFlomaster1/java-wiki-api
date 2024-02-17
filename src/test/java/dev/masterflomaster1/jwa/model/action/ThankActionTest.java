package dev.masterflomaster1.jwa.model.action;

import com.google.gson.Gson;
import dev.masterflomaster1.jwa.Response;
import dev.masterflomaster1.jwa.WikiApi;
import dev.masterflomaster1.jwa.WikiApiRequest;
import dev.masterflomaster1.jwa.WikiApiSyntaxException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ThankActionTest {

    private static WikiApi api;
    private static Gson gson;

    @BeforeAll
    static void before() {
        api = new WikiApi();
        gson = new Gson();
    }

    @Test
    @DisplayName("Send thanks for revision ID 456, with the source being a diff page")
    void testExample1() throws WikiApiSyntaxException, IOException, InterruptedException {
        var a = new WikiApiRequest.Builder()
                .action(new ThankAction.Builder()
                        .rev(456)
                        .token("ade5a6db13664e583b74ca6eb7bb73ba65d0134c+\\")
                        .source("diff")
                        .build()
                )
                .build();

        Response r = gson.fromJson(api.execute(a), Response.class);

        System.out.println(r);
    }

    @Test
    void getRev() throws WikiApiSyntaxException {
        var a = new ThankAction.Builder()
                .rev(456)
                .token("test12345")
                .build();

        assertEquals(456, a.getRev());
    }

    @Test
    void getLog() throws WikiApiSyntaxException {
        var a = new ThankAction.Builder()
                .log(456)
                .token("test12345")
                .build();

        assertEquals(456, a.getLog());
    }

    @Test
    void getToken() throws WikiApiSyntaxException {
        var a = new ThankAction.Builder()
                .token("test12345")
                .build();

        assertEquals("test12345", a.getToken());
    }

    @Test
    void getSource() throws WikiApiSyntaxException {
        var a = new ThankAction.Builder()
                .source("diff")
                .token("test12345")
                .build();

        assertEquals("diff", a.getSource());
    }
}