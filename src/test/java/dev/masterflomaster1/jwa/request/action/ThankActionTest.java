package dev.masterflomaster1.jwa.request.action;

import dev.masterflomaster1.jwa.Response;
import dev.masterflomaster1.jwa.WikiApi;
import dev.masterflomaster1.jwa.WikiApiRequest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeFalse;

class ThankActionTest {

    private static WikiApi api;

    @BeforeAll
    static void before() {
        api = new WikiApi();
    }

    @Test
    @DisplayName("Send thanks for revision ID 456, with the source being a diff page")
    void testExample1() throws IOException {
        var a = new WikiApiRequest.Builder()
                .action(new ThankAction.Builder()
                        .rev(456)
                        .token(Shared.tokens().getCsrfToken())
                        .source("diff")
                        .build()
                )
                .build();

        Response r = api.execute(a);
        assumeFalse(r.getError() != null && r.getError().getCode().equals("notloggedin"), "Not logged in, skipping");
    }

    @Test
    void testBuilder() {
        var a = new ThankAction.Builder()
                .rev(456)
                .log(456)
                .token("test12345")
                .source("diff")
                .build();

        assertEquals(456, a.getRev());
        assertEquals(456, a.getLog());
        assertEquals("test12345", a.getToken());
        assertEquals("diff", a.getSource());
    }

}